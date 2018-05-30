package jaime;

import java.util.Arrays;

/**
 * Esta clase almacena una combinacion de colores, con un array de tipo Ficha
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Combinacion implements Dibujable{

	/**
	 * Ficha[] combinacion : array que almacena objetos de tipo Ficha
	private Ficha f : instancia de la clase Ficha
	Dificultad dificultad: almacena el modo (facil, medio o dificil)
	 */
	Ficha[] combinacion;
	private Ficha f ;
	Dificultad dificultad;
	/**
	 * Construye un nuevo objeto Cadena que contiene el especificado número escrito en modo cadena
	 * @param dificultad La dificultad a partir de la cual se crea la combinacion
	 * @see #añadirFicha(int)
	 * @see dibujar
	 */
	//Con # le podemos indicar un método
	Combinacion(Dificultad dificultad){
		this.dificultad = dificultad;
		combinacion = new Ficha[dificultad.getCasilla()];
	}
	//se pedira por teclado el color que se qiere introducir en la 1 posicion, los colores estan en una lista del 1 al 10
	//este metodo añade la ficha que se e introduzca a la posicion que toque
	
	/**
	 * Crea la ficha del color que se le pase y la añade a la combinacion donde se le indique
	 * @param color El color que se elija
	 * @return combinacion El array de combinacion relleno de colores(Fichas)
	 */
	public Combinacion añadirFicha(int color, int posicion) {
		Combinacion c = new Combinacion(dificultad);
		boolean ocupada = false;
		f = new Ficha(dificultad, color);
		
		
		for(int i=0;i<dificultad.getCasilla();i++) {
			if(ocupada==false) {
				combinacion[posicion] = f;
				ocupada=true;
			}
			
		}
		
		return c;
	}
	
	/**
	 * Compara dos objetos
	 * @param obj Un objeto que se compara con el de esta clase
	 * @return El booleano resultante de la comparacion(true si son iguales, false si no lo son)
	 */
	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Combinacion && Arrays.equals(combinacion, ((Combinacion) obj).combinacion)){
			resultado = true;
		}
			
		return resultado;
	}
	/**
	 * Dibuja la combinacion creada recorriendola y dibujando cada ficha
	 */
	public void dibujar() {
		for(int i = 0; i<dificultad.getCasilla();i++) {
			if(combinacion[i]!= null) {
			combinacion[i].dibujar();
			}
			
		}
	}
	
//	public static void main(String[] args) {
//		Dificultad dificultad  = Dificultad.INDIVIDUAL;
//		Combinacion c = new Combinacion(dificultad);
//		Combinacion c1 = new Combinacion(dificultad);
//		c.añadirFicha(1,0);
//		c.añadirFicha(2,1);
//		c.añadirFicha(3,2);
//		c.añadirFicha(4,3);
//		
//		c1.añadirFicha(0,0);
//		c1.añadirFicha(5,1);
//		c1.añadirFicha(6,2);
//		c1.añadirFicha(7,3);
//		c.dibujar();
//		System.out.println();
//		c1.dibujar();
//		
//		
//		
//	}


}
