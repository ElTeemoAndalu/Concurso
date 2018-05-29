package Ismael;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Teclado {

	public static void main(String[] args) {

		/*
		 * Son funciones para: 1.Cerrar teclado 2.Pedir un caracter 3.Pedir una cadena
		 * 4.Pedir un boolean 5.Leer un boolean 6.Pedir un número de todos los tipos
		 * numéricos posibles (1 función para cada 1, con sobrecarga) 7.Pedir un número
		 * (de todos los tipos numéricos posibles con sobrecarga) y un parámetro sea
		 * mayor, menor, mayor igual o menor igual que el primer número introducido, y
		 * entonces pide un número al usuario que sea (parámetro que haya elegido) al
		 * número (que haya pasado por parámetro) 7.1.Enum para dicha tarea 8.Pedir un
		 * rango de números al usuario para luego pedirle un número (de todos los tipos
		 * numéricos con sobrecarga) comprendido entre esos valores, incluyendo o
		 * excluyendo su mínimo o máximo 8.1.Enum para dicha tarea 8.
		 */
	}

	static Scanner teclado = new Scanner(System.in);

	public static enum enumcomparacion {
		MAYORIGUAL_QUE, MENORIGUAL_QUE, MAYOR_QUE, MENOR_QUE
	}

	public static enum enummaximominimo {
		AMBOS_INCLUIDOS, AMBOS_EXCLUIDOS, MINIMOINCLUIDO_MAXIMOEXCLUIDO, MINIMOEXCLUIDO_MAXIMOINCLUIDO
	}

	// 1.
	public static void cerrarTeclado() {
		teclado.close();
	}

	// 2.
	public static char pedirCaracter() {
		boolean valido = false;
		String c = "";
		char caracter;
		do {
			try {
				c = teclado.nextLine();
				if (c.length()!=1) {
					System.out.printf("Error, introduce UN carácter: ");
				}
			} catch (NoSuchElementException | IllegalStateException | IndexOutOfBoundsException e) {
				System.out.printf("Introduce un carácter válido: ");
				// e.printStackTrace();
			}
			valido = true;
		} while (!valido || c.length() != 1);
		caracter = c.charAt(0);
		return caracter;
	}

	// 3.
	public static String pedirCadena() {
		boolean valido = false;
		String cadena;
		do {
			try {
				
				cadena = teclado.nextLine();
				/*if (cadena.length()<=0) {
					System.out.printf("Error, introduce un valor válido: ");
				}*/
				valido = true;
			} catch (NoSuchElementException | IllegalStateException e) {
				System.out.printf("Error, introduce un valor válido: ");
				// e.printStackTrace();
				throw e;
			}
		} while (!valido || cadena.length()<=0);
		return cadena;
	}

	// 4.
	public static boolean pedirBoolean(String cadena1, String cadena2, String cadena3) {
		int respuesta;
		boolean opcion = false;
		boolean valido = false;
		do {
			System.out.printf("%s\n    1.- %s\n    2.- %s\n", cadena1, cadena2, cadena3);
			try {
				respuesta = teclado.nextInt();
				if (respuesta == 1) {
					opcion = true;
					valido = true;
				} else if (respuesta == 2) {
					opcion = false;
					valido = true;
				}
			} catch (InputMismatchException e) {
				System.out.printf("Has introducido un dato erróneo\n");
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return opcion;
	}

	// 5.
	public static boolean leerBoolean(String cadena) {
		boolean opcion = false, valido = false;
		String respuesta;
		do {
			System.out.printf("%s (s/n): ", cadena);
			respuesta = teclado.nextLine();
			if (respuesta.equals("s") || respuesta.equals("S")) {
				opcion = true;
				valido = true;
			} else if (respuesta.equals("n") || respuesta.equals("N")) {
				opcion = false;
				valido = true;
			}
		} while (!valido);
		return opcion;
	}

	// 6.
	public static int pedirInt() {
		boolean valido = false;
		int numero = 0;
		do {
			try {
				numero = teclado.nextInt();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.printf("Error, debes introducir un número entero\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numero;
	}

	// 6.
	public static byte pedirByte() {
		boolean valido = false;
		byte numero = 0;
		do {
			try {
				numero = teclado.nextByte();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.printf("Error, debes introducir un número byte\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numero;
	}

	// 6.
	public static short pedirShort() {
		boolean valido = false;
		short numero = 0;
		do {
			try {
				numero = teclado.nextShort();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.printf("Error, debes introducir un número short\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numero;
	}

	// 6.
	public static long pedirLong() {
		boolean valido = false;
		long numero = 0;
		do {
			try {
				numero = teclado.nextLong();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.printf("Error, debes introducir un número long\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numero;
	}

	// 6.
	public static float pedirFloat() {
		boolean valido = false;
		float numero = 0;
		do {
			try {
				numero = teclado.nextFloat();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.printf("Error, debes introducir un número float\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numero;
	}

	// 6.
	public static double pedirDouble() {
		boolean valido = false;
		double numero = 0;
		do {
			try {
				numero = teclado.nextDouble();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.printf("Error, debes introducir un número double\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numero;
	}

	// 7.
	public static byte mayormenor(byte numero, enumcomparacion a) {
		boolean valido = false;
		byte numerito = 0;
		do {
			try {
				switch (a) {
				case MAYOR_QUE:
					do {
						System.out.printf("Introduce un número mayor que %d: ", numero);
						numerito = teclado.nextByte();
					} while (numerito <= numero);
					valido = true;
					break;
				case MAYORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número mayor o igual que %d: ", numero);
						numerito = teclado.nextByte();
					} while (numerito < numero);
					valido = true;
					break;
				case MENOR_QUE:
					do {
						System.out.printf("Introduce un número menor que %d: ", numero);
						numerito = teclado.nextByte();
					} while (numerito >= numero);
					valido = true;
					break;
				case MENORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número menor o igual que %d: ", numero);
						numerito = teclado.nextByte();
						valido = true;
					} while (numerito > numero);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("\nHas introducido un dato erróneo, debes introducir un byte\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numerito;
	}

	// 7.
	public static short mayormenor(short numero, enumcomparacion a) {
		boolean valido = false;
		short numerito = 0;
		do {
			try {
				switch (a) {
				case MAYOR_QUE:
					do {
						System.out.printf("Introduce un número mayor que %d: ", numero);
						numerito = teclado.nextShort();
					} while (numerito <= numero);
					valido = true;
					break;
				case MAYORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número mayor o igual que %d: ", numero);
						numerito = teclado.nextShort();
					} while (numerito < numero);
					valido = true;
					break;
				case MENOR_QUE:
					do {
						System.out.printf("Introduce un número menor que %d: ", numero);
						numerito = teclado.nextShort();
					} while (numerito >= numero);
					valido = true;
					break;
				case MENORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número menor o igual que %d: ", numero);
						numerito = teclado.nextShort();
						valido = true;
					} while (numerito > numero);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("\nHas introducido un dato erróneo, debes introducir un short\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numerito;
	}

	// 7.
	public static int mayormenor(int numero, enumcomparacion a) {
		boolean valido = false;
		int numerito = 0;
		do {
			try {
				switch (a) {
				case MAYOR_QUE:
					do {
						System.out.printf("Introduce un número mayor que %d: ", numero);
						numerito = teclado.nextInt();
					} while (numerito <= numero);
					valido = true;
					break;
				case MAYORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número mayor o igual que %d: ", numero);
						numerito = teclado.nextInt();
					} while (numerito < numero);
					valido = true;
					break;
				case MENOR_QUE:
					do {
						System.out.printf("Introduce un número menor que %d: ", numero);
						numerito = teclado.nextInt();
					} while (numerito >= numero);
					valido = true;
					break;
				case MENORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número menor o igual que %d: ", numero);
						numerito = teclado.nextInt();
						valido = true;
					} while (numerito > numero);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("\nHas introducido un dato erróneo, debes introducir un entero\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numerito;
	}

	// 7.
	public static long mayormenor(long numero, enumcomparacion a) {
		boolean valido = false;
		long numerito = 0;
		do {
			try {
				switch (a) {
				case MAYOR_QUE:
					do {
						System.out.printf("Introduce un número mayor que %d: ", numero);
						numerito = teclado.nextLong();
					} while (numerito <= numero);
					valido = true;
					break;
				case MAYORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número mayor o igual que %d: ", numero);
						numerito = teclado.nextLong();
					} while (numerito < numero);
					valido = true;
					break;
				case MENOR_QUE:
					do {
						System.out.printf("Introduce un número menor que %d: ", numero);
						numerito = teclado.nextLong();
					} while (numerito >= numero);
					valido = true;
					break;
				case MENORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número menor o igual que %d: ", numero);
						numerito = teclado.nextLong();
						valido = true;
					} while (numerito > numero);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("\nHas introducido un dato erróneo, debes introducir un long\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numerito;
	}

	// 7.
	public static float mayormenor(float numero, enumcomparacion a) {
		boolean valido = false;
		float numerito = 0;
		do {
			try {
				switch (a) {
				case MAYOR_QUE:
					do {
						System.out.printf("Introduce un número mayor que %.2f: ", numero);
						numerito = teclado.nextFloat();
					} while (numerito <= numero);
					valido = true;
					break;
				case MAYORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número mayor o igual que %.2f: ", numero);
						numerito = teclado.nextFloat();
					} while (numerito < numero);
					valido = true;
					break;
				case MENOR_QUE:
					do {
						System.out.printf("Introduce un número menor que %.2f: ", numero);
						numerito = teclado.nextFloat();
					} while (numerito >= numero);
					valido = true;
					break;
				case MENORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número menor o igual que %.2f: ", numero);
						numerito = teclado.nextFloat();
						valido = true;
					} while (numerito > numero);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("\nHas introducido un dato erróneo, debes introducir un float\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numerito;
	}

	// 7.
	public static double mayormenor(double numero, enumcomparacion a) {
		boolean valido = false;
		double numerito = 0;
		do {
			try {
				switch (a) {
				case MAYOR_QUE:
					do {
						System.out.printf("Introduce un número mayor que %.2f: ", numero);
						numerito = teclado.nextDouble();
					} while (numerito <= numero);
					valido = true;
					break;
				case MAYORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número mayor o igual que %.2f: ", numero);
						numerito = teclado.nextDouble();
					} while (numerito < numero);
					valido = true;
					break;
				case MENOR_QUE:
					do {
						System.out.printf("Introduce un número menor que %.2f: ", numero);
						numerito = teclado.nextDouble();
					} while (numerito >= numero);
					valido = true;
					break;
				case MENORIGUAL_QUE:
					do {
						System.out.printf("Introduce un número menor o igual que %.2f: ", numero);
						numerito = teclado.nextDouble();
						valido = true;
					} while (numerito > numero);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("\nHas introducido un dato erróneo, debes introducir un double\n");
				valido = false;
			} finally {
				teclado.nextLine();
			}
		} while (!valido);
		return numerito;
	}

	// 8.
	public static int valores(int minimo, int maximo, enummaximominimo a) {
		boolean valido = false;
		int numero = 0;

		if (minimo > maximo) {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				System.out.printf("El valor mínimo introducido es superior al valor máximo\n");
				valido = true;
			}
		}

		while (!valido)
			do {
				try {
					if (minimo == maximo) {
						do {
							System.out.printf("Introduce el valor %d: ", minimo);
							numero = teclado.nextInt();
							if (numero == minimo) {
								valido = true;
							}
						} while (!valido);
					}
					while (!valido) {
						switch (a) {
						case AMBOS_EXCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %d y %d (ambos excluidos): ", minimo,
										maximo);
								numero = teclado.nextInt();
								valido = true;
							} while (numero <= minimo || numero >= maximo);
							break;
						case AMBOS_INCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %d y %d (ambos incluidos): ", minimo,
										maximo);
								numero = teclado.nextInt();
							} while (numero < minimo || numero > maximo);
							valido = true;
							break;
						case MINIMOINCLUIDO_MAXIMOEXCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %d y %d (minimo incluido pero maximo excluido): ",
										minimo, maximo);
								numero = teclado.nextInt();
							} while (numero < minimo || numero >= maximo);
							valido = true;
							break;
						case MINIMOEXCLUIDO_MAXIMOINCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %d y %d (minimo excluido pero maximo incluido): ",
										minimo, maximo);
								numero = teclado.nextInt();
								valido = true;
							} while (numero <= minimo || numero > maximo);
							break;
						}
					}
				} catch (InputMismatchException e) {
					System.out.printf("\nHas introducido un dato erróneo\n");
					valido = false;
				} finally {
					teclado.nextLine();
				}
			} while (!valido);

		return numero;
	}

	// 8.
	public static byte valores(byte minimo, byte maximo, enummaximominimo a) {
		boolean valido = false;
		byte numero = 0;

		if (minimo > maximo) {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				System.out.printf("El valor mínimo introducido es superior al valor máximo\n");
				valido = true;
			}
		}

		while (!valido)
			do {
				try {
					if (minimo == maximo) {
						do {
							System.out.printf("Introduce el valor %d: ", minimo);
							numero = teclado.nextByte();
							if (numero == minimo) {
								valido = true;
							}
						} while (!valido);
					}
					while (!valido) {
						switch (a) {
						case AMBOS_EXCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %d y %d (ambos excluidos): ", minimo,
										maximo);
								numero = teclado.nextByte();
								valido = true;
							} while (numero <= minimo || numero >= maximo);
							break;
						case AMBOS_INCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %d y %d (ambos incluidos): ", minimo,
										maximo);
								numero = teclado.nextByte();
							} while (numero < minimo || numero > maximo);
							valido = true;
							break;
						case MINIMOINCLUIDO_MAXIMOEXCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %d y %d (minimo incluido pero maximo excluido): ",
										minimo, maximo);
								numero = teclado.nextByte();
							} while (numero < minimo || numero >= maximo);
							valido = true;
							break;
						case MINIMOEXCLUIDO_MAXIMOINCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %d y %d (minimo excluido pero maximo incluido): ",
										minimo, maximo);
								numero = teclado.nextByte();
								valido = true;
							} while (numero <= minimo || numero > maximo);
							break;
						}
					}
				} catch (InputMismatchException e) {
					System.out.printf("\nHas introducido un dato erróneo\n");
					valido = false;
				} finally {
					teclado.nextLine();
				}
			} while (!valido);

		return numero;
	}

	// 8.
	public static short valores(short minimo, short maximo, enummaximominimo a) {
		boolean valido = false;
		short numero = 0;

		if (minimo > maximo) {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				System.out.printf("El valor mínimo introducido es superior al valor máximo\n");
				valido = true;
			}
		}

		while (!valido)
			do {
				try {
					if (minimo == maximo) {
						do {
							System.out.printf("Introduce el valor %d: ", minimo);
							numero = teclado.nextShort();
							if (numero == minimo) {
								valido = true;
							}
						} while (!valido);
					}
					while (!valido) {
						switch (a) {
						case AMBOS_EXCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %d y %d (ambos excluidos): ", minimo,
										maximo);
								numero = teclado.nextShort();
								valido = true;
							} while (numero <= minimo || numero >= maximo);
							break;
						case AMBOS_INCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %d y %d (ambos incluidos): ", minimo,
										maximo);
								numero = teclado.nextShort();
							} while (numero < minimo || numero > maximo);
							valido = true;
							break;
						case MINIMOINCLUIDO_MAXIMOEXCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %d y %d (minimo incluido pero maximo excluido): ",
										minimo, maximo);
								numero = teclado.nextShort();
							} while (numero < minimo || numero >= maximo);
							valido = true;
							break;
						case MINIMOEXCLUIDO_MAXIMOINCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %d y %d (minimo excluido pero maximo incluido): ",
										minimo, maximo);
								numero = teclado.nextShort();
								valido = true;
							} while (numero <= minimo || numero > maximo);
							break;
						}
					}
				} catch (InputMismatchException e) {
					System.out.printf("\nHas introducido un dato erróneo\n");
					valido = false;
				} finally {
					teclado.nextLine();
				}
			} while (!valido);

		return numero;
	}

	// 8.
	public static double valores(double minimo, double maximo, enummaximominimo a) {
		boolean valido = false;
		double numero = 0;

		if (minimo > maximo) {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				System.out.printf("El valor mínimo introducido es superior al valor máximo\n");
				valido = true;
			}
		}

		while (!valido)
			do {
				try {
					if (minimo == maximo) {
						do {
							System.out.printf("Introduce el valor %.2f: ", minimo);
							numero = teclado.nextDouble();
							if (numero == minimo) {
								valido = true;
							}
						} while (!valido);
					}
					while (!valido) {
						switch (a) {
						case AMBOS_EXCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %.2f y %.2f (ambos excluidos): ", minimo,
										maximo);
								numero = teclado.nextDouble();
								valido = true;
							} while (numero <= minimo || numero >= maximo);
							break;
						case AMBOS_INCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %.2f y %.2f (ambos incluidos): ", minimo,
										maximo);
								numero = teclado.nextDouble();
							} while (numero < minimo || numero > maximo);
							valido = true;
							break;
						case MINIMOINCLUIDO_MAXIMOEXCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %.2f y %.2f (minimo incluido pero maximo excluido): ",
										minimo, maximo);
								numero = teclado.nextDouble();
							} while (numero < minimo || numero >= maximo);
							valido = true;
							break;
						case MINIMOEXCLUIDO_MAXIMOINCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %.2f y %.2f (minimo excluido pero maximo incluido): ",
										minimo, maximo);
								numero = teclado.nextDouble();
								valido = true;
							} while (numero <= minimo || numero > maximo);
							break;
						}
					}
				} catch (InputMismatchException e) {
					System.out.printf("\nHas introducido un dato erróneo\n");
					valido = false;
				} finally {
					teclado.nextLine();
				}
			} while (!valido);

		return numero;
	}

	// 8.
	public static long valores(long minimo, long maximo, enummaximominimo a) {
		boolean valido = false;
		long numero = 0;

		if (minimo > maximo) {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				System.out.printf("El valor mínimo introducido es superior al valor máximo\n");
				valido = true;
			}
		}

		while (!valido)
			do {
				try {
					if (minimo == maximo) {
						do {
							System.out.printf("Introduce el valor %d: ", minimo);
							numero = teclado.nextLong();
							if (numero == minimo) {
								valido = true;
							}
						} while (!valido);
					}
					while (!valido) {
						switch (a) {
						case AMBOS_EXCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %d y %d (ambos excluidos): ", minimo,
										maximo);
								numero = teclado.nextLong();
								valido = true;
							} while (numero <= minimo || numero >= maximo);
							break;
						case AMBOS_INCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %d y %d (ambos incluidos): ", minimo,
										maximo);
								numero = teclado.nextLong();
							} while (numero < minimo || numero > maximo);
							valido = true;
							break;
						case MINIMOINCLUIDO_MAXIMOEXCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %d y %d (minimo incluido pero maximo excluido): ",
										minimo, maximo);
								numero = teclado.nextLong();
							} while (numero < minimo || numero >= maximo);
							valido = true;
							break;
						case MINIMOEXCLUIDO_MAXIMOINCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %d y %d (minimo excluido pero maximo incluido): ",
										minimo, maximo);
								numero = teclado.nextLong();
								valido = true;
							} while (numero <= minimo || numero > maximo);
							break;
						}
					}
				} catch (InputMismatchException e) {
					System.out.printf("\nHas introducido un dato erróneo\n");
					valido = false;
				} finally {
					teclado.nextLine();
				}
			} while (!valido);

		return numero;
	}

	// 8.
	public static float valores(float minimo, float maximo, enummaximominimo a) {
		boolean valido = false;
		float numero = 0;

		if (minimo > maximo) {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				System.out.printf("El valor mínimo introducido es superior al valor máximo\n");
				valido = true;
			}
		}

		while (!valido)
			do {
				try {
					if (minimo == maximo) {
						do {
							System.out.printf("Introduce el valor %.2f: ", minimo);
							numero = teclado.nextFloat();
							if (numero == minimo) {
								valido = true;
							}
						} while (!valido);
					}
					while (!valido) {
						switch (a) {
						case AMBOS_EXCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %.2f y %.2f (ambos excluidos): ", minimo,
										maximo);
								numero = teclado.nextFloat();
								valido = true;
							} while (numero <= minimo || numero >= maximo);
							break;
						case AMBOS_INCLUIDOS:
							do {
								System.out.printf("Introduce un valor entre %.2f y %.2f (ambos incluidos): ", minimo,
										maximo);
								numero = teclado.nextFloat();
							} while (numero < minimo || numero > maximo);
							valido = true;
							break;
						case MINIMOINCLUIDO_MAXIMOEXCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %.2f y %.2f (minimo incluido pero maximo excluido): ",
										minimo, maximo);
								numero = teclado.nextFloat();
							} while (numero < minimo || numero >= maximo);
							valido = true;
							break;
						case MINIMOEXCLUIDO_MAXIMOINCLUIDO:
							do {
								System.out.printf(
										"Introduce un valor entre %.2f y %.2f (minimo excluido pero maximo incluido): ",
										minimo, maximo);
								numero = teclado.nextFloat();
								valido = true;
							} while (numero <= minimo || numero > maximo);
							break;
						}
					}
				} catch (InputMismatchException e) {
					System.out.printf("\nHas introducido un dato erróneo\n");
					valido = false;
				} finally {
					teclado.nextLine();
				}
			} while (!valido);

		return numero;
	}

}
