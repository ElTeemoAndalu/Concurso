package esther;
/**
 * Interfaz del tablero.
 * 
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 * 
 * @see      Tablero
 *
 */
public interface TableroDibujable {
	/**
	 * Pinta el tablero del jugador en una versión estándar.
	 * @param 	jugador 	El jugador contrario pintará la combinación comprobadora.
	 * @return	cadena		Tablero del jugador.
	 * 
	 * @since 	1.0
	 */
	String pintarTablero(Jugador jugador);
	/**
	 * Pinta el tablero del jugador en una versión reducida.
	 * @param 	jugador 	El jugador contrario pintará la combinación comprobadora.
	 * @return	cadena		Tablero del jugador.
	 * 
	 * @since 	1.0
	 */
	String pintarTableroMini(Jugador jugador);
}
