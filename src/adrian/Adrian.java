package adrian;

import static adrian.Colores.*;

import concurso.Participante;

public class Adrian extends Participante {
	private TableroJugador tablero ;
	private Maquina maquina;

	public Adrian() {
		tablero = new TableroJugador();
		maquina = new Maquina(Modos.Dificil);
	}

	@Override
	public byte[] crearCombPropuesta() {
		
		int i;
		Jugada jugada = new Jugada(Modos.Dificil);
		byte[] combinacion = new byte[Modos.Dificil.getNumCasillas()];
		jugada.addJugada(maquina.rellenarCombinacionAcertar(tablero), traducirByteString(resultado));
		tablero.getTablero().add(jugada);
		for (i = 0; i < Modos.Dificil.getNumCasillas(); i++) {
			combinacion[i] = traducirStringByte(maquina.acertarCombinacion.getCasillas()[i]);
		}

		return combinacion;

	}


	public byte[] crearCombSecreta() {
		int i;
		byte[] combinacion = new byte[Modos.Dificil.getNumCasillas()];
		maquina.rellenarCombiSecret();
		for (i = 0; i < Modos.Dificil.getNumCasillas(); i++) {
			combinacion[i] = traducirStringByte(maquina.combinacionSecreta.getCasillas()[i]);
		}

		return combinacion;
	}

	private byte traducirStringByte(Ficha ficha) {
		byte byteColor = 0;
		switch (ficha.getColor()) {
		case ROJO + (char) 9209 + RESET:
			byteColor = 0;
			break;
		case VERDE + (char) 9209 + RESET:
			byteColor = 1;
			break;
		case AMARILLO + (char) 9209 + RESET:
			byteColor = 2;
			break;
		case AZUL + (char) 9209 + RESET:
			byteColor = 3;
			break;
		case MORADO + (char) 9209 + RESET:
			byteColor = 4;
			break;
		case CELESTE + (char) 9209 + RESET:
			byteColor = 5;
			break;
		case ROSA + (char) 9209 + RESET:
			byteColor = 6;
			break;
		case CELESTE_CLARO + (char) 9209 + RESET:
			byteColor = 7;
			break;
		case AMARILLO_CLARO + (char) 9209 + RESET:
			byteColor = 8;
			break;
		case VERDE_CLARO + (char) 9209 + RESET:
			byteColor = 9;
			break;
		}
		return byteColor;
	}

	private Combinacion traducirByteString(byte[] resultado) {
		int i;
		Combinacion resultadoCombinacion = new Combinacion(Modos.Dificil);
		Ficha ficha1;
		Ficha ficha2;
		Ficha ficha3;
		
		ficha1=new Ficha();
		ficha1.setColor(NEGRO + (char) 9210 + RESET);
		for(i = 0 ; i < resultado[0] ; i++) {
			
			resultadoCombinacion.getCasillas()[i] = ficha1;
		}
		ficha2=new Ficha();
		ficha2.setColor(ROJO + (char) 9210 + RESET);
		for(i = resultado[0] ; i < (resultado[0] + resultado[1]) ; i++) {
			
			resultadoCombinacion.getCasillas()[i] = ficha2;
		}
		ficha3=new Ficha();
		ficha3.setColor(BLANCO + (char) 9210 + RESET);
		for(i = (resultado[0] + resultado[1]) ; i < resultadoCombinacion.getCasillas().length ; i++) {
			
			resultadoCombinacion.getCasillas()[i] = ficha3;
		}
		
		return resultadoCombinacion;
	}

}
