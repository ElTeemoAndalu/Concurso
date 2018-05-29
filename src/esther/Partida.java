package esther;
/**
 * Clase donde se almacena las jugadas y el tablero del juego.
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 * 
 * @see      Jugada
 * @see		 Tablero
 * @see 	 Jugador
 *
 */
public class Partida {
	/**
	 * Almacena las jugadas del usuario.
	 */
	private Jugada jugadaUsuario;
	/**
	 * Almacena las jugadas de la máquina.
	 */
	private Jugada jugadaMaquina;
	/**
	 * Almacena las jugadas de la máquina rival.
	 */
	private Jugada jugadaRival;
	/**
	 * Se establece la dificultad de la partida.
	 */
	private ModoJuego dificultad;
	/**
	 * Si la dificultad es fácil se establece quién de los dos jugadores jugará.
	 */
	private ModoFacil modoFacil; 
	/**
	 * Jugador que participa en la partida.
	 */
	private Persona usuario;
	/**
	 * Jugador que participa en la partida.
	 */
	private Maquina maquina;
	/**
	 * Jugador que participa en la partida.
	 */
	private Maquina maquinaRival;
	/**
	 * Tablero para las jugadas del primer jugador.
	 */
	private Tablero tableroA;
	/**
	 * Tablero para las jugadas del segundo jugador.
	 */
	private Tablero tableroB;
	/**
	 * Crea un teclado para que el usuario interactue.
	 */
	private Teclado teclado = new Teclado();
	/**
	 * Construye un nuevo objeto Partida a partir de la dificultad y los jugadores.
	 * 
	 * @param dificultad	Dificultad en la que se creará el objeto Partida.
	 * @param modoFacil		Si la dificultad es fácil, Jugador en la que jugará la Partida.
	 * @param usuario		Jugador en la que se creará el objeto Partida.
	 * @param maquina		Jugador en la que se creará el objeto Partida.
	 * @param maquinaRival	Jugador en la que se creará el objeto Partida.
	 */
	public Partida (ModoJuego dificultad, ModoFacil modoFacil, Persona usuario, Maquina maquina, Maquina maquinaRival) {
		this.dificultad = dificultad;
		this.modoFacil = modoFacil;
		this.usuario = usuario;
		this.maquina = maquina;
		this.maquinaRival = maquinaRival;
	}
	// Pre-partida
	/**
	 * Dependiendo de la dificultad, el/los jugador/es añadirán las combinaciones ocultas antes de la partida.
	 * 
	 * @since	1.0
	 */
	protected void prePartida () {	
		int decision;
		boolean salir = false;
		
		switch (dificultad) {
		
		case FACIL:
			switch (modoFacil) {
			
			case USUARIO:
				maquina.addOculto();
				break;
				
			case MAQUINA:
				do {
					System.out.println("Añade tu combinación oculta" + informacionColores());
					usuario.addOculto();
					
					// Indica si va a volver a cambiar la combinación.
					usuario.pintarCombinacionOculta();
					System.out.println();
					System.out.print("¿Estás seguro de continuar?\n  1. Sí         2. No\n\n> Elige 1 o 2: ");
					decision = teclado.tecladoDosOpciones();
					
					if (decision == 2) {
						salir = false;
						System.out.println();
					} else
						salir = true;
					
				} while (salir == false);
				break;
			}
			break;
			
		case MEDIO: // El usuario y la máquina introducen la combinación de colores.
			maquina.addOculto();
			
			do {		
				System.out.println("Añade tu combinación oculta" + informacionColores());
				usuario.addOculto();
				
				// Indica si va a volver a cambiar la combinación.
				usuario.pintarCombinacionOculta();
				System.out.println();
				System.out.print("¿Estás seguro de continuar?\n  1. Sí         2. No\n\n> Elige 1 o 2: ");
				decision = teclado.tecladoDosOpciones();
				
				if (decision == 2) {
					salir = false;
					System.out.println();
				} else
					salir = true;
				
			} while (salir == false);
			break;
			
		case DIFICIL: // La máquina y la máquina rival escogen la combinación de colores.
			maquina.addOculto();
			maquinaRival.addOculto();
			break;
		}
	}
	// Partida
	/**
	 * La partida comenzará dependiendo de la dificultad.
	 * 
	 * @since	1.0
	 */
	protected void partida() {
		switch (dificultad) {
			case FACIL:
				facil();
				break;
			case MEDIO:
				medio();
				break;
			case DIFICIL:
				dificil();
				break;
		}
	}
	
	// Niveles de dificultad
	/**
	 * El/Los jugador/es jugarán a una partida en modo fácil.
	 * 
	 * @since	1.0
	 */
	private void facil() {
		int intentos=0;
		int maxIntentos = dificultad.getIntentos();
		int maxCasillas = dificultad.getCasilla();
		boolean salir;
		
		switch (modoFacil) {
		
		case USUARIO: // Adivina Usuario
			jugadaUsuario = new Jugada (usuario);
			jugadaMaquina = new Jugada (maquina);
			tableroA = new Tablero (jugadaUsuario);
			
			do {
				System.out.println("Añade tu combinación  " + informacionColores() + "\n");
				jugadaUsuario.turnoAdivinar();
				jugadaMaquina.turnoComprobarByN(maquina.getOculto(), usuario.getCombinacion());
				System.out.println(tableroA.pintarTablero(maquina));
				System.out.println("-----------------------------------------------");
				intentos ++;
				
				if (jugadaMaquina.esGanador(intentos, maxIntentos, maxCasillas) || intentos==maxIntentos) {
					salir = true;
				} else {
					salir = false;
				}
				
			} while (salir==false);
			
			if (jugadaMaquina.esGanador(intentos, maxIntentos, maxCasillas) && intentos<=maxIntentos) {
				System.out.println("¡ENHORABUENA! Has ganado");
			} else {
				System.out.println("HAS PERDIDO. Tu número de intentos se ha agotado.");
			}
			
			break;
				
		case MAQUINA: // Adivina Máquina
			jugadaMaquina = new Jugada (maquina);
			jugadaUsuario = new Jugada (usuario);

			tableroB = new Tablero (jugadaMaquina);
			
			do {
				System.out.println("\n        TU COMBINACION OCULTA                ");
				usuario.pintarCombinacionOculta();
				System.out.println("-----------------------------------------------");
				System.out.println("La máquina ha decidido su combinación  \n");
				jugadaMaquina.turnoAdivinar();
				jugadaMaquina.pintarCombinacion();
				
				System.out.println();
				
				jugadaUsuario.turnoComprobarByN(usuario.getOculto(), maquina.getCombinacion());
				System.out.println(tableroB.pintarTablero(usuario)); // Se introduce al jugador para que indique el nº de negras y blancas que tiene que pintar.
				System.out.println("-----------------------------------------------");
				intentos ++;
				
				if (jugadaUsuario.esGanador(intentos, maxIntentos, maxCasillas) || intentos==maxIntentos) {
					salir = true;
				} else {
					salir = false;
				}
				
			} while (salir==false);
			
			if (jugadaUsuario.esGanador(intentos, maxIntentos, maxCasillas) && intentos<=maxIntentos) {
				System.out.println(Color.VERDE.getColor() + "¡ENHORABUENA! Has ganado" + Color.RESET.getColor());
			} else {
				System.out.println(Color.ROJO.getColor() + "HAS PERDIDO. Tu número de intentos se ha agotado." + Color.RESET.getColor());
			}	
			break;
		}
	}	
	/**
	 * El/Los jugador/es jugarán a una partida en modo medio.
	 * 
	 * @since	1.0
	 */
	private void medio() {
		
		boolean ganaUsuario = false, ganaMaquina = false, salir = false;
		
		int intentosUsuario = 0, intentosMaquina = 0;
		
		int maxIntentos = dificultad.getIntentos();
		int maxCasillas = dificultad.getCasilla();
		
		jugadaMaquina = new Jugada (maquina);
		jugadaUsuario = new Jugada (usuario);
		
		tableroA = new Tablero (jugadaUsuario); // Tablero Usuario
		tableroB = new Tablero (jugadaMaquina); // Tablero Máquina
		
		do {
			
			// Turno de la máquina
			
			System.out.println(Color.AMARILLO.getColor() + "                         TURNO DE LA MAQUINA                         " + Color.RESET.getColor());
			
			System.out.println(); // Salto de línea
			
			// Pinta la combinación oculta del usuario para saber que combinación escogió.
			System.out.println("\n              TU COMBINACION OCULTA                ");
			usuario.pintarCombinacionOculta();
			System.out.println("---------------------------------------------------------------");
			
			// Pinta la combinación que ha escogido la máquina
			System.out.println("La máquina ha decidido su combinación  \n");
			jugadaMaquina.turnoAdivinar();
			jugadaMaquina.pintarCombinacion();
			
			System.out.println(); // Salto de línea
			
			jugadaUsuario.turnoComprobarByN(usuario.getOculto(), maquina.getCombinacion()); // El usuario comprueba la combinación de la máquina.
			
			System.out.println(tableroB.pintarTablero(usuario));
			
			System.out.println("---------------------------------------------------------------");
						
			intentosMaquina++;
			
//____________________________________________________________________________________________________________________________________________________________________________________________________
			
			// Turno del usuario
			System.out.println(Color.AMARILLO.getColor() + "                               TU TURNO                              \n" + Color.RESET.getColor());
			
			System.out.println("Añade tu combinación  " + informacionColores() + "\n");
			jugadaUsuario.turnoAdivinar();
			jugadaMaquina.turnoComprobarByN(maquina.getOculto(), usuario.getCombinacion());
			System.out.println(tableroA.pintarTablero(maquina));
			System.out.println("---------------------------------------------------------------");
	
			intentosUsuario ++;
		
			if (jugadaMaquina.esGanador(intentosUsuario, maxIntentos, maxCasillas) || intentosMaquina==maxIntentos) { // Si el usuario gana
				salir = true;
				ganaUsuario = true;
					
			} else if (jugadaUsuario.esGanador(intentosMaquina, maxIntentos, maxCasillas)) { // Si la máquina gana
				salir = true;
				ganaMaquina = true;
				
			} else {
				salir = false;
			}
			
		} while (salir==false);
		
		if (ganaUsuario == true) {
			System.out.println(Color.VERDE.getColor() + "¡ENHORABUENA! HAS GANADO. " + Color.RESET.getColor());
		} else if (ganaMaquina == true){
			System.out.println(Color.ROJO.getColor() + "HAS PERDIDO. La máquina ha ganado." + Color.RESET.getColor());
		} else if (ganaMaquina == false){
			System.out.println(Color.ROJO.getColor() + "HABEIS PERDIDO. Se ha agotado número de intentos." + Color.RESET.getColor());
		}
			
	}
	/**
	 * El/Los jugador/es (ambas máquinas) jugarán a una partida en modo difícil.
	 * 
	 * @since	1.0
	 */
	private void dificil() {
		boolean ganaIA = false, ganaMaquina = false, salir = false;
		
		int intentosIA = 0, intentosMaquina = 0;
		
		int maxIntentos = dificultad.getIntentos();
		int maxCasillas = dificultad.getCasilla();
		
		jugadaMaquina = new Jugada (maquina);
		jugadaRival = new Jugada (maquinaRival);
		
		tableroA = new Tablero (jugadaRival); // Tablero MaquinaRival
		tableroB = new Tablero (jugadaMaquina); // Tablero Máquina
		
		do {
			
			// Turno de la IA
			
			System.out.println(Color.AMARILLO.getColor() + "                            TURNO DE LA IA                            " + Color.RESET.getColor());
			
			System.out.println(); // Salto de línea
			
			// Pinta la combinación oculta del usuario para saber que combinación escogió.
			System.out.println("\n         COMBINACION OCULTA IA               ");
			maquinaRival.pintarOcultaMini();
			System.out.println("---------------------------------------------------------------");

			jugadaRival.turnoAdivinar();
			
			jugadaMaquina.turnoComprobarByN(maquina.getOculto(), maquinaRival.getCombinacion());
			
			System.out.println(tableroA.pintarTableroMini(maquina));
			System.out.println("---------------------------------------------------------------");
			maquina.pintarOcultaMini();
			System.out.println("         COMBINACION OCULTA MAQUINA               \n\n");			
			intentosIA++;
			
						
			// Turno de la Máquina
			
			System.out.println(Color.AMARILLO.getColor() + "                         TURNO DE LA MAQUINA                         " + Color.RESET.getColor());
			System.out.println(); // Salto de línea
			
			// Pinta la combinación oculta del usuario para saber que combinación escogió.
			System.out.println("\n         COMBINACION OCULTA MAQUINA               ");
			maquina.pintarOcultaMini();
			System.out.println("---------------------------------------------------------------");

			jugadaMaquina.turnoAdivinar();			
			jugadaRival.turnoComprobarByN(maquinaRival.getOculto(), maquina.getCombinacion()); // El usuario comprueba la combinación de la máquina.
			
			System.out.println(tableroB.pintarTableroMini(maquinaRival));
			System.out.println("---------------------------------------------------------------");
			maquinaRival.pintarOcultaMini();			
			System.out.println("         COMBINACION OCULTA IA               \n\n");
			intentosMaquina++;	
			
			if (jugadaMaquina.esGanador(intentosIA, maxIntentos, maxCasillas)) { // Si la IA gana
			salir = true;
			ganaIA = true;
				
			} else if (jugadaRival.esGanador(intentosMaquina, maxIntentos, maxCasillas)) { // Si la máquina gana
				salir = true;
				ganaMaquina = true;
//			} else if (intentosMaquina == 5){ 
//				salir = true;
			} else {
				salir = false;
			}
				
			} while (salir==false);
			
		if (ganaIA == true) {
			System.out.println("Ha ganado la máquina IA.");
		} else if (ganaMaquina == true){
			System.out.println("Ha ganado la máquina.");
		} else if (ganaMaquina == false){
			System.out.println("Ambos han perdido. Se ha agotado número de intentos.");
		}
	}
	/**
	 * Informa de los colores disponibles para el jugador.
	 * @return 	cadena Información de los colores disponibles.
	 * 
	 * @since	1.0
	 */
	private String informacionColores() {
		return String.format(Color.AZUL.getColor() + " 1 " + 
							 Color.LIMA.getColor() + " 2 " + 
							 Color.VERDE.getColor() + " 3 " + 
							 Color.AMARILLO.getColor() + " 4 " +  
							 Color.ROJO.getColor()+ " 5 " +  
							 Color.MORADO.getColor()+ " 6 " +  
							 Color.MARINO.getColor()+ " 7 " +  
							 Color.GRIS.getColor()+ " 8 " +  
							 Color.RESET.getColor());
	}
}
