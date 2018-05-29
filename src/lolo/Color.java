package lolo;

public enum Color {
	GRIS("\u001B[1;30m"), NEGRO("\u001B[30m"), AZUL("\u001B[1;34m"), ROJO("\u001B[1;31m"), AMARILLO("\u001B[1;33m"), 
	LIMA("\u001B[1;32m"), CELESTE("\u001B[36m"), TURQUESA("\u001B[1;36m"), ROSA("\u001B[1;35m"), MORADO("\u001B[35m");

	private String codigo;

	private Color(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
