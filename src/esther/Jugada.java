package esther;
/**
 * Esta clase crea jugadas que el jugador hace durante la partida.
 * 
 * @author Esther Castañeda
 * @version  1.0
 * @since    1.0
 * 
 * @see Partida
 * @see Respuesta
 * @see Jugador
 * @see Combinacion
 *
 */
public class Jugada {
	/**
	 * Indica el jugador que va a hacer la jugada.
	 */
	private Jugador jugador;
	/**
	 * Indica el número de jugadas que lleva el jugador.
	 */
	private int intentos = 1;
	/**
	 * Recibe la respuesta de las combinaciones comprobadas
	 */
	private Respuesta respuesta = new Respuesta();
	/**
	 * Construye un nuevo objeto Jugada a partir del Jugador especificado.
	 * 
	 * @param jugador El jugador a partir del cual se crea el objeto Jugada.
	 */
	Jugada (Jugador jugador) {
		this.jugador = jugador;
	}
	/**
	 * Se introduce fichas para crear una combinación para adivinar la combinación oculta.
	 * 
	 * @since  1.0
	 */
	protected void turnoAdivinar() {
		jugador.introducirFicha();
	}
	/**
	 * Se introduce por parámetros la combinación oculta y la combinacion jugada por el jugador y se comprueba las fichas negras y blancas.
	 * Luego se establece un controlador en el jugador por si se equivocan introduciendo las blancas y negras salte un aviso para que revisen de nuevo.
	 * 
	 * @param  combinacion         Combinación intentada por el jugador.
	 * @param  combinacionOculta   Combinación oculta del jugador contrario.
	 * 
	 * @since  1.0
	 */
	protected void turnoComprobarByN(Combinacion combinacion, Combinacion combinacionOculta) {
		respuesta.comprobarByN(combinacionOculta, combinacion);
		jugador.addByN(respuesta.getBlancas(), respuesta.getNegras());
		System.out.println();
	}
	/**
	 * Comprueba si el jugador ha ganado o ha perdido al adivinar la combinación oculta.
	 * 
	 * @param   intento      Número de intentos que lleva el jugador.
	 * @param   maxIntento   Número máximo de intentos permitidos.
	 * @param   maxFichas    Número de fichas máximas permitidas.
	 * @return  true:  Si tiene todas las fichas negras y el número de intentos es menor o igual al número de intentos máximo.
	 * 			false: Si no tiene todas las fichas negras y el número de intentos es menor o igual al número de intentos máximo.
	 * 
	 *  @since  1.0
	 */
	protected boolean esGanador (int intento, int maxIntento, int maxFichas) {
		return respuesta.esGanador(intento, maxIntento, maxFichas);
	}
	
	// Pinta Combinación
	/**
	 * Pinta la ronda en una versión estándar.
	 * @param  jugByN  Jugador contrario que introducirá la combinación de blancas y negras.
	 * @return cadena  Devuelve la combinacion de esa ronda con las fichas blancas y negras.
	 * 
	 * @since  1.0
	 */
	public String pintarJugada(Jugador jugByN) {
		String jugada = "";
		if (intentos<=9) {
			jugada = jugada +
					 ("      " + jugador.getPintaFila() + "\n" +
					  " Nº0" + intentos + " " + jugador.getPintaFila() + jugByN.getPintaByN() + "\n" +
					  "      " + jugador.getPintaFila() + "\n\n");
		} else {
			jugada = jugada +
					 ("      " + jugador.getPintaFila() + "\n" +
					  " Nº" + intentos + " " + jugador.getPintaFila() + jugByN.getPintaByN() + "\n" +
					  "      " + jugador.getPintaFila() + "\n\n");
		}
		intentos++;
		return jugada;
	}
	/**
	 * Pinta la ronda en una versión reducida.
	 * @param jugByN  Jugador contrario que introducirá la combinación de blancas y negras.
	 * @return cadena Devuelve la combinacion de esa ronda con las fichas blancas y negras.
	 * 
	 * @since  1.0
	 */
	public String pintarJugadaMini(Jugador jugByN) {
		String jugada = "";
		jugada = jugada + (" Nº0" + intentos + " " + jugador.getPintaMini() + jugByN.getPintaByN()+ "\n\n");
		
		intentos++;
		
		return jugada;
	}
	/**
	 * Pinta la combinación del jugador en esa ronda en una versión estándar.
	 * 
	 * @since  1.0
	 */
	public void pintarCombinacion() {
		int j;
		for (j=0; j<3; j++) { // Altura de las fichas
			System.out.print("      ");
			System.out.println(jugador.getPintaFila());
		}
	}	
}
