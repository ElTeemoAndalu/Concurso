package lolo;

public class Respuesta implements Dibujable {

	private Ficha respuestas[];

	Respuesta(int tamanho) {
		respuestas = new Ficha[tamanho];
	}
	
	public Ficha[] getRespuestas() {
		return respuestas;
	}

	// Va añadiendo fichas a la respuesta, para tener una respuesta que esté formada de fichas.
	void anadirFicha(Color color, int posicion) {
		respuestas[posicion] = new Ficha(color);
	}
	
	public void dibujar() {
		for (int i = 0; i < respuestas.length; i++) {
			respuestas[i].dibujar();
		}
	}

}
