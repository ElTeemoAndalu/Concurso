package mastermind;

import static mastermind.Colores.*;
import java.util.Random;
import mastermind.Teclado.Incluido;
/**
 * Esta clase contiene un nombre y dos combinaciones , una secreta y otra para adivinar del jugador, junto a su modo.
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.0
 *
 */
public abstract class Jugador {
	protected String nombre;
	protected Combinacion combinacionSecreta;
	protected Combinacion acertarCombinacion;
	protected Modos modo;
	/**
	 * Construye un nuevo objeto Jugador que contiene el modo de juego.
	 * 
	 * @param modo
	 *            El modo a partir del cual se asigna a las combinaciones.
	 */
	Jugador(Modos modo) {
		this.modo = modo;
		combinacionSecreta = new Combinacion(modo);
		acertarCombinacion = new Combinacion(modo);
	}
	/**
	 * Devuelve la combinación secreta del Jugador ya rellenada.
	 * @return			Combinación Secreta
	 */
	public abstract Combinacion rellenarCombiSecret();
	/**
	 * Devuelve la combinación Acertar del Jugador ya rellenada.
	 * @param tablero   Recibe el tablero de la partida que se está jugadno
	 * @return			Combinación a Acertar.
	 */
	public abstract Combinacion rellenarCombinacionAcertar(TableroJugador tablero);
	/**
	 * Devuelve una pista de aciertos y errores al rival
	 * @param combiComprobar   Combinacion a comprobar (la secreta propia).
	 * @param combiRival       Combinación del rival a comparar con la nuestra.
	 * @return			Pista de errores y aciertos de la jugada.
	 */
	public abstract Combinacion darAciertosRival(Combinacion combiComprobar,Combinacion combiRival);
	/**
	 * Devuelve una ficha que se le asignara a una casilla de la combinacion utilizada
	 * @param tipoJugador	El jugador que usara el método, lo cual variará este.
	 * @return			Una ficha
	 */
	public Ficha elegirCombi(int tipoJugador) {
		Ficha ficha = new Ficha();
		Random rnd = new Random();
		int respuesta = 0;
		if (tipoJugador == 1) {
			respuesta = Teclado.leerNumEntre(Incluido.INCLUIDOS, 1, getModo().getNumColores());
		} else if (tipoJugador == 2) {
			respuesta = rnd.nextInt(modo.getNumColores()) + 1;
		}
		switch (respuesta) {
		case 1:
			ficha.setColor(CELESTE + (char) 9209 + RESET);
			break;
		case 2:
			ficha.setColor(ROJO + (char) 9209 + RESET);
			break;
		case 3:
			ficha.setColor(VERDE + (char) 9209 + RESET);
			break;
		case 4:
			ficha.setColor(AZUL + (char) 9209 + RESET);
			break;
		case 5:
			ficha.setColor(AMARILLO + (char) 9209 + RESET);
			break;
		case 6:
			ficha.setColor(MORADO + (char) 9209 + RESET);
			break;
		case 7:
			ficha.setColor(ROSA + (char) 9209 + RESET);
			break;
		case 8:
			ficha.setColor(VERDE_CLARO + (char) 9209 + RESET);
			break;
		case 9:
			ficha.setColor(CELESTE_CLARO + (char) 9209 + RESET);
			break;
		case 10:
			ficha.setColor(AMARILLO_CLARO + (char) 9209 + RESET);
			break;
		}
		return ficha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setAcertarCombinacion(Combinacion acertarCombinacion) {
		this.acertarCombinacion = acertarCombinacion;
	}
	public Combinacion getCombinacionSecreta() {
		return combinacionSecreta;
	}
	public Combinacion getAcertarCombinacion() {
		return acertarCombinacion;
	}
	public Modos getModo() {
		return modo;
	}
}
