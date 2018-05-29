package practica;

/** 
 * Esta clase almacena su tablero con la coreespondiente dificultad.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

import practica.Teclado.Intervalos;

public class Menu {
	
	/**
	 * Muestra el menú donde el usuario elegirá como quiere que sea la partida.
	 * @return la partida, según como haya elegido el usuario.
	 */
	
	Partida empezarPartida() {
		int numeroDif, numeroJug;
		Partida partida=null;
		System.out.println("BIENVENIDO A MASTERMIND\n\nAntes de empezar debe elegir una dificultad:\n\t1.-Fácil\n\t2.-Medio\n\t3.-Difícil");
		numeroDif=Teclado.intervalos(1, 3, Intervalos.AMBOS_INC);
		switch (numeroDif) {
		case 1:
			System.out.println("Escoja quien jugará la partida:\n\t1.-Usuario\n\t2.-Máquina");
			numeroJug=Teclado.intervalos(1, 2, Intervalos.AMBOS_INC);
			switch (numeroJug) {
			case 1:
				partida=new Partida(Dificultad.FACIL, new Usuario(Dificultad.FACIL), new Maquina(Dificultad.FACIL));
				break;
			case 2:
				partida=new Partida(Dificultad.FACIL, new Maquina(Dificultad.FACIL), new Usuario(Dificultad.FACIL));
				break;
			}
			break;
		case 2:
			partida=new Partida(Dificultad.MEDIO, new Maquina(Dificultad.MEDIO), new Usuario(Dificultad.MEDIO));
			break;
		case 3:
			partida=new Partida(Dificultad.DIFICIL, new Maquina(Dificultad.DIFICIL), new Maquina(Dificultad.DIFICIL));
			break;
		}
		return partida;
	}
	
	
	
}
