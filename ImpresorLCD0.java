import java.util.HashMap;
import java.util.Map;

import components.PuntoFijo;
import digitos.Digito;
import util.Validaciones;

/**
 * Clase que crea el tablero y lo imprime.
 * @author Jonnatan Ríos Vásquez
 *
 */

public class ImpresorLCD0 {

	private String[][] matrizImpr;
	private int size;

	private Map<String, Digito> digitosObj = null;

	public ImpresorLCD0(Map<String, Digito> digitos) {
		// Inicializa variables
		this.digitosObj = digitos;
	}

	/**
	 *
	 * Metodo encargado de procesar la entrada que contiene el size del segmento
	 * de los digitos y los digitos a imprimir
	 *
	 * @param comando
	 *            Entrada que contiene el size del segmento de los digito y el
	 *            numero a imprimir
	 * @param espacioDig
	 *            Espacio Entre digitos
	 */
	public void procesar(String comando, int espacioDigitos) {

		String[] parametros = null;
		int cantidadParametros = 0;
		int tamaño = 0;
		String numeroAImprimir = null;

		if (!comando.contains(",")) {
			throw new IllegalArgumentException("Cadena " + comando + " no contiene caracter ,");
		}

		// Se hace el split de la cadena
		parametros = comando.split(",");
		// Se obtiene la cantidad de parametos divididos por coma.
		cantidadParametros = parametros.length;

		// Valida la cantidad de parametros
		if (cantidadParametros > 2 || cantidadParametros < 2) {
			throw new IllegalArgumentException(
					"Cadena " + comando + " no contiene la cantidad de parametros requeridos");
		}

		boolean isTamañoNumerico = Validaciones.isNumeric(parametros[0]);

		// Valida que el parametro size sea un numerico
		if (!isTamañoNumerico) {
			throw new IllegalArgumentException("Parametro Size [" + parametros[0] + "] no es un numero");
		}
		tamaño = Integer.parseInt(parametros[0]);

		// se valida que el size este entre 1 y 10
		if (tamaño < 1 || tamaño > 10) {
			throw new IllegalArgumentException("El parametro size [" + tamaño + "] debe estar entre 1 y 10");
		}
		this.size = tamaño;
		numeroAImprimir = parametros[1];

		// Realiza la impresion del numero
		agregarDigitosAlTablero(numeroAImprimir, espacioDigitos);

	}

	/**
	 *
	 * Metodo encargado de imprimir un numero
	 *
	 * @param size
	 *            Tamaño Segmento Digitos
	 * @param numeroImp
	 *            Numero a Imprimir
	 * @param espacio
	 *            Espacio Entre digitos
	 */
	private void agregarDigitosAlTablero(String numeroImp, int espacioDigitos) {
		int pivotX = 0;
		char[] digitos = null;
		int filasDigito = 0;
		int columnasDigito = 0;

		// Calcula el numero de filas cada digito
		filasDigito = (2 * this.size) + 3;

		// Calcula el numero de columna de cada digito
		columnasDigito = this.size + 2;

		crearTablero(filasDigito, columnasDigito, numeroImp, espacioDigitos);

		// crea el arreglo de digitos
		digitos = numeroImp.toCharArray();

		for (char digito : digitos) {

			// Valida que el caracter sea un digito
			if (!Character.isDigit(digito)) {
				throw new IllegalArgumentException("Caracter " + digito + " no es un digito");
			}

			// Calcula puntos fijos
			Map<String, PuntoFijo> puntosFijos = calcularPuntosFijos(filasDigito, columnasDigito, pivotX);

			// Incrementa el pivotX para calcular los puntos fijos del siguiente
			// dígito.
			pivotX = pivotX + columnasDigito + espacioDigitos;

			// Obtiene la instancia del objeto a insertar en el tablero.
			Digito objetoDigito = this.digitosObj.get(String.valueOf(digito));

			// Se agrega el digito al tablero.
			objetoDigito.agregarAlTablero(this.matrizImpr, puntosFijos, this.size);
		}
		
		// Llama el metodo para imprimir el tablero.
		imprimirTablero();

	}
	
	/**
	 * Este metodo imprime el tablero con los dígitos ingresados.
	 * 
	 */

	private void imprimirTablero() {
		int maxFilas = this.matrizImpr.length;
		
		// Recorre la matriz e imprime los valores de cada celda.
		for (int i = 0; i < maxFilas; i++) {
			int maxColumnas = this.matrizImpr[i].length;
			for (int j = 0; j < maxColumnas; j++) {
				System.out.print(this.matrizImpr[i][j]);
			}
			System.out.println();
		}

	}
	
	/**
	 * Este metodo crea el tablero con dimensiones especificas donde se imprimen los digitos.
	 *  
	 * @param filasDigito
	 * @param columnasDigito
	 * @param numeroImp
	 * @param espacio
	 */

	private void crearTablero(int filasDigito, int columnasDigito, String numeroImp, int espacio) {

		int totalFilas = 0;
		int totalColumnas = 0;

		// Calcula el total de filas de la matriz en la que se almacenaran los
		// digitos
		totalFilas = filasDigito;

		// Calcula el total de columnas de la matriz en la que se almacenaran
		// los digitos
		totalColumnas = (columnasDigito * numeroImp.length()) + (espacio * numeroImp.length());

		// crea matriz para almacenar los numero a imprimir
		this.matrizImpr = new String[totalFilas][totalColumnas];

		// Inicializa matriz
		for (int i = 0; i < totalFilas; i++) {
			for (int j = 0; j < totalColumnas; j++) {
				this.matrizImpr[i][j] = " ";
			}
		}

	}
	
	/**
	 * Este método calcula los puntos fijos para agregar lo cada dígito.
	 * @param filasDigito
	 * @param columnasDigito
	 * @param pivotX
	 * @return puntos fijos.
	 */

	private Map<String, PuntoFijo> calcularPuntosFijos(int filasDigito, int columnasDigito, int pivotX) {
		Map<String, PuntoFijo> puntosFijos = new HashMap<String, PuntoFijo>();
		
		// Objetos puntos fijos para cada dígito
		PuntoFijo puntoFijo1 = new PuntoFijo();
		PuntoFijo puntoFijo2 = new PuntoFijo();
		PuntoFijo puntoFijo3 = new PuntoFijo();
		PuntoFijo puntoFijo4 = new PuntoFijo();
		PuntoFijo puntoFijo5 = new PuntoFijo();
		
		// Asigna la fila y la columna a cada punto.
		puntoFijo1.setFila(0);
		puntoFijo1.setColumna(0 + pivotX);
		puntoFijo2.setFila(filasDigito / 2);
		puntoFijo2.setColumna(0 + pivotX);
		puntoFijo3.setFila(filasDigito - 1);
		puntoFijo3.setColumna(0 + pivotX);
		puntoFijo4.setFila(columnasDigito - 1);
		puntoFijo4.setColumna((filasDigito / 2) + pivotX);
		puntoFijo5.setFila(0);
		puntoFijo5.setColumna((columnasDigito - 1) + pivotX);

		puntosFijos.put("pf1", puntoFijo1);
		puntosFijos.put("pf2", puntoFijo2);
		puntosFijos.put("pf3", puntoFijo3);
		puntosFijos.put("pf4", puntoFijo4);
		puntosFijos.put("pf5", puntoFijo5);

		return puntosFijos;

	}

}
