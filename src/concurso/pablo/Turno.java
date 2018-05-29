package concurso.pablo;

public class Turno {
	private Jugador jugadorCombinacion;
	private Jugador jugadorRespuesta;

	private enum Resultado {
		GANADO, EMPATE, PERDIDO
	};

	public Turno(Jugador jugadorCombinacion, Jugador jugadorRespuesta) {
		this.jugadorCombinacion = jugadorCombinacion;
		this.jugadorRespuesta = jugadorRespuesta;
	}

	private int calcularFichas(Jugador jugador, Colores colores) {
		int numeroDeFichas = 0;
		for (int j = 0; j < jugador.getTablero().getTableroCombinaciones().getFirst()[1].getCodigo().length; j++) {
			if (jugador.getTablero().getTableroCombinaciones().getFirst()[1].getCodigo()[j]
					.equals(new Ficha(colores))) {
				numeroDeFichas++;
			}
		}
		return numeroDeFichas;
	}

	// Metodo que devuelve si la partida ha terminado y de ser asi, muestra al
	// ganador de la partida o el empate y los dos tableros.
	public boolean comprobador(Combinacion codigoIntroducido, Combinacion respuesta) {
		boolean partida = false;
		// compruebo primero con un for si la ccombinacion es la ganadora, de no ser
		// asi, compruebo si se ha terminado la partidaTerminada y devuelvo true o false
		// en su lugar.

		for (int i = 0; i < respuesta.getCodigo().length && !partida; i++) {
			if (respuesta.getCodigo()[i].equals(new Ficha(Colores.NEGRO))) {
				partida = false;
			} else {
				partida = true;
			}
		}
		if (!partida) {
			jugadorCombinacion.getTablero().añadirAlTablero(codigoIntroducido, respuesta);
			haGanado(Resultado.GANADO);
		} else {
			partida = jugadorCombinacion.getTablero().añadirAlTablero(codigoIntroducido, respuesta);
			if (!partida && jugadorCombinacion.getDificultad() == Dificultad.MEDIO) {
				partida = haGanado(Resultado.EMPATE);
			} else if (!partida) {
				haGanado(Resultado.PERDIDO);
			}
		}
		return partida;
	}

	private boolean haGanado(Resultado resultado) {
		boolean primerJugador = false;
		switch (resultado) {
		case GANADO:
			System.out.println(jugadorCombinacion.getDificultad() == Dificultad.FACIL ? String.format(
					"%s ha ganado la partida%n%s ha perdido.%nCombinacion Oculta de %s: %s %nTablero de %s:%n%s %n%nPresione introduzca cualquier tecla para continuar...",
					jugadorCombinacion.getNombre(), jugadorRespuesta.getNombre(), jugadorRespuesta.getNombre(),
					jugadorRespuesta.getTablero().getCombinacionOculta().dibujar(), jugadorCombinacion.getNombre(),
					jugadorCombinacion.getTablero().dibujar())
					: String.format(
							"%s ha ganado la partida%n%s ha perdido.%nCombinacion Oculta de %s: %s %nCombinacion Oculta de %s: %s %n%nTablero de %s:%n%s %n%nTablero de %s:%n%s %n%nPresione introduzca cualquier tecla para continuar...",
							jugadorCombinacion.getNombre(), jugadorRespuesta.getNombre(),
							jugadorCombinacion.getNombre(),
							jugadorCombinacion.getTablero().getCombinacionOculta().dibujar(),
							jugadorRespuesta.getNombre(),
							jugadorRespuesta.getTablero().getCombinacionOculta().dibujar(),
							jugadorCombinacion.getNombre(), jugadorCombinacion.getTablero().dibujar(),
							jugadorRespuesta.getNombre(), jugadorRespuesta.getTablero().dibujar()));

			break;

		case EMPATE:

			// Con esto descartamos que se decida el empate sin haber terminado todos los
			// jugadores con sus respectivos intentos.
			if (jugadorCombinacion.getTablero().getTableroCombinaciones().size() != jugadorRespuesta.getTablero()
					.getTableroCombinaciones().size()) {
				primerJugador = true;
			} else {
				if (calcularFichas(jugadorCombinacion, Colores.NEGRO) == calcularFichas(jugadorRespuesta,
						Colores.NEGRO)) {

					if (calcularFichas(jugadorCombinacion, Colores.BLANCO) == calcularFichas(jugadorRespuesta,
							Colores.BLANCO)) {

						System.out.println(String.format(
								"%s y %s han empatado la partida.%nCombinacion Oculta de %s: %s %nCombinacion Oculta de %s: %s %n%nTablero de %s:%n%s %n%nTablero de %s:%n%s %n%nPresione introduzca cualquier tecla para continuar...",
								jugadorCombinacion.getNombre(), jugadorRespuesta.getNombre(),
								jugadorCombinacion.getNombre(),
								jugadorCombinacion.getTablero().getCombinacionOculta().dibujar(),
								jugadorRespuesta.getNombre(),
								jugadorRespuesta.getTablero().getCombinacionOculta().dibujar(),
								jugadorCombinacion.getNombre(), jugadorCombinacion.getTablero().dibujar(),
								jugadorRespuesta.getNombre(), jugadorRespuesta.getTablero().dibujar()));

					} else if (calcularFichas(jugadorCombinacion, Colores.BLANCO) > calcularFichas(jugadorRespuesta,
							Colores.BLANCO)) {

						haGanado(Resultado.GANADO);
					} else {
						haGanado(Resultado.PERDIDO);
					}
				} else if (calcularFichas(jugadorCombinacion, Colores.NEGRO) > calcularFichas(jugadorRespuesta,
						Colores.NEGRO)) {
					haGanado(Resultado.GANADO);
				} else {
					haGanado(Resultado.PERDIDO);
				}
			}
			break;

		case PERDIDO:
			System.out.println(jugadorRespuesta.getDificultad() == Dificultad.FACIL ? String.format(
					"%s ha ganado la partida%n%s ha perdido.%nCombinacion Oculta de %s: %s %nTablero de %s:%n%s%nPresione introduzca cualquier tecla para continuar...",
					jugadorRespuesta.getNombre(), jugadorCombinacion.getNombre(), jugadorRespuesta.getNombre(),
					jugadorRespuesta.getTablero().getCombinacionOculta().dibujar(), jugadorCombinacion.getNombre(),
					jugadorCombinacion.getTablero().dibujar())
					: String.format(
							"%s ha ganado la partida%n%s ha perdido.%nCombinacion Oculta de %s: %s %nCombinacion Oculta de %s: %s %n%nTablero de %s:%n%s %n%nTablero de %s:%n%s %n%nPresione introduzca cualquier tecla para continuar...",
							jugadorRespuesta.getNombre(), jugadorCombinacion.getNombre(), jugadorRespuesta.getNombre(),
							jugadorRespuesta.getTablero().getCombinacionOculta().dibujar(),
							jugadorCombinacion.getNombre(),
							jugadorCombinacion.getTablero().getCombinacionOculta().dibujar(),
							jugadorCombinacion.getNombre(), jugadorCombinacion.getTablero().dibujar(),
							jugadorRespuesta.getNombre(), jugadorRespuesta.getTablero().dibujar()));

			break;
		}

		return primerJugador;
	}

	public boolean jugar() {
		boolean bucle = true;
		Combinacion respuesta = null;
		Combinacion codigo = null;

		do {
			System.out.printf("%s", jugadorCombinacion instanceof Maquina ? String.format(".%n")
					: String.format(
							"%n%nTurno de %s - Elige una opcion:%n1-Introducir Combinacion%n2-Ver Tablero%n3-Ver opciones del juego%n",
							jugadorCombinacion.getNombre()));

			switch (jugadorCombinacion instanceof Maquina ? 1
					: Teclado.leerEntre(1, 4, Teclado.Incluido.TODOS, Teclado.Tipos.INT)) {
			case 1:
				codigo = jugadorCombinacion.introducirCodigo(false);
				respuesta = jugadorRespuesta.comprobarColores(codigo);

				System.out.println(jugadorCombinacion instanceof Maquina ? "." : "Respuesta: " + respuesta.dibujar());
				bucle = false;
				break;
			case 2:
				System.out.println(jugadorCombinacion.getTablero().dibujar());
				break;
			case 3:
				Constantes.explicaColores();
				break;
			case 4:
				System.out.println(jugadorRespuesta.getTablero().getCombinacionOculta().dibujar());
			}
		} while (bucle);
		return comprobador(codigo, respuesta);
	}

}
