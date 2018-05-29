package esther;
/**
 * Tablero donde se irá mostrando todas las jugadas del jugador.
 * 
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 * 
 * @see      Jugada
 *
 */
public class Tablero implements TableroDibujable{
	/**
	 * Se almacena las jugadas del jugador.
	 */
	private Jugada jugada;
	/**
	 * Se almacena la jugada completa de ambos jugadores.
	 */
	private String ronda = "";
	/**
	 * Construye el objeto Tablero a partir la jugada.
	 * @param jugada	Jugada a patir del cual se creará el objeto Tablero.
	 */
	Tablero (Jugada jugada) {
		this.jugada = jugada;
	}
	/**
	 * Pinta el tablero del jugador en una versión estándar.
	 * @param 	jugador 	El jugador contrario pintará la combinación comprobadora.
	 * @return	cadena		Tablero del jugador.
	 * 
	 * @since 	1.0
	 */
	public String pintarTablero(Jugador jugador) {
		ronda += jugada.pintarJugada(jugador);
		return ronda;
	}
	/**
	 * Pinta el tablero del jugador en una versión reducida.
	 * @param 	jugador 	El jugador contrario pintará la combinación comprobadora.
	 * @return	cadena		Tablero del jugador.
	 * 
	 * @since 	1.0
	 */
	public String pintarTableroMini(Jugador jugador) {
		ronda += jugada.pintarJugadaMini(jugador);
		return ronda;
	}
}
