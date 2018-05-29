package Ismael;

/**
 * Este enum almacena el número de casillas y el número de colores de los distintos modos de juego
 * 
 * @author Ismael Raqi Picardo
 * @version 1.0
 * @since 1.0
 *
 */
public enum Modos {
	
	FACIL (4, 8), MEDIO (5, 8), DIFICIL (8, 10), INSTRUCCIONES(0,0);
	
	/**
	 * Almacena un número para las casillas
	 */
	private int casillas;
	
	/**
	 * Almacena un número para los colores
	 */
	private int colores;
	
	/**
	 * Método get del atributo casillas
	 * @return		int		Número de casillas de la combinación
	 */
	protected int getCasillas(){
		return casillas;
	}
	
	/**
	 * Método get del atributo colores
	 * @return		int		Número de colores de la combinación
	 */
	protected int getColores(){
		return colores;
	}
	
	/**
	 * Construye un nuevo enum Modos que contiene el número de casillas y el número de colores
	 * @param casillas  Determina cuántas casillas tendrá el objeto Combinacion
	 * @param colores  Determina cuántos colores tendrá el objeto Combinacion
	 */
	Modos(int casillas, int colores){
		this.casillas = casillas;
		this.colores = colores;
	}

}
