package mastermind;

import static mastermind.Colores.*;

public class Adrian extends Participante {
	private TableroJugador tablero;
	private Modos modo;
	private Maquina maquina;

	public Adrian() {
		tablero = new TableroJugador();
		modo = Modos.Dificil;
		maquina = new Maquina(modo);
	}

	@Override
	public byte[] crearCombPropuesta() {
		int i;
		Jugada jugada = new Jugada(modo);
		byte[] combinacion = new byte[modo.getNumCasillas()];

		jugada.addJugada(maquina.rellenarCombinacionAcertar(tablero), traducirByteString(resultado));
		tablero.getTablero().add(jugada);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			combinacion[i] = traducirStringByte(maquina.acertarCombinacion.getCasillas()[i].getColor());
		}

		return combinacion;

	}

	@Override
	public byte[] crearCombSecreta() {
		int i;
		byte[] combinacion = new byte[modo.getNumCasillas()];
		maquina.rellenarCombiSecret();
		for (i = 0; i < modo.getNumCasillas(); i++) {
			combinacion[i] = traducirStringByte(maquina.combinacionSecreta.getCasillas()[i].getColor());
		}

		return combinacion;
	}

	private byte traducirStringByte(String color) {
		byte byteColor = 0;
		switch (color) {
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
		Combinacion respuesta = new Combinacion(modo);
		Ficha ficha;
		for (i = 0; i < resultado[0]; i++) {
			ficha = new Ficha();
			ficha.setColor(NEGRO + (char) 9210 + RESET);
			respuesta.getCasillas()[i] = ficha;
		}
		while (i < resultado[0] + resultado[1]) {
			ficha = new Ficha();
			ficha.setColor(ROJO + (char) 9210 + RESET);
			respuesta.getCasillas()[i] = ficha;
			i++;
		}
		i = resultado[0] + resultado[1];
		while (i < modo.getNumCasillas()) {
			ficha = new Ficha();
			ficha.setColor(BLANCO + (char) 9210 + RESET);
			respuesta.getCasillas()[i] = ficha;
			i++;
		}
		return respuesta;
	}
}
