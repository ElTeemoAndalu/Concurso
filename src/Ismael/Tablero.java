package Ismael;

import java.util.ArrayList;

/**
 * Esta clase almacena 2 objetos ArrayList para el tablero y la pista, respectivamente
 * @author Ismael Raqi Picardo
 * @version 1.0
 * @since 1.0
 *
 */
public class Tablero implements Dibujable {

	/**
	 * Almacena un ArrayList para el tablero donde se almacenaran los intentos
	 */
	private ArrayList<Combinacion> tablero;
	/**
	 * Almacena un ArrayList para las combinaciones generadas por los jugadores donde se almacenaran las pistas
	 */
	private ArrayList<Combinacion> pista;

	/**
	 * Construye un nuevo objeto Tablero que inicializa sus objetos ArrayList
	 */
	protected Tablero() {
		tablero = new ArrayList<Combinacion>();
		pista = new ArrayList<Combinacion>();
	}

	/**
	 * Método para ir añadiendo objetos Combinacion a los ArrayList
	 * @param		fila	El objeto Combinacion que representa los intentos del jugador
	 * @param		pista	El objeto Combinacion que representa la pista a los intentos del jugador
	 */
	protected void añadirAlTablero(Combinacion fila, Combinacion pista) {
		tablero.add(fila);
		this.pista.add(pista);

	}
	
	/**
	 * Método get del atributo tablero
	 * @return		ArrayList		Objeto ArrayList que contendrá todos los intentos de un jugador
	 */
	protected ArrayList<Combinacion> getTablero() {
		return this.tablero;
	}
	
	/**
	 * Método get del atributo pista
	 * @return		ArrayList		Objeto ArrayList que contendrá todas las pistas de un jugador
	 */
	protected ArrayList<Combinacion> getPista() {
		return this.pista;
	}

	/**
	 * Método implementado de la interfaz Dibujable para mostrar por consola el tablero entero (intentos y pistas)
	 * @param		tablero	El objeto Tablero que se va a recorrer y mostrar por consola
	 */
	@Override
	public void dibujarTablero(Tablero tablero) {

		System.out.printf("\n\n");
		for (int i = 0; i < tablero.tablero.size(); i++) {
			System.out.printf("Intento %d: ", i + 1);
			for (int h = 0; h < tablero.tablero.get(i).getCombinacion().length; h++) {
				System.out.printf("%s ", tablero.tablero.get(i).getCombinacion()[h].getColor());
			}
			System.out.printf("         Pista: ");
			
			for (int t=0;t<tablero.pista.get(i).getCombinacion().length;t++) {
				System.out.printf("%s ",tablero.pista.get(i).getCombinacion()[t].getColor());
			}

			System.out.printf("\n\n");
		}
		System.out.printf("\n\n");
	}

}
