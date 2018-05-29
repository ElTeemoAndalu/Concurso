package esther;
/**
 * Esta clase hereda de la clase Jugador.
 * El objeto Jugador podrá jugar durante la partida.
 * 
 * @author  Esther Castañeda
 * @version 1.0
 * @since   1.0
 * 
 * @see     Jugador
 * @see     Teclado
 */
public class Persona extends Jugador {
	/**
	 * Funciones del Objeto Teclado para escribir.
	 */
	private Teclado teclado = new Teclado();
	/**
	 * Se le asigna la dificultad que jugará el jugador.
	 */
	private ModoJuego dificultad;
	/**
	 * Construye un nuevo objeto Persona a partir de la dificultad especificada.
	 * @param dificultad  Dificultad en la que jugará el objeto Persona.
	 */
	public Persona(ModoJuego dificultad) {
		super(dificultad);
		this.dificultad = dificultad;
	}
	/**
	 * Selecciona el color que introducirá en la ficha.
	 * @return  Color   Devuelve el color seccionado.
	 * @since   1.0
	 * 
	 * @see     #tecladoColor()
	 */
	public Color introducirColores() {
		Color color;
		
		// Introduce los colores
		color = seleccionColor(tecladoColor());
				
		return color;
	}
	/**
	 * Inserta el número de fichas que aparece en la combinación propuesta respecto la ombinación oculta mediante fichas blancas.
	 * @param   blancas  El comprobador indicará si está bien introducido el número de fichas blancas.
	 * @return  Número de fichas blancas
	 * @since   1.0
	 * 
	 * @see     #tecladoByN()
	 * @see     Respuesta
	 */
	public int insertarBlancas(int blancas) {
		int aparece;
		
		System.out.print("¿Cuántos colores no están bien colocados? ");
		
		do {
			aparece = tecladoByN();
			if (blancas!=aparece) {
				System.out.println("No has colocado bien la cifra, hay menos/más colores que aparecen.");
			}
		} while (blancas!=aparece);
		return aparece;
	}
	/**
	 * Inserta el número de fichas que están en la misma posición en la combinación propuesta respecto la ombinación oculta mediante fichas negras.
	 * @param   negras   El comprobador indicará si está bien introducido el número de fichas negras.
	 * @return  Número de fichas negras.
	 * @since   1.0
	 * 
	 * @see     #tecladoByN()
	 * @see     Respuesta
	 */
	public int insertarNegras(int negras) {
		int colocado;
		
		System.out.print("¿Cuántos colores están bien colocados? ");
		
		do {
			colocado = tecladoByN();
			
			if (negras!=colocado) {
				System.out.println("No has colocado bien la cifra, hay menos/más colores que están en la misma posición.");
			}
		} while (negras!=colocado);
		
		
		return colocado;
	}
	/**
	 * Controlador de teclado de Blancas y Negras.
	 * @return  Número
	 */
	private int tecladoByN() {
		int opcion;
		int maxFichas = dificultad.getCasilla();
		do {
			opcion = teclado.teclado_int();
			if (opcion>maxFichas || opcion<0)
				System.out.printf("Te has salido del rango establecido. Prueba otra vez. (Solo números del 1 al %d) \n> ", maxFichas);
		} while(opcion>maxFichas || opcion<0);
		
		return opcion;
	}
	/**
	 * Controlador de teclado de Colores.
	 * @return  Número
	 */
	private int tecladoColor() {
		int opcion;
		int limiteMax = dificultad.getNumColores(); // Número de colores que puede usar el usuario.
		
		do {
			opcion = teclado.teclado_int();
			if (opcion>limiteMax || opcion<1)
				System.out.printf("Te has salido del rango establecido. Prueba otra vez. (Solo números del 1 al %d) \n> ", limiteMax);
		} while(opcion>limiteMax || opcion<1);
		
		return opcion;
	}
}
