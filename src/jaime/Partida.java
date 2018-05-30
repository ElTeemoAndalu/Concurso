package jaime;

import java.util.ArrayList;

/**
 * Almacena la partida
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Partida {

	/**
	 * Almacena la dificultad e instancias de jugador, maquina y usuario
	 */
	
	Dificultad dificultad;
	Jugador jugador1;
	Maquina maquina1, maquina2;
	Usuario usuario;

	/**
	 * Construye un nuevo objeto Numero a partir del entero especificado
	 * @param dificultad  La dificultad a partir del cual se crea el objeto Partida
	 * @param usuario El usuario que va a jugar o el que va a comenzar jugando
	 */ 
	Partida(Dificultad dificultad, Usuario usuario){
	
		this.dificultad = dificultad;
		this.usuario = usuario;
	
		/*hacer estas condiciones en un metodo privarlo y llamarlo aqui dentro, 
		 * lo del main meterlo en otro metodo y tambien llamarlo y asi solo tener que crear una instancia de partida y se crea ya el juego en si
		 * o si no ir llamando al metodo que toca en el main*/
		if(dificultad == Dificultad.INDIVIDUAL && usuario == jugador1) {//hay un solo jugador
			jugador1 = new Jugador(dificultad);
		}else if(dificultad == Dificultad.INDIVIDUAL && usuario == maquina1) {// hay un solo jugador maquina
			maquina1 = new Maquina(dificultad);
		}else if(dificultad == Dificultad.EXPERTO && usuario == jugador1){//modo medio comienza jugador
			jugador1 = new Jugador(dificultad);
			maquina1 = new Maquina(dificultad);
		}else if(dificultad == Dificultad.EXPERTO && usuario == maquina1){//modo medio comienza maquina
			maquina1 = new Maquina(dificultad);
			jugador1 = new Jugador(dificultad);
		}else if(dificultad == Dificultad.AUTOMATICO && usuario == maquina1) {//modo dificil comienza maquina1
			maquina1 = new Maquina(dificultad);
			maquina2 = new Maquina(dificultad);
		}else if(dificultad == Dificultad.AUTOMATICO && usuario == maquina2) {//modo dificil comienza maquina2
			maquina2 = new Maquina(dificultad);
			maquina1 = new Maquina(dificultad);
		}
		
	}
	

	/**
	 * Devuelve la cadena formada por los datos de la partida
	 * @return 	Las condiciones de la partida en modo cadena
	 * @see 	String
	 */
	public String toString() {
		return String.format("Casillas: %d Colores: %s Intentos: %d Repeticion: %s",
				dificultad.getCasilla(), dificultad.getColores(), dificultad.getIntentos(), dificultad.isRepeticion()?"si":"no");
	}
	
	
	public void iniciarPartida() {
		

		Menu menu = new Menu();
		Partida partida; 
		Jugador jugador;
		Maquina maquina1;
		Maquina maquina2;
		Dificultad dificultad;
		int intento= 0;
		Tablero tableroJugador, tableroMaquina, tablero;
		Combinacion combinacion, combinacionResultado, combinacionIntento, combinacionRes;//las dos ultimas para la maquina o la maquina2
		Combinacion combinacionSecreta;
		Combinacion combinacionSecretaAux;
		ArrayList<Jugada> listaJugadas = new ArrayList<Jugada>();
		Jugada jugada;
		
		//consultar instrucciones
		if(menu.getModo() == 1) {
			menu.toString();
//		modo facil, juega el usuario
		}else if(menu.getModo() == 2 && menu.getOpcion()==1) {
			dificultad = Dificultad.INDIVIDUAL;
			Combinacion combinacionGanadora = new Combinacion(dificultad);
			//crea la combinacion ganadora, que es cuando sea todo negro
			for(int i=0;i<dificultad.getCasilla();i++) {
				combinacionGanadora.añadirFicha(0,i);
			}
			
			jugador = new Jugador(dificultad);
			maquina1 = new Maquina(dificultad);
			partida = new Partida(dificultad, jugador);
			
			combinacionSecreta = maquina1.crearCombinacionSecreta();
			tablero = new Tablero(combinacionSecreta);
			Combinacion ultimaCombinacion = tablero.listaResultados.get(tablero.listaResultados.size()-1);
			do {
				combinacion = jugador.rellenarCombinacion();
				combinacionResultado = maquina1.obtenerResultado(/*jugador.listaColoresCombinacion*/);
				jugada = new Jugada(combinacion, combinacionResultado);
				tablero.añadirJugada(combinacion, combinacionResultado);
				tablero.dibujar();
				
				
			}while(intento<=dificultad.getIntentos()  || combinacionGanadora.equals(ultimaCombinacion)==true);
			
			if(intento == dificultad.getIntentos()) {
				System.out.println("LOSER, te has quedado sin intentos");
			}
			if(combinacionGanadora.equals(ultimaCombinacion)==true) {
				System.out.println("CONGRATS!!!! YOU WIN!!!");
			}
			
//		modo facil, juega la maquina
		}else if(menu.getModo() == 2 && menu.getOpcion()==2) {
			dificultad = Dificultad.INDIVIDUAL;
			Combinacion combinacionGanadora = new Combinacion(dificultad);
			
			for(int i=0;i<dificultad.getCasilla();i++) {
				combinacionGanadora.añadirFicha(0,i);
			}
			
			jugador = new Jugador(dificultad);
			maquina1 = new Maquina(dificultad);
			partida = new Partida(dificultad, maquina1);
			
			combinacionSecreta = jugador.crearCombinacionSecreta();
			tablero = new Tablero(combinacionSecreta);
			Combinacion ultimaCombinacion = tablero.listaResultados.get(tablero.listaResultados.size()-1);
			do {
				combinacion = maquina1.crearCombinacionPrueba();
				combinacionResultado = jugador.obtenerResultado(ultimaCombinacion);
				tablero.añadirJugada(combinacion, combinacionResultado);
				tablero.dibujar();
			}while(intento<=dificultad.getIntentos()  || combinacionGanadora.equals(ultimaCombinacion)==true);
			
			if(intento == dificultad.getIntentos()) {
				System.out.println("LA MAQUINA HA PERDIDO...");
			}
			if(combinacionGanadora.equals(ultimaCombinacion)==true) {
				System.out.println("LA MAQUINA ES UNA MAQUINA, HA GANADO!!");
			}
//		modo medio empieza el jugador
		}else if(menu.getModo() == 3 && menu.getOpcion() == 1) {
			dificultad = Dificultad.EXPERTO;
			Combinacion combinacionGanadora = new Combinacion(dificultad);
			
			for(int i=0;i<dificultad.getCasilla();i++) {
				combinacionGanadora.añadirFicha(0,i);
			}
			
			jugador = new Jugador(dificultad);
			maquina1 = new Maquina(dificultad);
			partida = new Partida(dificultad, jugador);
			
			combinacionSecretaAux = jugador.crearCombinacionSecreta();
			combinacionSecreta = maquina1.crearCombinacionSecreta();
			tableroJugador = new Tablero(combinacionSecreta);
			tableroMaquina = new Tablero(combinacionSecretaAux);
			Combinacion ultimaCombinacionJugador = tableroJugador.listaResultados.get(tableroJugador.listaResultados.size()-1);
			Combinacion ultimaCombinacionMaquina = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()-1);
			do {
				//el jugador crea una combinacion y la maquina le devuelve el resultado, asi hast q acaben los intentos o una acierte
				combinacion = jugador.rellenarCombinacion();
				combinacionResultado= maquina1.obtenerResultado(/*jugador.listaColoresCombinacion*/);
				combinacionIntento = maquina1.crearCombinacionPrueba();
				combinacionRes = jugador.obtenerResultado(ultimaCombinacionJugador);
				tableroJugador.añadirJugada(combinacion, combinacionResultado);
				tableroMaquina.añadirJugada(combinacionIntento, combinacionRes);
				tableroJugador.dibujar();
				tableroMaquina.dibujar();
				
			}while(intento<=dificultad.getIntentos()  || combinacionGanadora.equals(ultimaCombinacionJugador)==true || combinacionGanadora.equals(ultimaCombinacionMaquina)==true );
			
			if(intento == dificultad.getIntentos()) {
				System.out.println("TENEMOS EMPATE!!!!!!!!!!");
			}
			if(combinacionGanadora.equals(ultimaCombinacionJugador)==true) {
				System.out.println("EL JUGADOR SE IMPONE, CONGRATULATIONS!!");
			}else if(combinacionGanadora.equals(ultimaCombinacionMaquina)==true) {
				System.out.println("OTRA DEMOSTRACION DE QUE LA IA SUPERA AL SER HUMANO");
			}

//		modo medio empieza la maquina
		}else if(menu.getModo() == 3 && menu.getOpcion() == 2) {
			dificultad = Dificultad.EXPERTO;
			Combinacion combinacionGanadora = new Combinacion(dificultad);
			
			for(int i=0;i<dificultad.getCasilla();i++) {
				combinacionGanadora.añadirFicha(0,i);
			}
			
			jugador = new Jugador(dificultad);
			maquina1 = new Maquina(dificultad);
			partida = new Partida(dificultad,maquina1);
			
			combinacionSecretaAux = jugador.crearCombinacionSecreta();
			combinacionSecreta = maquina1.crearCombinacionSecreta();
			tableroJugador = new Tablero(combinacionSecreta);
			tableroMaquina = new Tablero(combinacionSecretaAux);
			Combinacion ultimaCombinacionJugador = tableroJugador.listaResultados.get(tableroJugador.listaResultados.size()-1);
			Combinacion ultimaCombinacionMaquina = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()-1);
			do {
				//el jugador crea una combinacion y la maquina le devuelve el resultado, asi hast q acaben los intentos o una acierte
				combinacionIntento = maquina1.crearCombinacionPrueba();
				combinacionRes = jugador.obtenerResultado(ultimaCombinacionJugador);
				combinacion = jugador.rellenarCombinacion();
				combinacionResultado = maquina1.obtenerResultado(/*jugador.listaColoresCombinacion*/);
				tableroMaquina.añadirJugada(combinacionIntento, combinacionRes);
				tableroJugador.añadirJugada(combinacion, combinacionResultado);
				
				tableroMaquina.dibujar();
				tableroJugador.dibujar();
				
				
			}while(intento<=dificultad.getIntentos()  || combinacionGanadora.equals(ultimaCombinacionJugador)==true || combinacionGanadora.equals(ultimaCombinacionMaquina)==true );
			
			if(intento == dificultad.getIntentos()) {
				System.out.println("TENEMOS EMPATE!!!!!!!!!!");
			}
			if(combinacionGanadora.equals(ultimaCombinacionJugador)==true) {
				System.out.println("EL JUGADOR SE IMPONE, CONGRATULATIONS!!");
			}else if(combinacionGanadora.equals(ultimaCombinacionMaquina)==true) {
				System.out.println("OTRA DEMOSTRACION DE QUE LA IA SUPERA AL SER HUMANO");
			}
//		modo dificil empieza maquina1
		}else if(menu.getModo() == 4) {
			dificultad = Dificultad.AUTOMATICO;
			Combinacion combinacionGanadora = new Combinacion(dificultad);
			
			for(int i=0;i<dificultad.getCasilla();i++) {
				combinacionGanadora.añadirFicha(0,i);
			}
			
			maquina2 = new Maquina(dificultad);
			maquina1 = new Maquina(dificultad);
			partida = new Partida(dificultad, maquina1);
			
			combinacionSecretaAux = maquina2.crearCombinacionSecreta();
			combinacionSecreta = maquina1.crearCombinacionSecreta();
			tablero = new Tablero(combinacionSecreta);
			tableroMaquina = new Tablero(combinacionSecretaAux);
			Combinacion ultimaCombinacionMaquina2= tablero.listaResultados.get(tablero.listaResultados.size()-1);
			Combinacion ultimaCombinacionMaquina = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()-1);
			do {
				//el jugador crea una combinacion y la maquina le devuelve el resultado, asi hasta q acaben los intentos o una acierte
				combinacion = maquina1.crearCombinacionPrueba();
				combinacionResultado = maquina2.obtenerResultado(/*maquina1.listaColoresCombinacion*/);
				combinacionIntento = maquina2.crearCombinacionPrueba();
				combinacionRes = maquina1.obtenerResultado(/*maquina2.listaColoresCombinacion*/);
				tableroMaquina.añadirJugada(combinacion, combinacionResultado);
				tablero.añadirJugada(combinacionIntento, combinacionRes);
				tableroMaquina.dibujar();
				tablero.dibujar();
				
			}while(intento<=dificultad.getIntentos()  || combinacionGanadora.equals(ultimaCombinacionMaquina2)==true || combinacionGanadora.equals(ultimaCombinacionMaquina)==true );
			
			if(intento == dificultad.getIntentos()) {
				System.out.println("TENEMOS EMPATE!!!!!!!!!!");
			}
			if(combinacionGanadora.equals(ultimaCombinacionMaquina2)==true) {
				System.out.println("LA IA SECUNDARIA VENCE A LA PRINCIPAL");
			}else if(combinacionGanadora.equals(ultimaCombinacionMaquina)==true) {
				System.out.println("LA IA PRINCIPAL VENCE A LA SECUNDARIA");
			}

//		modo dificil empieza maquina2
		}else if(menu.getModo() == 4) {
			dificultad = Dificultad.AUTOMATICO;
			Combinacion combinacionGanadora = new Combinacion(dificultad);
			
			for(int i=0;i<dificultad.getCasilla();i++) {
				combinacionGanadora.añadirFicha(0,i);
			}
			
			maquina2 = new Maquina(dificultad);
			maquina1 = new Maquina(dificultad);
			partida = new Partida(dificultad, maquina1);
			
			combinacionSecretaAux = maquina2.crearCombinacionSecreta();
			combinacionSecreta = maquina1.crearCombinacionSecreta();
			tablero = new Tablero(combinacionSecreta);
			tableroMaquina = new Tablero(combinacionSecretaAux);
			Combinacion ultimaCombinacionMaquina2= tablero.listaResultados.get(tablero.listaResultados.size()-1);
			Combinacion ultimaCombinacionMaquina = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()-1);
			do {
				//el jugador crea una combinacion y la maquina le devuelve el resultado, asi hast q acaben los intentos o una acierte
				combinacionIntento = maquina2.crearCombinacionPrueba();
				combinacionRes = maquina1.obtenerResultado(/*maquina2.listaColoresCombinacion*/);
				combinacion = maquina1.crearCombinacionPrueba();
				combinacionResultado = maquina2.obtenerResultado(/*maquina1.listaColoresCombinacion*/);
				tablero.añadirJugada(combinacionIntento, combinacionRes);
				tableroMaquina.añadirJugada(combinacion, combinacionResultado);
				tablero.dibujar();
				tableroMaquina.dibujar();
				
			}while(intento<=dificultad.getIntentos()  || combinacionGanadora.equals(ultimaCombinacionMaquina2)==true || combinacionGanadora.equals(ultimaCombinacionMaquina)==true );
			
			if(intento == dificultad.getIntentos()) {
				System.out.println("TENEMOS EMPATE!!!!!!!!!!");
			}
			if(combinacionGanadora.equals(ultimaCombinacionMaquina2)==true) {
				System.out.println("LA IA SECUNDARIA VENCE A LA PRINCIPAL");
			}else if(combinacionGanadora.equals(ultimaCombinacionMaquina)==true) {
				System.out.println("LA IA PRINCIPAL VENCE A LA SECUNDARIA");
			}
		}
		
	}

	public static void main(String[] args) {
		Dificultad d = Dificultad.INDIVIDUAL;
		Jugador jugador = new Jugador(d);
		Partida p = new Partida(d, jugador);
		
		p.iniciarPartida();
		
	}
}
