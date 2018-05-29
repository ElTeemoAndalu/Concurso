package lolo;

import lolo.Teclado.Incluido;
import lolo.Teclado.Tipo;

public class Menu {

	// Con este método se le pide al usuario elegir una dificultad, y se crean los jugadores.
	public Partida configurarPartida() {
		boolean jugadorFacil;
		Partida partida = null;
		Jugador jugador1, jugador2;
		System.out.println("BIENVENIDO A MASTERMIND\n");
		System.out.println("Selecciona el modo de juego: ");
		System.out.println("\t1.- Fácil");
		System.out.println("\t2.- Medio");
		System.out.println("\t3.- Difícil");

		switch (Teclado.leerEntre(1, 3, Incluido.TODOS, Tipo.INT)) {
		case 1:
			jugadorFacil = Teclado.leerBoolean("Ha elegido el modo fácil. ¿Quién va a ser el jugador?", "Usuario", "Máquina");
			jugador1 = new Usuario(Modo.FACIL);
			jugador2 = new Maquina(Modo.FACIL);
			if (jugadorFacil) {
				partida = new Partida(jugador1, jugador2, Modo.FACIL);
			} else {
				partida = new Partida(jugador2, jugador1, Modo.FACIL);
			}
			break;
		case 2:
			System.out.println("Ha elegido el modo medio.");
			jugador1 = new Usuario(Modo.MEDIO);
			jugador2 = new Maquina(Modo.MEDIO);
			partida = new Partida(jugador1, jugador2, Modo.MEDIO);
			break;
		case 3:
			System.out.println("Ha elegido el modo difícil.");
			jugador1 = new Maquina(Modo.DIFICIL);
			jugador2 = new Maquina(Modo.DIFICIL);
			partida = new Partida(jugador1, jugador2, Modo.DIFICIL);
			break;
		}
		return partida;

	}
}
