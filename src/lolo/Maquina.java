package lolo;

import java.util.Random;

public class Maquina extends Jugador {

	public Maquina(Modo modo) {
		super(modo);
	}

	// Devuelve una combinación que se va añadir a la Jugada.
	public Combinacion anadirCombinacion() {
		Random rnd = new Random();
		Combinacion combinacion = new Combinacion(modo.getNumCasillas());
		Color color = null;
		int posicionFicha, eleccion;

		for (posicionFicha = 0; posicionFicha < modo.getNumCasillas(); posicionFicha++) {
			eleccion = rnd.nextInt(modo.getNumColores()) + 1;

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
	// Si el modo es difícil, permitirá la repetición de colores.
	Combinacion anadirCombinacionOculta() {
		Random rnd = new Random();
		Combinacion combinacionOculta = new Combinacion(modo.getNumCasillas());
		Color color = null;
		int posicionFicha, eleccionAleatoria, contador = 0;
		int elecciones[] = new int[modo.getNumCasillas()];
		boolean salir = false;

		for (posicionFicha = 0; posicionFicha < modo.getNumCasillas(); posicionFicha++) {
			if (modo == Modo.DIFICIL) {
				eleccionAleatoria = rnd.nextInt(modo.getNumColores()) + 1;
			} else {
				do {
					salir = false;
					eleccionAleatoria = rnd.nextInt(modo.getNumColores()) + 1;
					for (int i = 0; i < elecciones.length && !salir; i++) {
						if (eleccionAleatoria != elecciones[i])
							contador++;
						else {
							contador = 0;
							salir = true;
						}
					}
				} while (contador != modo.getNumCasillas());
			}

			contador = 0;
			elecciones[posicionFicha] = eleccionAleatoria;

			switch (eleccionAleatoria) {
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
		int[] respuestas = comprobarJugada(combinacion);

		return new Jugada(combinacion, crearRespuesta(respuestas), modo);
	}

}
