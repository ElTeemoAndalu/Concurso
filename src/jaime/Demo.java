package jaime;

public class Demo {

	public static void main(String[] args) {
//		Menu menu = new Menu();
//		dificultad = menu.configurarDificultad(menu.getModo());
//		Partida partida = new Partida(dificultad, jugador);
//		partida.iniciarPartida();
		/*Prueba de jugador: CORRECTA
		 * Dificultad dificultad  = Dificultad.INDIVIDUAL;
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(dificultad);
		
		Combinacion intento = new Combinacion(dificultad);
		Combinacion resultado = new Combinacion(dificultad);
		
		intento = jugador.rellenarCombinacion();
		resultado = jugador.obtenerResultado(intento);
		tablero.añadirJugada(intento, resultado);
		tablero.dibujar();*/
		

		/*PRUEBA rellenar de MAQUINA : funciona
		 * Dificultad dificultad  = Dificultad.AUTOMATICO;
		Combinacion intento = new Combinacion(dificultad);
		Maquina m  = new Maquina(dificultad);
		intento = m.IAConcurso();
		intento.dibujar();*/
	}
}
