package mastermind;

import java.util.LinkedHashMap;
/**
 * Que almacena la clase
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public abstract class Usuario {
	
	/**
	 * Almacena un mapa para comparar los colores, ademas de 2 metodos comunes a jugador y maquina(crearCombinacionSecreta y rellenarCombinacion)
	 */
	//Clase comun de jugador y maquina
	LinkedHashMap<Integer, Integer> mapaComparacion = new LinkedHashMap<Integer, Integer>();
	protected abstract Combinacion crearCombinacionSecreta();
	protected abstract Combinacion rellenarCombinacion();
	
}
