package mastermind;


import java.util.Arrays;
/**
 * Esta clase contiene una combinacion de colores y un modo que dara tamaño a esa combinacion.
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.0
 *
 */
public class Combinacion implements Dibujable {
	private Ficha[] casillas;
	private Modos modo;

	/**
	 * Construye un nuevo objeto Combinacion que contiene el modo de juego.
	 * 
	 * @param modo
	 *            El modo a partir del cual se da tamaño a las casillas.
	 */
	public Combinacion(Modos modo) {
		this.modo = modo;
		this.casillas = new Ficha[modo.getNumCasillas()];

	}

	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Combinacion && Arrays.equals(casillas, ((Combinacion) obj).casillas)
				&& modo.equals(((Combinacion) obj).modo)) {
			resultado = true;
		}
		return resultado;
	}
	/**
	 * Dibuja la combinacion completa a partir del metodo dibujar de ficha.
	 * @return			El dibujo de la combinacion.
	 */
	public String dibujar() {
		int i;
		String dibujo = "";
		for (i = 0; i < casillas.length; i++) {
			if (i == casillas.length - 1) {
				dibujo = dibujo + String.format(" %s |", casillas[i].dibujar());
			} else {
				dibujo = dibujo + String.format(" %s", casillas[i].dibujar());
			}
		}
		return dibujo;

	}

	public Ficha[] getCasillas() {
		return casillas;
	}

	public void setCasillas(Ficha[] casillas) {
		this.casillas = casillas;
	}

	public Modos getModo() {
		return modo;
	}

}
