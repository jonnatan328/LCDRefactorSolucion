import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import digitos.Cero;
import digitos.Cinco;
import digitos.Cuatro;
import digitos.Digito;
import digitos.Dos;
import digitos.Nueve;
import digitos.Ocho;
import digitos.Seis;
import digitos.Siete;
import digitos.Tres;
import digitos.Uno;
import util.Validaciones;

/**
 * Implementa el metodo principal donde se validan los parametros iniciales y se
 * llama el objecto impresor
 * 
 * @author Jonnatan R�os
 */
public class LCDTester0 {

	static final String CADENA_FINAL = "0,0";

	/**
	 * Metodo principal que ejecuta la aplicación.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Guarda las lineas de comando ingresadas por el usuario.
		List<String> listaComando = new ArrayList<>();

		// Guarda temporalmente el comando ingresado.
		String comando = null;

		// Guarda el argumento ingresado para definir el espacio entre los
		// digitos.
		int espacioDigitos = 0;
		
		// Objeto que imprime cada comando.
		ImpresorLCD0 impresorLCD = null;
		
		// Guarda las instancias de los digítos con las claves correspondientes. 
		Map<String, Digito> digitos = null;

		try (Scanner lector = new Scanner(System.in)) {

			System.out.print("Espacio entre Digitos (0 a 5): ");
			comando = lector.next();

			// Valida si es un numero
			if (!Validaciones.isNumeric(comando)) {
				throw new IllegalArgumentException("Cadena " + comando + " no es un entero");
			}

			espacioDigitos = Integer.parseInt(comando);

			// se valida que el espaciado este entre 0 y 5
			if (!Validaciones.isValidDigitSpace(espacioDigitos)) {
				throw new IllegalArgumentException("El espacio entre " + "digitos debe estar entre 0 y 5");
			}

			// Obtiene lineas de comandos al menos una vez hasta que el comando
			// iniciado sea igual que la cadena final.
			do {
				System.out.print("Entrada: ");
				comando = lector.next();

				if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
					listaComando.add(comando);
				}
			} while (!comando.equalsIgnoreCase(CADENA_FINAL));

			// Guarda las instancias de los digitos.
			digitos = new HashMap<String, Digito>();
			
			digitos.put("0", new Cero());
			digitos.put("1", new Uno());
			digitos.put("2", new Dos());
			digitos.put("3", new Tres());
			digitos.put("4", new Cuatro());
			digitos.put("5", new Cinco());
			digitos.put("6", new Seis());
			digitos.put("7", new Siete());
			digitos.put("8", new Ocho());
			digitos.put("9", new Nueve());

			// Crea una instancia del impresorLCD y le envia las instancias de
			// los dígitos.
			impresorLCD = new ImpresorLCD0(digitos);

			Iterator<String> iterator = listaComando.iterator();
			while (iterator.hasNext()) {
				impresorLCD.procesar(iterator.next(), espacioDigitos);
			}
			
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}

	}

}
