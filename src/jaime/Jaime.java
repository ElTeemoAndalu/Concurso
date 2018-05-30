package jaime;


import concurso.Participante;

public class Jaime extends Participante{

	
	Dificultad dificultad = Dificultad.AUTOMATICO;
	private Maquina maquina;
	byte[] combinacionConvertida;
	
	
	public Jaime(){
		maquina = new Maquina(dificultad);
	}
	

	
	public byte[] crearCombSecreta() {
		byte[] comb = new byte[dificultad.getCasilla()];
		Combinacion aux = new Combinacion(dificultad);
		
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

	@Override
	public byte[] crearCombPropuesta() {
		
		byte[] comb = new byte[dificultad.getCasilla()];
		Combinacion aux = new Combinacion(dificultad);
		
		aux = maquina.IAConcurso();
		
		comb = convertir(aux);
		
		
		return comb;
	}
	

}
