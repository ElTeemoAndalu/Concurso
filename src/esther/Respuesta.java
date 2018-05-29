package esther;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Almacena las jugadas del jugador.
 * 
 * @author 		Esther Castañeda
 * @version		1.0
 * @since		1.0
 * 
 * @see			Combinacion
 */
public class Respuesta {
	/**
	 * Almacena el número de fichas blancas.
	 */
	private int blancas = 0;
	/**
	 * Almacena el número de fichas negras.
	 */
	private int negras = 0;
	/**
	 * Guarda en una colección las combinaciones propuestas del jugador.
	 */
	private ArrayList <Combinacion> combinaciones = new ArrayList<Combinacion>();
	/**
	 * Guarda en una colección las combinaciones comprobadoras del jugador.
	 */
	private ArrayList <Combinacion> combinacionByN = new ArrayList<Combinacion>();
	/**
	 * Añade las combinaciones propuestas del jugador a la colección de combinaciones propuestas.
	 * @param	combinacion		Combinación propuesta.
	 * 
	 * @since	1.0
	 */
	public void addCombinacion(Combinacion combinacion) {
		combinaciones.add(combinacion);
	}
	/**
	 * Añade las combinaciones comproobadoras del jugador a la colección de combinaciones comprobadoras.
	 * @param	combinacion		Combinación comprobadora.
	 * 
	 * @since	1.0
	 */
	public void addByN(Combinacion combinacion) {
		combinacionByN.add(combinacion);
	}
	/**
	 * Comprueba si el jugador ha ganado o ha perdido al adivinar la combinación oculta.
	 * 
	 * @param   intento      Número de intentos que lleva el jugador.
	 * @param   maxIntento   Número máximo de intentos permitidos.
	 * @param   maxFichas    Número de fichas máximas permitidas.
	 * @return  true:  Si tiene todas las fichas negras y el número de intentos es menor o igual al número de intentos máximo.
	 * 			false: Si no tiene todas las fichas negras y el número de intentos es menor o igual al número de intentos máximo.
	 * 
	 *  @since  1.0
	 */
	public boolean esGanador(int intento, int maxIntento, int maxFichas) {
		boolean gana;
		
		if (negras == maxFichas && intento<=maxIntento) {
			gana = true;
		} else {
			gana = false;
		}
		
		return gana;
	}
	/**
	 * Se introduce por parámetros la combinación oculta y la combinacion jugada por el jugador y se comprueba las fichas negras y blancas.
	 * 
	 * @param  combinacion         Combinación intentada por el jugador.
	 * @param  combinacionOculta   Combinación oculta del jugador contrario.
	 * 
	 * @since  1.0
	 */
	public void comprobarByN(Combinacion combinacionOculta, Combinacion combinacion) {
		int i, j;
		int aparece, mismaPosicion;
		
		Map<Color, Boolean> apareceMap = new HashMap<Color, Boolean>();
		Map<Color, Boolean> mismaPosicionMap = new HashMap<Color, Boolean>();
		
		apareceMap.clear();
		mismaPosicionMap.clear();

		// Combrueba si hay fichas blancas
		for (i=0; i<combinacionOculta.getFicha().length; i++) {
			for (j=0; j<combinacion.getFicha().length; j++) {
				if (combinacionOculta.getFicha()[i].equalsColor(combinacion.getFicha()[j]) && !combinacionOculta.getFicha()[i].equalsPosicion(combinacion.getFicha()[j])) {
					apareceMap.put(combinacion.colorNameFicha(j), true);
				}
			}
		}
		
		// Comprueba si hay fichas negras
		for (i=0; i<combinacionOculta.getFicha().length; i++) {
			if (combinacionOculta.getFicha()[i].equalsColor(combinacion.getFicha()[i])) {
				mismaPosicionMap.put(combinacion.colorNameFicha(i), true);
				apareceMap.put(combinacion.colorNameFicha(i), false);
				
			}
		}
				
		mismaPosicion = mismaPosicionMap.size();
		aparece = apareceMap.size();
		
		aparece = aparece - mismaPosicion;
		
		blancas = aparece;
		negras = mismaPosicion;
	}
	/**
	 * Obtiene el número de fichas blancas.
	 * @return	blancas 	Número de fichas blancas. 
	 * 
	 * @since	1.0
	 */
	public int getBlancas() {
		return blancas;
	}
	/**
	 * Obtiene el número de fichas negras.
	 * @return	negras 	Número de fichas negras. 
	 * 
	 * @since	1.0
	 */
	public int getNegras() {
		return negras;
	}
}
