package practica;

/** 
 * Esta clase almacena su tablero con la coreespondiente dificultad.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

import java.util.LinkedList;

public class Tablero {
	
	/** 
	 * Almacena la dificultad de la partida, 
	 * para darle tamaño a las dos combinacione y el número máximo de intentos.
	 * Guarda las combinaciones ocultas de los dos jugadores.
	 * Guarda un ArrayList de jugadas, que tiene de tamaño máximo el número de intentos de esa dificultad.
	 */

	private Dificultad dificultad;
	private Combinacion combinacionOcultaPropia, combinacionOcultaContrario;
	private LinkedList<Jugada>jugada = new LinkedList<Jugada>();
	
	/**
	 * Construye un nuevo objeto Tablero
	 * @param dificultad  La dificultad de la partida.
	 */
	
	Tablero(Dificultad dificultad){
		this.dificultad=dificultad;
	}
	
	/**
	 * Devuelve la combinación del jugador que posee el tablero.
	 * @return La combinación oculta.
	 */
	
	Combinacion getCombinacionOcultaPropia() {
		return combinacionOcultaPropia;
	}
	
	/**
	 * Devuelve la combinación del jugador contrario al que posee el tablero.
	 * @return La combinación oculta.
	 */
	
	Combinacion getCombinacionOcultaContrario() {
		return combinacionOcultaContrario;
	}
	
	/**
	 * Devuelve la última jugada que se ha ejecutado.
	 * @return La última jugada..
	 */
	
	Jugada ultimaJugada() {
		return jugada.getLast();
	}
	
	/**
	 * Modifica la combinación del jugador que posee el tablero.
	 * @param La combinación oculta.
	 */
	
	void setCombinacionOcultaPropia(Combinacion combinacionOcultaPropia) {
		this.combinacionOcultaPropia=combinacionOcultaPropia;
	}
	
	/**
	 * Modifica la combinación del jugador contrario al que posee el tablero.
	 * @param La combinación oculta.
	 */
	
	void setCombinacionOcultaContrario(Combinacion combinacionOcultaContrario) {
		this.combinacionOcultaContrario=combinacionOcultaContrario;
	}
	
	/**
	 * Añade una jugada a la pila de jugadas.
	 * @param La jugada que va a ser añadida.
	 */
	
	void anhadirJugada(Jugada jugada) {
		this.jugada.addLast(jugada);
	}
	
	/**
	 * Imprime por pantalla todas las jugadas realizadas en ese momento.
	 */
	
	void dibujar() {
		int i;
		for (i = 0; i < jugada.size(); i++) {
			System.out.printf("Intento nº %d:\t",i+1);
			jugada.get(i).dibujar();
			System.out.println();
		}
	}
	
	/**
	 * Imprime por pantalla todas las jugadas realizadas en ese momento y la oculta.
	 */
	
	void dibujarCompleto() {
		int i;
		for (i = 0; i < jugada.size(); i++) {
			System.out.printf("Intento nº %d:\t",i+1);
			jugada.get(i).dibujar();
			System.out.println();
		}
		System.out.println("La combinación oculta era: ");
		combinacionOcultaContrario.dibujar();
	}
	
}
