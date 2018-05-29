package mastermind;

public class Jaime {

	Maquina maquina;
	Dificultad dificultad = Dificultad.AUTOMATICO;
	byte[] combinacionConvertida;
	//Tablero tablero = new Tablero();
	
	Ficha ficha;
	
	Jaime(Maquina maquina){
		maquina = new Maquina(dificultad);
	}
	
	public byte[] crearCombRespuesta() {
		byte[] comb = new byte[dificultad.getCasilla()];
		Combinacion aux = new Combinacion(dificultad);
		maquina = new Maquina(dificultad);
		aux = maquina.IAConcurso();
		
		comb = convertir(aux);
		
		
		return comb;
	}
	
	public byte[] crearCombSecreta() {
		byte[] comb = new byte[dificultad.getCasilla()];
		Combinacion aux = new Combinacion(dificultad);
		maquina = new Maquina(dificultad);
		
		aux = maquina.IAConcurso();
		
		comb = convertir(aux);
		
		return comb;
	}
	


	public byte[] convertir(Combinacion combinacion) {
		byte[] comb = new byte[dificultad.getCasilla()];
		byte color = 0;
		
		for (int i = 0; i < dificultad.getCasilla(); i++) {
			
			
			switch (combinacion.combinacion[i].posicion) {
			case 0:
				color = 0;
				break;
			case 1:
				color = 1;
				break;
			case 2:
				color = 2;
				break;
			case 3:
				color = 3;
				break;
			case 4:
				color = 4;
				break;
			case 5:
				color = 5;
				break;
			case 6:
				color = 6;
				break;
			case 7:
				color = 7;
				break;
			case 8:
				color = 8;
				break;
			default:
				break;
			}
			comb[i] = color;
		}
		
		return comb;
	}
	
	public static void main(String[] args) {
		Maquina m = null ;
		Jaime j = new Jaime(m);
		Combinacion c = new Combinacion(Dificultad.INDIVIDUAL);
		byte color = 0 ;
		byte[] comb = new byte[Dificultad.INDIVIDUAL.getCasilla()];

		comb = j.crearCombSecreta();
		
		for(int i=0;i<comb.length;i++) {
			System.out.println(comb[i]);
		}
	}

}
