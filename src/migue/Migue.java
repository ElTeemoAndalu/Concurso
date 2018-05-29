package migue;

import concurso.Participante;

public class Migue extends Participante{
	
	// Variables
	private Maquina maquina;
	private Ronda ronda;
	private byte contadorRonda=-1;
	
	// Constructor
	public Migue(){
		maquina = new Maquina(true,Dificultad.DIFICIL);
	}
	
	// Métodos heredados
	public byte[] crearCombPropuesta() {
		byte combPropuesta[] = new byte[Dificultad.DIFICIL.getNumCasillas()];
		if (contadorRonda>=0) {
			crearByN();
			maquina.comprobarCombinacion(maquina.getTablero().getRondas().getLast());
		}
		maquina.setCombinacionPropuesta(maquina.colocarCombinacion());
		for (byte i=0;i<maquina.getCombinacionPropuesta().getCombinacion().length;i++) {
			combPropuesta[i]=(byte)maquina.getCombinacionPropuesta().getCombinacion()[i].getColorFicha().ordinal();
		}
		contadorRonda++;
		ronda = new Ronda(contadorRonda);
		ronda.setCombinacionPropuesta(maquina.getCombinacionPropuesta());
		maquina.getTablero().agregarRonda(ronda);
		return combPropuesta;
	}

	public byte[] crearCombSecreta() {
		byte combSecreta[] = new byte[Dificultad.DIFICIL.getNumCasillas()];
		for (byte i=0;i<maquina.getCombinacionOriginal().getCombinacion().length;i++) {
			combSecreta[i]=(byte)maquina.getCombinacionOriginal().getCombinacion()[i].getColorFicha().ordinal();
		}
		return combSecreta;
	}
	
	private void crearByN() {
		Ficha fichasByN[] = new Ficha[Dificultad.DIFICIL.getNumCasillas()];
		byte contador=0;
		for (byte negras=0;negras<resultado[0];negras++) {		//---- Se almacenan las casillas
			fichasByN[contador]=new Ficha(Color.NEGRO);					// negras en el array.
			contador++;													//
		}
		for (byte blancas=0;blancas<resultado[1];blancas++) {	//---- Se almacenan las casillas
			fichasByN[contador]=new Ficha(Color.BLANCO);				// blancas en el array.
			contador++;													//
		}
		ronda.setResultadoByN(new Combinacion(fichasByN));
	}
	
	
}
