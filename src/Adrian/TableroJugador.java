package mastermind;


import java.util.ArrayList;
/**
 * Esta clase contiene una lista de tipo Jugada
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.5
 *
 */
public class TableroJugador implements Dibujable {
	private ArrayList<Jugada> tablero;

	/**
	 * Construye una lista de tipo Jugada
	 */
	TableroJugador() {
		tablero = new ArrayList<>();
	}

	/**
	 * Dibuja el tablero completo jugada a jugada
	 * 
	 * @return El dibujo del tablero.
	 */
	public String dibujar() {
		String dibujo = "";
		int i = 0;
		while (i < tablero.size()) {
			dibujo += String.format("%s\n", tablero.get(i).dibujar());
			i++;
		}

		return dibujo;
	}

	public ArrayList<Jugada> getTablero() {
		return tablero;
	}
}
