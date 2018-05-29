package concurso.pablo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 * Clase que implementa el tablero del jugador.
 * @author pablo
 *
 */
public class Tablero implements Dibujable {
	private LinkedList<Combinacion[]> tableroCombinaciones = new LinkedList<>();
	private LinkedList<LocalDateTime> tiempo = new LinkedList<>();
	private Combinacion combinacionOculta;
	private Dificultad dificultad;

	// Constructor
	/**Instancia un tablero.
	 * @param dificultad dificultad utilizada en el tablero.
	 */
	public Tablero(Dificultad dificultad) {
		this.dificultad=dificultad;
	}
	
	public LinkedList<Combinacion[]> getTableroCombinaciones(){
		return tableroCombinaciones;
	}


	/**
	 * Añade al tablero las dos combinaciones separadas a traves de un array, y el
	 * momento en el que se añade
	 *
	 * @param colores combinacion utilizada por el contrario.
	 * @param comprobadores combinacion respuesta de la combinacion anterior.
	 * @return devuelve un boolean que indica si se ha terminado o no la partida.
	 */
	public boolean añadirAlTablero(Combinacion colores, Combinacion comprobadores) {
		Combinacion[] combinacion = { colores, comprobadores };
		tableroCombinaciones.addFirst(combinacion);
		tiempo.addFirst(LocalDateTime.now());
		return seguirJugando();
	}

	/*
	 * La funcion seguirJugando cuenta las lineas de colores que posee el tablero y
	 * lo compara con el numero maximo de movimientos posibles. Si existen mas
	 * lineas de las permitidas, devuelve false.
	 */

	/**
	 * Metodo que comprueba si se han acabado los intentos o no.
	 * @return devuelve un boolean dependiendo de si han terminado los intentos o no.
	 */
	private boolean seguirJugando() {
		boolean resultado = true;
		if (tableroCombinaciones.size() >= dificultad.getIntentos() && dificultad!=Dificultad.DIFICIL) {
			resultado = false;
		}
		return resultado;
	}

	@Override
	public String dibujar() {
		String cadena = "";
		if (tableroCombinaciones.size() == 0) {
			cadena = String.format("El tablero no posee ninguna combinacion todavia.");
		} else {

			for (int i = 0; i < tableroCombinaciones.size(); i++) {
				cadena += String.format("Intento: %6d%s    Codigo: %-5s    Respuesta: %-6s    Tiempo:  %-6s%n",
						(tableroCombinaciones.size() - i),"/"+dificultad.getIntentos(), tableroCombinaciones.get(i)[0].dibujar(), tableroCombinaciones.get(i)[1].dibujar(),
						tiempo.get(i).format(DateTimeFormatter.ofPattern("hh:mm:ss")));
			}
		}
		return cadena;
	}

	public Combinacion getCombinacionOculta() {
		return combinacionOculta;
	}

	public void setCombinacionOculta(Combinacion combinacionOculta) {
		this.combinacionOculta = combinacionOculta;
	}

}
