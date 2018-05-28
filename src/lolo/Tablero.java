package lolo;

import java.util.LinkedList;

public class Tablero implements Dibujable {
	private LinkedList<Jugada> jugadas = new LinkedList<Jugada>();
	private Combinacion combinacionOcultaPropia;
	private Combinacion combinacionOcultaContrario;
	private Modo modo;

	Tablero(Modo modo) {
		this.modo = modo;
	}

	public LinkedList<Jugada> getJugadas() {
		return jugadas;
	}

	public Combinacion getCombinacionOcultaPropia() {
		return combinacionOcultaPropia;
	}

	public void setCombinacionOcultaPropia(Combinacion combinacionOcultaPropia) {
		this.combinacionOcultaPropia = combinacionOcultaPropia;
	}

	public Combinacion getCombinacionOcultaContrario() {
		return combinacionOcultaContrario;
	}

	public void setCombinacionOcultaContrario(Combinacion combinacionOcultaContrario) {
		this.combinacionOcultaContrario = combinacionOcultaContrario;
	}

	// Añade la jugada pasada por parámetro al último lugar del LinkedList <Jugada>.
	public void anadirJugada(Jugada jugada) {
		this.jugadas.addLast(jugada);
	}

	public void dibujar() {
		System.out.print("\n\t    TABLERO ");
		System.out.printf("%n-------------------------------------%n");
		for (int i = 0; i < jugadas.size(); i++) {
			if (i < 10) {
				System.out.printf("Jugada %d:   ", i + 1);
			} else {
				System.out.printf("Jugada %d:  ", i + 1);
			}
			jugadas.get(i).dibujar();
			System.out.println();
		}

	}
	
	// Este dibujar es exclusivo para medio y dificil, para mostrar dos tableros en horizontal.
	public void dibujarMedioDificil(Jugador jugador1, Jugador jugador2) {
		String cadena1, cadena2;
		
		if (modo == Modo.MEDIO) {
			cadena1 = "USUARIO  ";
			cadena2 = "MÁQUINA";
		} else {
			cadena1 = "MÁQUINA 1";
			cadena2 = "MÁQUINA 2";
		}

		System.out.printf("\n\t    TABLERO - %s \t\t\t\t\t    TABLERO - %s", cadena1, cadena2);
		System.out.printf("%n------------------------------------------------\t\t");
		System.out.printf("------------------------------------------------%n");

		for (int j = 0; j < jugadas.size(); j++) {
			if (j < 9) {
				System.out.printf("Jugada %d:   ", j + 1);
				jugador1.getTablero().getJugadas().get(j).dibujar();
				if (modo == Modo.MEDIO) {
					System.out.printf("\t\t\t\tJugada %d:   ", j + 1);
				} else {
					System.out.printf("\t\tJugada %d:   ", j + 1);
				}
				jugador2.getTablero().getJugadas().get(j).dibujar();
			} else {
				System.out.printf("Jugada %d:  ", j + 1);
				jugador1.getTablero().getJugadas().get(j).dibujar();
				if (modo == Modo.MEDIO) {
					System.out.printf("\t\t\t\tJugada %d:  ", j + 1);
				} else {
					System.out.printf("\t\tJugada %d:  ", j + 1);
				}
				jugador2.getTablero().getJugadas().get(j).dibujar();
			}
			System.out.println();
		}

	}

}
