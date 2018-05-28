package esther;

import concurso.Participante;

public class Esther extends Participante {
	
	private final ModoJuego DIFICULTAD = ModoJuego.DIFICIL;
	private Maquina maquina = new Maquina(DIFICULTAD);
	
	public byte[] crearCombPropuesta() {
		byte [] combinacion = new byte [DIFICULTAD.getCasilla()];
		for (int i=0; i<DIFICULTAD.getCasilla(); i++) {
			combinacion [i] = maquina.introducirColor();
		}
		return combinacion;
	}
	
	public byte[] crearCombSecreta() {
		byte [] combinacion = new byte [DIFICULTAD.getCasilla()];
		for (int i=0; i<DIFICULTAD.getCasilla(); i++) {
			combinacion [i] = maquina.introducirColor();
		}
		return combinacion;
	}
	
}
