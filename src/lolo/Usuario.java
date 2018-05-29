package lolo;

import static lolo.Constantes.AMARILLO;
import static lolo.Constantes.AZUL;
import static lolo.Constantes.CELESTE;
import static lolo.Constantes.GRIS;
import static lolo.Constantes.LIMA;
import static lolo.Constantes.MORADO;
import static lolo.Constantes.NEGRO;
import static lolo.Constantes.ROJO;
import static lolo.Constantes.ROSA;
import static lolo.Constantes.TURQUESA;

import lolo.Teclado.Incluido;
import lolo.Teclado.Tipo;

public class Usuario extends Jugador {

	Usuario(Modo modo) {
		super(modo);
	}

	// Devuelve una combinación que se va añadir a la Jugada.
	Combinacion anadirCombinacion() {
		Combinacion combinacion = new Combinacion(modo.getNumCasillas());
		Color color = null;
		int posicionFicha, eleccion;

		System.out.printf("Elige los colores de las %d fichas:%n", modo.getNumCasillas());
		if (modo != Modo.DIFICIL) {
			System.out.printf("1.%s   2.%s   3.%s   4.%s%n", GRIS, NEGRO, AZUL, ROJO);
			System.out.printf("5.%s   6.%s   7.%s   8.%s%n", AMARILLO, LIMA, TURQUESA, ROSA);
		} else {
			System.out.printf("1.%s   2.%s   3.%s   4.%s   5.%s%n", GRIS, NEGRO, AZUL, ROJO, AMARILLO);
			System.out.printf("6.%s   7.%s   8.%s   9.%s  10.%s%n", LIMA, TURQUESA, ROSA, CELESTE, MORADO);
		}

		for (posicionFicha = 0; posicionFicha < modo.getNumCasillas(); posicionFicha++) {
			eleccion = Teclado.leerEntre(1, modo.getNumColores(), Incluido.TODOS, Tipo.INT);

			switch (eleccion) {
			case 1:
				color = Color.GRIS;
				break;
			case 2:
				color = Color.NEGRO;
				break;
			case 3:
				color = Color.AZUL;
				break;
			case 4:
				color = Color.ROJO;
				break;
			case 5:
				color = Color.AMARILLO;
				break;
			case 6:
				color = Color.LIMA;
				break;
			case 7:
				color = Color.TURQUESA;
				break;
			case 8:
				color = Color.ROSA;
				break;
			case 9:
				color = Color.CELESTE;
				break;
			case 10:
				color = Color.MORADO;
				break;
			}

			combinacion.anadirFicha(color, posicionFicha);
		}
		return combinacion;
	}

	// Con este método se añade una combinación oculta que el contrario tiene que adivinar.
	Combinacion anadirCombinacionOculta() {
		Combinacion combinacionOculta = new Combinacion(modo.getNumCasillas());
		Color color = null;
		int posicionFicha, eleccion, totalColores = modo.getNumColores();
		int elecciones[] = new int[modo.getNumCasillas()], coloresElegidos[] = new int[totalColores];
		boolean salir = false;

		System.out.printf("1.%s   2.%s   3.%s   4.%s%n", GRIS, NEGRO, AZUL, ROJO);
		System.out.printf("5.%s   6.%s   7.%s   8.%s%n", AMARILLO, LIMA, TURQUESA, ROSA);
		for (posicionFicha = 0; posicionFicha < modo.getNumCasillas(); posicionFicha++) {
			do {
				eleccion = Teclado.leerEntre(1, totalColores, Incluido.TODOS, Tipo.INT);
				if (coloresElegidos[eleccion-1] == 0) {
					coloresElegidos[eleccion-1]++;
					elecciones[posicionFicha] = eleccion;
					salir = true;
				} else {
					System.out.println("Has introducido un color repetido. Inténtalo de nuevo:");
				}

			} while (!salir);

			salir = false;

			switch (eleccion) {
			case 1:
				color = Color.GRIS;
				break;
			case 2:
				color = Color.NEGRO;
				break;
			case 3:
				color = Color.AZUL;
				break;
			case 4:
				color = Color.ROJO;
				break;
			case 5:
				color = Color.AMARILLO;
				break;
			case 6:
				color = Color.LIMA;
				break;
			case 7:
				color = Color.TURQUESA;
				break;
			case 8:
				color = Color.ROSA;
				break;
			case 9:
				color = Color.CELESTE;
				break;
			case 10:
				color = Color.MORADO;
				break;
			}

			combinacionOculta.anadirFicha(color, posicionFicha);
		}

		tablero.setCombinacionOcultaPropia(combinacionOculta);

		return combinacionOculta;
	}

	// Recibe una combinación que se va utilizar para añadirla como Respuesta a una Jugada.
	Jugada anadirRespuesta(Combinacion combinacion) {
		// Respuesta respuesta = new Respuesta(modo.getNumCasillas());
		int[] respuestas = comprobarJugada(combinacion);
		int aciertos;
		boolean correcto = true;

		System.out.print("   Jugada: ");
		combinacion.dibujar();
		
		do {
			System.out.println("\n¿Cuántos aciertos rojos ha tenido el rival?(Coincidencia en color y posición):");
			aciertos = Teclado.leerEntre(0, 4, Incluido.TODOS, Tipo.INT);
			if (aciertos != respuestas[0]) {
				System.out.println("Te has equivocado al poner los aciertos rojos.");
				correcto = false;
			} else
				correcto = true;
		} while (!correcto);

		do {
			System.out.println("¿Cuántos aciertos blancos ha tenido el rival?(Coincidencia en color):");
			aciertos = Teclado.leerEntre(0, 4, Incluido.TODOS, Tipo.INT);
			if (aciertos != respuestas[1]) {
				System.out.println("Te has equivocado al poner los aciertos blancos.");
				correcto = false;
			} else
				correcto = true;
		} while (!correcto);

		return new Jugada(combinacion, crearRespuesta(respuestas), modo);
	}

}
