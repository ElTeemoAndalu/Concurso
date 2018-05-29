package practica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {
	
	static Scanner teclado=new Scanner(System.in);

	public enum Comparador{
		MENOR, MAYOR, MENOR_IGUAL, MAYOR_IGUAL
	}
	
	public enum Intervalos{
		AMBOS_INC, AMBOS_EXC, MINIMO_INC, MAXIMO_INC
	}
	
	public static void cerrarTeclado(){
		teclado.close();
	}
	
	public static char leerChar(){
		char caracter;
		caracter=teclado.nextLine().charAt(0);
		return caracter;
	}
	
	public static String leerCadena(){
		String cadena;
		cadena=teclado.nextLine();
		return cadena;
	}
	
	public static boolean leerBoolean(String mensaje,String opcion1,String opcion2){

		boolean valor=false, error=false;
		byte numero=0;
		do {
			do {
				try {
					System.out.printf("%s\n", mensaje);
					System.out.printf("\t1.- %s\n", opcion1);
					System.out.printf("\t2.- %s\n", opcion2);
					System.out.println("Introduce una opción: ");
					numero=teclado.nextByte();
					error=false;
				} catch (InputMismatchException e) {
					System.out.println("Error, introduce un entero.");
					error=true;
					teclado.nextLine();
				}
			} while (error);
			if (numero==1) {
				valor=true;
			}else if (numero==2) {
				valor=false;
			}else{
				System.out.println("Error, debes introducir 1 o 2.");
			}
			teclado.nextLine();
		} while (numero!=1 && numero!=2);
		return valor;
	}
	
	public static boolean leerBoolean(String mensaje) {
		
		char si='s', no='n', respuestaC, siMayus='S', noMayus='N';
		String respuesta;
		boolean valor=false;

		do {
			System.out.printf("%s s/n\n",mensaje);
			System.out.println("Introduce una respuesta(s/n): ");
			respuesta=teclado.nextLine();
			respuestaC=respuesta.charAt(0);
			if (respuestaC==si || respuestaC==siMayus) {
				valor=true;
			} else if(respuestaC==no || respuestaC==noMayus){
				valor=false;
			}else{
				System.out.println("Error, no has introducido bien la respuesta.");
			}
		} while (respuestaC!=si && respuestaC!=no && respuestaC!=noMayus && respuestaC!=siMayus);
		return valor;
	}
	
	public static byte leerByte(){
		
		byte numero=0;
		boolean error=false;
		
		do {
			try {
				numero=teclado.nextByte();
				error=false;
			} catch (InputMismatchException e) {
				System.out.println("Error, eso no es un byte.");
				error=true;
			} finally {
				teclado.nextLine();
			}
		} while (error);
		return numero;
	}
	
	public static short leerShort(){
		
		short numero=0;
		boolean error=false;
		
		do {
			try {
				numero=teclado.nextShort();
				error=false;
			} catch (InputMismatchException e) {
				System.out.println("Error, eso no es un short.");
				error=true;
			} finally {
				teclado.nextLine();
			}
		} while (error);
		return numero;
	}
	
	public static int leerInt(){
		
		int numero=0;
		boolean error=false;
		
		do {
			try {
				numero=teclado.nextInt();
				error=false;
			} catch (InputMismatchException e) {
				System.out.println("Error, eso no es un entero.");
				error=true;
			} finally {
				teclado.nextLine();
			}
		} while (error);
		return numero;
	}
	
	public static long leerLong(){
		
		long numero=0;
		boolean error=false;
		
		do {
			try {
				numero=teclado.nextLong();
				error=false;
			} catch (InputMismatchException e) {
				System.out.println("Error, eso no es un long.");
				error=true;
			} finally {
				teclado.nextLine();
			}
		} while (error);
		return numero;
	}
	
	public static float leerFloat(){
		
		float numero=0;
		boolean error=false;
		
		do {
			try {
				numero=teclado.nextFloat();
				error=false;
			} catch (InputMismatchException e) {
				System.out.println("Error, eso no es un float.");
				error=true;
			} finally {
				teclado.nextLine();
			}
		} while (error);
		return numero;
	}
	
	public static double leerDouble(){
		
		double numero=0;
		boolean error=false;
		
		do {
			try {
				numero=teclado.nextDouble();
				error=false;
			} catch (InputMismatchException e) {
				System.out.println("Error, eso no es un decimal.");
				error=true;
			} finally {
				teclado.nextLine();
			}
		} while (error);
		return numero;
	}
	
	public static byte leerComparacion( byte parametro,Comparador comparador){
		
		byte numero=0;
		boolean error=false;
		
		do {
			numero = leerByte();
			switch (comparador) {
			case MENOR:
				if (parametro<numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor que el valor.");
					error=true;
				}
				break;
			case MAYOR:
				if (parametro>numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor que el valor.");
					error=true;
				}
				break;
			case MAYOR_IGUAL:
				if (parametro>=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor o igual que el valor.");
					error=true;
				}
				break;
			case MENOR_IGUAL:
				if (parametro<=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor o igual que el valor.");
					error=true;
				}
				break;
			}
		} while (error);
		return numero;
	}
	
	
	public static short leerComparacion( short valor,Comparador comparador){
		
		short numero=0;
		boolean error=false;
		
		do {
			numero = leerShort();
			switch (comparador) {
			case MENOR:
				if (valor<numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor que el valor.");
					error=true;
				}
				break;
			case MAYOR:
				if (valor>numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor que el valor.");
					error=true;
				}
				break;
			case MAYOR_IGUAL:
				if (valor>=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor o igual que el valor.");
					error=true;
				}
				break;
			case MENOR_IGUAL:
				if (valor<=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor o igual que el valor.");
					error=true;
				}
				break;
			}
		} while (error);
		return numero;
	}
	
	
	public static int leerComparacion( int valor,Comparador comparador){
		
		int numero=0;
		boolean error=false;
		
		do {
			numero = leerInt();
			switch (comparador) {
			case MENOR:
				if (valor<numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor que el valor.");
					error=true;
				}
				break;
			case MAYOR:
				if (valor>numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor que el valor.");
					error=true;
				}
				break;
			case MAYOR_IGUAL:
				if (valor>=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor o igual que el valor.");
					error=true;
				}
				break;
			case MENOR_IGUAL:
				if (valor<=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor o igual que el valor.");
					error=true;
				}
				break;
			}
		} while (error);
		return numero;
	}
	
	
	public static long leerComparacion( long valor,Comparador comparador){
		
		long numero=0;
		boolean error=false;
		
		do {
			numero = leerLong();
			switch (comparador) {
			case MENOR:
				if (valor<numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor que el valor.");
					error=true;
				}
				break;
			case MAYOR:
				if (valor>numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor que el valor.");
					error=true;
				}
				break;
			case MAYOR_IGUAL:
				if (valor>=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor o igual que el valor.");
					error=true;
				}
				break;
			case MENOR_IGUAL:
				if (valor<=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor o igual que el valor.");
					error=true;
				}
				break;
			}
		} while (error);
		return numero;
	}
	
	
	public static float leerComparacion( float valor,Comparador comparador){
		
		float numero=0;
		boolean error=false;
		
		do {
			numero = leerFloat();
			switch (comparador) {
			case MENOR:
				if (valor<numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor que el valor.");
					error=true;
				}
				break;
			case MAYOR:
				if (valor>numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor que el valor.");
					error=true;
				}
				break;
			case MAYOR_IGUAL:
				if (valor>=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor o igual que el valor.");
					error=true;
				}
				break;
			case MENOR_IGUAL:
				if (valor<=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor o igual que el valor.");
					error=true;
				}
				break;
			}
		} while (error);
		return numero;
	}
	
	
	public static double leerComparacion( double valor,Comparador comparador){
		
		double numero=0;
		boolean error=false;
		
		do {
			numero = leerDouble();
			switch (comparador) {
			case MENOR:
				if (valor<numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor que el valor.");
					error=true;
				}
				break;
			case MAYOR:
				if (valor>numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor que el valor.");
					error=true;
				}
				break;
			case MAYOR_IGUAL:
				if (valor>=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser mayor o igual que el valor.");
					error=true;
				}
				break;
			case MENOR_IGUAL:
				if (valor<=numero) {
					error=false;
				} else {
					System.out.println("Error, el parámetro debe ser menor o igual que el valor.");
					error=true;
				}
				break;
			}
		} while (error);
		return numero;
	}

	public static byte intervalos(byte minimo, byte maximo, Intervalos intervalos){
		
		byte numero=0;
		boolean error=false;
		
		if (minimo>maximo) {
			throw  new IllegalArgumentException("Error, el mínimo es mayor que el máximo.");
		}
		
		do {
			numero=leerByte();
			switch (intervalos) {
			case AMBOS_INC:
				if (numero>=minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case AMBOS_EXC:
				if (numero>minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MINIMO_INC:
				if (numero>=minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MAXIMO_INC:
				if (numero>minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			}
			
		} while (error);
		
		return numero;
	}
	
	public static short intervalos(short minimo, short maximo, Intervalos intervalos){
		
		short numero=0;
		boolean error=false;
		
		if (minimo>maximo) {
			throw  new IllegalArgumentException("Error, el mínimo es mayor que el máximo.");
		}
		
		do {
			numero=leerShort();
			switch (intervalos) {
			case AMBOS_INC:
				if (numero>=minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case AMBOS_EXC:
				if (numero>minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MINIMO_INC:
				if (numero>=minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MAXIMO_INC:
				if (numero>minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			}
			
		} while (error);
		
		return numero;
	}
	
	public static int intervalos(int minimo, int maximo, Intervalos intervalos){
		
		int numero=0;
		boolean error=false;
		
		if (minimo>maximo) {
			throw  new IllegalArgumentException("Error, el mínimo es mayor que el máximo.");
		}
		
		do {
			numero=leerInt();
			switch (intervalos) {
			case AMBOS_INC:
				if (numero>=minimo && numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case AMBOS_EXC:
				if (numero>minimo && numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MINIMO_INC:
				if (numero>=minimo && numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MAXIMO_INC:
				if (numero>minimo && numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			}
			
		} while (error);
		
		return numero;
	}
	
	public static long intervalos(long minimo, long maximo, Intervalos intervalos){
		
		long numero=0;
		boolean error=false;
		
		if (minimo>maximo) {
			throw  new IllegalArgumentException("Error, el mínimo es mayor que el máximo.");
		}
		
		do {
			numero=leerLong();
			switch (intervalos) {
			case AMBOS_INC:
				if (numero>=minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case AMBOS_EXC:
				if (numero>minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MINIMO_INC:
				if (numero>=minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MAXIMO_INC:
				if (numero>minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			}
			
		} while (error);
		
		return numero;
	}
	
	public static float intervalos(float minimo, float maximo, Intervalos intervalos){
		
		float numero=0;
		boolean error=false;
		
		if (minimo>maximo) {
			throw  new IllegalArgumentException("Error, el mínimo es mayor que el máximo.");
		}
		
		do {
			numero=leerFloat();
			switch (intervalos) {
			case AMBOS_INC:
				if (numero>=minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case AMBOS_EXC:
				if (numero>minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MINIMO_INC:
				if (numero>=minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MAXIMO_INC:
				if (numero>minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			}
			
		} while (error);
		
		return numero;
	}
	
	public static double intervalos(double minimo, double maximo, Intervalos intervalos){
		
		double numero=0;
		boolean error=false;
		
		if (minimo>maximo) {
			throw  new IllegalArgumentException("Error, el mínimo es mayor que el máximo.");
		}
		
		do {
			numero=leerDouble();
			switch (intervalos) {
			case AMBOS_INC:
				if (numero>=minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case AMBOS_EXC:
				if (numero>minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MINIMO_INC:
				if (numero>=minimo || numero<maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			case MAXIMO_INC:
				if (numero>minimo || numero<=maximo) {
					error=false;
				} else {
					System.out.printf("El número %d, no está en rango.\n", numero);
					error=true;
				}
				break;
			}
			
		} while (error);
		
		return numero;
	}
}
