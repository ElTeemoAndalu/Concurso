package Ismael;

import java.util.Arrays;

/**
 * Esta clase almacena un array de objetos Casilla
 * 
 * @author Ismael Raqi Picardo
 * @version 1.0
 * @since 1.0
 *
 */
public class Combinacion {
	
	/**
	 * Almacena un array de objetos Casilla
	 */
	public Casilla combinacion[];
	
	/**
	 * Construye un nuevo objeto Combinacion que contiene el especificado array de objetos Casilla
	 * @param modo  El modo que determinará la longitud del array
	 */
	public Combinacion(Modos modo){
		combinacion = new Casilla[modo.getCasillas()];
	}
	
	/**
	 * Método get del atributo combinacion
	 * @return		combinacion		Objeto de la clase Combinacion que será la combinación del jugador
	 */
	public Casilla[] getCombinacion() {
		return combinacion;
	}
	
	/**
	 * Método set del atributo combinacion
	 * @param		combinacion		Objeto de la clase Combinacion
	 */
	public void setCombinacion(Casilla combinacion[]) {
		this.combinacion = combinacion;
	}

	/**
	 * Devuelve el hashcode del atributo combinacion que será la combinación del jugador
	 * @return 		un número int
	 */
	@Override
	public int hashCode() {
		return Arrays.hashCode(combinacion);
	}

	/**
	 * Compara este objeto con el objeto especificado
	 * @param obj	El objeto a comparar. Puede ser null
	 * @return 		true: si son iguales. 
	 * 				false: si son diferentes.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean igual = false;
		if (obj instanceof Combinacion && Arrays.equals(combinacion, ((Combinacion) obj).combinacion)) {
			igual = true;
		}
		return igual;
	}
	
	
	
}
