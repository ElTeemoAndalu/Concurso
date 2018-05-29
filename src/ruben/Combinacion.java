package ruben;


public class Combinacion{

	private Ficha combinacionFicha[];
	
	Combinacion(int numFicha){
		combinacionFicha = new Ficha[numFicha];
	}
	
	public void addFicha(String color, int posicion) {
		Ficha ficha = new Ficha(color);
		
		combinacionFicha[posicion]=ficha;
	}
	
	
	
	public Ficha[] getCombinacionFicha() {
		return combinacionFicha;
	}

	
}
