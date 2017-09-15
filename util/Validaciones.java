package util;

/**
 * Clase para validaciones en general del sistema
 * 
 * @author Jonnatan Ríos Vásquez
 */
public class Validaciones {

	/**
	 *
	 * Metodo encargado de validar si una cadena es numerica
	 * 
	 * @return true, si la cadena ingresada en numerica, de lo contrario false
	 * @param cadena
	 *            Cadena
	 */
	public static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	/**
	 *
	 * Metodo encargado de validar si el valor del espacio entre digitos está
	 * entre los valores permitidos.
	 * 
	 * @return true, si la cadena ingresada en numerica, de lo contrario false
	 * @param cadena
	 *            Cadena
	 */
	public static boolean isValidDigitSpace(int espacioDigitos) {
		return (espacioDigitos >= 0 || espacioDigitos <= 5) ;
		
	}
}
