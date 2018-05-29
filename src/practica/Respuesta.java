package practica;

/** 
 * Esta clase crea un array de casillas con el constructor de tipo byte.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

public class Respuesta implements Dibujable{
	
	/** 
	 * Crea un array de casillas de un tamaño que depende de la dificultad.
	 */

	private Casilla tamanho[];	
	
	/**
	 * Construye un nuevo objeto Respuesta.
	 * @param dificultad  La dificultad de la partida.
	 */
	
	Respuesta(Dificultad dificultad){
		tamanho=new Casilla[(byte)dificultad.getCantidadCasillas()];
	}
	
	/**
	 * Devuelve una posición del array de casillas.
	 * @return La posición especificada.
	 */
	
	Casilla[] getTamanho() {
		return tamanho;
	}
	
	/**
	 * Se rellena el array de casillas con objetos casilla.
	 * @param la posicion del array que se va a rellenar.
	 * @param el color con el que se va a rellenar, en este caso coge el array de los colores de respuesta.
	 */
	
	void anhadirRespuesta(int posicion, byte colorRespuesta){
		tamanho[posicion]=new Casilla(colorRespuesta);
	}
	
	/**
	 * Imprime por pantalla el array de casillas, el espacio entre ellas y al final un salto de línea.
	 */
	
	public void dibujar() {
		int i;
		for (i = 0; i < tamanho.length; i++) {
			tamanho[i].dibujar();
			System.out.print("  ");
		}
		System.out.println();
	}
	
}
