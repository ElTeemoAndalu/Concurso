package mastermind;


public class Jugada implements Dibujable {

	Combinacion intento, resultado;
	
	Jugada(Combinacion intento, Combinacion resultado){
		this.intento = intento;
		this.resultado = resultado;
		
	}

	@Override
	public void dibujar() {
		intento.dibujar();
		System.out.printf(" | ");
		resultado.dibujar();
	}
	



}
