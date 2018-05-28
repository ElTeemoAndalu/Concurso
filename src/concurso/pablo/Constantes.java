package concurso.pablo;

/**
 * Clase que almacena todas las constantes utilizadas por el programa.
 * @author pablo
 *
 */
public class Constantes {

	
    // COLORES A UTILIZAR EN EL PROPIO JUEGO

	public final static char CIRCULO='\u25CF';
	public final static String COLOR_AZUL = "\u001B[1;94m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_VERDE = "\u001B[1;92m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_LILA = "\u001B[38;5;90m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_ROJO = "\u001B[1;91m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_AMARILLO = "\u001B[1;93m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_CELESTE = "\u001B[1;96m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_ROSA = "\u001B[38;5;213m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_NARANJA = "\u001B[38;5;208m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_MARRON = "\u001B[38;5;94m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_GRIS = "\u001B[1;90m" + CIRCULO + "\u001B[0m";
    

    // COLORES DE CONTROL
    public final static String COLOR_NEGRO = "\u001B[38;5;232m" + CIRCULO + "\u001B[0m";
    public final static String COLOR_BLANCO = "\u001B[1;97m" + CIRCULO + "\u001B[0m";

    // SIN COLOR. ES UTILIZADO EN LOS DOS APARTADOS ANTERIORES.
    public final static String SIN_COLOR = String.valueOf('\u25CC');


    // FUNCION QUE EXPLICA LOS COLORES A UTILIZAR DEL JUEGO.
    public static void explicaColores() {
    	/**
    	 * Metodo que pinta y muestra en consola la utilizacion de todos los colores del juego.
    	 * 
    	 */
    	
    	System.out.printf("El juego consiste en adivinar la combinacion del contrario antes de que se acabe los turnos permitidos. %nExisten dos posibles roles, uno de introducir una combinacion de colores para adivinar la del contrario,%nel otro rol es de enviar la respuesta para que el jugador que ha enviado la combinacion sepa si ha acertado o no.%n%n");
        System.out.println("COLORES DEL JUEGO\n");
        System.out.printf("Color Azul:%20s%n", COLOR_AZUL);
        System.out.printf("Color Amarillo:%16s%n", COLOR_AMARILLO);
        System.out.printf("Color Celeste:%17s%n", COLOR_CELESTE);
        System.out.printf("Color Morado:%21s%n", COLOR_LILA);
        System.out.printf("Color Rojo:%20s%n", COLOR_ROJO);
        System.out.printf("Color Verde:%19s%n", COLOR_VERDE);
        System.out.printf("Color Gris:%20s%n", COLOR_GRIS);
        System.out.printf("Color Rosa:%24s%n", COLOR_ROSA);
        System.out.printf("Color Naranja:%21s%n", COLOR_NARANJA);
        System.out.printf("Color Marron:%21s%n", COLOR_MARRON);
        System.out.println("\nCOLORES DE CONTROL\n");
        System.out.printf("Color Negro:%23s     -->    Se utiliza para indicar que se ha acertado la posicion de un color en la combinacion oculta.%n", COLOR_NEGRO);
        System.out.printf("Color Blanco:%18s     -->    Se utiliza para indicar que se ha acertado un color de la combinacion oculta, pero no su posicion.%n", COLOR_BLANCO);
        System.out.println("\nSIN COLOR O POSICION VACIA.\n");
        System.out.printf("Sin Color:%10s     -->    Se utiliza como un color mas, o para indicar que un color no pertenece a la combinacion oculta.%n", SIN_COLOR);
    }





}
