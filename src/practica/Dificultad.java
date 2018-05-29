package practica;

/** 
 * Este enum contiene las distintas dificultades existentes con la cantidad de:
 * casillas, colores, intentos y la posibilidad de repetir colores.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

public enum Dificultad {

	FACIL(4,8,10,false), MEDIO(5,8,15,true), DIFICIL(8,10,-1,true);
	
	/** 
	 * Almacena la cantidad de casillas que van a tener las combinaciones y las respuestas.
	 * Almacena la cantidad de colores diferentes que se van a poder introducir en las combinaciones.
	 * Almacena la cantidad máxima de intentos que van a tener los jugadores.
	 * Almacena la posibilidad de que se pueda repetir colores en las combinaciones.
	 */
	
	private int cantidadCasillas, cantidadColores, intentos;
	private boolean repetirColor;
	
	/**
	 * Construye la dificultad, según cual sea tendrá unos valores u otros.
	 * @param cantidadCasillas  La cantidad de casillas.
	 * @param cantidadColores  La cantidad de colores posibles.
	 * @param intentos  La cantidad de intentos máximos.
	 * @param repetirColor  true: si se puede repetir color. 
	 * 						false: si no se puede repetir color.
	 */
	
	Dificultad(int cantidadCasillas, int cantidadColores, int intentos, boolean repetirColor){
		this.cantidadCasillas=cantidadCasillas;
		this.cantidadColores=cantidadColores;
		this.intentos=intentos;
		this.repetirColor=repetirColor;
	}
	
	/**
	 * Devuelve la cantidad de casillas.
	 * @return El atributo cantidadCasillas.
	 */
	
	int getCantidadCasillas(){
		return cantidadCasillas;
	}
	
	/**
	 * Devuelve la cantidad de colores.
	 * @return El atributo cantidadColores.
	 */
	
	int getCantidadColores(){
		return cantidadColores;
	}
	
	/**
	 * Devuelve la cantidad de intentos.
	 * @return El atributo intentos.
	 */
	
	int getIntentos(){
		return intentos;
	}
	
	/**
	 * Devuelve la posibilidad de repetición de color.
	 * @return El atributo repetirColor:	true: si se puede repetir color. 
	 * 										false: si no se puede repetir color.
	 */
	
	boolean getRepetirColor(){
		return repetirColor;
	}
}
