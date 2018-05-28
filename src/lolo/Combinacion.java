package lolo;

import java.util.Arrays;

public class Combinacion implements Dibujable {
	
	private Ficha fichas[];

	Combinacion(int numFichas) {
		fichas = new Ficha[numFichas];
	}
	
	public Ficha[] getFichas() {
		return fichas;
	}

	// Va añadiendo fichas a su array, para tener una combinación que esté formada de fichas.
	void anadirFicha(Color color, int posicion) {
		fichas[posicion] = new Ficha(color);
	}
	
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Combinacion && Arrays.equals(fichas, ((Combinacion)obj).fichas))
				resultado=true;
		return resultado;		
	}
	
	public void dibujar() {
		for (int i = 0; i < fichas.length; i++) {
			fichas[i].dibujar();
		}
	}
	
}
