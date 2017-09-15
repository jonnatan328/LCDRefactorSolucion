package components;
/**
 * Clase para crear puntos fijos en una matriz.
 * 
 * @author Jonnatan Ríos
 *
 */
public class PuntoFijo {

	// Número de la fila en la matriz.
	private int fila = 0;
	//Número de la columna en la matriz.
	private int columna = 0;
	
	public PuntoFijo() {
		super();
	}

	/**
	 * Asigna el valor de la fila.
	 * @param fila
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}

	/**
	 * Obtiene el valor de la fila.
	 * @return
	 */
	public int getFila() {
		return this.fila;
	}
	
	/**
	 * Asigna el valor de la columna.
	 * @param columna
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	/**
	 * Obtiene el valor de la columna.
	 * @return
	 */
	public int getColumna() {
		return this.columna;
	}

}
