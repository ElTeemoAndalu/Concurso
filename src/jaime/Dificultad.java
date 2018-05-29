package mastermind;
/**
 * Almacena la dificultad de cada modo, asi como sus correspondientes casillas, colores, intentos
 *  y si tiene o no repeticion de colores
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public enum Dificultad {

	INDIVIDUAL(4,8, false, 10), EXPERTO(5,8,false,15), AUTOMATICO(8,10,true,1000);
	
	private int casilla;
	private int colores;
	private boolean repeticion;
	private int intentos;
	
	Dificultad(int casilla, int colores, boolean repeticion, int intentos){
		this.casilla = casilla;
		this.colores = colores;
		this.repeticion = repeticion;
		this.intentos = intentos;
		
	}

	public int getCasilla() {
		return casilla;
	}
	public int getColores() {
		return colores;
	}
	public boolean isRepeticion() {
		return repeticion;
	}
	public int getIntentos() {
		return intentos;
	}

	
}
