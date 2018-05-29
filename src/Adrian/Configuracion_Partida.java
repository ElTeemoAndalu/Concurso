package mastermind;

import static mastermind.Teclado.*;
/**
 * Esta clase contiene el modo de la partida que se iniciará en sus metodos
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.9
 *
 */
public class Configuracion_Partida {
	Modos modo;

	public Configuracion_Partida() {
	}
	/**
	 * Da opción al admin a elegir el modo de juego que seguirá la partida
	 * 
	 * @return Modo de juego de la partida.
	 */
	public Modos elegirModo() {
		int numModo;
		Modos modo = null;
		System.out.println("Bienvenido a Mastermind");
		System.out.println("Elige un modo de juego:");
		System.out.println("1. Fácil");
		System.out.println("2. Medio");
		System.out.println("3. Difícil");
		numModo=leerNumEntre(Incluido.INCLUIDOS,1,3);
		switch(numModo) {
		case 1:
			modo=Modos.Facil;
			break;
		case 2:
			modo=Modos.Medio;
			break;
		case 3:
			modo=Modos.Dificil;
			break;
		}
		return modo;
	}
	/**
	 * Comprueba el modo de juego, llamando a la función anterior. E inicializa una partida con sus distintas características.
	 * .
	 */
	public void hacerPartida(){
		boolean jugar = false;
		do {
		Partida partida;
		Jugador jugador1 = null;
		Jugador jugador2 = null;
		TableroJugador tablero1=new TableroJugador();
		TableroJugador tablero2=new TableroJugador();
		this.modo=elegirModo();
		partida=new Partida(jugador1,jugador2,tablero1,tablero2,modo);
		partida.llamarPartida();
		jugar=Teclado.leerBoolean("\n¿Volver a jugar?", "Si","No" );
		}while(jugar);
		System.out.println("Hasta la próxima");
	}
	/**
	 * Se crea un objeto de la clase y se llama al método hacerPartida() para conmenzar el juego.
	 */
	public static void main(String[] args){
		Configuracion_Partida partida=new Configuracion_Partida();
		partida.hacerPartida();
	}
	
}
