package digitos;

import java.util.Map;

import components.PuntoFijo;

/**
 * Implementa los metodos para agregar el dígito uno.
 * 
 * @author Jonnatan Ríos
 *
 */
public class Uno implements Digito {

	@Override
	public void agregarAlTablero(String[][] tablero, Map<String, PuntoFijo> puntosFijos, int size) {
		// Puntos fijos desdes donde se crea el dígito.
		PuntoFijo puntoFijo1 = null;
		PuntoFijo puntoFijo2 = null;

		// Obtengo los puntos fijos de interes para el dígito.
		puntoFijo1 = puntosFijos.get("pf5");
		puntoFijo2 = puntosFijos.get("pf4");

		// Dibuja todos los segmentos del dígito dentro del tablero.
		for (int y = 1; y <= size; y++) {

			int valorS1 = puntoFijo1.getFila() + y;
			tablero[valorS1][puntoFijo1.getColumna()] = CARACTER_VERTICAL;
			int valorS2 = puntoFijo2.getFila() + y;
			tablero[valorS2][puntoFijo2.getColumna()] = CARACTER_VERTICAL;
		}

	}

}
