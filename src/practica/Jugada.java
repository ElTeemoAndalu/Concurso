package practica;

/** 
 * Esta clase crea un array de casillas con el constructor de tipo int.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

public class Jugada implements Dibujable{
	
	/** 
	 * Almacena un objeto Combinación.
	 * Almacena un objeto Respuesta.
	 */

	private Combinacion combinacion;
	private Respuesta respuesta;
	
	/**
	 * Construye un nuevo objeto Jugada.
	 * @param combinacion  La combinación que se haya introducido.
	 * @param respuesta  La respuesta correspondiente a esa combinación.
	 */
	
	Jugada(Combinacion combinacion, Respuesta respuesta){
		this.combinacion=combinacion;
		this.respuesta=respuesta;
	}
	
	/**
	 * Devuelve la combinación que se haya introducido.
	 * @return el atributo combinacion.
	 */
	
	Combinacion getCombinacion() {
		return combinacion;
	}
	
	/**
	 * Devuelve la respuesta de la combinación.
	 * @return el atributo respuesta.
	 */
	
	Respuesta getRespuesta() {
		return respuesta;
	}
	
	/**
	 * Dibuja la jugada, dibujando la combinación y luego la respuesta.
	 */
	
	public void dibujar(){
		combinacion.dibujar();
		respuesta.dibujar();
	}
	
}
