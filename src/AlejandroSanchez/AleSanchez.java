package AlejandroSanchez;

import concurso.Participante;

public class AleSanchez extends Participante {
	
	Maquina maquina = new Maquina(new ModoJuego(3));

	@Override
	public byte[] crearCombPropuesta() {
		
		return maquina.introducirCombinacion();
	}

	@Override
	public byte[] crearCombSecreta() {
		
		return maquina.introducirCombSecreta();
	}

}
