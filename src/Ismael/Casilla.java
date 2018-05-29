package Ismael;

/**
 * Esta clase almacena una cadena que contendrá los colores
 * 
 * @author Ismael Raqi Picardo
 * @version 1.0
 * @since 1.0
 *
 */
public class Casilla {
	/**
	 * Almacena un string
	 */
	private String color;
	
	/**
	 * Construye un nuevo objeto Casilla con un atributo String a partir del String especificado
	 * @param color  El String a partir del cual se crea el atributo color
	 */
	public Casilla(String color){
		this.color = color;
	}
	
	/**
	 * Método get del atributo color
	 * @return		color		Es un color
	 */
	public String getColor(){
		return color;
	}
	
	/**
	 * Método set del atributo color
	 * @param		color		Es un color
	 */
	protected void setColor(String color){
		this.color = color;
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
		if (obj instanceof Casilla && color.equals(((Casilla) obj).color)) {
			igual = true;
		}
		return igual;
	}
	
}
