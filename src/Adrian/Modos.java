package mastermind;
/**
 * Esta clase contiene los distintos modos de juego y sus atributos.
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.0
 *
 */
public enum Modos {
	Facil('F', 4, 8, false, 10), Medio('M', 5, 8, false, 15), Dificil('D', 8, 10, true, -1);
	private char codigo;
	private int numCasillas;
	private int numColores;
	private boolean color_Repetido;
	private int intentos;
	/**
	 * Construye un nuevo objeto Modo con unos atributos ya definidos.
	 */
	Modos(char codigo, int numCasillas, int numColores, boolean color_Repetido, int intentos) {
		this.codigo = codigo;
		this.numCasillas = numCasillas;
		this.numColores = numColores;
		this.color_Repetido = color_Repetido;
		this.intentos = intentos;
	}

	public char getCodigo() {
		return codigo;
	}

	public int getNumCasillas() {
		return numCasillas;
	}

	public int getNumColores() {
		return numColores;
	}

	public boolean isColor_Repetido() {
		return color_Repetido;
	}

	public int getIntentos() {
		return intentos;
	}

}
