package ruben;

import concurso.Participante;

public class Ruben extends Participante{

	
	public byte[] crearCombPropuesta() {
		byte combinacionByte[] = new byte[8];
		Combinacion combinacionIa;
		int i;
		Maquina ia = new Maquina(Dificultad.DIFICIL);
		
		combinacionIa=ia.addCombinacion();
		
		for(i=0;i<combinacionIa.getCombinacionFicha().length;i++) {
			String color;
			color=combinacionIa.getCombinacionFicha()[i].getColor();
			
			switch (color) {
				case Colores.ROJO:
					combinacionByte[i]=0;
					break;
				case Colores.AMARILLO:
					combinacionByte[i]=1;
					break;
				case Colores.AZUL:
					combinacionByte[i]=2;
					break;
				case Colores.BLANCO:
					combinacionByte[i]=3;
					break;
				case Colores.CELESTE:
					combinacionByte[i]=4;
					break;
				case Colores.MORADO:
					combinacionByte[i]=5;
					break;
				case Colores.NARANJA:
					combinacionByte[i]=6;
					break;
				case Colores.NEGRO:
					combinacionByte[i]=7;
					break;
				case Colores.ROSA:
					combinacionByte[i]=8;
					break;
				case Colores.VERDE:
					combinacionByte[i]=9;
					break;
			}
		}
		
		return combinacionByte;
	}

	public byte[] crearCombSecreta() {
		
		return crearCombPropuesta();
	}

}
