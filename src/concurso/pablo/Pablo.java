package concurso.pablo;

import concurso.Participante;

public class Pablo extends Participante {
	private Maquina ia;
	private Combinacion ultimaCombinacion;
	private int contador=0;

	public Pablo(){
		ia=new Maquina("Pablo", Dificultad.DIFICIL);
		ia.introducirCodigoPrivado();
	}

	@Override
	public byte[] crearCombPropuesta() {
		if(contador == 0){
			ultimaCombinacion=ia.introducirCodigo(true);
			contador++;
		}else{
			ia.getTablero().añadirAlTablero(ultimaCombinacion,anhadirRespuesta(resultado));
			ultimaCombinacion=ia.introducirCodigo(true);
			contador++;
		}
		return cambiarCombinacionByte(ultimaCombinacion);
	}

	@Override
	public byte[] crearCombSecreta() {
		return cambiarCombinacionByte(ia.getTablero().getCombinacionOculta());
	}

	private byte[] cambiarCombinacionByte(Combinacion combinacionAConvertir){
		byte combinacion[]= new byte [8];
		for(int i = 0;i<combinacion.length;i++){
			combinacion[i]=cambiarColor(combinacionAConvertir.getCodigo()[i].getColor());
		}
		return combinacion;
	}

	private Combinacion cambiarCombinacionColor(byte[] numeros){
		Ficha[] colores = new Ficha[8];
		for(int i = 0 ; i < numeros.length; i++){
			colores[i]=new Ficha(cambiarByte(numeros[i]));
		}
		return new Combinacion(colores);
	}

	private byte cambiarColor(Colores color){
		byte numero=0;
		switch (color){
			case AMARILLO:
				numero=0;
				break;
			case AZUL:
				numero=1;
				break;
			case ROJO:
				numero=2;
				break;
			case VERDE:
				numero=3;
				break;
			case NARANJA:
				numero=4;
				break;
			case LILA:
				numero=5;
				break;
			case ROSA:
				numero=6;
				break;
			case CELESTE:
				numero=7;
				break;
			case GRIS:
				numero=8;
				break;
			case MARRON:
				numero=9;
				break;
		}



		return 0;
	}

	private Colores cambiarByte(byte numero){
		Colores color = null;
		switch(numero){
			case 0:
				color=Colores.AMARILLO;
				break;
			case 1:
				color=Colores.AZUL;
				break;
			case 2:
				color=Colores.ROJO;
				break;
			case 3:
				color=Colores.VERDE;
				break;
			case 4:
				color=Colores.NARANJA;
				break;
			case 5:
				color=Colores.LILA;
				break;
			case 6:
				color=Colores.ROSA;
				break;
			case 7:
				color=Colores.CELESTE;
				break;
			case 8:
				color=Colores.GRIS;
				break;
			case 9:
				color=Colores.MARRON;
				break;
		}

		return color;
	}

	private Combinacion anhadirRespuesta(byte[] resultado){
		Ficha[] colores = new Ficha[8];
		for (int i = 0; i< resultado[0];i++){
			colores[i]=new Ficha(Colores.NEGRO);
		}
		for(int i = resultado[0]; i<resultado[1]+resultado[0];i++){
			colores[i]=new Ficha(Colores.BLANCO);
		}
		for(int i = resultado[1]+resultado[0]; i < 8;i++){
			colores[i]= new Ficha(Colores.SC);
		}
		return new Combinacion(colores);
	}
	
}
