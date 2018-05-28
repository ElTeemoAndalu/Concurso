package esther;
/**
 * Indica quién jugará en el modo fácil.
 * 
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 * 
 * @see      MenuConfiguracion
 *
 */
public enum Opciones {
	JUGAR(1), INSTRUCCIONES(2), SALIR(3);
	/**
	 * Número que indica la opción.
	 */
	private int num;
	/**
	 * Construye un nuevo objeto Opciones a partir del número especificado.
	 * @param num  Número que se relaciona con la opción.
	 */
	Opciones (int num) {
		this.num=num;
	}
	/**
	 * Obtiene la opción de lo que quiere configurar.
	 * @return  Número
	 * 
	 * @since   1.0
	 */
	public int getNum() {
		return num;
	}	
}
