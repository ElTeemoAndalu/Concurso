package concurso.pablo;


import concurso.pablo.Humano;
import concurso.pablo.Jugador;
import concurso.pablo.Maquina;

public class Menu {
	public Menu() {
	}

	public Partida crearPartida() {
		Jugador jugador1;
		Jugador jugador2;
		Dificultad dificultad = elegirDificultad();

		// SI JUEGAN EN LA MAXIMA DIFICULTAD, LOS JUGADORES SERAN MAQUINAS
		if (dificultad == Dificultad.DIFICIL) {
			System.out.println("Introduce el nombre de la primera IA.");
			jugador1 = new Maquina(Teclado.leerString(), dificultad);
			jugador1.introducirCodigoPrivado();
			System.out.println("Introduce el nombre de la segunda IA.");
			jugador2 = new Maquina(Teclado.leerString(), dificultad);
			jugador2.introducirCodigoPrivado();

		} else {
			System.out.println(dificultad == Dificultad.FACIL
					? "En el modo Facil, el primer jugador introducido será el que adivine la combinacion oculta."
					: "Introduce los nombres de los jugadores");
			if (Teclado.leerBoolean("Elige primer jugador", "Humano", "Maquina")) {
				System.out.println("Introduce el nombre del jugador Humano elegido:");
				jugador1 = new Humano(Teclado.leerString(), dificultad);
				if (dificultad != Dificultad.FACIL)
					jugador1.introducirCodigoPrivado();
			} else {
				System.out.println("Introduce el nombre del jugador Maquina elegido:");
				jugador1 = new Maquina(Teclado.leerString(), dificultad);
				if (dificultad != Dificultad.FACIL)
					jugador1.introducirCodigoPrivado();
			}

			if (Teclado.leerBoolean("Elige segundo jugador", "Humano", "Maquina")) {
				System.out.println("Introduce el nombre del jugador Humano elegido:");
				jugador2 = new Humano(Teclado.leerString(), dificultad);
				jugador2.introducirCodigoPrivado();
			} else {
				System.out.println("Introduce el nombre del jugador Maquina elegido:");
				jugador2 = new Maquina(Teclado.leerString(), dificultad);
				jugador2.introducirCodigoPrivado();
			}
		}
		return new Partida(jugador1, jugador2, dificultad);
	}

	private Dificultad elegirDificultad() {
		Dificultad dificultad = null;

		System.out.println("¿En que modo quiere jugar? \n1-FACIL\n2-MEDIO\n3-DIFICIL\n");

		switch (Teclado.leerEntre(1, 3, Teclado.Incluido.TODOS, Teclado.Tipos.INT)) {
		case 1:
			dificultad = Dificultad.FACIL;
			break;
		case 2:
			dificultad = Dificultad.MEDIO;
			break;
		case 3:
			dificultad = Dificultad.DIFICIL;
			break;
		}
		return dificultad;
	}

}
