package esther;

/**
 * Esta clase almacena los colores y la posición que tiene una ficha.
 * 
 * @author Esther Castañeda
 * @version 1.0
 * @since 1.0
 * @see Color
 *
 */
public class Ficha  {
	/**
	 * Almacena el color.
	 */
	private Color color;
	/**
	 * Almacena la posición que tendrá la ficha en la combinación. 
	 */
	private int posicion;
	/**
	 * Construye un nuevo objeto ficha a partir del color y posición especificada por el jugador.
	 * @param color     El color a partir del cual se crea el objeto Ficha.
	 * @param posicion  La posición a partir del cual se crea el objeto Ficha.
	 */
	// Constructor
	Ficha (Color color, int posicion) {
		this.color = color;
		this.posicion = posicion;
	}
	/**
	 * Obtiene el color que posee la ficha.
	 * @return color  Devuelve el color que tiene la ficha.
	 * @since  1.0
	 */
	public Color getFichaColor() {
		return color;
	}	
	/**
	 * Compara el color con el objeto especificado.
	 * @param    objeto	Objeto que se introduce para comparar el color del objeto ficha.
	 * @return   true:  Si ambos colores son iguales.
	 * 			 false: Si ambos colores no son iguales.
	 * @since    1.0
	 */
	public boolean equalsColor(Object objeto) {
		boolean esIgual = false;
		
		if(objeto instanceof Ficha && color == ((Ficha)objeto).color) {
			esIgual = true;
		}
		return esIgual;
	}
	/**
	 * Compara la posición con el objeto especificado.
	 * @param    objeto	Objeto que se introduce para comparar la posición del objeto ficha.
	 * @return   true:  Si ambas posiciones son iguales.
	 * 			 false: Si ambas posiciones no son iguales.
	 * @since    1.0
	 */
	public boolean equalsPosicion(Object objeto) {
		boolean esIgual = false;
		
		if(objeto instanceof Ficha && posicion == ((Ficha)objeto).posicion){
			esIgual = true;
		}
		return esIgual;
	}
	/**
	 * Compara la posición y el color con el objeto especificado.
	 * @param    objeto	Objeto que se introduce para compararlo con el objeto ficha.
	 * @return   true:  Si ambos colores y posiciones son iguales.
	 * 			 false: Si ambos colores y posiciones no son iguales.
	 * @since    1.0
	 */
	public boolean equals(Object objeto) {
		boolean esIgual = false;
		
		if(objeto instanceof Ficha && color == ((Ficha)objeto).color && posicion == ((Ficha)objeto).posicion){
			esIgual = true;
		}
		return esIgual;
	}
}
