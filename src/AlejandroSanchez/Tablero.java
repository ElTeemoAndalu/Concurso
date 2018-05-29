package AlejandroSanchez;

import java.util.ArrayList;
import java.util.Arrays;

/** 
 * Esta clase almacenará los datos del tablero de cada usuario
 * @author Alejandro Sánchez
 * @see Jugador
 * @version 1.0
 * @since 1.0
 *
 */
public class Tablero {
	/**
	 * Modo de juego asignado por el usuario
	 * @see ModoJuego
	 */
	private ModoJuego modo;
	/**
	 * Lista con todas las combinaciones introducidas por el jugador junto a sus respuestas
	 * @see CombinacionRespuesta
	 */
	private ArrayList<CombinacionRespuesta> combinaciones_respuestas = new ArrayList<>(); 
	private int numIntentos, numColores;
	private boolean repeticion;
	/**
	 * Combinación que el jugador deberá de adivinar para ganar
	 * @see Combinacion
	 */
	private Combinacion combSecreta;
	private CombinacionRespuesta casillas;
	
	/**
	 * Se generará un tablero con el modo de juego pasado por parámetro
	 * @param modo Modo de juego generado dependiendo de la elcción del usuario
	 * @see ModoJuego
	 */
	public Tablero(ModoJuego modo) {
		this.modo = modo;
		setModo(modo);
	}
	
	public CombinacionRespuesta getCombinacion() {
		return casillas;
	}
	
	public ModoJuego getModo() {
		return modo;
	}
	
	public int getIntentos() {
		return numIntentos;
	}	
	
	public Combinacion getcombSecreta() {
		return combSecreta;
	}
	
	public boolean isRepeticion() {
		return repeticion;
	}
	
	public int getNumColores() {
		return numColores;
	}
	
	public void setCombinacionSecreta(Combinacion combSecreta) {
		this.combSecreta = combSecreta;
	}
	
	/**
	 * Añadirá la combinación introducida a la lista de combinaciones
	 * @param combinacion Combinación que será añadida
	 */
	public void colocarCombinacionLista(CombinacionRespuesta combinacion) {

		combinaciones_respuestas.add(combinacion);

	}
	
	public ArrayList<CombinacionRespuesta> getCombinaciones(){
		return combinaciones_respuestas;
	}
	
	/**
	 * Generará una nueva combinación que introducirá el jugador
	 * @see CombinacionRespuesta
	 */
	public void nuevaCombinacion() {
		casillas = new CombinacionRespuesta(modo.getDificultad().getNumCasillas());
	}
	
	/**
	 * Compara la combinación secreta con la introducida por el jugador 
	 * @return True: Si son iguales. False: Si no son iguales
	 */
	public boolean compararCombinaciones() {
		Casilla combinacionUsuario[] = casillas.getCeldas();
		Casilla combinacionSecreta[] = combSecreta.getCeldas();
		return Arrays.equals(combinacionUsuario, combinacionSecreta);
	}
	
	/**
	 * Almacena los intentos disponibles, la longitud de cada combinación y el número de colores que serán usados para la partida
	 * @param modo Modo de juego generado dependiendo de la elcción del usuario
	 * @see Dificultad
	 */
	public void setModo(ModoJuego modo) {
	
		numIntentos = modo.getDificultad().getNumIntentos();
		casillas = new CombinacionRespuesta(modo.getDificultad().getNumCasillas());
		combSecreta = new Combinacion(modo.getDificultad().getNumCasillas());
		numColores = modo.getDificultad().getNumColores();

	}

	
}
