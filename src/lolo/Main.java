package lolo;

public class Main {

	public static void main(String[] args) {
		boolean reiniciar;
		
		do {
			Menu menu = new Menu();
			menu.configurarPartida().comenzarPartida();
			reiniciar = Teclado.leerBoolean("¿Desea jugar de nuevo?", "Sí", "No");
		} while (reiniciar);
	}
	
}
