package esther;
/**
 * Indica la dificultad que se establecerá la partida.
 * 
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 *
 */
public enum ModoJuego {
	
	FACIL (1, 4, 8, false, 10), MEDIO (2, 5, 8, false, 15), DIFICIL (3, 8, 10, true, 0);
	/**
	 * Número de fichas usables.
	 */
	private int numcasilla, 
	/**
	 * Número de colores disponibles.
	 */
	numcolores, 
	/**
	 * Número de intentos máximo.
	 */
	numintentos, 
	/**
	 * Número de la opción que pertenece.
	 */
	opcion;
	/**
	 * Indica si se pueden repetir los colores en la combinación oculta.
	 */
	private boolean repeticionColor;
	/**
	 * Construye un nuevo objeto ModoJuego a partir del número de la opción, de casillas, de intentos y la repetición o no de colores.
	 * @param opcion			Opción de la dificultad.
	 * @param numcasilla		Casillas máxima.
	 * @param numcolores		Colores disponibles.
	 * @param repeticionColor	Repetición o no de colores.
	 * @param numIntentos		Intentos máximo.
	 */
	ModoJuego(int opcion, int numcasilla, int numcolores, boolean repeticionColor, int numIntentos) {		
		this.opcion=opcion;
		this.numcasilla=numcasilla;
		this.numcolores=numcolores;
		this.repeticionColor=repeticionColor;
		this.numintentos=numIntentos;
	}
	/**
	 * Obtiene la opción del modo del juego.
	 * @return		Opcion  Número de la dificultad.
	 * 
	 * @since		1.0
	 */
	public int getOpcion() {
		return opcion;
	}
	/**
	 * Obtiene el número de casillas que se utilizará.
	 * @return		numCasilla  Número de casillas disponibles.
	 * 
	 * @since		1.0
	 */
	public int getCasilla() {
		return numcasilla;
	}
	/**
	 * Obtiene el número de colores disponibles para usar.
	 * @return		numcolores  Número de colores disponible.
	 * 
	 * @since		1.0
	 */
	public int getNumColores() {
		return numcolores;
	}
	/**
	 * Obtiene la repetición o no de colores.
	 * @return		true:  Los colores se pueden repetir.
	 * 				false: Los colores no se pueden repetir.
	 * 
	 * @since		1.0
	 */
	public boolean getRepeticion() {
		return repeticionColor;
	}
	/**
	 * Obtiene el número de intentos máximo de la dificultad.
	 * @return		numintentos	Número de intentos máximo.
	 * 
	 * @since		1.0
	 */
	public int getIntentos() {
		return numintentos;
	}
	/**
	 * Obtiene la información de los atributos del modo de juego elegido.
	 * 
	 * @since		1.0
	 */
	public String toString() {
		return String.format(" - Nº de casillas: %d\n - Nº de colores: %d\n - ¿Se repite? %s\n - Nº de intentos: %d\n__________________________", getCasilla(),getNumColores(),getRepeticion()?"Si":"No",getIntentos());
	}
}
