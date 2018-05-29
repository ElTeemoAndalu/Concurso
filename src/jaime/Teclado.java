package mastermind;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Teclado {

	public static enum ES{
		MAYOR_IGUAL, MENOR_IGUAL, MAYOR, MENOR
	}
	
	public static enum Rango {
		AMBOS_INCLUIDOS, AMBOS_EXCLUIDOS, MIN_INCLUIDO, MAX_INCLUIDO
	}
	
	
	//DECLARACIONES-----------------------------------------------------------------------------------------------------------
	static Scanner teclado = new Scanner(System.in);
	public static final String ERROR_NUM_IMPUT="El nÃºmero introducido no es correcto. Vuelva a Introducirlo.";
	
	
	
	
	//CERRAR TECLADO-----------------------------------------------------------------------------------------------------------
	public static void cerrarTeclado(){
			teclado.close();
		}
		
	//LEER CARACTER------------------------------------------------------------------------------------------------------------
	public static char leerCaracter(){
		char caracter;
		caracter = teclado.next().charAt(0);
		return caracter;
	}
	//LEER CARACTER CON MENSAJE--------------------------------------------------------------------------------------------------
	public static char leerCaracter(String mensaje){
		char caracter;
		System.out.println(mensaje);
		caracter = teclado.next().charAt(0);
		return caracter;
	}
	
	//LEER CADENA------------------------------------------------------------------------------------------------------------
	public static String leerCadena(){
		String cadena;
		do{
			cadena = teclado.nextLine();
		}while(cadena.equals(""));
		return cadena;
	}
	//LEER CADENA CON MENSAJE--------------------------------------------------------------------------------------------------
	public static String leerCadena(String mensaje){
		String cadena;
		System.out.println(mensaje);
		do{
			cadena = teclado.nextLine();
		}while(cadena.equals(""));
		return cadena;
	}
	
	
	//LEER BOOLEANO------------------------------------------------------------------------------------------------------
	public static boolean leerBoolean(String pregunta, String opciontrue, String opcionfalse){
		byte res=0;
		boolean valido=false;
		//boolean resultado = true;
		do{
			System.out.printf("%s:\n\t1.- %s\n\t2.- %s\n",pregunta,opciontrue,opcionfalse);
			try{
				res=teclado.nextByte();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
			if(res!=1 && res!=2){
				System.out.printf("\nIntroduce una opcion valida \n");
			}
		}while(res!=1 && res!=2 && !valido);
		//resultado=(res==1)?true:false;
		return res == 1;
	}
	
	public static boolean leerBoolean(String pregunta){
		String respuesta;
		//boolean resultado = true;
		do{
			System.out.println(pregunta + ": s/n");
			respuesta = leerCadena().toUpperCase();
			if(!respuesta.equals("S") && !respuesta.equals("N")){
				System.out.println("No has introducido \"s\" ó \"n\" , introduce un valor valido.");
			}
		}while(!respuesta.equals("S") && !respuesta.equals("N"));
		//resultado=(respuesta=="S")?true:false;
		return respuesta.equals("S");
	}
	
	
	//LEER NUMEROS----------------------------------------------------------------------------------------------------------
	//LEER INT--------------------------------------------------
	public static int leerEntero(){
		int numero=0;
		boolean valido=false;
		
		do{
			try{
				numero=teclado.nextInt();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido\n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	//LEER CON MENSAJE INT--------------------------------------------------
	public static int leerEntero(String mensaje){
		int numero=0;
		boolean valido=false;
		
		do{
			System.out.println(mensaje);
			try{
				numero=teclado.nextInt();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	
	//LEER BYTE MENSAJE--------------------------------------------------
	public static byte leerByte(){
		byte numero=0;
		boolean valido=false;
		
		do{
			try{
				numero=teclado.nextByte();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	//LEER BYTE CON MENSAJE--------------------------------------------------
	public static byte leerByte(String mensaje){
		byte numero=0;
		boolean valido=false;
		
		do{
			System.out.println(mensaje);
			try{
				numero=teclado.nextByte();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	
	//LEER SHORT--------------------------------------------------
	public static short leerShort(){
		short numero=0;
		boolean valido=false;
		
		do{
			try{
				numero=teclado.nextShort();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	//LEER SHORT CON MENSAJE--------------------------------------------------
	public static short leerShort(String mensaje){
		short numero=0;
		boolean valido=false;
		
		do{
			System.out.println(mensaje);
			try{
				numero=teclado.nextShort();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	
	//LEER LONG--------------------------------------------------
	public static long leerLong(){
		long numero=0;
		boolean valido=false;
		
		do{
			try{
				numero=teclado.nextLong();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	//LEER LONG CON MENSAJE--------------------------------------------------
	public static long leerLong(String mensaje){
		long numero=0;
		boolean valido=false;
		
		do{
			System.out.println(mensaje);
			try{
				numero=teclado.nextLong();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	
	//LEER FLOAT CON MENSAJE--------------------------------------------------
	public static float leerFloat(String mensaje){
		float numero=0;
		boolean valido=false;
		
		do{
			System.out.println(mensaje);
			try{
				numero=teclado.nextFloat();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	//LEER FLOAT--------------------------------------------------
	public static float leerFloat(){
		float numero=0;
		boolean valido=false;
		
		do{
			try{
				numero=teclado.nextFloat();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido\n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	
	//LEER DOUBLE CON MENSAJE--------------------------------------------------
	public static double leerDouble(String mensaje){
		double numero=0;
		boolean valido=false;
		
		do{
			System.out.println(mensaje);
			try{
				numero=teclado.nextDouble();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	//LEER DOUBLE--------------------------------------------------
	public static double leerDouble(){
		double numero=0;
		boolean valido=false;
		
		do{
			try{
				numero=teclado.nextDouble();
				valido=true;
			}
			catch(InputMismatchException e){
				System.out.printf("ERROR introduce un valor valido \n");
				teclado.nextLine();
			}
		}while(!valido);
		
		return numero;
	}
	
	
	
	//LEER COMPARACIONES--------------------------------------------------------------------------------------------------------------
	//NUMERO MENOR/MAYOR BYTE------------------------------------------
	public static byte mayor_menor(byte numero, ES es){
		byte numero2 = 0;
		switch(es){
			case MENOR: 
				do{
					System.out.printf("Introduce un numero menor que %d: \n", numero);
					numero2=leerByte();
					if(numero2 >=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 >=numero);
				break;
				
			case MENOR_IGUAL:
				do{
					System.out.printf("Introduce un numero menor o igual que %d: \n", numero);
					numero2=leerByte();
					if(numero2 >numero){
						System.out.printf("El numero que has introducido no es menor o igual que %d\n",es,numero);
					}
				}while(numero2 >numero);
				break;
			case MAYOR:
				do{
					System.out.printf("Introduce un numero mayor que %d: \n", numero);
					numero2=leerByte();
					if(numero2 <=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <=numero);
				break;
			case MAYOR_IGUAL:
				do{
					System.out.printf("Introduce un numero mayor o igual que %d: \n", numero);
					numero2=leerByte();
					if(numero2 <numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <numero);
				break;
		}
		return numero2;
	}
	
	//NUMERO MENOR/MAYOR INT------------------------------------------
	public static int mayor_menor(int numero, ES es){
		int numero2 = 0;
		switch(es){
			case MENOR: 
				do{
					System.out.printf("Introduce un numero menor que %d: \n", numero);
					numero2=leerEntero();
					if(numero2 >=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 >=numero);
				break;
				
			case MENOR_IGUAL:
				do{
					System.out.printf("Introduce un numero menor o igual que %d: \n", numero);
					numero2=leerEntero();
					if(numero2 >numero){
						System.out.printf("El numero que has introducido no es menor o igual que %d\n",es,numero);
					}
				}while(numero2 >numero);
				break;
			case MAYOR:
				do{
					System.out.printf("Introduce un numero mayor que %d: \n", numero);
					numero2=leerEntero();
					if(numero2 <=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <=numero);
				break;
			case MAYOR_IGUAL:
				do{
					System.out.printf("Introduce un numero mayor o igual que %d: \n", numero);
					numero2=leerEntero();
					if(numero2 <numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <numero);
				break;
		}
		return numero2;
	}
	
	//NUMERO MENOR/MAYOR SHORT------------------------------------------
	public static short mayor_menor(short numero, ES es){
		short numero2 = 0;
		switch(es){
			case MENOR: 
				do{
					System.out.printf("Introduce un numero menor que %d: \n", numero);
					numero2=leerShort();
					if(numero2 >=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 >=numero);
				break;
				
			case MENOR_IGUAL:
				do{
					System.out.printf("Introduce un numero menor o igual que %d: \n", numero);
					numero2=leerShort();
					if(numero2 >numero){
						System.out.printf("El numero que has introducido no es menor o igual que %d\n",es,numero);
					}
				}while(numero2 >numero);
				break;
			case MAYOR:
				do{
					System.out.printf("Introduce un numero mayor que %d: \n", numero);
					numero2=leerShort();
					if(numero2 <=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <=numero);
				break;
			case MAYOR_IGUAL:
				do{
					System.out.printf("Introduce un numero mayor o igual que %d: \n", numero);
					numero2=leerShort();
					if(numero2 <numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <numero);
				break;
		}
		return numero2;
	}
	
	//NUMERO MENOR/MAYOR LONG------------------------------------------
	public static long mayor_menor(long numero, ES es){
		long numero2 = 0;
		switch(es){
			case MENOR: 
				do{
					System.out.printf("Introduce un numero menor que %d: \n", numero);
					numero2=leerLong();
					if(numero2 >=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 >=numero);
				break;
				
			case MENOR_IGUAL:
				do{
					System.out.printf("Introduce un numero menor o igual que %d: \n", numero);
					numero2=leerLong();
					if(numero2 >numero){
						System.out.printf("El numero que has introducido no es menor o igual que %d\n",es,numero);
					}
				}while(numero2 >numero);
				break;
			case MAYOR:
				do{
					System.out.printf("Introduce un numero mayor que %d: \n", numero);
					numero2=leerLong();
					if(numero2 <=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <=numero);
				break;
			case MAYOR_IGUAL:
				do{
					System.out.printf("Introduce un numero mayor o igual que %d: \n", numero);
					numero2=leerLong();
					if(numero2 <numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <numero);
				break;
		}
		return numero2;
	}
	
	//NUMERO MENOR/MAYOR FLOAT------------------------------------------
	public static float mayor_menor(float numero, ES es){
		float numero2 = 0;
		switch(es){
			case MENOR: 
				do{
					System.out.printf("Introduce un numero menor que %d: \n", numero);
					numero2=leerFloat();
					if(numero2 >=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 >=numero);
				break;
				
			case MENOR_IGUAL:
				do{
					System.out.printf("Introduce un numero menor o igual que %d: \n", numero);
					numero2=leerFloat();
					if(numero2 >numero){
						System.out.printf("El numero que has introducido no es menor o igual que %d\n",es,numero);
					}
				}while(numero2 >numero);
				break;
			case MAYOR:
				do{
					System.out.printf("Introduce un numero mayor que %d: \n", numero);
					numero2=leerFloat();
					if(numero2 <=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <=numero);
				break;
			case MAYOR_IGUAL:
				do{
					System.out.printf("Introduce un numero mayor o igual que %d: \n", numero);
					numero2=leerFloat();
					if(numero2 <numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <numero);
				break;
		}
		return numero2;
	}
	
	//NUMERO MENOR/MAYOR DOUBLE------------------------------------------
	public static double mayor_menor(double numero, ES es){
		double numero2 = 0;
		switch(es){
			case MENOR: 
				do{
					System.out.printf("Introduce un numero menor que %d: \n", numero);
					numero2=leerDouble();
					if(numero2 >=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 >=numero);
				break;
				
			case MENOR_IGUAL:
				do{
					System.out.printf("Introduce un numero menor o igual que %d: \n", numero);
					numero2=leerDouble();
					if(numero2 >numero){
						System.out.printf("El numero que has introducido no es menor o igual que %d\n",es,numero);
					}
				}while(numero2 >numero);
				break;
			case MAYOR:
				do{
					System.out.printf("Introduce un numero mayor que %d: \n", numero);
					numero2=leerDouble();
					if(numero2 <=numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <=numero);
				break;
			case MAYOR_IGUAL:
				do{
					System.out.printf("Introduce un numero mayor o igual que %d: \n", numero);
					numero2=leerDouble();
					if(numero2 <numero){
						System.out.printf("El numero que has introducido no es %s que %d\n",es,numero);
					}
				}while(numero2 <numero);
				break;
		}
		return numero2;
	}
	
	
	
	//RANGO-------------------------------------------------------------------------------------------------------------------
	//RANGO BYTE---------------------------------------------------------
	public static byte rango(byte numeroInferior, byte numeroSuperior, Rango entre){
		if(numeroInferior >= numeroSuperior){
			throw new IllegalArgumentException("ERROR, el numero inferior no puede ser mayor o igual al superior");
		}
		byte numero = 0;
		switch(entre){
			case AMBOS_INCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos incluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerByte();
				}while(numeroInferior > numero || numero > numeroSuperior);
				break;
			case AMBOS_EXCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos excluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerByte();
				}while(numeroInferior >= numero || numero >= numeroSuperior);
				break;
			case MIN_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el minimo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerByte();
				}while(numeroInferior > numero || numero >= numeroSuperior);
				break;
			case MAX_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el maximo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerByte();
				}while(numeroInferior >= numero || numero > numeroSuperior);
				break;
		}
		return numero;
	}
	
	//RANGO INT---------------------------------------------------------
	public static int rango(int numeroInferior, int numeroSuperior, Rango entre){
		if(numeroInferior >= numeroSuperior){
			throw new IllegalArgumentException("ERROR, el numero inferior no puede ser mayor o igual al superior");
		}
		int numero = 0;
		switch(entre){
			case AMBOS_INCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos incluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerEntero();
				}while(numeroInferior > numero || numero > numeroSuperior);
				break;
			case AMBOS_EXCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos excluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerEntero();
				}while(numeroInferior >= numero || numero >= numeroSuperior);
				break;
			case MIN_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el minimo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerEntero();
				}while(numeroInferior > numero || numero >= numeroSuperior);
				break;
			case MAX_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el maximo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerEntero();
				}while(numeroInferior >= numero || numero > numeroSuperior);
				break;
		}
		return numero;
	}
	
	//RANGO SHORT---------------------------------------------------------
	public static short rango(short numeroInferior, short numeroSuperior, Rango entre){
		if(numeroInferior >= numeroSuperior){
			throw new IllegalArgumentException("ERROR, el numero inferior no puede ser mayor o igual al superior");
		}
		short numero = 0;
		switch(entre){
			case AMBOS_INCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos incluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerShort();
				}while(numeroInferior > numero || numero > numeroSuperior);
				break;
			case AMBOS_EXCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos excluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerShort();
				}while(numeroInferior >= numero || numero >= numeroSuperior);
				break;
			case MIN_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el minimo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerShort();
				}while(numeroInferior > numero || numero >= numeroSuperior);
				break;
			case MAX_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el maximo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerShort();
				}while(numeroInferior >= numero || numero > numeroSuperior);
				break;
		}
		return numero;
	}
	
	//RANGO LONG---------------------------------------------------------
	public static long rango(long numeroInferior, long numeroSuperior, Rango entre){
		if(numeroInferior >= numeroSuperior){
			throw new IllegalArgumentException("ERROR, el numero inferior no puede ser mayor o igual al superior");
		}
		long numero = 0;
		switch(entre){
			case AMBOS_INCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos incluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerLong();
				}while(numeroInferior > numero || numero > numeroSuperior);
				break;
			case AMBOS_EXCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos excluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerLong();
				}while(numeroInferior >= numero || numero >= numeroSuperior);
				break;
			case MIN_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el minimo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerLong();
				}while(numeroInferior > numero || numero >= numeroSuperior);
				break;
			case MAX_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el maximo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerLong();
				}while(numeroInferior >= numero || numero > numeroSuperior);
				break;
		}
		return numero;
	}
	
	//RANGO FLOAT---------------------------------------------------------
	public static float rango(float numeroInferior, float numeroSuperior, Rango entre){
		if(numeroInferior >= numeroSuperior){
			throw new IllegalArgumentException("ERROR, el numero inferior no puede ser mayor o igual al superior");
		}
		float numero = 0;
		switch(entre){
			case AMBOS_INCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos incluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerFloat();
				}while(numeroInferior > numero || numero > numeroSuperior);
				break;
			case AMBOS_EXCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos excluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerFloat();
				}while(numeroInferior >= numero || numero >= numeroSuperior);
				break;
			case MIN_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el minimo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerFloat();
				}while(numeroInferior > numero || numero >= numeroSuperior);
				break;
			case MAX_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el maximo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerFloat();
				}while(numeroInferior >= numero || numero > numeroSuperior);
				break;
		}
		return numero;
	}
	
	//RANGO DOUBLE---------------------------------------------------------
	public static double rango(double numeroInferior, double numeroSuperior, Rango entre){
		if(numeroInferior >= numeroSuperior){
			throw new IllegalArgumentException("ERROR, el numero inferior no puede ser mayor o igual al superior");
		}
		double numero = 0;
		switch(entre){
			case AMBOS_INCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos incluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerDouble();
				}while(numeroInferior > numero || numero > numeroSuperior);
				break;
			case AMBOS_EXCLUIDOS:
				do{
					System.out.printf("Introduce un numero entre %d y %d ambos excluidos:\n ", numeroInferior, numeroSuperior);
					numero = leerDouble();
				}while(numeroInferior >= numero || numero >= numeroSuperior);
				break;
			case MIN_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el minimo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerDouble();
				}while(numeroInferior > numero || numero >= numeroSuperior);
				break;
			case MAX_INCLUIDO:
				do{
					System.out.printf("Introduce un numero entre %d y %d con el maximo incluido:\n ", numeroInferior, numeroSuperior);
					numero = leerDouble();
				}while(numeroInferior >= numero || numero > numeroSuperior);
				break;
		}
		return numero;
	}
	
	
	
	

}
