package lolo;

import concurso.Participante;

public class Lolo extends Participante{

	public byte[] crearCombPropuesta() {
		Maquina ia = new Maquina(Modo.DIFICIL);
		Combinacion combinacion = ia.anadirCombinacion();
		byte[] arrayCombinacion = new byte[Modo.DIFICIL.getNumCasillas()];
		int posicionFicha;

		for (posicionFicha = 0; posicionFicha < Modo.DIFICIL.getNumCasillas(); posicionFicha++) {
			
			switch (combinacion.getFichas()[posicionFicha].getColor()) {
			case MORADO:
				arrayCombinacion[posicionFicha] = 0;
				break;
			case GRIS:
				arrayCombinacion[posicionFicha] = 1;
				break;
			case NEGRO:
				arrayCombinacion[posicionFicha] = 2;
				break;
			case AZUL:
				arrayCombinacion[posicionFicha] = 3;
				break;
			case ROJO:
				arrayCombinacion[posicionFicha] = 4;
				break;
			case AMARILLO:
				arrayCombinacion[posicionFicha] = 5;
				break;
			case LIMA:
				arrayCombinacion[posicionFicha] = 6;
				break;
			case TURQUESA:
				arrayCombinacion[posicionFicha] = 7;
				break;
			case ROSA:
				arrayCombinacion[posicionFicha] = 8;
				break;
			case CELESTE:
				arrayCombinacion[posicionFicha] = 9;
				break;
			}
		}
		return arrayCombinacion;
	}

	public byte[] crearCombSecreta() {
		return crearCombPropuesta();
	}

}
