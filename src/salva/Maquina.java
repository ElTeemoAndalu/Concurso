package salva;

/** 
 * Esta clase almacena su tablero con la coreespondiente dificultad.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

import java.util.HashMap;
import java.util.Random;

public class Maquina extends Jugador{
	
	/**
	 * Construye un nuevo objeto Máquina
	 * @param dificultad  La dificultad de la partida, heredada del padre jugador.
	 */

	public Maquina(Dificultad dificultad) {
		super(dificultad);
	}
	
	/**
	 * Crea una combinación que será la que tiene que adivinar el contrario, 
	 * si el modo es fácil o medio se controlará que no se repitan colores.
	 * @return La combinación completa.
	 */
	
	public Combinacion crearCombinacionOculta() {
		Combinacion combinacion=new Combinacion(dificultad);
		Random rnd=new Random();
		HashMap<Integer, Boolean> mapa=new HashMap<>();
		int i, color;
		
		for (i = 0; i < dificultad.getCantidadColores(); i++) {
			mapa.put(i, false);
		}
		i=0;
		
		do {
			color=rnd.nextInt(dificultad.getCantidadColores());
			if (dificultad==Dificultad.DIFICIL) {
				combinacion.crearCombinacion(i, color);
				i++;
			} else {
				if (!mapa.get(color)) {
					combinacion.crearCombinacion(i, color);
					i++;
					mapa.put(color, true);
				}
			}
		} while (i<dificultad.getCantidadCasillas());
		tablero.setCombinacionOcultaPropia(combinacion);
		return combinacion;
	}

	/**
	 * Crea una respuesta acorde a las combinaciones que se comparan.
	 * @param La combinación que se tiene que comparar a la oculta.
	 * @return La jugada completa, es decir la combinación que se introdujo y su respuesta correspondiente.
	 */
	
	Jugada crearRespuesta(Combinacion combinacion) {
		Respuesta respuesta= new Respuesta(combinacion.getDificultad());
		HashMap<Integer, Casilla> mapaCombinacionOculta=new HashMap<>();
		HashMap<Integer, Casilla> mapaCombinacionContrario=new HashMap<>();
		int i, j;
		byte [] contador = new byte[3];
		boolean salir=false;
		
		for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
			mapaCombinacionOculta.put(i, tablero.getCombinacionOcultaPropia().getTamanho()[i]);
		}
		
		for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
			mapaCombinacionContrario.put(i, combinacion.getTamanho()[i]);
		}
		
		for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
			if (mapaCombinacionOculta.get(i).equals(mapaCombinacionContrario.get(i))) {
				contador[0]++;
				mapaCombinacionOculta.remove(i);
				mapaCombinacionContrario.remove(i);
			}
		}
		if (!mapaCombinacionOculta.isEmpty() && !mapaCombinacionContrario.isEmpty()) {
			for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
				if (mapaCombinacionOculta.containsKey(i)) {
					for (j = 0; j < dificultad.getCantidadCasillas() && !salir; j++) {
						if (mapaCombinacionContrario.containsKey(j)) {
							if (mapaCombinacionOculta.get(i).equals(mapaCombinacionContrario.get(j))) {
								contador[1]++;
								mapaCombinacionOculta.remove(i);
								mapaCombinacionContrario.remove(j);
								salir=true;
							}
						}
					}
					salir=false;
				}

			}
		}
		
		for (i = 0; i < combinacion.getTamanho().length; i++) {
			if (contador[0]>0) {
				respuesta.anhadirRespuesta(i,(byte)0);
				contador[0]--;
			} else if(contador[1]>0){
				respuesta.anhadirRespuesta(i,(byte)1);
				contador[1]--;
				} else{
					respuesta.anhadirRespuesta(i,(byte)2);
				}
		}
		
		return new Jugada(combinacion, respuesta);
	}
	
	/**
	 * Crea una combinación con los colores que introduce la máquina, 
	 * si es en modo fácil o medio no se repiten, pero si es en modo difícil sí.
	 * @return La combinación completa.
	 */

	Combinacion crearCombinacion() {
		Combinacion combinacion=new Combinacion(dificultad);
		Random rnd=new Random();
		HashMap<Integer, Boolean> mapa=new HashMap<>();
		int i, color;
		
		for (i = 0; i < dificultad.getCantidadColores(); i++) {
			mapa.put(i, false);
		}
		i=0;
		
		do {
			color=rnd.nextInt(dificultad.getCantidadColores());
			if (dificultad==Dificultad.DIFICIL) {
				combinacion.crearCombinacion(i, color);
				i++;
			} else {
				if (!mapa.get(color)) {
					combinacion.crearCombinacion(i, color);
					i++;
					mapa.put(color, true);
				}
			}
		} while (i<dificultad.getCantidadCasillas());
		
		return combinacion;
	}
	
}
