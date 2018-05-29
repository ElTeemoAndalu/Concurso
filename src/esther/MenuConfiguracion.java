package esther;
/**
 * Menú que configura la dificultad en la que se quiere jugar.
 * 
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 * 
 * @see      Partida
 * @see      Teclado
 *
 */
public class MenuConfiguracion implements MenuConfiguracionDibujable {
	/**
	 * Indica si sale del juego.
	 */
	private boolean salir;
	/**
	 * Almacena la dificultad indicada.
	 */
	private ModoJuego dificultad;
	/**
	 * Almacena la opción escogida dentro del modo fácil.
	 */
	private ModoFacil modoFacil;
	/**
	 * Jugador que jugará en la partida.
	 */
	private Persona usuario;
	/**
	 * Jugador que jugará en la partida.
	 */
	private Maquina maquina;
	/**
	 * Jugador que jugará en la partida.
	 */
	private Maquina maquinaRival;
	/**
	 * Establece los jugadores y la dificultad en la que se jugará.
	 */
	private Partida partida;
	/**
	 * Utiliza las funciones del teclado para configurar el menú.
	 */
	private Teclado teclado = new Teclado();
	/**
	 * Menu inicial del Juego, donde se configura la dificultad en la que se jugará la partida.
	 * 
	 * @since  1.0
	 */
	public void menuInicial() {
		
		/* 1. Se le muestra al usuario las primeras opciones del menú.
		 * 2. El usuario escogerá una de las opciones.
		 * 3. Si el usuario escoge la opción:
		 * 		3.1. JUGAR: Se le mostrará que modo de juego quiere escoger.
		 * 			3.1.1 Si el usuario escoge el modo: 
		 * 				3.1.1.1. FACIL: Un jugador. Tendrá que escoger quién juega antes de empezar la partida.
		 * 				3.1.1.2. MEDIO: Dos jugadores. Usuario Vs Máquina.
		 * 				3.1.1.3. DIFICIL: Dos jugadores. Máquina Vs. Máquina Rival.
		 * 		3.2. INSTRUCCIONES: Se le mostrará las instrucciones del juego.
		 * 		3.3. SALIR: El usuario saldrá del menú del juego. */
		
		Opciones menu;

		String informacionModo;
		boolean fin = false;
		
		System.out.println( "\r\n" + 
				"___  ___  ___   _____ _____ ______________  ________ _   _______ \r\n" + 
				"|  \\/  | / _ \\ /  ___|_   _|  ___| ___ \\  \\/  |_   _| \\ | |  _  \\\r\n" + 
				"| .  . |/ /_\\ \\\\ `--.  | | | |__ | |_/ / .  . | | | |  \\| | | | |\r\n" + 
				"| |\\/| ||  _  | `--. \\ | | |  __||    /| |\\/| | | | | . ` | | | |\r\n" + 
				"| |  | || | | |/\\__/ / | | | |___| |\\ \\| |  | |_| |_| |\\  | |/ / \r\n" + 
				"\\_|  |_/\\_| |_/\\____/  \\_/ \\____/\\_| \\_\\_|  |_/\\___/\\_| \\_/___/  \r\n" + 
				" _________________________________________________________________\r\n" + 
				"                                                                 \r\n" + 
				"");
		
//		1. Se le muestra al usuario las primeras opciones del menú.
		
		System.out.printf(   "  1. Jugar\n" + 
						     "  2. Cómo se juega\n" + 
						     "  3. Salir\n\n");
		
//		2. El usuario escogerá una de las opciones.
		do {
			System.out.printf("> Seleccione el número de una de las opciones: ");
			
//			3. Si el usuario escoge la opción:
			menu = teclado.tecladoMenu();
			switch(menu) {
		
//			3.1. JUGAR: Se le mostrará que modo de juego quiere escoger.
			case JUGAR:
				System.out.print("\n\nSELECCIONE EL MODO DE JUEGO\n\n1. Fácil (Jugador // Máquina)\n2. Medio (Jugador Vs. Máquina)\n3. Difícil (Máquina Vs. Máquina Rival)\n\n> Seleccione el número de una de las opciones: ");
				
//					3.1.1 Si el usuario escoge el modo: 
				dificultad = teclado.tecladoModoJuego();
				informacionModo = dificultad.toString();
				
				switch (dificultad) {
//					3.1.1.1. FACIL: Un jugador. Tendrá que escoger quién juega antes de empezar la partida.
					case FACIL:
						usuario = new Persona(dificultad);
						maquina = new Maquina(dificultad);
						System.out.println("\r\n" + 
								"          ___  ______________ _____  ______ ___  _____ _____ _     \r\n" + 
								"          |  \\/  |  _  |  _  \\  _  | |  ___/ _ \\/  __ \\_   _| |    \r\n" + 
								"          | .  . | | | | | | | | | | | |_ / /_\\ \\ /  \\/ | | | |    \r\n" + 
								"          | |\\/| | | | | | | | | | | |  _||  _  | |     | | | |    \r\n" + 
								"          | |  | \\ \\_/ / |/ /\\ \\_/ / | |  | | | | \\__/\\_| |_| |____\r\n" + 
								"          \\_|  |_/\\___/|___/  \\___/  \\_|  \\_| |_/\\____/\\___/\\_____/\r\n" + 
								"           ______ ______ ______ ______ ______ ______ ______ ______ \r\n" + 
								"          |______|______|______|______|______|______|______|______|\r\n\n");
						
						System.out.println(informacionModo); // Muestra la información del modo de juego
						
						System.out.println("\n\nSELECCIONA QUIEN JUGARA\n\n1. Usuario\n2. Maquina\n");
						System.out.printf("> Seleccione el número de una de las opciones: ");
						
						modoFacil = teclado.tecladoModoFacil(); // El usuario decidira si juega el USUARIO o la MAQUINA
						
						fin = true;
						
						break;
					
//						3.1.1.2. MEDIO: Dos jugadores. Usuario Vs Máquina.
					case MEDIO:
						usuario = new Persona(dificultad);
						maquina = new Maquina(dificultad);
						System.out.println("\r\n" + 
								"          ___  ______________ _____  ___  ______________ _____ _____ \r\n" + 
								"          |  \\/  |  _  |  _  \\  _  | |  \\/  |  ___|  _  \\_   _|  _  |\r\n" + 
								"          | .  . | | | | | | | | | | | .  . | |__ | | | | | | | | | |\r\n" + 
								"          | |\\/| | | | | | | | | | | | |\\/| |  __|| | | | | | | | | |\r\n" + 
								"          | |  | \\ \\_/ / |/ /\\ \\_/ / | |  | | |___| |/ / _| |_\\ \\_/ /\r\n" + 
								"          \\_|  |_/\\___/|___/  \\___/  \\_|  |_|____/|___/  \\___/ \\___/ \r\n" + 
								"           ______ ______ ______ ______ ______ ______ ______ ______   \r\n" + 
								"          |______|______|______|______|______|______|______|______|  \r\n\n");
						
									
						System.out.println(informacionModo); // Muestra la información del modo de juego
						fin = true;
						
						break;
					
//						3.1.1.3. DIFICIL: Dos jugadores. Máquina Vs. Máquina Rival.
					case DIFICIL:
						maquina = new Maquina(dificultad);
						maquinaRival = new Maquina(dificultad);
						System.out.println("\r\n" + 
								"          ___  ______________ _____  ______ ___________ _____ _____ _____ _      \r\n" + 
								"          |  \\/  |  _  |  _  \\  _  | |  _  \\_   _|  ___|_   _/  __ \\_   _| |     \r\n" + 
								"          | .  . | | | | | | | | | | | | | | | | | |_    | | | /  \\/ | | | |     \r\n" + 
								"          | |\\/| | | | | | | | | | | | | | | | | |  _|   | | | |     | | | |     \r\n" + 
								"          | |  | \\ \\_/ / |/ /\\ \\_/ / | |/ / _| |_| |    _| |_| \\__/\\_| |_| |____ \r\n" + 
								"          \\_|  |_/\\___/|___/  \\___/  |___/  \\___/\\_|    \\___/ \\____/\\___/\\_____/ \r\n" + 
								"           ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ \r\n" + 
								"          |______|______|______|______|______|______|______|______|______|______|\r\n\n");
						
						System.out.println(informacionModo); // Muestra la información del modo de juego			
						fin = true;
						
						break;
					
					default:
						System.out.println("\nNo has seleccionado una opción correcta. Prueba otra vez.\n");
				}
				break;
//			3.2. INSTRUCCIONES: Se le mostrará las instrucciones del juego.
			case INSTRUCCIONES:
				System.out.println(instrucciones());
				break;
				
//			3.3. SALIR: El usuario saldrá del menú del juego.
			case SALIR:
				fin = true;
				salir = true;
				teclado.cerrar_teclado();
				break;

			default:
				System.out.println("\nNo has seleccionado una opción correcta. Prueba otra vez.");
				break;
			}
			
		} while(fin==false);
	}
	/**
	 * Inicia la partida una vez configurada la dificultad.
	 * 
	 * @since  1.0
	 */
	public void iniciarPartida() {
		partida = new Partida(dificultad, modoFacil, usuario, maquina, maquinaRival);
		partida.prePartida();
		partida.partida();
	}
	/**
	 * Muestra las instrucciones del juego.
	 * @return cadena  Instrucciones del juego.
	 * 
	 * @since  1.0
	 */
	private String instrucciones() {
		return String.format("\nCÓMO SE JUEGA\n\nEn Mastermind compiten 2 jugadores, uno de ellos creará un código\n" + 
				"oculto con un número de colores (dependiendo del Modo del Juego),"                   + 
				"pudiendo hacer las combinaciones con los 8 colores disponibles\n"				      + 
				"e incluso repitiendo color si lo desea.\r\n" 										  + 
				
				"\nLa combinación oculta se podrá repetir los colores si el Modo de Juego lo indica.\n" +
				
				"\nEl código de colores debe de ocultarse con el escudo para que no\r\n" + 
				"pueda verlo el oponente, que deberá acertar en el menor número posible de\r\n" + 
				"jugadas la clave para obtener una buena puntuación. Para descifrar el código\r\n" + 
				"secreto de colores el jugador deberá ir probando combinaciones aleatorias de \r\n" + 
				"colores, y en cada combinación, el jugador contrario debe darle pistas mediante\r\n" + 
				"los pines blancos y negros.\r\n\n" + 
				"Por cada pin acertado en color y posición, colocará un pin negra,\r\n" + 
				"y por cada color acertado pero en un lugar equivocado colocara un pin blanca.\r\n");
	}
	/**
	 * Indica si en la configuración indica que el usuario quiere salir del juego.
	 * @return   true:  Termmina el juego.
	 * 			 false: No termina el juego.
	 * 
	 * @since    1.0
	 */
	public boolean isSalir() {
		return salir;
	}
}
