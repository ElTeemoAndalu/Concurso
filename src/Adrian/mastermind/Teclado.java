package mastermind;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Esta clase contiene las funciones de teclado necesarias para ejecutar la aplicación.
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.0
 *
 */
public class Teclado {
	//En cada Leer... existe un try catch por si no se introduce el numero del tipo que se indica, asi no hay que introducir erros manualmente en cada programa
	
	// Declarar Teclado
	/**
	 * Declaración del Scanner teclado en la clase.
	 */
	public static Scanner teclado = new Scanner(System.in);

	// Limpiar bufer
	/**
	 * Método para limpiar el buffer.
	 */
	public static void nextLine() {
		teclado.nextLine();
	}

	
	//Leer boolean
	/**
	 * Funcion para leer un boolean entre dos números a elegir, donde 1 es true y 2 es false.
	 * 
	 * @param mensaje  El mensaje o pregunta a mostrar al usuario.
	 * @param opcion1  El número 1 o true	
	 * @param opcion2  El número 2 o false
	 * @return  Un boolean según lo elegido.	  
	 */
	public static boolean leerBoolean(String mensaje, String opcion1, String opcion2) {
		int eleccion;

		boolean valor = false;
		System.out.printf("%s\n", mensaje);
		System.out.printf("1.- %s\n", opcion1);
		System.out.printf("2.- %s\n", opcion2);
		do {
			eleccion = Teclado.leerInt();

			if (eleccion == 1) {
				valor = true;

			} else if (eleccion == 2) {
				valor = false;

			}else if(eleccion!=1||eleccion!=2) {
				System.out.println("Introduce 1 o 2");
			}
		} while (eleccion != 1 && eleccion != 2);

		return valor;
	}

	//Leer int
	/**
	 * Función para leer un número por teclado y controlar que se introduzca correctamente
	 * @return valor de tipo Integer.  
	 */
	public static int leerInt() {
		boolean error = false;
		int a = 0;
		do {
			try {

				a = teclado.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error: Deben ser numeros de tipo entero");
				error = true;
				
			}
			finally {
				Teclado.nextLine();
			}

		} while (error);

		return a;
	}
	
	//Enum para indicar el rango de los numeros
	
	public static enum Incluido {
		INCLUIDOS, EXCLUIDOS, MENORINCLUIDO, MAYORINCLUIDO
	}
	/**
	 * Funcion para controlar que el usuario introduzca un Integer entre unos valores permitidos.
	 * @param incluido  Parametro de tipo Enum, el cual controla los limites ya sean incluidos o excluidos.
	 * @param minimo   Valor mínimo a introducir.
	 * @param maximo  Valor máximo a introducir.
	 * @return   Devuelve un Integer.
	 */
	public static int leerNumEntre(Incluido incluido, int minimo, int maximo) throws IllegalArgumentException {

		int num = 0;
		if (minimo > maximo) {
			throw new IllegalArgumentException();
		}
		switch (incluido) {
		case INCLUIDOS:
			do {
				num = leerInt();
			} while (!(num >= minimo && num <= maximo));
			break;
		case EXCLUIDOS:
			do {
				num = leerInt();
			} while (!(num > minimo && num < maximo));
			break;
		case MENORINCLUIDO:
			do {
				num = leerInt();
			} while (!(num >= minimo && num < maximo));
			break;
		case MAYORINCLUIDO:
			do {
				num = leerInt();
			} while (!(num > minimo && num <= maximo));
		}
		return num;

	}

}
