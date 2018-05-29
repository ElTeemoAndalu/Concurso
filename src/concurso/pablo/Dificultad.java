package concurso.pablo;

/**
 * Enum que almacena las dificultades posibles a elegir por el usuario.
 * 
 * @author pablo
 *
 */
public enum Dificultad {
	FACIL(4, 8, false, 10), MEDIO(5, 8, false, 15), DIFICIL(8, 10, true, 0);

	private int intentos, numeroCasillas, numeroColores;
	private boolean repeticionColores;

	/**
	 * Crea una dificultad.
	 * @param numeroCasillas Introduce el numero de casillas maximo a utilizar en esa dificultad.
	 * @param numeroColores Introduce el numero de colores maximo a utilizar en esa dificultad.
	 * @param repeticionColores Introduce la repeticion de colores a utilizar en esa dificultad.
	 * @param intentos Introduce el numero de intentos maximos a utilizar en esa dificultad.
	 */
	private Dificultad(int numeroCasillas, int numeroColores, boolean repeticionColores, int intentos) {
		this.numeroCasillas = numeroCasillas;
		this.numeroColores = numeroColores;
		this.repeticionColores = repeticionColores;
		this.intentos = intentos;
	}

	/**
	 * @return Devuelve el numero de casillas que posee esa dificultad.
	 */
	public int getNumeroCasillas() {
		
		return numeroCasillas;
	}

	/**
	 * 
	 * @return Devuelve el numero de colores que posee esa dificultad.
	 */
	
	public int getNumeroColores() {
		return numeroColores;
	}

	/**
	 * 
	 * @return Devuelve si en esa dificultad hay repeticion de colores o no.
	 */
	
	public boolean isRepeticionColores() {
		return repeticionColores;
	}

	/**
	 * 
	 * @return Devuelve el numero de intentos de esa dificultad.
	 */
	public int getIntentos() {
		return intentos;
	}
}
