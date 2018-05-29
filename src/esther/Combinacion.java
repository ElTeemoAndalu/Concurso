package esther;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase almacena las fichas de la combinación.
 * 
 * @author Esther Castañeda
 * @version 1.0
 * @since 1.0
 * @see ModoJuego
 * @see Ficha
 *
 */
public class Combinacion {
	/**
	 * Se establece la dificultad en la que está para previamente saber cuántas fichas y colores son necesarios en la combinación.
	 */
	private ModoJuego dificultad;
	/**
	 * Le indicará a la ficha en que posición de la combinación irá colocada.
	 */
	private int posicion = 0;
	/**
	 * Número máximo de fichas que se podrá colocar en la combinación. Este número depende de la dificultad configurada.
	 */
	private int maxFichas;
	/**
	 * Almacena las fichas seleccionadas por el jugador.
	 */
	private Ficha ficha [];
	/**
	 * Construirá un objeto combinación en el que se añadiran un rango de 4 a 8 fichas (dependiendo de la dificultad).
	 * @param  dificultad  La dificultad a partir del cual se crea el objeto Combinacion.
	 */
	// Constructor
	public Combinacion (ModoJuego dificultad) {
		this.dificultad = dificultad;
		maxFichas = dificultad.getCasilla();
		ficha = new Ficha [maxFichas];
	}
	/**
	 * El jugador seleccionará un color para introducirlo en la ficha.
	 * A medida que vaya introduciendolo, irá guardando en la ficha el color y en la posición que estará colocada dentro de la combinación.
	 * @param  color	Color de la ficha que va a añadir.
	 * 
	 * @since  1.0
	 */
	public void introducirFicha(Color color) {
		if (posicion == maxFichas) {
			posicion = 0;
		}
		ficha [posicion] = new Ficha (color, posicion);
		posicion ++;
	}
	/**
	 * El jugador indicará el número de fichas blancas y negras a la hora de comprobar la combinación del jugador contrario.
	 * @param  blancas	Número de fichas blancas que tiene que añadir.
	 * @param  negras	Número de fichas negras que tiene que añadir.
	 * 
	 * @since  1.0
	 */
	public void addByN(int blancas, int negras) {
		int posicion;
		int numBlancas = 0, numNegras = 0;
		ficha= new Ficha [maxFichas];
		Color color;
		
		// El jugador introducirá el número de fichas que aparecen y las que están bien posicionadas.
		numBlancas = blancas;
		numNegras = negras;
		
		// Una vez introducido los datos se crearán las fichas Blancas y Negras. 
		for (posicion=0; posicion<numBlancas; posicion++) {
			color = Color.BLANCO;
			ficha[posicion] = new Ficha(color, posicion); // El jugador introduce las fichas en la combinacion
		}
		for (posicion=numBlancas; posicion<(numBlancas+numNegras); posicion++) { // Se suma para que el recuento de las fichas no se reinicie.
			color = Color.NEGRO;
			ficha[posicion] = new Ficha(color, posicion); // El jugador introduce las fichas en la combinacion
		}
		for (posicion=(numBlancas+numNegras); posicion<maxFichas; posicion++) {
			color = Color.RESET;
			ficha[posicion] = new Ficha(color, posicion); // El jugador introduce las fichas en la combinacion
		}
	}
	/**
	 * Comprueba si se repite los colores al añadir la combinación oculta.
	 * Esto sirve para los modos de juegos fácil y medio.
	 * @return  true: Si se repiten los colores.
	 * 		    false: Si no se repiten los colores. 
	 * @since   1.0
	 */
	public boolean noRepetidorColores() { 
	    int i; 
	    boolean sonIgual; 
	    
	    Map<Color, Boolean> colorMap = new HashMap<Color, Boolean>();
	    
	    for (i=0; i<ficha.length; i++) {
	    	colorMap.put(ficha[i].getFichaColor(), false);
	    	
	    	for (int j=0; j<ficha.length; j++) {
	    		if (ficha[i].getFichaColor().equals(ficha[j].getFichaColor()) && (i!=j)) {
	    			colorMap.put(ficha[i].getFichaColor(), true);
	    		} 
	    	}
	    }	    
	    
	    if (colorMap.containsValue(true)) {
	    	sonIgual = true;
	    } else {
	    	sonIgual = false;
	    }
	    
	    return sonIgual; 
	 } 
	/**
	 * Devuelve el nombre del color de la ficha.
	 * @param   i : Indica la posición de la ficha que quiere escoger de la combinación.
	 * @return  color
	 * @since   1.0
	 */
	// Getters
	public Color colorNameFicha (int i) {
		return ficha[i].getFichaColor();
	}
	/**
	 * Devuelve las fichas que ha seleccionado el jugador en la partida.
	 * 
	 * @return  ficha
	 * @since   1.0
	 * @see		Partida
	 */
	public Ficha [] getFicha() {
		return ficha;
	}
	/**
	 * Se pinta la combinación de comprobación (fichas blancas y negras).
	 * @return  cadena
	 * @since   1.0
	 */
	// Dibujable
	public String pintarByN() {
		int i;
		String pinNegro = "■", pinBlanco = "□";
		String cadena = "";
		maxFichas = dificultad.getCasilla();
		
		for (i=0; i<maxFichas; i++) { // Indica cuantos colores tiene que pintar
			if (ficha[i].getFichaColor() == Color.NEGRO) {
				cadena = cadena + (pinNegro + "  ");
			} else if (ficha[i].getFichaColor() == Color.BLANCO) {
				cadena = cadena + (pinBlanco + "  ");
			} else {
				cadena = cadena + ("");
			}
		}
		
		return cadena;
	}
	/**
	 * Se pinta la combinación escogida por el usuario en la partida.
	 * @return  fila: Devuelve la fila de la combinación.
	 * @since   1.0
	 * @see     Partida
	 */
	public String pintarFila() {
		int i;
		
		String fila = "";
		
		for (i=0; i<ficha.length; i++) { // Indica cuantos colores tiene que pintar
			fila = fila + ficha[i].getFichaColor().getColor() + "     " + Color.RESET.getColor() + "  ";
		}
		
		return fila;
	}
	/**
	 * Se pinta la combinación escogida por el usuario en la partida pero con una interfaz más reducida.
	 * @return  fila: Devuelve la combinación.
	 * @since   1.0
	 * @see     Partida
	 */
	public String pintarMini() {
		int i;
		
		String fila = "";
		
		for (i=0; i<ficha.length; i++) { // Indica cuantos colores tiene que pintar
			fila = fila + ficha[i].getFichaColor().getColor() + "  " + Color.RESET.getColor() + "  ";
		}
		
		return fila;
	}
	/**
	 * Compara las fichas y el número de fichas con el objeto especificado.
	 * @param    objeto	Objeto que se introduce para compararlo con el objeto Combinacion.
	 * @return   true:  Si ambas fichas y número de fichas son iguales.
	 * 			 false: Si ambas fichas y número de fichas no son iguales.
	 * @since    1.0
	 */
	public boolean equals(Object objeto) {
	    boolean resultado=false;
	    if (objeto instanceof Combinacion && ficha.equals(((Combinacion)objeto).ficha) && maxFichas == ((Combinacion)objeto).maxFichas) {
	      resultado = true;
	    }
	    return resultado;    
	  }
}