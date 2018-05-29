package esther;
/**
 * Indica quién jugará en el modo fácil.
 * 
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 * 
 * @see      ModoJuego
 *
 */
public enum ModoFacil {
	USUARIO(1), MAQUINA(2);
	/**
	 * Número del jugador.
	 */
	private int opcion;
	/**
	 * Construye un nuevo objeto ModoFacil a partir del número especificado.
	 * @param opcion  Número del jugador que jugará.
	 */
	ModoFacil(int opcion){
		this.opcion = opcion;
	}	
	/**
	 * Obtiene la opción respecto del jugador que jugará.
	 * @return  opcion  Número del jugador.
	 * 
	 * @since   1.0
	 */
	public int getOpcion() {
		return opcion;
	}
}
