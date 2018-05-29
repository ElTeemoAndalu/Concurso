package Ismael;

import java.util.ArrayList;
import Ismael.Teclado.enummaximominimo;

/**
 * Esta clase tiene los mismos atributos que su padre, representa al usuario humano que juega
 * 
 * @author Ismael Raqi Picardo
 * @version 1.0
 * @since 1.0
 *
 */
public class Usuario extends Jugador {

	/**
	 * Construye un nuevo objeto Usuario que contiene llama al método de su padre
	 * @param modo  El modo que determinará la longitud del array
	 */
	protected Usuario(Modos modo) {
		super(modo);
	}

	/**
	 * Genera un objeto Combinacion con la pista de su combinación secreta al contrincante, se pedirá la pista al usuario hasta que dé la pista correcta
	 * @param		pistaCorrecta		Objeto Combinacion generada por el método {@link #generarPista(Jugador)} para comprobar 
	 * si el usuario da la pista correcta
	 * @return 		Combinacion			Devuelve un objeto Combinacion con la pista al contrincante
	 */
	protected Combinacion elegirPista(Combinacion pistaCorrecta) {
		Combinacion pinchos = new Combinacion(getModo());
		int num1, num2;
		boolean bandera = false;

		do {
			bandera = false;
			
			System.out.printf("\n\n¿Cuántos pinchitos negros?\n");
			num1 = Teclado.valores(0, getModo().getCasillas(), enummaximominimo.AMBOS_INCLUIDOS);

			System.out.printf("\n¿Cuántos pinchitos rojos?\n");
			num2 = Teclado.valores(0, getModo().getCasillas(), enummaximominimo.AMBOS_INCLUIDOS);

			for (int i = 0; i < getModo().getCasillas(); i++) {
				if (num1 > 0) {
					pinchos.getCombinacion()[i] = new Casilla(Colores.NEGRO + "  " + Colores.RESET);
					num1--;
				} else if (num2 > 0) {
					pinchos.getCombinacion()[i] = new Casilla(Colores.ROJO + "  " + Colores.RESET);
					num2--;
				} else {
					pinchos.getCombinacion()[i] = new Casilla(Colores.BLANCO + "  " + Colores.RESET);
				}
			}
			
			for (int i=0;i< getModo().getCasillas();i++) {
				if (!pinchos.getCombinacion()[i].equals(pistaCorrecta.getCombinacion()[i])) {
					bandera = true;
				}
			}
			if (bandera) {
				System.out.printf("\nHas dado mal la pista\n");
			}
			
		} while (bandera);
		return pinchos;
	}

	/**
	 * Genera un objeto Combinacion que será el intento del usuario hacia la combinación secreta del contrincante, se pueden repetir colores
	 * @return 		Combinacion			Devuelve un objeto Combinacion que será la combRespuesta del usuario, pudiendo haber colores repetidos
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Combinacion elegirCombinacionConRepet() {
		Combinacion combSecreta = new Combinacion(getModo());
		ArrayList lista = new ArrayList<String>();
		boolean repetir = true;
		int opcionPosicion;
		int opcionColor;
		String pregunta;

		for (int x = 0; x < getModo().getCasillas(); x++) {
			lista.add(null);
			combSecreta.getCombinacion()[x] = new Casilla(null);
		}

		do {

			System.out.printf(
					"\n\nColores:\n1. Negro\n2. Rojo\n3. Verde\n4. Amarillo\n5. Azul\n6. Morado\n7. Celeste\n8. Blanco\n");
			opcionColor = Teclado.valores(1, 8, enummaximominimo.AMBOS_INCLUIDOS);

			System.out.printf("\nPosiciones: De 1 a %d\n", getModo().getCasillas());
			opcionPosicion = Teclado.valores(1, getModo().getCasillas(), enummaximominimo.AMBOS_INCLUIDOS);

			opcionPosicion--;

			switch (opcionColor) {
			case 1:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.NEGRO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.NEGRO + "  " + Colores.RESET);;
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 2:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.ROJO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.ROJO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 3:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.VERDE + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.VERDE + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 4:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.AMARILLO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.AMARILLO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 5:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.AZUL + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.AZUL + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 6:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.MORADO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.MORADO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 7:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.CELESTE + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.CELESTE + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 8:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.BLANCO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.BLANCO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 9:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.VERDECLARO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.VERDECLARO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 10:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.ROSA + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.ROSA + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			}
			if (!lista.contains(null)) {
				do {
					System.out.printf("\nTu combinación es:\n\n");
					for (int i = 0; i < getModo().getCasillas(); i++) {
						System.out.printf("%dº: %s  ", i + 1, combSecreta.getCombinacion()[i].getColor());
					}
					System.out.printf("\n¿Desea cambiar alguna casilla? S/N ");
					pregunta = Teclado.pedirCadena();
					pregunta = pregunta.toUpperCase();
				} while (!pregunta.equals("S") && !pregunta.equals("N"));
				if (pregunta.equals("N")) {
					repetir = false;
				}
			}

		} while (repetir);

		return combSecreta;
	}

	/**
	 * Genera un objeto Combinacion que será la combinación secreta del usuario, no se pueden repetir colores
	 * @return 		Combinacion			Devuelve un objeto Combinacion que será la combSecreta del usuario, no pudiendo haber colores repetidos
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Combinacion elegirCombinacionSinRepet() {
		Combinacion combSecreta = new Combinacion(getModo());
		ArrayList lista = new ArrayList<String>();
		boolean repetir = true;
		int opcionPosicion;
		int opcionColor;
		int repeticion = 0;
		String pregunta;

		for (int x = 0; x < getModo().getCasillas(); x++) {
			lista.add(null);
			combSecreta.getCombinacion()[x] = new Casilla(null);
		}

		do {

			System.out.printf(
					"\n\nColores:\n1. Negro\n2. Rojo\n3. Verde\n4. Amarillo\n5. Azul\n6. Morado\n7. Celeste\n8. Blanco\n");
			opcionColor = Teclado.valores(1, 8, enummaximominimo.AMBOS_INCLUIDOS);

			System.out.printf("\nPosiciones: De 1 a %d\n", getModo().getCasillas());
			opcionPosicion = Teclado.valores(1, getModo().getCasillas(), enummaximominimo.AMBOS_INCLUIDOS);

			opcionPosicion--;

			switch (opcionColor) {
			case 1:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.NEGRO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.NEGRO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 2:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.ROJO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.ROJO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 3:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.VERDE + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.VERDE + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 4:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.AMARILLO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.AMARILLO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 5:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.AZUL + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.AZUL + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 6:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.MORADO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.MORADO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 7:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.CELESTE + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.CELESTE + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 8:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.BLANCO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.BLANCO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 9:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.VERDECLARO + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.VERDECLARO + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			case 10:
				if (combSecreta.getCombinacion()[opcionPosicion].getColor() == null) {
					combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.ROSA + "  " + Colores.RESET);
					lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
				} else {
					do {
						System.out.printf("La posición %d es %s ¿Deseas cambiarla? S/N: ", opcionPosicion + 1,
								combSecreta.getCombinacion()[opcionPosicion].getColor());
						pregunta = Teclado.pedirCadena();
						pregunta = pregunta.toUpperCase();
					} while (!pregunta.equals("S") && !pregunta.equals("N"));
					if (pregunta.equals("S")) {
						combSecreta.getCombinacion()[opcionPosicion].setColor(Colores.ROSA + "  " + Colores.RESET);
						lista.set(opcionPosicion, combSecreta.getCombinacion()[opcionPosicion]);
					}
				}
				break;
			}
			if (!lista.contains(null)) {
				do {
					System.out.printf("\nTu combinación es:\n\n");
					for (int i = 0; i < getModo().getCasillas(); i++) {
						System.out.printf("%dº: %s  ", i + 1, combSecreta.getCombinacion()[i].getColor());
					}
					System.out.printf("\n¿Desea cambiar alguna casilla? S/N ");
					pregunta = Teclado.pedirCadena();
					pregunta = pregunta.toUpperCase();
				} while (!pregunta.equals("S") && !pregunta.equals("N"));
				if (pregunta.equals("N")) {
					repetir = false;

					// CREAR UN METODO

					for (int h = 0; h < getModo().getCasillas(); h++) { // AQUI SE COMPARA CADA COLOR PARA QUE NO SE REPITAN
						repeticion = 0;
						for (int t = 0; t < getModo().getCasillas(); t++) {
							if (combSecreta.getCombinacion()[h].getColor().equals(combSecreta.getCombinacion()[t].getColor())) {
								repeticion++;
							}
						}
						if (repeticion > 1) {
							repetir = true;
						}
					}

					if (repetir) {
						System.out.printf("\nNo se pueden repetir colores, por favor, modifique su combinación");
					}
				}
			}

		} while (repetir);

		return combSecreta;
	}

	/**
	 * Método que llama al método {@link #elegirCombinacionSinRepet()} para elegir una combinación , es implementada de su
	 * clase padre
	 * @return 		Combinacion			Objeto de clase Combinacion que será la combinación secreta del usuario
	 */
	@Override
	protected Combinacion generarCombinacion() {

		return elegirCombinacionSinRepet();
	}

	/**
	 * Muestra por pantalla la combinación secreta de la máquina que lo ejecute, es implementada de su
	 * clase padre 
	 */
	protected void dibujarCombinacionSecreta() {
		for (int i = 0; i < getModo().getCasillas(); i++) {
			System.out.printf("%s ", getCombSecreta().getCombinacion()[i].getColor());
		}
	}

}
