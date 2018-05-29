package salva;

import concurso.Participante;

public class Salva extends Participante{

	@Override
	public byte[] crearCombPropuesta() {
		Maquina ia=new Maquina(Dificultad.DIFICIL);
		int i, j;
		byte[] combinacionNueva=new byte[8];
		Combinacion combinacion=ia.crearCombinacionOculta();
		for (i = 0; i < combinacion.getTamanho().length; i++) {
			for (j = 0; j < combinacion.getTamanho().length; j++) {
				if (combinacion.devolverCasilla(i).getColor().equals(Casilla.devolverColor(j)) ) {
					combinacionNueva[i]=(byte)j;
				} 
			}
		}
		
		return combinacionNueva;
	}

	@Override
	public byte[] crearCombSecreta() {
		Maquina ia=new Maquina(Dificultad.DIFICIL);
		int i, j;
		byte[] combinacionNueva=new byte[8];
		Combinacion combinacion=ia.crearCombinacionOculta();
		for (i = 0; i < combinacion.getTamanho().length; i++) {
			for (j = 0; j < combinacion.getTamanho().length; j++) {
				if (combinacion.devolverCasilla(i).getColor().equals(Casilla.devolverColor(j)) ) {
					combinacionNueva[i]=(byte)j;
				} 
			}
		}
		
		return combinacionNueva;
	}

	
	
	
}
