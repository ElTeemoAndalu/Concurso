package AlejandroD;

import concurso.Participante;
import static AlejandroD.ModoDeJuego.*;

public class AleDiaz extends Participante {
	private Jugador ia = new Maquina(DIFICIL);
	
	@Override
	public byte[] crearCombPropuesta() {
		int i, j;
		byte combinacion[] = new byte[DIFICIL.getNumCasillas()];
		boolean salir = false;
		String color;
		int[] respuesta = new int[2];
		
		if (!ia.getTablero().noCombinaciones() && resultado != null) {
			for (i = 0; i < resultado.length; i++) {
				respuesta[i] = resultado[i];
			}
			ia.insertRespuesta(ia.getTablero().lastCombinacion(), respuesta);
		}
		
		ia.elegirCombinacion();
		for (i = 0; i < DIFICIL.getNumCasillas(); i++) {
			color = ia.getTablero().lastCombinacion().oneFicha(i).getColor();
			for (j = 0; j < DIFICIL.getNumColores() && !salir; j++) {
				if (color.equals(Casilla.darColor(j))) {
					combinacion[i] = (byte) j;
					salir = true;
				}
			}
			salir = false;
		}
		return combinacion;
	}

	@Override
	public byte[] crearCombSecreta() {
		int i, j;
		boolean salir = false;
		Combinacion combinacionOcul = new Combinacion(DIFICIL);
		byte combiOculta[] = new byte[DIFICIL.getNumCasillas()];
		String color;
		
		combinacionOcul = ia.elegirCombinacionOculta();
		for (i = 0; i < DIFICIL.getNumCasillas(); i++) {
			color = combinacionOcul.oneFicha(i).getColor();
			for (j = 0; j < DIFICIL.getNumColores() && !salir; j++) {
				if (color.equals(Casilla.darColor(j))) {
					combiOculta[i] = (byte) j;
					salir = true;
				}
			}
			salir = false;
		}
		return combiOculta;
	}
}
