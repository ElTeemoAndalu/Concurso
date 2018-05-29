package mastermind;
/**
 * Esta clase almacena los colores
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.0
 *
 */

public class Ficha implements Dibujable{
	private String color;
	/**
	 * Construye un nuevo objeto Ficha.
	 */
	public Ficha() {
		
	}
	@Override
	public int hashCode() {
		int hash;
		hash= color.hashCode();
		return hash;
	}
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Ficha && color.equals(((Ficha) obj).color)) {
			resultado=true;
		}
		return resultado;
	}
	/**
	 * Dibuja la ficha
	 * @return			El dibujo de la ficha.
	 */
	@Override
	public String dibujar() {
		String dibujo=String.format("%s", color);
		return dibujo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
