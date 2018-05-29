package lidia;

import java.util.LinkedList;

import concurso.Participante;

public class Lidia extends Participante {
	Maquina maquina = new Maquina(Dificultad.DIFICIL);
	LinkedList<Combinacion> jugadasRealizadas = new LinkedList<>();
	int intento = 1;

	@Override
	public byte[] crearCombPropuesta() {
		Tablero tablero = new Tablero(null, Dificultad.DIFICIL);
		Combinacion combinacion = null;
		Jugada jugada;		
		
		if(intento == 1) {
			combinacion  = maquina.crearIntento(tablero, intento);
			jugadasRealizadas.addLast(combinacion);
		} else {
			jugada = new Jugada(jugadasRealizadas.getLast());
			jugada.setResultado(convertirResultadoEnCombinacion(resultado));
			tablero.anadirJugada(jugada);

			combinacion  = maquina.crearIntento(tablero, intento);
			jugadasRealizadas.addLast(combinacion);			
		}

		byte[] combinacionByte = new byte[combinacion.getCombinacion().length];
		
		for(int i = 0 ; i < combinacionByte.length ; i++) {
			combinacionByte[i] = convertirCasillaEnByte(combinacion.getCasilla(i));
		}
		
		intento++;
		return combinacionByte;
	}

	@Override
	public byte[] crearCombSecreta() {
		Combinacion combinacionSecreta = maquina.crearCombinacionSecreta();
		byte[] combinacionSecretaByte = new byte[combinacionSecreta.getCombinacion().length];
		
		for(int i = 0 ; i < combinacionSecretaByte.length ; i++) {
			combinacionSecretaByte[i] = convertirCasillaEnByte(combinacionSecreta.getCasilla(i));
		}
		
		return combinacionSecretaByte;
	}

	private byte convertirCasillaEnByte(Casilla casilla) {
		byte casillaByte = -1;
		String color = casilla.getColor();

		switch (color) {
		case Color.FONDO_ROJOCLARO:
			casillaByte = 0;
			break;
		case Color.FONDO_VERDE:
			casillaByte = 1;
			break;
		case Color.FONDO_AMARILLOCLARO:
			casillaByte = 2;
			break;
		case Color.FONDO_AZULCLARO:
			casillaByte = 3;
			break;
		case Color.FONDO_MORADO:
			casillaByte = 4;
			break;
		case Color.FONDO_CELESTECLARO:
			casillaByte = 5;
			break;
		case Color.FONDO_AMARILLO:
			casillaByte = 6;
			break;
		case Color.FONDO_GRISOSCURO:
			casillaByte = 7;
			break;
		case Color.FONDO_MORADOCLARO:
			casillaByte = 8;
			break;
		case Color.FONDO_VERDECLARO:
			casillaByte = 9;
			break;
		}
		return casillaByte;
	}
	
	private Combinacion convertirResultadoEnCombinacion(byte[] resultado) {
		Combinacion resultadoCombinacion = new Combinacion(Dificultad.DIFICIL);
		int i;
		
		for(i = 0 ; i < resultado[0] ; i++) {
			resultadoCombinacion.anadirCasillaPosicion(new Casilla(Color.FONDO_ROJOCLARO), i);
		}
		
		for(i = resultado[0] ; i < (resultado[0] + resultado[1]) ; i++) {
			resultadoCombinacion.anadirCasillaPosicion(new Casilla(Color.FONDO_BLANCO), i);
		}
		
		for(i = (resultado[0] + resultado[1]) ; i < resultadoCombinacion.getCombinacion().length ; i++) {
			resultadoCombinacion.anadirCasillaPosicion(new Casilla(Color.FONDO_NEGRO), i);
		}
		
		return resultadoCombinacion;
	}
	
}
