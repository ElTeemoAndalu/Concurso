package mastermind;

/**
 * Esta clase contiene dos objetos de tipo TableroJugador
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.5
 *
 */
public class TableroPartida implements Dibujable {
	private TableroJugador tablero1;
	private TableroJugador tablero2;

	/**
	 * Construye un nuevo objeto TableroPartida con dos tableros
	 */
	TableroPartida() {
		tablero1 = new TableroJugador();
		tablero2 = new TableroJugador();
	}

	/**
	 * Añade dos tableros nuevos al Tablero.
	 * 
	 * @param tablero1
	 *            Tablero nuevo a añadir.
	 * @param tablero2
	 *            Tablero nuevo a añadir.
	 */
	public void addTableros(TableroJugador tablero1, TableroJugador tablero2) {
		this.tablero1 = tablero1;
		this.tablero2 = tablero2;
	}

	/**
	 * Dibuja el tablero de la partida completo jugada a jugada
	 * 
	 * @return El dibujo del tablero.
	 */
	public String dibujar() {
		String dibujo = "";
		int i;
		if ((tablero1.getTablero().size() > 3)) {
			i = tablero1.getTablero().size() - 3;
		} else {
			i = 0;
		}
		while (i < tablero1.getTablero().size()) {
			dibujo += String.format("%s\t%s\n", tablero1.getTablero().get(i).dibujar(),
					tablero2.getTablero().get(i).dibujar());
			i++;
		}

		return dibujo;
	}

	public TableroJugador getTablero1() {
		return tablero1;
	}

	public TableroJugador getTablero2() {
		return tablero2;
	}

}
