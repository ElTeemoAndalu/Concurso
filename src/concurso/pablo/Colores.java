package concurso.pablo;

/**
 * Enum que almacena todos los colores utilizados en el juego.
 * 
 * @author pablo
 *
 */
public enum Colores {
	ROJO(Constantes.COLOR_ROJO), AZUL(Constantes.COLOR_AZUL), AMARILLO(Constantes.COLOR_AMARILLO),
	VERDE(Constantes.COLOR_VERDE), NARANJA(Constantes.COLOR_NARANJA), ROSA(Constantes.COLOR_ROSA), 
	LILA(Constantes.COLOR_LILA), CELESTE(Constantes.COLOR_CELESTE), MARRON(Constantes.COLOR_MARRON), 
	GRIS(Constantes.COLOR_GRIS), NEGRO(Constantes.COLOR_NEGRO),BLANCO(Constantes.COLOR_BLANCO),SC(Constantes.SIN_COLOR)	;

	private String color;

	private Colores(String colores) {
		color = colores;
	}

	/**
	 * 
	 * @return Devuelve el codigo del color elegido.
	 */
	public String getCodigo() {
		return color;
	}

}
