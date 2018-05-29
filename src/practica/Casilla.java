package practica;

/** 
 * Esta clase almacena el color en un objeto casilla.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

public class Casilla implements Dibujable{
	
	/** 
	 * Almacena el color que es de tipo cadena.
	 */
	
	static final String FONDO_NEGRO = "\u001B[48;5;0m";
	static final String FONDO_BURDEOS = "\u001B[48;5;1m";
	static final String FONDO_VERDE = "\u001B[48;5;2m";
	static final String FONDO_AMARILLO = "\u001B[48;5;11m";
	static final String FONDO_AZUL = "\u001B[48;5;4m";
	static final String FONDO_MORADO = "\u001B[48;5;5m";
	static final String FONDO_CELESTE = "\u001B[48;5;6m";
	static final String FONDO_BLANCO = "\u001B[48;5;7m";
	static final String FONDO_GRIS = "\u001B[48;5;8m";
	static final String FONDO_ROJO = "\u001B[48;5;9m";
	static final String RESET = "\u001B[0m";
	
	static String[] colores={"\u001B[48;5;0m", "\u001B[48;5;1m", "\u001B[48;5;2m", "\u001B[48;5;11m", "\u001B[48;5;4m", "\u001B[48;5;5m", "\u001B[48;5;6m", "\u001B[48;5;7m", "\u001B[48;5;8m", "\u001B[48;5;9m"};
	static String[] coloresRespuesta = {"\u001B[48;5;9m", "\u001B[48;5;7m", "\u001B[48;5;0m"};
	private String color;
	
	/**
	 * Construye un nuevo objeto Casilla para las combinaciones que contiene la posicion específica del array de colores de tipo int.
	 * @param posicion  El número que corresponde a la posición del array de colores.
	 */
	
	public Casilla(int posicion){ //Constructor para las casillas de la clase combinación
		color=colores[posicion];
	}
	
	/**
	 * Construye un nuevo objeto Casilla para las respuestas que contiene la posicion específica del array de colores de tipo byte.
	 * @param posicionRespuesta  El número que corresponde a la posición del array de colores.
	 */
	
	Casilla(byte posicionRespuesta){ //Constructor para las casillas de la clase respuesta.
		color=coloresRespuesta[posicionRespuesta];
	}
	
	/**
	 * Devuelve el color de la casilla.
	 * @return El atributo color.
	 */
	
	public String getColor() {
		return color;
	}
	
	/**
	 * Imprime por pantalla la casilla.
	 */
	
	public void dibujar() {
		System.out.printf("%s  %s", color, Casilla.RESET);
	}
	
	/**
	 * Compara objetos casilla.
	 * @param obj	El objeto a comparar. Puede ser <code>null</code>
	 * @return 		true: si son iguales. 
	 * 				false: si son diferentes. 
	 */
	
	public static String devolverColor(int posicion) {
		return colores[posicion];
	}
	
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Casilla
				&& color.equals(((Casilla)obj).color)){
			resultado=true;
		}		
		return resultado;		
	}
	
}
