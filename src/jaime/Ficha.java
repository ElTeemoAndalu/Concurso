package mastermind;


/**
 * Almacena los colores de cada modo
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc

public class Ficha implements Dibujable{

	/**
	 * Almacena el color, el modo, un array de colores para cada modo y 2 caracteres de circulo
	 * 	 */
	//Solamente se muestran en el Javadoc los atributos públicos
	
	private String color;
	Dificultad dificultad;
	int posicion;
	public static final char CIRCULO = '\u2b24';
	public static final char CIRCULO_PEQUEÑO = '\u23fa';
	//en lugar de poner los espacios poner los circulos, pero en lugar del fondo hay que poner el color
	private static String[] fichasFacilMedio =  {"\u001B[30m"+CIRCULO+ "\u001B[0m",
			"\u001B[37m"+CIRCULO+"\u001B[0m",
			"\u001B[31m"+CIRCULO+"\u001B[0m",
			"\u001B[32m"+CIRCULO+"\u001B[0m",
			"\u001B[33m"+CIRCULO+"\u001B[0m",
			"\u001B[34m"+CIRCULO+"\u001B[0m",
			"\u001B[35m"+CIRCULO+"\u001B[0m",
			"\u001B[36m"+CIRCULO+"\u001B[0m"};
	private static String[] fichasDificil = {"\u001B[30m"+"  " + "\u001B[0m",
			"\u001B[37m"+CIRCULO+"\u001B[0m",
			"\u001B[31m"+CIRCULO+"\u001B[0m",
			"\u001B[32m"+CIRCULO+"\u001B[0m",
			"\u001B[33m"+CIRCULO+"\u001B[0m",
			"\u001B[34m"+CIRCULO+"\u001B[0m",
			"\u001B[35m"+CIRCULO+"\u001B[0m",
			"\u001B[36m"+CIRCULO+"\u001B[0m",
			"\u001B[90m"+CIRCULO+"\u001B[0m",
			"\u001B[91m"+CIRCULO+"\u001B[0m"};
	
	/**
	 * Construye un nuevo objeto Ficha que contiene la dificultad y obtendra segun la posicion el color al que corresponda
	 * @param posicion  La posicion que indicaremos y coincidirá con un color
	 * @param dificultad La dificultad de la ficha segun la partida, necesario para acceder a un array de colores y otro
	 * @see #getColor()
	 */
	Ficha(Dificultad dificultad, int posicion){
		this.dificultad = dificultad;
		this.posicion = posicion;
		if(dificultad == Dificultad.INDIVIDUAL || dificultad == Dificultad.EXPERTO) {
			color = fichasFacilMedio[posicion];
		}else {
			color = fichasDificil[posicion];
		}
	}
	/**
	 * Devuelve el color que se halla elegido
	 * @return color de la ficha
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Dibuja la ficha, mostrando el circulo y el color
	 */
	
	//interfaz
	public void dibujar() {
		System.out.printf("%s", getColor());
	}
	/**
	 * Compara objetos Ficha
	 */
	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Ficha && color.equals(((Ficha)obj).color) 
				&& posicion==((Ficha)obj).posicion){
			resultado = true;
		}
			
		return resultado;
	}

	
}
