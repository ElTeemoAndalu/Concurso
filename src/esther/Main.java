package esther;
/**
 * Esta clase inicia el juego, es decir que para ejecutar el juego en consola deberá de ser desde esta clase.
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 * 
 * @see      MenuConfiguracion
 */
public class Main {
	/**
	 * Método Main donde de inicia el juego.
	 * @param args	Argumentos del main.
	 */
	public static void main(String[] args) {
		MenuConfiguracion menu = new MenuConfiguracion();
		do { 
			menu.menuInicial();
			if(menu.isSalir()) {
				System.out.println("Gracias por jugar a Mastermind.");
			} else {
				menu.iniciarPartida();
			}
		} while (!menu.isSalir());	
	}
}