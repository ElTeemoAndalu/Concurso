package esther;

/**
 * Esta clase es el padre de Persona y Máquina. El jugador podrá introducir combinaciones (tanto las que va a jugar como la combinación oculta.
 * Además también le servirá para añadir la combinación de las fichas negras y blancas.
 * 
 * @author  Esther Castañeda
 * @version 1.0
 * @since   1.0
 * 
 * @see Opciones
 * @see ModoJuego
 * @see ModoFacil
 * @see Combinacion 
 * @see Color
 *
 */
public abstract class Jugador {
	/**
	 * Establece en la dificultad que va a jugar el jugador.
	 */
	private ModoJuego dificultad;
	/**
	 * Establece en el número de fichas máximo para introducir en la combinación.
	 */
	private int maxFichas;
	/**
	 * Almacena la combinacion propuesta.
	 */
	private Combinacion combinacion;
	/**
	 * Almacena la combinacion oculta.
	 */
	private Combinacion combinacionOculta;
	/**
	 * Almacena la fila de la combinacion propuesta. 
	 */
	private String pintaFila;
	/**
	 * Almacena la fila de la combinacion oculta.
	 */
	private String pintaOculto;
	/**
	 * Almacena la fila de la combinacion blancas y negras.
	 */
	private String pintaByN;
	/**
	 * Almacena la fila de la combinacion propuesta (versión minizada).
	 */
	private String pintaMini;
	/**
	 * Almacena la fila de la combinacion oculta (versión minizada).
	 */
	private String pintaOcultoMini;
	/**
	 * Almacena las respuestas de las combinaciones que el jugador va introduciendo durante la partida.
	 */
	private Respuesta respuesta = new Respuesta();
	/**
	 * Construye un nuevo objeto Jugador que contiene las combinaciones.
	 * @param dificultad   Establece la dificultad que jugará el jugador.
	 */
	Jugador (ModoJuego dificultad) {
		this.dificultad = dificultad;
		maxFichas = dificultad.getCasilla();
	}
	/**
	 * Introduce una ficha en la combinación.
	 * 
	 * @since 1.0
	 */
	public void introducirFicha() {
		int posicion;
		Color color = null;
		
		combinacion = new Combinacion (dificultad); // Crea una nueva combinación
		
		for (posicion=0; posicion<maxFichas; posicion++) {
			color = introducirColores();
			combinacion.introducirFicha(color);
		}
		respuesta.addCombinacion(combinacion);
		pintaFila = combinacion.pintarFila();
		pintaMini = combinacion.pintarMini();
	}	
	/**
	 * Introduce el número de fichas blancas y negras que aparecen y/o que esten en la misma posición.
	 * @param blancas  Número de fichas blancas que aparecen en la combinación.
	 * @param negras   Número de fichas negras que esten en la misma posición.
	 * @since 1.0
	 * 
	 * @see   #insertarNegras(int)
	 * @see   #insertarBlancas(int)
	 */
	protected void addByN(int blancas, int negras) {
		int numBlancas = 0, numNegras = 0;
		
		combinacion = new Combinacion (dificultad); // Crea una nueva combinación de Blancas y Negras
		
		// El jugador introducirá el número de fichas que aparecen y las que están bien posicionadas.
		numBlancas = insertarBlancas(blancas);
		numNegras = insertarNegras(negras);
		
		// Una vez introducido los datos se crearán las fichas Blancas y Negras. 
		combinacion.addByN(numBlancas, numNegras);
		
		respuesta.addByN(combinacion);
		pintaByN = combinacion.pintarByN();
	}	
	/**
	 * Introduce una ficha en la combinación oculta.
	 * 
	 * @since 1.0
	 */
	public void addOculto () {
		int posicion;
		Color color;
		
		combinacionOculta = new Combinacion (dificultad);
		
		do {
			for (posicion=0; posicion<maxFichas; posicion++) {
				color = introducirColores();
				combinacionOculta.introducirFicha(color);
			}
		
			if (combinacionOculta.noRepetidorColores()==true && dificultad != ModoJuego.DIFICIL)
				System.out.println("Has introducido colores repetidos en la combinación original, prueba otra vez.");
		
			
		} while (dificultad != ModoJuego.DIFICIL && combinacionOculta.noRepetidorColores()==true);
		
		pintaOculto = combinacionOculta.pintarFila();
		pintaOcultoMini = combinacionOculta.pintarMini();
	}
	/**
	 * Transforma la opción pasada por parámetro en un color.
	 * @param   opcion   Número que luego se cambiará por su respectivo color. 
	 * @return  color    Color correspondiente con la opción.
	 * @since   1.0
	 * @see     #introducirColores()
	 * @see     Color
	 */
	// Traducctor de número a color
	protected Color seleccionColor(int opcion) { // Función que traduce del número que introduce el usuario a un color.
		Color enum_colores;
		String color;
		
		switch (opcion) {
			case 1:
				color = "AZUL";
				break;
			case 2:
				color = "LIMA";
				break;
			case 3:
				color = "VERDE";
				break;
			case 4:
				color = "AMARILLO";
				break;
			case 5:
				color = "ROJO";
				break;
			case 6:
				color = "MORADO";
				break;
			case 7:
				color = "MARINO";
				break;
			case 8:
				color = "GRIS";
				break;
			case 9:
				color = "BURDEOS";
				break;
			case 10:
				color = "DORADO";
				break;
			default:
				color = "RESET";
				break;
		}
		enum_colores = Color.valueOf(color);
		return enum_colores;
	}	
	// Métodos abstractos
	/**
	 * Selecciona el color que introducirá en la ficha.
	 * @return  Color   Devuelve el color seccionado.
	 * @since   1.0
	 */
	public abstract Color introducirColores();
	/**
	 * Inserta el número de fichas que aparece en la combinación propuesta respecto la ombinación oculta mediante fichas blancas.
	 * @param   blancas  El comprobador indicará si está bien introducido el número de fichas blancas.
	 * @return  Número de fichas blancas
	 * @since   1.0
	 * 
	 * @see     Respuesta
	 */
	protected abstract int insertarBlancas(int blancas);
	/**
	 * Inserta el número de fichas que están en la misma posición en la combinación propuesta respecto la ombinación oculta mediante fichas negras.
	 * @param   negras   El comprobador indicará si está bien introducido el número de fichas negras.
	 * @return  Número de fichas negras.
	 * @since   1.0
	 * 
	 * @see     Respuesta
	 */
	protected abstract int insertarNegras(int negras);
	/**
	 * Pinta la combinación oculta en una versión estándar.
	 * 
	 * @since   1.0
	 */
	protected void pintarCombinacionOculta() {
		int j;

		for (j=0; j<3; j++) { // Altura de las fichas
			System.out.print("     ");
			System.out.println(pintaOculto);
		}
		System.out.println();
	}
	/**
	 * Pinta la combinación oculta en una versión reducida.
	 * 
	 * @since   1.0
	 */
	protected void pintarOcultaMini() {

		System.out.print("       ");
		System.out.println(pintaOcultoMini);
	
		System.out.println();
	}
	// Getters
	/**
	 * Obtiene la respuesta del jugador.
	 * @return   Respuesta
	 * 
	 * @since    1.0
	 */
	protected Respuesta getRespuesta() {
		return respuesta;
	}
	/**
	 * Obtiene la combinación propuesta pintada en versión estándar.
	 * @return   Cadena
	 * 
	 * @since    1.0
	 */
	protected String getPintaFila() {
		return pintaFila;
	}
	/**
	 * Obtiene la combinación comprobadora pintada en versión estándar.
	 * @return   Cadena
	 * 
	 * @since    1.0
	 */
	protected String getPintaByN() {
		return pintaByN;
	}
	/**
	 * Obtiene el objeto de la combinación propuesta
	 * @return   Combinacion
	 * 
	 * @since    1.0
	 */
	public Combinacion getCombinacion() {
		return combinacion;
	}
	/**
	 * Obtiene el objeto de la combinación oculta.
	 * @return   Combinacion
	 * 
	 * @since    1.0
	 */
	public Combinacion getOculto () {
		return combinacionOculta;
	}
	/**
	 * Obtiene la combinación propuesta pintada de manera reducida.
	 * @return   Cadena
	 * 
	 * @since    1.0
	 */
	protected String getPintaMini() {
		return pintaMini;
	}
}