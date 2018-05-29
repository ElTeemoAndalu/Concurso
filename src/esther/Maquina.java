package esther;

import java.util.Random;
/**
 * Esta clase hereda de la clase Jugador.
 * La máquina juega de manera aleatoria e introducirá la combinación comprobadora mediante comprobador de la clase Respuesta.
 * @author  Esther Castañeda
 * @version 1.0
 * @since   1.0
 * 
 * @see     Jugador
 */
public class Maquina extends Jugador {
	/**
	 * Objeto que creará un aleatorio.
	 */
	private Random rnd = new Random ();
	/**
	 * Número donde se almacenará el número aleatorio.
	 */
	private int aleatorio; 
	/**
	 * Rango de número de colores máximo que podrá escoger dependiendo de la dificultad.
	 */
	private int maxColores;
	/**
	 * Construye un nuevo objeto Maquina a partir de la dificultad especificada.
	 * @param dificultad  Dificultad en la que jugará el objeto Máquina.
	 */
	public Maquina (ModoJuego dificultad) {
		super(dificultad);
		this.maxColores = dificultad.getNumColores();
	}
	/**
	 * Selecciona el color que introducirá de manera aleatoria en la ficha.
	 * @return  Color   Devuelve el color seccionado.
	 * @since   1.0
	 */
	public Color introducirColores () {
		Color color;
		aleatorio = rnd.nextInt(maxColores);
		// Introduce los colores
		color = seleccionColor(aleatorio+1);
		return color;
	}
	
	public byte introducirColor () {
		aleatorio = rnd.nextInt(maxColores);
		return (byte) aleatorio;
	}
	
	
	/**
	 * Inserta el número de fichas que aparece en la combinación propuesta respecto la ombinación oculta mediante fichas blancas.
	 * @param   blancas  El comprobador indicará si está bien introducido el número de fichas blancas.
	 * @return  Número de fichas blancas.
	 * @since   1.0
	 * 
	 * @see     Respuesta
	 */
	protected int insertarBlancas(int blancas) {
		return blancas;
	}
	/**
	 * Inserta el número de fichas que están en la misma posición en la combinación propuesta respecto la ombinación oculta mediante fichas negras.
	 * @param   negras   El comprobador indicará si está bien introducido el número de fichas negras.
	 * @return  Número de fichas negras.
	 * @since   1.0
	 * 
	 * @see     Respuesta
	 */
	protected int insertarNegras(int negras) {
		return negras;
	}
}