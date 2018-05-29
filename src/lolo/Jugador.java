package lolo;

import java.util.HashMap;

public abstract class Jugador {
	protected Tablero tablero;
	protected Modo modo;

	Jugador(Modo modo) {
		tablero = new Tablero(modo);
		this.modo = modo;
	}

	public Tablero getTablero() {
		return tablero;
	}

	// Se utiliza para comprobar que la respuesta esté bien hecha, y devuelve un array de tamaño 3
	// que va a contener los aciertos rojos, blancos y negros en las distintas posiciones.
	int[] comprobarJugada(Combinacion combinacion) { 
		HashMap<Integer, Ficha> mapaCombinacion = new HashMap<>();
		HashMap<Integer, Ficha> mapaCombinacionOculta = new HashMap<>();
		int arrayRespuestas[] = new int[3];
		boolean salir = false;

		for (int i = 0; i < modo.getNumCasillas(); i++) {
			mapaCombinacion.put(i, combinacion.getFichas()[i]);
			mapaCombinacionOculta.put(i, tablero.getCombinacionOcultaPropia().getFichas()[i]);
		}
		
		for (int i = 0; i < modo.getNumCasillas(); i++) {
			if (mapaCombinacion.get(i).equals(mapaCombinacionOculta.get(i))) {
				arrayRespuestas[0]++;
				mapaCombinacion.remove(i);
				mapaCombinacionOculta.remove(i);
			}
		}
		
		if (!mapaCombinacion.isEmpty() && !mapaCombinacionOculta.isEmpty()) {
			for (int i = 0; i < modo.getNumCasillas(); i++) {
				if (mapaCombinacion.containsKey(i)) {
					for (int j = 0; j < modo.getNumCasillas() && !salir; j++) {
						if (mapaCombinacionOculta.containsKey(j)) {
							if (mapaCombinacion.get(i).equals(mapaCombinacionOculta.get(j))) {
								arrayRespuestas[1]++;
								mapaCombinacion.remove(i);
								mapaCombinacionOculta.remove(j);
								salir = true;
							} 
						}
					}
					salir = false;
				}
			}
		}

		if (arrayRespuestas[0] + arrayRespuestas[1] < modo.getNumCasillas()) {
			arrayRespuestas[2] = modo.getNumCasillas() - (arrayRespuestas[0] + arrayRespuestas[1]);
		}

		return arrayRespuestas;
	}

	// Necesita método de arriba como parámetro para funcionar.
	// El array que se le pasa sirve para crear una Respuesta que se va a añadir en la Jugada.
	Respuesta crearRespuesta(int[] arrayRespuestas) {
		Respuesta respuesta = new Respuesta(modo.getNumCasillas());
		Color color = null;
		int posicion = 0;

		for (int i = 0; i < arrayRespuestas.length; i++) {
			while (arrayRespuestas[i] > 0) {
				if (i == 0) {
					color = Color.ROJO;
				} else if (i == 1) {
					color = Color.GRIS;
				} else {
					color = Color.NEGRO;
				}
				arrayRespuestas[i]--;
				respuesta.anadirFicha(color, posicion);
				posicion++;
			}
		}

		return respuesta;
	}

	abstract Jugada anadirRespuesta(Combinacion combinacion);

	abstract Combinacion anadirCombinacion();

	abstract Combinacion anadirCombinacionOculta();

}
