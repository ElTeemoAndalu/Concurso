package mastermind;

/**
 * Esta clase contiene dos combinaciones y el modo de juego.
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.0
 *
 */
public class Jugada implements Dibujable {
	private Combinacion combinacion;
	private Combinacion respuesta;
	Modos modo;

	/**
	 * Construye un nuevo objeto Jugada que contiene el modo de juego.
	 * 
	 * @param modo
	 *            El modo que se le asigna a cada objeto Combinacion de la clase.
	 */
	public Jugada(Modos modo) {
		this.modo = modo;
		combinacion = new Combinacion(modo);
		respuesta = new Combinacion(modo);
	}

	/**
	 * Añade dos combinaciones nueva a la jugada
	 * 
	 * @param combinacion
	 *            Combinacion que el jugador ha seleccionado
	 * @param respuesta
	 *            Respuesta que recibe segun su semejanza con la que debe acertar
	 */
	public void addJugada(Combinacion combinacion, Combinacion respuesta) {
		this.combinacion = combinacion;
		this.respuesta = respuesta;
	}

	/**
	 * Dibuja la jugada completa a partir del metodo dibujar de combinacion.
	 * 
	 * @return El dibujo de la jugada.
	 */
	public String dibujar() {
		String dibujo = String.format("%s%s", combinacion.dibujar(), respuesta.dibujar());

		return dibujo;
	}

	public Combinacion getCombinacion() {
		return combinacion;
	}

	public Combinacion getRespuesta() {
		return respuesta;
	}

	public Modos getModo() {
		return modo;
	}

}
