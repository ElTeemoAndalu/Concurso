package jaime;

/**
 *	Almacena el menu del juego
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Menu {

	/**
	 * modo: Almacena un número de 0 a 4, que indicará la dificultad de la partida
	 * opcion: Almacena un número entre 1 y 2(ambos incluidos) que indicará el usuario que juega
	 */
	private int modo;
	private int opcion;
	Dificultad dificultad;
	private String instrucciones = "Se juega en un tablero con fichas blancas,negras y rojas que se utilizaran para el resultado"
			+ " y de otros colores para la combinacion"
			+ " Uno de los jugadores escoge un número de fichas de colores,"
			+ " 4 en el juego original, y pone un código secreto oculto del otro jugador."
			+ " Este, tomando fichas de colores del mismo conjunto, aventura una posibilidad contestada con negras"
			+ " (fichas de color y posicion correcto), blancas (fichas de color correcto en posicion incorrecta) y rojas(ficha de color incorrecto)";
	/**
	 * Construye un nuevo objeto Menu del que se obtienen el modo y la opcion
	 */
	Menu(){
		
		do {
			System.out.println("  __  __           _            __  __ _           _ \r\n" + 
					" |  \\/  |         | |          |  \\/  (_)         | |\r\n" + 
					" | \\  / | __ _ ___| |_ ___ _ __| \\  / |_ _ __   __| |\r\n" + 
					" | |\\/| |/ _` / __| __/ _ | '__| |\\/| | | '_ \\ / _` |\r\n" + 
					" | |  | | (_| \\__ | ||  __| |  | |  | | | | | | (_| |\r\n" + 
					" |_|  |_|\\__,_|___/\\__\\___|_|  |_|  |_|_|_| |_|\\__,_|");
			
			System.out.println(" 1. INSTRUCCIONES\n 2. INDIVIDUAL\n 3. EXPERTO\n 4. AUTOMATICO");
			modo = Teclado.leerEntero();
			
		}while(modo>=5 || modo<1);
		
	}
	/**
	 * Devuelve el número del modo 
	 * @return 	El número especificado en modo numero
	 * @see int
	 * 
	 */
	public int getModo() {
		return modo;
	}
	/**
	 * Cambia el número del modo 
	 * @param modo La dificultad de la partida
	 * @see 	modo
	 */
	public void setModo(int modo) {
		this.modo = modo;
	}

	/**
	 * Devuelve el número de la opcion
	 * @return 	El número especificado en modo numero
	 *@see int
	 */

	public int getOpcion() {
		return opcion;
	}

	/**
	 * Cambia el número de la opcion 
	 * @param opcion El usuario que juega o comienza
	 * @see 	opcion
	 */

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}


	/**
	 * Devuelve las instrucciones del juego
	 * @return 	Las instrucciones especificadas en modo texto
	 * @see instrucciones
	 */
	public String getInstrucciones() {
		return instrucciones;
	}

	/**
	 * Cambia las instrucciones
	 * @param instrucciones Las instrucciones del juego
	 * @see 	instrucciones
	 */

	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}
	
	public Dificultad configurarDificultad(int modo) {
		if(modo==1) {
			String.format("%s", instrucciones);
		}else if(modo==2) {
			dificultad = Dificultad.INDIVIDUAL;
			System.out.println("¿Quieres jugar o que juegue la maquina?:\n 1- Jugar 2- Maquina");
			opcion = Teclado.leerEntero();
			

		}else if(modo == 3) {
			dificultad = Dificultad.EXPERTO;
			System.out.println("¿Quien empezará a jugar?:\n 1- Jugador 2- Maquina");
			opcion = Teclado.leerEntero();
		}else {
			dificultad = Dificultad.AUTOMATICO;
			System.out.println("Elige la velocidad del juego:\n 1- Lento 2- Rapido");
			opcion = Teclado.leerEntero();
		}
		return dificultad;
	}
	

}
