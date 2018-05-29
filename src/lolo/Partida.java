package lolo;

public class Partida {
	private Jugador jugador1;
	private Jugador jugador2;
	private Modo modo;

	Partida(Jugador jugador1, Jugador jugador2, Modo modo) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.modo = modo;
	}

	// Con este método se comienza ya a jugar y dependiendo del modo se hace una partida diferente.
	void comenzarPartida() {
		int intento;
		boolean salir = false, ganaJ1, ganaJ2;
		int[] array;

		if (modo == Modo.FACIL) {
			if (jugador1 instanceof Usuario) {
				System.out.println("La máquina ha elegido una combinación oculta. Ahora te toca a ti adivinarla.");
			} else {
				System.out.println("Elige una combinación oculta para que la máquina la intente adivinar.");
				System.out.printf("Elige los colores de las %d fichas: %n", modo.getNumCasillas());
			}
			jugador1.getTablero().setCombinacionOcultaContrario(jugador2.anadirCombinacionOculta());

			for (intento = 1; intento <= modo.getNumIntentos() && !salir; intento++) {
				System.out.printf("\nINTENTO Nº %d%n", intento);
				if (jugador1 instanceof Maquina) {
					System.out.printf("Combinación oculta: ");
					jugador1.getTablero().getCombinacionOcultaContrario().dibujar();
				}
				jugador1.getTablero().anadirJugada(jugador2.anadirRespuesta(jugador1.anadirCombinacion()));
				array = jugador2.comprobarJugada(jugador1.getTablero().getJugadas().getLast().getCombinacion());
				salir = comprobarJugada(jugador1, array, intento);
			}
		} else if (modo == Modo.MEDIO) {
			System.out.println("\nLa máquina ha elegido una combinación oculta para que la adivines.");
			jugador1.getTablero().setCombinacionOcultaContrario(jugador2.anadirCombinacionOculta());
			System.out.println("Ahora te toca a ti hacerla para que ella la adivine:");
			jugador2.getTablero().setCombinacionOcultaContrario(jugador1.anadirCombinacionOculta());

			for (intento = 1; intento <= modo.getNumIntentos() && !salir; intento++) {
				System.out.printf("\nUSUARIO - INTENTO Nº %d%n", intento);
				jugador1.getTablero().anadirJugada(jugador2.anadirRespuesta(jugador1.anadirCombinacion()));
				array = jugador2.comprobarJugada(jugador1.getTablero().getJugadas().getLast().getCombinacion());
				ganaJ1 = comprobarJugada(jugador1, array, intento);

				System.out.printf("\nMÁQUINA - INTENTO Nº %d%n", intento);
				System.out.printf("Combinación oculta: ");
				jugador1.getTablero().getCombinacionOcultaPropia().dibujar();
				jugador2.getTablero().anadirJugada(jugador1.anadirRespuesta(jugador2.anadirCombinacion()));
				array = jugador1.comprobarJugada(jugador2.getTablero().getJugadas().getLast().getCombinacion());
				ganaJ2 = comprobarJugada(jugador2, array, intento);

				jugador1.getTablero().dibujarMedioDificil(jugador1, jugador2);
				salir = comprobarGanador(ganaJ1, ganaJ2, intento);
				System.out.println("\n");
			}
		} else {
			intento = 1;
			jugador1.getTablero().setCombinacionOcultaContrario(jugador2.anadirCombinacionOculta());
			jugador2.getTablero().setCombinacionOcultaContrario(jugador1.anadirCombinacionOculta());
			while (!salir) {

				jugador1.getTablero().anadirJugada(jugador2.anadirRespuesta(jugador1.anadirCombinacion()));
				array = jugador2.comprobarJugada(jugador1.getTablero().getJugadas().getLast().getCombinacion());
				ganaJ1 = comprobarJugada(jugador1, array, intento);

				jugador2.getTablero().anadirJugada(jugador1.anadirRespuesta(jugador2.anadirCombinacion()));
				array = jugador1.comprobarJugada(jugador2.getTablero().getJugadas().getLast().getCombinacion());
				ganaJ2 = comprobarJugada(jugador2, array, intento);
				salir = comprobarGanador(ganaJ1, ganaJ2, intento);
				if (intento % 5 == 0 || salir) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					jugador1.getTablero().dibujarMedioDificil(jugador1, jugador2);
				}
				System.out.println("\n");
				intento++;
			}
		}
	}

	// Devuelve un boolean, que básicamente es para el modo fácil, pero también lo vamos a utilizar en el resto de modos.
	private boolean comprobarJugada(Jugador jugador, int[] array, int intentosConsumidos) {
		boolean esGanador = false;
		String ganador = "HA GANADO", perdedor = "HA PERDIDO";

		if (modo == Modo.FACIL) {
			jugador1.getTablero().dibujar();
		}

		if (array[0] == modo.getNumCasillas()) {
			esGanador = true;
			if (modo == Modo.FACIL) {
				if (jugador instanceof Usuario) {
					System.out.printf("\n¡%s EL USUARIO, %s LA MÁQUINA!\t ", ganador, perdedor);
				} else {
					System.out.printf("\n¡%s LA MÁQUINA, %s EL USUARIO!\t ", ganador, perdedor);
				}
				System.out.print("Combinación oculta: ");
				jugador1.getTablero().getCombinacionOcultaContrario().dibujar();
				System.out.println("\n");
			}
		} else {
			esGanador = false;
			if (intentosConsumidos == modo.getNumIntentos()) {
				if (modo == Modo.FACIL) {
					if (jugador instanceof Usuario) {
						System.out.printf("\n¡%s EL USUARIO, %s LA MÁQUINA!\t ", perdedor, ganador);
					} else {
						System.out.printf("\n¡%s LA MÁQUINA, %s EL USUARIO!\t ", perdedor, ganador);
					}
					System.out.print("Combinación oculta: ");
					jugador1.getTablero().getCombinacionOcultaContrario().dibujar();
					System.out.println("\n");
				}
			}
		}

		return esGanador;
	}

	// Sirve únicamente para los modos medio y difícil, y necesita el método anterior para su funcionamiento.
	// Si alguno de los jugadores ha ganado, devuelve true.
	private boolean comprobarGanador(boolean esGanador1, boolean esGanador2, int intentos) {
		boolean salir = false;
		String cadena1, cadena2, ganador = "";
		int[] arrayRespuestasJ1, arrayRespuestasJ2;
		arrayRespuestasJ1 = jugador2.comprobarJugada(jugador1.getTablero().getJugadas().getLast().getCombinacion());
		arrayRespuestasJ2 = jugador1.comprobarJugada(jugador2.getTablero().getJugadas().getLast().getCombinacion());

		if (modo == Modo.MEDIO) {
			cadena1 = "EL USUARIO";
			cadena2 = "LA MÁQUINA";
		} else {
			cadena1 = "MÁQUINA 1";
			cadena2 = "MÁQUINA 2";
		}

		if (esGanador1 && esGanador2 || intentos == modo.getNumIntentos()) {
			if (arrayRespuestasJ1[0] > arrayRespuestasJ2[0]) {
				ganador = cadena1;
			} else if (arrayRespuestasJ1[0] < arrayRespuestasJ2[0]) {
				ganador = cadena2;
			} else {
				if (arrayRespuestasJ1[1] > arrayRespuestasJ2[1]) {
					ganador = cadena1;
					System.out.printf("\n¡HA GANADO %s!\n", ganador);
				} else if (arrayRespuestasJ1[1] < arrayRespuestasJ2[1]) {
					ganador = cadena2;
					System.out.printf("\n¡HA GANADO %s!\n", ganador);
				} else {
					System.out.println("¡HA QUEDADO EMPATE!");
				}
			}

			salir = true;
		} else if (esGanador1 || esGanador2) {
			if (esGanador1) {
				ganador = cadena1;
			} else if (esGanador2) {
				ganador = cadena2;
			}
			System.out.printf("\n¡HA GANADO %s!\n", ganador);
			salir = true;
		}
		return salir;
	}

}
