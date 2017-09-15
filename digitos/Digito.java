package digitos;
import java.util.Map;

import components.PuntoFijo;

/**
 * Define los metodos para agregar cada dígito al tablero.
 * @author Jonnatan R�os
 *
 */
public interface Digito {
	
	// Constantes para crear los segmentos de cada dígito.
	public static final String CARACTER_VERTICAL = "|";
	public static final String CARACTER_HORIZONTAL = "-";
	
	/**
	 * Agrega un dígito al tablero.
	 * @param tablero
	 * @param puntosFijos
	 * @param size
	 */
	public void agregarAlTablero(String[][] tablero, Map<String, PuntoFijo> puntosFijos, int size);

}
