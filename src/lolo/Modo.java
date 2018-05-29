package lolo;

public enum Modo {
	FACIL(4, 8, false, 10), MEDIO(5, 8, false, 15), DIFICIL(8, 10 ,true , -1);
	
	private int numCasillas;
	private int numColores;
	private boolean repeticionColores;
	private int numIntentos;
	
	private Modo(int numCasillas, int numColores, boolean repeticionColores, int numIntentos) {
		this.numCasillas = numCasillas;
		this.numColores = numColores;
		this.repeticionColores = repeticionColores;
		this.numIntentos = numIntentos;
	}

	public int getNumCasillas() {
		return numCasillas;
	}

	public int getNumColores() {
		return numColores;
	}

	public boolean isRepeticionColores() {
		return repeticionColores;
	}

	public int getNumIntentos() {
		return numIntentos;
	}
	
}
