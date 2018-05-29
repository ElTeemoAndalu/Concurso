package practica;

/** 
 * Esta clase crea un array de casillas con el constructor de tipo int.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

public class Combinacion implements Dibujable{

	/** 
	 * Crea un array de casillas de un tamaño que depende de la dificultad.
	 * Almacena la dificultad de la partida, para darle tamaño al array de casillas.
	 */
	
	private Casilla tamanho[];
	private Dificultad dificultad;	
	
	/**
	 * Construye un nuevo objeto Combinación
	 * @param dificultad  La dificultad de la partida.
	 */
	
	public Combinacion(Dificultad dificultad){
		this.dificultad=dificultad;
		tamanho=new Casilla[dificultad.getCantidadCasillas()];
	}
	
	/**
	 * Devuelve una posición del array de casillas.
	 * @return La posición especificada.
	 */
	
	public Casilla[] getTamanho() {
		return tamanho;
	}
	
	/**
	 * Devuelve la dificultad de la partida.
	 * @return El atributo dificultad.
	 */
	
	Dificultad getDificultad() {
		return dificultad;
	}
	
	public Casilla devolverCasilla(int posicion) {
		return tamanho[posicion];
	}
	
	/**
	 * Se rellena el array de casillas con objetos casilla.
	 * @param la posicion del array que se va a rellenar.
	 * @param el color con el que se va a rellenar.
	 */
	
	void crearCombinacion(int posicion, int color){
		tamanho[posicion]=new Casilla(color);
	}
	
	/**
	 * Imprime por pantalla el array de casillas, el espacio entre ellas y al final una tabulación.
	 */
	
	public void dibujar() {
		int i;
		for (i = 0; i < tamanho.length; i++) {
			tamanho[i].dibujar();
			System.out.print("  ");
		}
		System.out.print("\t");
	}
	
}
