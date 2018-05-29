package Ismael;

import Ismael.Teclado.enummaximominimo;

/**
 * Esta clase almacena 2 objetos Jugador, 2 objetos Tablero y un enum Modos, es la clase principal del programa
 * 
 * @author Ismael Raqi Picardo
 * @version 1.0
 * @since 1.0
 *
 */
public class Partida {

	@SuppressWarnings("unused")
	/**
	 * Almacena un enum Modos
	 */
	private Modos modo;
	/**
	 * Almacena un objeto Jugador para el jugador 1
	 */
	private Jugador jugador1;
	/**
	 * Almacena un objeto Tablero para el jugador 1
	 */
	private Tablero tablero1;

	/**
	 * Almacena un objeto Jugador para el jugador 2
	 */
	private Jugador jugador2;
	/**
	 * Almacena un objeto Tablero para el jugador 2
	 */
	private Tablero tablero2;

	/**
	 * Construye un nuevo objeto Partida totalmente vacío que sirve de auxiliar
	 */
	protected Partida() {
	}

	/**
	 * Construye un nuevo objeto Partida que inicializa los objetos Jugador y Tablero
	 * @param modo  El modo que determinará si se inicializan los objetos Jugador, en Maquina, o Usuario
	 * 
	 */
	protected Partida(Modos modo) {
		this.modo = modo;
		if (modo == Modos.FACIL) {
			jugador1 = new Usuario(modo);
			tablero1 = new Tablero();

			jugador2 = new Maquina(modo);
			tablero2 = new Tablero();

		} else if (modo == Modos.MEDIO) {
			jugador1 = new Usuario(modo);
			tablero1 = new Tablero();

			jugador2 = new Maquina(modo);
			tablero2 = new Tablero();
		} else {
			jugador1 = new Maquina(modo);
			tablero1 = new Tablero();

			jugador2 = new Maquina(modo);
			tablero2 = new Tablero();
		}
	}

	/**
	 * Método principal del programa, donde se ejecutará todo el programa (juego MasterMind) desde el principio hasta el final
	 */
	protected void inicioPartida() {
		int opcion;
		Modos modo;
		Partida partida;
		boolean fin = true;
		boolean fin1 = true;
		boolean fin2 = true;

		System.out.printf("\r\n" + 
				".___  ___.      ___           _______.___________._______ .______     .___  ___.  __  .__   __.  _______  \r\n" + 
				"|   \\/   |     /   \\         /       |           |   ____||   _  \\    |   \\/   | |  | |  \\ |  | |       \\ \r\n" + 
				"|  \\  /  |    /  ^  \\       |   (----`---|  |----|  |__   |  |_)  |   |  \\  /  | |  | |   \\|  | |  .--.  |\r\n" + 
				"|  |\\/|  |   /  /_\\  \\       \\   \\       |  |    |   __|  |      /    |  |\\/|  | |  | |  . `  | |  |  |  |\r\n" + 
				"|  |  |  |  /  _____  \\  .----)   |      |  |    |  |____ |  |\\  \\----|  |  |  | |  | |  |\\   | |  '--'  |\r\n" + 
				"|__|  |__| /__/     \\__\\ |_______/       |__|    |_______|| _| `._____|__|  |__| |__| |__| \\__| |_______/ \r\n" + 
				"                                                                                                          \r\n\n\n" + 
				" 									 ___        ___           _ \r\n" + 
				" 									| _ )_  _  | _ \\__ _ __ _(_)\r\n" + 
				"					 				| _ | || | |   / _` / _` | |\r\n" + 
				"					 				|___/\\_, | |_|_\\__,_\\__, |_|\r\n" + 
				"					 		          	     |__/              |_|");
		System.out.printf("\n\n\n\nElija dificultad:\n\n1.Fácil\n2.Medio\n3.Difícil\n4.Instrucciones\n");
		opcion = Teclado.valores(1, 4, enummaximominimo.AMBOS_INCLUIDOS);

		switch (opcion) {
		case 1:
			modo = Modos.FACIL;
			break;
		case 2:
			modo = Modos.MEDIO;
			break;
		case 3:
			modo = Modos.DIFICIL;
			break;
		default:
			modo = Modos.INSTRUCCIONES;
		}
		partida = new Partida(modo);

		if (modo == Modos.FACIL) {
			System.out.printf("\n\n¿Quién va a jugar?\n1. Jugador\n2. Máquina\nOpción: ");
			opcion = Teclado.valores(1, 3, enummaximominimo.AMBOS_INCLUIDOS);

			if (opcion == 1) {

				partida.jugador2.setCombSecreta(partida.jugador2.generarCombinacion()); 
			} else {
				System.out.printf("\nElija su combinación secreta jugador 1\n");
				partida.jugador1.setCombSecreta(((Usuario) partida.jugador1).elegirCombinacionSinRepet());
			}
			do {
				if (opcion == 1) { // APARTADO DEL USUARIO EN EL MODO FACIL

					System.out.printf("\n\nElija su intento jugador 1\n");
					partida.jugador1.setCombRespuesta(((Usuario) partida.jugador1).elegirCombinacionConRepet());

					if (partida.jugador2.comprobarCombinacion(partida.jugador1.getCombRespuesta())) {

						partida.tablero1.añadirAlTablero(partida.jugador1.getCombRespuesta(),
								partida.jugador2.generarPista(partida.jugador1));

						partida.tablero1.dibujarTablero(partida.tablero1);

						System.out.printf("Has acertado la combinación: ");
						fin = false;
						((Maquina) partida.jugador2).dibujarCombinacionSecreta();
						System.out.printf("\n\n");
					} else {
						partida.tablero1.añadirAlTablero(partida.jugador1.getCombRespuesta(),
								partida.jugador2.generarPista(partida.jugador1));
						partida.jugador1.setIntentos(partida.jugador1.getIntentos() -1);

						if (partida.jugador1.getIntentos() != 0) {

							partida.tablero1.dibujarTablero(partida.tablero1);

							System.out.printf("Has fallado, te quedan %d intentos", partida.jugador1.getIntentos());
						} else {
							partida.tablero1.dibujarTablero(partida.tablero1);

							System.out.printf("Has perdido, la combinación era: ");
							((Maquina) partida.jugador2).dibujarCombinacionSecreta();
							System.out.printf("\n\n");
						}
					}
				} else { // APARTADO DE LA MÁQUINA EN EL MODO FACIL
					System.out.printf("\n\nVa a jugar la máquina\n");
					System.out.printf("Presione ENTER para el turno de la máquina\n");
					Teclado.pedirCadena();
					partida.jugador2.setCombRespuesta(((Maquina) partida.jugador2).IA(partida.tablero2));
					
					System.out.printf("El actual intento de la máquina es:  ");
					((Maquina) partida.jugador2).dibujarCombinacionRespuesta();
					((Usuario) partida.jugador1).elegirPista(partida.jugador1.generarPista(partida.jugador2));

					if (partida.jugador1.comprobarCombinacion(partida.jugador2.getCombRespuesta())) {

						partida.tablero2.añadirAlTablero(partida.jugador2.getCombRespuesta(),
								jugador1.generarPista(partida.jugador2));

						partida.tablero2.dibujarTablero(partida.tablero2);

						System.out.printf("La máquina ha acertado la combinación: ");
						fin = false;
						partida.jugador1.dibujarCombinacionSecreta();
						System.out.printf("\n\n");
					} else {
						partida.tablero2.añadirAlTablero(partida.jugador2.getCombRespuesta(),
								partida.jugador1.generarPista(partida.jugador2));
						partida.jugador2.setIntentos(partida.jugador2.getIntentos() -1);

						if (partida.jugador2.getIntentos() != 0) {

							partida.tablero2.dibujarTablero(partida.tablero2);

							System.out.printf("La máquina fallado, le quedan %d intentos", partida.jugador2.getIntentos());

						} else {
							partida.tablero2.dibujarTablero(partida.tablero2);

							System.out.printf("La máquina ha perdido, la combinación era: ");
							partida.jugador1.dibujarCombinacionSecreta();
							System.out.printf("\n\n");
						}
					}

				}
			} while ((partida.jugador1.getIntentos() != 0 && partida.jugador2.getIntentos() != 0) && fin);

		} else if (modo == Modos.MEDIO) {

			partida.jugador2.setCombSecreta(partida.jugador2.generarCombinacion());

			System.out.printf("\nVamos a generar tu combinación secreta jugador 1 (no se pueden repetir colores)\n");
			partida.jugador1.setCombSecreta(partida.jugador1.generarCombinacion());

			do {
				// AQUI EMPIEZA JUGANDO EL USUARIO
				System.out.printf("\n\nElija su intento jugador 1\n");

				partida.jugador1.setCombRespuesta(((Usuario) partida.jugador1).elegirCombinacionConRepet());

				if (partida.jugador2.comprobarCombinacion(partida.jugador1.getCombRespuesta())) {

					partida.tablero1.añadirAlTablero(partida.jugador1.getCombRespuesta(),
							partida.jugador2.generarPista(partida.jugador1));

					partida.tablero1.dibujarTablero(partida.tablero1);

					System.out.printf("Has acertado la combinación: ");
					fin1 = false;
					((Maquina) partida.jugador2).dibujarCombinacionSecreta();
					System.out.printf("\n\n");
				} else {
					partida.tablero1.añadirAlTablero(partida.jugador1.getCombRespuesta(),
							partida.jugador2.generarPista(partida.jugador1));
					partida.jugador1.setIntentos(partida.jugador1.getIntentos() -1);

					if (partida.jugador1.getIntentos() != 0) {

						partida.tablero1.dibujarTablero(partida.tablero1);

						System.out.printf("Has fallado, te quedan %d intentos\n\n", partida.jugador1.getIntentos());

					} else {
						partida.tablero1.dibujarTablero(partida.tablero1);

						System.out.printf("Has perdido, la combinación era: ");
						((Maquina) partida.jugador2).dibujarCombinacionSecreta();
						System.out.printf("\n\n");
					}
				}

				partida.jugador2.setCombRespuesta(((Maquina) partida.jugador2).IA(partida.tablero2));

				if (partida.jugador1.comprobarCombinacion(partida.jugador2.getCombRespuesta())) {

					partida.tablero2.añadirAlTablero(partida.jugador2.getCombRespuesta(),partida.jugador1.generarPista(partida.jugador2));

					partida.tablero2.dibujarTablero(partida.tablero2);

					System.out.printf("La máquina ha acertado la combinación: ");
					fin2 = false;
					partida.jugador1.dibujarCombinacionSecreta();
					System.out.printf("\n\n");
				} else {
					partida.tablero2.añadirAlTablero(partida.jugador2.getCombRespuesta(),
							partida.jugador1.generarPista(partida.jugador2));
					partida.jugador2.setIntentos(partida.jugador2.getIntentos() -1);

					if (partida.jugador2.getIntentos() != 0) {

						partida.tablero1.dibujarTablero(partida.tablero2);

						System.out.printf("La máquina ha fallado, le quedan %d intentos\n\n",
								partida.jugador2.getIntentos());
					} else {
						partida.tablero2.dibujarTablero(partida.tablero2);

						System.out.printf("La máquina ha perdido, la combinación era: ");
						partida.jugador1.dibujarCombinacionSecreta();
						System.out.printf("\n\n");
					}
				}

				if (!fin1 && !fin2) {
					System.out.println("\nHabeis empatado");
				} else if (!fin1) {
					System.out.println("\nHa ganado el jugador 1");
				} else if (!fin2) {
					System.out.println("\nHa ganado la máquina");
				}

			} while (partida.jugador1.getIntentos() != 0 && fin1 || fin2); 

		} else if (modo == Modos.DIFICIL) {
			
			partida.jugador1.setCombSecreta(partida.jugador1.generarCombinacion());
			System.out.printf("La combinación secreta de la máquina 1 es:\n");
			partida.jugador1.dibujarCombinacionSecreta();
			
			System.out.printf("\n\n");
			
			partida.jugador2.setCombSecreta(partida.jugador2.generarCombinacion());
			System.out.printf("La combinación secreta de la máquina 2 es:\n");
			partida.jugador2.dibujarCombinacionSecreta();
			
			
			do {
				//	AQUI JUEGA MÁQUINA 1
				System.out.printf("\n\nIntento %d de la máquina 1\n\nPulse ENTER para continuar",partida.jugador1.getIntentos()+1);
				
				partida.jugador1.setCombRespuesta(((Maquina) partida.jugador1).IA(partida.tablero1));
				
				partida.tablero1.añadirAlTablero(partida.jugador1.getCombRespuesta(),partida.jugador2.generarPista(partida.jugador1));

				//partida.tablero1.dibujarTablero(partida.tablero1);
				
				if (partida.jugador1.comprobarCombinacion(partida.jugador2.getCombSecreta())) {
					fin1 = false;
					System.out.printf("La máquina 1 ha acertado la combinación");
				}else {
					partida.jugador1.setIntentos(partida.jugador1.getIntentos() +1);
				}
				
				
				//	AQUI JUEGA MÁQUINA 2
				System.out.printf("\n\nIntento %d de la máquina 2\n\nPulse ENTER para continuar",partida.jugador2.getIntentos()+1);
				
				partida.jugador2.setCombRespuesta(((Maquina) partida.jugador2).IA(partida.tablero2));
				
				partida.tablero2.añadirAlTablero(partida.jugador2.getCombRespuesta(),partida.jugador1.generarPista(partida.jugador2));

				//partida.tablero2.dibujarTablero(partida.tablero2);
				
				if (partida.jugador1.comprobarCombinacion(partida.jugador2.getCombSecreta())) {
					fin2 = false;
					System.out.printf("La máquina 2 ha acertado la combinación");
				}else {
					partida.jugador2.setIntentos(partida.jugador2.getIntentos() +1);
				}
				
				
				if (!fin1 && !fin2) {
					System.out.printf("Habeis empatado");
				}else if (!fin1) {
					System.out.printf("Ha ganado la máquina 1");
				}else if (!fin2) {
					System.out.printf("Ha ganado la máquina 2");
				}
				
			}while(fin1 && fin2);
			
		} else {
			System.out.printf(
					"\n\nINSTRUCCIONES:\n\nLas bolitas %s significan que un color está en la posición adecuada\nLas bolitas %s significan que el color es correcto pero no su posición\nLas bolitas %s significan que el color no se encuentra en la combinación\n\n",
					Colores.NEGRO + "  " + Colores.RESET, Colores.ROJO + "  " + Colores.RESET, Colores.BLANCO + "  " + Colores.RESET);
		}
	}

	public static void main(String[] args) {

		boolean respuesta;
		do {
			Partida partida = new Partida();
			partida.inicioPartida();
			
			respuesta = Teclado.pedirBoolean("¿Desea jugar otra partida?", "Sí", "No");
			System.out.printf("\n\n");
		}while (respuesta);
		

	}

}
