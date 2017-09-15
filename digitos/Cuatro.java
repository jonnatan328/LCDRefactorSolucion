package digitos;

import java.util.Map;

import components.PuntoFijo;

/**
 * Implementa los metodos para agregar el dígito cuatro.
 * 
 * @author Jonnatan Ríos
 *
 */
public class Cuatro implements Digito {

	@Override
	public void agregarAlTablero(String[][] tablero, Map<String, PuntoFijo> puntosFijos, int size) {
		// Puntos fijos desdes donde se crea el dígito.
		PuntoFijo puntoFijo1 = null;
		PuntoFijo puntoFijo2 = null;
		PuntoFijo puntoFijo3 = null;
		PuntoFijo puntoFijo4 = null;

		// Obtengo los puntos fijos de interes para el dígito.
		puntoFijo1 = puntosFijos.get("pf1");
		puntoFijo2 = puntosFijos.get("pf2");
		puntoFijo3 = puntosFijos.get("pf4");
		puntoFijo4 = puntosFijos.get("pf5");

		// Dibuja todos los segmentos del dígito dentro del tablero.
		for (int y = 1; y <= size; y++) {

			int valorS1 = puntoFijo1.getFila() + y;
			tablero[valorS1][puntoFijo1.getColumna()] = CARACTER_VERTICAL;
			int valorS2 = puntoFijo2.getColumna() + y;
			tablero[puntoFijo2.getFila()][valorS2] = CARACTER_HORIZONTAL;
			int valorS3 = puntoFijo3.getFila() + y;
			tablero[valorS3][puntoFijo3.getColumna()] = CARACTER_VERTICAL;
			int valorS4 = puntoFijo4.getFila() + y;
			tablero[valorS4][puntoFijo4.getColumna()] = CARACTER_VERTICAL;

		}

	}

}
