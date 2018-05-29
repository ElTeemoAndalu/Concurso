package mastermind;

import static mastermind.Colores.NEGRO;
import static mastermind.Colores.RESET;
import static mastermind.Colores.ROJO;

//Controlar darAciertos por la maquina
import mastermind.Teclado.Incluido;

/**
 * Esta clase contiene los jugadores, tableros y el modo que realizaran el tipo
 * de Partida
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.0
 *
 */
public class Partida {
	private Jugador jugador1;
	private Jugador jugador2;
	private TableroJugador tableroJ1;
	private TableroJugador tableroJ2;
	private Modos modo;

	/**
	 * Construye un nuevo objeto Partida a partir de los parametros indicados.
	 * 
	 * @param jugador1
	 *            Jugador que participará en la partida.
	 * @param jugador2
	 *            Jugador que participará en la partida.
	 * @param tablero1
	 *            Tablero que participará en la partida.
	 * @param tablero2
	 *            Tablero que participará en la partida.
	 * @param modo
	 *            Modo que dará características a la partida.
	 */
	Partida(Jugador jugador1, Jugador jugador2, TableroJugador tablero1, TableroJugador tablero2, Modos modo) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.tableroJ1 = tablero1;
		this.tableroJ2 = tablero2;
		this.modo = modo;
	}

	/**
	 * Realiza una llamada a la partida deseada según el modo de juego del objeto
	 * Partida.
	 */
	public void llamarPartida() {
		if (modo.getCodigo() == 'F') {
			partidaFacil();
		} else if (modo.getCodigo() == 'M') {
			partidaMedia();
		} else if (modo.getCodigo() == 'D') {
			partidaDificil();
		}
	}

	/**
	 * Realiza una partida del modo Fácil
	 * 
	 */
	public void partidaFacil() {
		boolean salir = false;
		int eligeJugador;
		Jugada jugada;
		int i = 0;
		System.out.println("Elige quien jugará");
		System.out.println("1. Usuario");
		System.out.println("2. Máquina");
		jugador1 = new Usuario(modo);
		jugador2 = new Maquina(modo);
		tableroJ1 = new TableroJugador();
		eligeJugador = Teclado.leerNumEntre(Incluido.INCLUIDOS, 1, 2);
		if (eligeJugador == 1) {
			jugador2.rellenarCombiSecret();
			do {
				jugada = new Jugada(modo);
				jugada.addJugada(jugador1.rellenarCombinacionAcertar(tableroJ2),
						jugador2.darAciertosRival(jugador2.getCombinacionSecreta(), jugador1.getAcertarCombinacion()));
				tableroJ1.getTablero().add(jugada);
				System.out.printf("Tablero de %s Intento: %d de %d\n", jugador1.getNombre(), i + 1, modo.getIntentos());
				System.out.println(tableroJ1.dibujar());
				i++;
				if (i == modo.getIntentos()
						|| jugador1.getAcertarCombinacion().equals(jugador2.getCombinacionSecreta())) {
					salir = true;
				}
			} while (!salir);
			if (jugador1.getAcertarCombinacion().equals(jugador2.getCombinacionSecreta())) {
				System.out.printf("\nEnhorabuena %s has acertado la combinación\nHas ganado!!", jugador1.getNombre());
			} else {
				System.out.printf("\nSe te acabaron los intentos %s\nPerdiste:(\n", jugador1.getNombre());
				System.out.printf("La combinacion del rival era: \n%s", jugador2.getCombinacionSecreta().dibujar());
			}
		} else if (eligeJugador == 2) {
			jugador1.rellenarCombiSecret();
			do {
				jugada = new Jugada(modo);
				jugada.addJugada(jugador2.rellenarCombinacionAcertar(tableroJ2), jugador1.darAciertosRival(
						jugador2.darAciertosRival(jugador1.getCombinacionSecreta(), jugador2.acertarCombinacion),
						jugador2.getAcertarCombinacion()));
				tableroJ2.getTablero().add(jugada);
				System.out.printf("Tablero de %s Intento: %d de %d\n", jugador2.getNombre(), i + 1, modo.getIntentos());
				System.out.println(tableroJ2.dibujar());
				i++;
				if (i == modo.getIntentos()
						|| jugador2.getAcertarCombinacion().equals(jugador1.getCombinacionSecreta())) {
					salir = true;
				}
			} while (!salir);
			if (jugador2.getAcertarCombinacion().equals(jugador1.getCombinacionSecreta())) {
				System.out.printf("\nEnhorabuena %s has acertado la combinación\nHas ganado!!", jugador2.getNombre());
			} else {
				System.out.printf("\nSe te acabaron los intentos %s\nPerdiste:(", jugador2.getNombre());
			}

		}
	}

	/**
	 * Realiza una partida del modo Medio
	 * 
	 */
	public void partidaMedia() {
		int i = 0;
		boolean salir = false;
		TableroPartida tableroPartida;
		Jugada jugadaJ1;
		Jugada jugadaJ2;
		jugador1 = new Usuario(modo);
		jugador2 = new Maquina(modo);
		tableroJ1 = new TableroJugador();
		tableroJ2 = new TableroJugador();
		tableroPartida = new TableroPartida();
		jugador1.rellenarCombiSecret();
		jugador2.rellenarCombiSecret();
		System.out.printf("Tu combinacion secreta: \n%s\n", jugador1.getCombinacionSecreta().dibujar());
		System.out.printf("Combinacion de la maquina: \n%s\n", jugador2.getCombinacionSecreta().dibujar());
		do {
			jugadaJ1 = new Jugada(modo);
			jugadaJ2 = new Jugada(modo);
			jugadaJ1.addJugada(jugador1.rellenarCombinacionAcertar(tableroJ1),
					jugador2.darAciertosRival(jugador2.getCombinacionSecreta(), jugador1.getAcertarCombinacion()));
			tableroJ1.getTablero().add(jugadaJ1);
			jugadaJ2.addJugada(jugador2.rellenarCombinacionAcertar(tableroJ2),
					jugador1.darAciertosRival(
							jugador2.darAciertosRival(jugador1.getCombinacionSecreta(), jugador2.acertarCombinacion),
							jugador2.getAcertarCombinacion()));
			tableroJ2.getTablero().add(jugadaJ2);
			tableroPartida.addTableros(tableroJ1, tableroJ2);
			System.out.printf(" Tablero de %-20sTablero de %-12sIntento: %d de %d\n\n", jugador1.getNombre(),
					jugador2.getNombre(), i + 1, modo.getIntentos());
			System.out.printf("%s", tableroPartida.dibujar());
			i++;
			if (i == modo.getIntentos() || jugador1.getAcertarCombinacion().equals(jugador2.getCombinacionSecreta())
					|| jugador2.getAcertarCombinacion().equals(jugador1.getCombinacionSecreta())) {
				salir = true;
			}
		} while (!salir);
		if (jugador1.getAcertarCombinacion().equals(jugador2.getCombinacionSecreta())
				&& jugador2.getAcertarCombinacion().equals(jugador1.getCombinacionSecreta())) {
			if (devolverGanador(jugadaJ1.getRespuesta(), 1) > devolverGanador(jugadaJ2.getRespuesta(), 1)) {
				System.out.printf("\nHas ganado %s por tener mas aciertos", jugador1.getNombre());
			} else if (devolverGanador(jugadaJ1.getRespuesta(), 1) < devolverGanador(jugadaJ2.getRespuesta(), 1)) {
				System.out.printf("\nHas ganado %s por tener mas aciertos", jugador2.getNombre());
			} else if (devolverGanador(jugadaJ1.getRespuesta(), 1) == devolverGanador(jugadaJ2.getRespuesta(), 1)) {
				if (devolverGanador(jugadaJ1.getRespuesta(), 2) > devolverGanador(jugadaJ2.getRespuesta(), 2)) {
					System.out.printf("\nHas ganado %s por tener mas colores acertados", jugador1.getNombre());
				} else if (devolverGanador(jugadaJ1.getRespuesta(), 2) < devolverGanador(jugadaJ2.getRespuesta(), 2)) {
					System.out.printf("\nHas ganado %s por tener mas colores acertados", jugador2.getNombre());
				} else if (devolverGanador(jugadaJ1.getRespuesta(), 2) == devolverGanador(jugadaJ2.getRespuesta(), 2)) {
					System.out.printf("\nHabeis empatado", jugador2.getNombre());
				}
			}
		} else if (jugador1.getAcertarCombinacion().equals(jugador2.getCombinacionSecreta())) {
			System.out.printf("\nEnhorabuena %s has acertado la combinación\nHas ganado!!", jugador1.getNombre());
		} else if (jugador2.getAcertarCombinacion().equals(jugador1.getCombinacionSecreta())) {
			System.out.printf("\nEnhorabuena %s has acertado la combinación\nHas ganado!!", jugador2.getNombre());
		}
	}

	/**
	 * Realiza una partida del modo Dificil
	 * 
	 */
	public void partidaDificil() {
		int i = 0;
		boolean salir = false;
		Jugada jugadaJ1;
		Jugada jugadaJ2;
		TableroPartida tableroPartida;
		jugador1 = new Maquina(modo);
		jugador2 = new Maquina(modo);
		tableroJ1 = new TableroJugador();
		tableroJ2 = new TableroJugador();
		tableroPartida = new TableroPartida();
		System.out.println(jugador1.rellenarCombiSecret().dibujar());
		System.out.println(jugador2.rellenarCombiSecret().dibujar());
		do {

			jugadaJ1 = new Jugada(modo);
			jugadaJ2 = new Jugada(modo);
			jugadaJ1.addJugada(jugador1.rellenarCombinacionAcertar(tableroJ1),
					jugador2.darAciertosRival(jugador2.getCombinacionSecreta(), jugador1.getAcertarCombinacion()));
			tableroJ1.getTablero().add(jugadaJ1);

			jugadaJ2.addJugada(jugador2.rellenarCombinacionAcertar(tableroJ2),
					jugador1.darAciertosRival(jugador1.getCombinacionSecreta(), jugador2.getAcertarCombinacion()));

			tableroJ2.getTablero().add(jugadaJ2);
			tableroPartida.addTableros(tableroJ1, tableroJ2);
			System.out.printf("\tTablero de %-29sTablero de %s\t\tIntento: %d\n\n", jugador1.getNombre(),
					jugador2.getNombre(), i + 1);

			System.out.printf("%s", tableroPartida.dibujar());
			
			
			if (jugador1.getAcertarCombinacion().equals(jugador2.getCombinacionSecreta())
					|| jugador2.getAcertarCombinacion().equals(jugador1.getCombinacionSecreta())) {

				salir = true;
			}
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		} while (!salir);
		if (jugador1.getAcertarCombinacion().equals(jugador2.getCombinacionSecreta())
				&& jugador2.getAcertarCombinacion().equals(jugador1.getCombinacionSecreta())) {
			System.out.println("Ambas máquinas han acertado");
		} else if (jugador1.getAcertarCombinacion().equals(jugador2.getCombinacionSecreta())) {
			System.out.printf("Has ganado %s", jugador1.getNombre());
		} else if (jugador2.getAcertarCombinacion().equals(jugador1.getCombinacionSecreta())) {
			System.out.printf("Has ganado %s", jugador2.getNombre());
		}
	}

	/**
	 * Devuelve el ganador en caso de empate en el modo Medio
	 * 
	 * @param c1
	 *            Combinacion a comprobar
	 * @param num
	 *            Numero que indica si se esta comprobando el aciertoTotal o solo de
	 *            Color.
	 * @return Devuelve el número de aciertos realizados segun sea rojo o negro.
	 * 
	 */
	public int devolverGanador(Combinacion c1, int num) {
		// Este metodo, devuelve el número de veces que la combinacion contiene la ficha
		// indicada por parametro
		int i;
		int contador = 0;
		Ficha ficha = new Ficha();
		switch (num) {
		case 1:
			ficha.setColor(NEGRO + (char) 9210 + RESET);
			break;
		case 2:
			ficha.setColor(ROJO + (char) 9210 + RESET);
			break;
		}
		for (i = 0; i < c1.getCasillas().length; i++) {
			if (c1.getCasillas()[i].equals(ficha)) {
				contador++;
			}
		}
		return contador;

	}

}