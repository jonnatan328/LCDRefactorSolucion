package digitos;

import java.util.Map;

import components.PuntoFijo;

/**
 * Implementa los metodos para agregar el dígito ocho.
 * 
 * @author Jonnatan Ríos
 *
 */
public class Ocho implements Digito {

	@Override
	public void agregarAlTablero(String[][] tablero, Map<String, PuntoFijo> puntosFijos, int size) {
		// Puntos fijos desdes donde se crea el dígito.
		PuntoFijo puntoFijo1 = null;
		PuntoFijo puntoFijo2 = null;
		PuntoFijo puntoFijo3 = null;
		PuntoFijo puntoFijo4 = null;
		PuntoFijo puntoFijo5 = null;

		puntoFijo1 = puntosFijos.get("pf1");
		puntoFijo2 = puntosFijos.get("pf2");
		puntoFijo3 = puntosFijos.get("pf3");
		puntoFijo4 = puntosFijos.get("pf4");
		puntoFijo5 = puntosFijos.get("pf5");

		// Dibuja todos los segmentos del dígito dentro del tablero.
		for (int y = 1; y <= size; y++) {

			int valorS1 = puntoFijo1.getColumna() + y;
			tablero[puntoFijo1.getFila()][valorS1] = CARACTER_HORIZONTAL;
			int valorS2 = puntoFijo1.getFila() + y;
			tablero[valorS2][puntoFijo1.getColumna()] = CARACTER_VERTICAL;
			int valorS3 = puntoFijo2.getColumna() + y;
			tablero[puntoFijo2.getFila()][valorS3] = CARACTER_HORIZONTAL;
			int valorS4 = puntoFijo2.getFila() + y;
			tablero[valorS4][puntoFijo2.getColumna()] = CARACTER_VERTICAL;
			int valorS5 = puntoFijo4.getFila() + y;
			tablero[valorS5][puntoFijo4.getColumna()] = CARACTER_VERTICAL;
			int valorS6 = puntoFijo3.getColumna() + y;
			tablero[puntoFijo3.getFila()][valorS6] = CARACTER_HORIZONTAL;
			int valorS7 = puntoFijo5.getFila() + y;
			tablero[valorS7][puntoFijo5.getColumna()] = CARACTER_VERTICAL;

		}

	}

}
