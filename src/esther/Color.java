package esther;

/**
 * Esta enum guarda los colores que se van a poder usar durante el juego.
 * 
 * @author Esther Castañeda
 * @version 1.0
 * @since 1.0
 *
 */
public enum Color {
	AZUL("\u001B[104m"), LIMA("\u001B[102m"), VERDE("\u001B[42m"),
	AMARILLO("\u001B[103m"), ROJO("\u001B[101m"), MORADO("\u001B[46m"), 
	MARINO("\u001B[44m"), GRIS("\u001B[100m"), BURDEOS("\u001B[41m") , DORADO("\u001B[43m"),
	NEGRO("\u001B[40m"),BLANCO("\u001B[37m"), RESET("\u001B[0m");
	private String color;
	/**
	 * Son los colores que se podrán utilizar durante el juego
	 * @param color  El color a partir del cual se crea el objeto Color para la interfaz.
	 */
	Color (String color){
		this.color=color;
	}
	/**
	 * Obtiene el color indicado por el jugador 
	 * @return 		color: el cual haya escogido el jugador en su combinación.  
	 * @since 		1.0
	 * @see Combinacion
	 * @see Jugador
	 */
	protected String getColor() {
		return color;
	}
}
