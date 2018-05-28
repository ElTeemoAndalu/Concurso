package esther;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Esta clase usa las funciones de teclado.
 * 
 * @author   Esther Castañeda
 * @version  1.0
 * @since    1.0
 *
 * @see 	 MenuConfiguracion
 * @see 	 Persona
 */
public class Teclado {
	/**
	 * Abre el teclado.
	 */
	private Scanner teclado = new Scanner (System.in);
	/**
	 * Teclado controlado que solo puede introducir '1' o '2'.
	 * @return		opcion	Número escogido por el usuario.
	 * @since		1.0
	 */
	public int tecladoDosOpciones() {
		int opcion;
		do {
			opcion = teclado_int();
			if (opcion>2 || opcion<1)
				System.out.printf("Te has salido del rango establecido. Prueba otra vez. (Solo números del 1 al 2) \n> ");
		} while(opcion>2 || opcion<1);
		
		return opcion;
	}
	/**
	 * Teclado controlado que solo puede introducir un número del 1 al 3.
	 * @return		opcion	Número escogido por el usuario.
	 * @since		1.0
	 * 
	 * @see 		#seleccionMenu(int)
	 */
	public Opciones tecladoMenu() {
		Opciones menu = null;
		int opcion;
		do {
			opcion = teclado_int();
			menu = seleccionMenu(opcion);
			if (opcion>3 || opcion<1)
				System.out.print("Te has salido del rango establecido. Prueba otra vez. (Solo números del 1 al 3) \n> ");
		} while(opcion>3 || opcion<1);
	
		return menu;
	}
	/**
	 * Teclado controlado que solo puede introducir un número del 1 al 3.
	 * @return		opcion	Número escogido por el usuario.
	 * @since		1.0
	 * 
	 * @see 		#seleccionModo(int)
	 */
	public ModoJuego tecladoModoJuego() {
		ModoJuego modo = null;
		int opcion;
		do {
			opcion = teclado_int();
			modo = seleccionModo(opcion);
			if (opcion>3 || opcion<1)
				System.out.print("Te has salido del rango establecido. Prueba otra vez. (Solo números del 1 al 3) \n> ");
		} while(opcion>3 || opcion<1);
	
		return modo;
	}
	/**
	 * Teclado controlado que solo puede introducir '1' o '2'.
	 * @return		opcion	Número escogido por el usuario.
	 * @since		1.0
	 * 
	 * @see			#seleccionModoFacil(int)
	 */
	public ModoFacil tecladoModoFacil() {
		ModoFacil modo;
		int opcion;
		do {
			opcion = teclado_int();
			modo = seleccionModoFacil(opcion);			
			if (opcion>2 || opcion<1)
				System.out.print("Te has salido del rango establecido. Prueba otra vez. (Solo números del 1 al 2) \n> ");
		} while(opcion>2 || opcion<1);
		
		return modo;
	}
	// Controlador de límites de teclado numérico
	/**
	 * Traductor de un número a una opción del menú.
	 * @param 	opcion		Número que escoge el usuario.
	 * @return	opciones 	Opcion del menú que escoge el usuario.
	 * 
	 * @since	1.0
	 */
	private Opciones seleccionMenu(int opcion) {
		Opciones menu = null;
		
		if (opcion == Opciones.JUGAR.getNum() || opcion == Opciones.INSTRUCCIONES.getNum() || opcion == Opciones.SALIR.getNum()) // Compara si el número de la opcion es igual al nº del enum
			if (opcion == Opciones.JUGAR.getNum())
				menu = Opciones.JUGAR;
			else if (opcion == Opciones.INSTRUCCIONES.getNum())
				menu = Opciones.INSTRUCCIONES;
			else if (opcion == Opciones.SALIR.getNum())
				menu = Opciones.SALIR;
		return menu;
	}
	/**
	 * Traductor de un número a una opción del modo de juego.
	 * @param 	opcion		Número que escoge el usuario.
	 * @return	modoJuego 	Opcion del modo de juego que escoge el usuario.
	 * 
	 * @since	1.0
	 */
	private ModoJuego seleccionModo(int opcion) {
		ModoJuego dificultad = null;
		
		if (opcion == ModoJuego.FACIL.getOpcion() || opcion == ModoJuego.MEDIO.getOpcion() || opcion == ModoJuego.DIFICIL.getOpcion()) // Compara si el número de la opcion es igual al nº del enum
			if (opcion == ModoJuego.FACIL.getOpcion())
				dificultad = ModoJuego.FACIL;
			else if (opcion == ModoJuego.MEDIO.getOpcion())
				dificultad = ModoJuego.MEDIO;
			else if (opcion == ModoJuego.DIFICIL.getOpcion())
				dificultad = ModoJuego.DIFICIL;

		return dificultad;
	}
	/**
	 * Traductor de un número a una opción del modo fácil.
	 * @param 	opcion		Número que escoge el usuario.
	 * @return	modoFacil 	Opcion del modo fácil que escoge el usuario.
	 * 
	 * @since	1.0
	 */
	private ModoFacil seleccionModoFacil(int opcion) {
		ModoFacil modoFacil = null;
		
		if (opcion == ModoFacil.USUARIO.getOpcion())
			modoFacil = ModoFacil.USUARIO;
		else if (opcion == ModoFacil.MAQUINA.getOpcion())
			modoFacil = ModoFacil.MAQUINA;
		return modoFacil;
	}

	// Teclado
	/**
	 * Cierra el teclado.
	 * 
	 * @since	1.0
	 */
	public void cerrar_teclado(){
		teclado.close();
	}	
	/**
	 * Teclado numérico.
	 * @return numero	Número seleccionado por el usuario.
	 * 
	 * @since	1.0
	 */
	protected int teclado_int(){	
		boolean prueba=true;
		int i=0;
		do {
			prueba=true;
		try {
				i=teclado.nextInt();			
			} catch (InputMismatchException e) {
                System.out.printf("Error, introduce un número entero. > ");
                prueba=false;
                limpiar_buffer();
			}
		} while (!(prueba));
		return i;
	}
	/**
	 * Limpia el buffer.
	 * 
	 * @since	1.0
	 */
	private void limpiar_buffer(){
		teclado.nextLine();
	}
		
}
