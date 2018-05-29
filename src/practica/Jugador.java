package practica;

/** 
 * Esta clase almacena su tablero con la coreespondiente dificultad.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

public abstract class Jugador {
	
	/** 
	 * Cada jugador tiene su tablero.
	 * Se almacena también la dificultad de la partida.
	 */
	
	protected Tablero tablero;
	protected Dificultad dificultad;
	
	/**
	 * Construye un objeto jugador que tiene su tablero.
	 * @param dificultad  La dificultad de la partida que se le pasa también a tablero.
	 */
	
	Jugador(Dificultad dificultad){
		this.dificultad=dificultad;
		tablero=new Tablero(dificultad);
	}
	
	/**
	 * Devuelve el tablero del jugador.
	 * @return El atributo tablero.
	 */
	
	Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * Crea una combinación y la devuelve.
	 */
	
	abstract Combinacion crearCombinacion();
	
	/**
	 * Crea una combinación oculta y la devuelve.
	 */
	
	abstract Combinacion crearCombinacionOculta();
	
	/**
	 * Crea una respuesta según una combinación y devuelve un objeto jugada.
	 * @param la combinación a la que se le asigna la respuesta.
	 */
	
	abstract Jugada crearRespuesta(Combinacion combinacion);
	
}
