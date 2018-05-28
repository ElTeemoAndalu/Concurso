package mastermindNicolas;

import concurso.Participante;

public class Nicolas extends Participante{
	
	private byte turno;
	private byte[] resultado;
	IA miIAu;

	public Nicolas() {
		resultado = new byte[2];
		turno = 0;
	}

	public void setResultado(byte[] resultado) {
		this.resultado = resultado;
	}

	public byte[] crearCombPropuesta() {
		byte combPropuesta[] = new byte[Dificultad.DIFICIL.casillas];
		
		if (turno > 0) {
			miIAu.getTablero().coger_ultima_comb_y_result().colocar_respuesta(resultado[0], resultado[1]);
		}
		
		miIAu.analisis_intento();
		
		for (int i = 0; i < miIAu.getTablero().getCifrado().tamanio(); i++) {
			combPropuesta[i] = colorEnByte(miIAu.getTablero().coger_ultima_comb_y_result().getCombinacion()[i].getColor());
		}
		
		turno++;
		
		return combPropuesta;
	}

	public byte[] crearCombSecreta() {
		IA miIA = new IA(Dificultad.DIFICIL);
		
		byte cifrado[] = new byte[Dificultad.DIFICIL.casillas];

		Tablero tableroRival = new Tablero(Dificultad.DIFICIL);

		miIA.introducir_cifrado(miIA.comb_random(tableroRival, false), tableroRival);

		for (int i = 0; i < tableroRival.getCifrado().tamanio(); i++) {
			cifrado[i] = colorEnByte(tableroRival.getCifrado().combinacion[i].getColor());
		}

		return cifrado;
	}

	private byte colorEnByte(Color color) {
		byte num_color = 0;

		if (color == Color.ROJO) {
			num_color = 0;
		} else if (color == Color.VERDE) {
			num_color = 1;
		} else if (color == Color.AMARILLO) {
			num_color = 2;
		} else if (color == Color.AZUL) {
			num_color = 3;
		} else if (color == Color.MORADO) {
			num_color = 4;
		} else if (color == Color.CELESTE) {
			num_color = 5;
		} else if (color == Color.NEGRO) {
			num_color = 6;
		} else if (color == Color.GRIS) {
			num_color = 7;
		} else if (color == Color.VERDE_CLARO) {
			num_color = 8;
		} else if (color == Color.MORADO_CLARO) {
			num_color = 9;
		}

		return num_color;
	}

}
