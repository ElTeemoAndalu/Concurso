package adrian;

import static adrian.Colores.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Esta clase es hija de Jugador.
 *
 * 
 * @author Adrian Mena
 * @version 2.0
 * @since 1.0
 *
 *
 */
public class Maquina extends Jugador {
	private static int numMaquina = 0;

	/**
	 * Construye un nuevo objeto Mawquina
	 * 
	 * @param modo
	 *            El modo a partir del cual se asigna a las combinaciones.
	 */
	public Maquina(Modos modo) {
		super(modo);
		numMaquina++;
		nombre = "Maquina " + numMaquina;

	}

	/**
	 * Devuelve la combinación secreta de la máquina ya rellenada.
	 * 
	 * @return Combinación Secreta
	 */
	public Combinacion rellenarCombiSecret() {
		int i;
		boolean contieneColor = false;
		Ficha ficha;
		LinkedHashSet<Ficha> listaSinRepetidos = new LinkedHashSet<>();
		for (i = 0; i < combinacionSecreta.getCasillas().length; i++) {
			do {
				ficha = new Ficha();
				ficha = elegirCombi(2);
				combinacionSecreta.getCasillas()[i] = ficha;
				if (!getModo().isColor_Repetido()) {
					if (listaSinRepetidos.contains(ficha)) {
						contieneColor = true;
					} else {
						contieneColor = false;
						listaSinRepetidos.add(ficha);
					}
				}
			} while (contieneColor);
		}
		return combinacionSecreta;
	}

	/**
	 * Devuelve una pista de aciertos y errores al rival
	 * 
	 * @param combiComprobar
	 *            Combinacion a comprobar (la secreta propia).
	 * @param combiRival
	 *            Combinación del rival a comparar con la nuestra.
	 * @return Pista de errores y aciertos de la jugada.
	 */
	public Combinacion darAciertosRival(Combinacion combiComprobar, Combinacion combiRival) {

		int i;
		int aciertoTotal = 0;
		int soloColor = 0;
		Ficha ficha;
		ArrayList<Ficha> listaSoloColor = new ArrayList<>();
		ArrayList<Ficha> listaCombi1 = new ArrayList<>();
		ArrayList<Ficha> listaCombi2 = new ArrayList<>();
		HashMap<Ficha, Integer> mapaRojos = new HashMap<>();
		Combinacion aciertoError = new Combinacion(getModo());
		for (i = 0; i < combiComprobar.getCasillas().length; i++) {
			if (combiComprobar.getCasillas()[i].equals(combiRival.getCasillas()[i])) {
				aciertoTotal++;
			} else {
				listaCombi1.add(combiComprobar.getCasillas()[i]);
				listaCombi2.add(combiRival.getCasillas()[i]);
			}
		}
		for (i = 0; i < listaCombi1.size(); i++) {
			if (!mapaRojos.containsKey(listaCombi1.get(i))) {
				mapaRojos.put(listaCombi1.get(i), 1);
			} else {
				mapaRojos.put(listaCombi1.get(i), mapaRojos.get(listaCombi1.get(i)).intValue() + 1);
			}
		}

		for (i = 0; i < listaCombi2.size(); i++) {
			if (mapaRojos.containsKey(listaCombi2.get(i))) {
				if ((mapaRojos.get(listaCombi2.get(i)).intValue() < 1)) {
					mapaRojos.remove(listaCombi2.get(i));
				} else {
					soloColor++;
					mapaRojos.put(listaCombi2.get(i), mapaRojos.get(listaCombi2.get(i)).intValue() - 1);
				}
			}
		}

		for (i = 0; i < aciertoTotal; i++) {
			ficha = new Ficha();
			ficha.setColor(NEGRO + (char) 9210 + RESET);
			listaSoloColor.add(ficha);
		}

		if (aciertoTotal < getModo().getNumCasillas()) {
			for (i = 0; i < soloColor; i++) {
				ficha = new Ficha();
				ficha.setColor(ROJO + (char) 9210 + RESET);
				listaSoloColor.add(ficha);
			}
		}

		aciertoError.setCasillas(listaSoloColor.toArray(aciertoError.getCasillas()));
		for (i = 0; i < aciertoError.getCasillas().length; i++) {
			if (aciertoError.getCasillas()[i] == null) {
				ficha = new Ficha();
				ficha.setColor(BLANCO + (char) 9210 + RESET);
				aciertoError.getCasillas()[i] = ficha;
			}
		}
		return aciertoError;
	}

	/**
	 * Devuelve la combinación Acertar de la máquina ya rellenada.
	 * 
	 * @param tablero
	 *            Recibe el tablero de la partida que se está jugadno
	 * @return Combinación a Acertar.
	 */
	public Combinacion rellenarCombinacionAcertar(TableroJugador tablero) {
		Random rnd = new Random();
		int aleatorio;
		int i;
		int j;
		boolean repetir = false;
		Combinacion combinacion = new Combinacion(modo);
		Ficha ficha;
		Ficha fichaNegra = new Ficha();
		Ficha fichaRoja = new Ficha();
		Ficha fichaBlanca = new Ficha();
		ArrayList<Combinacion> combis = new ArrayList<>();
		ArrayList<Ficha> coloresAcertados = new ArrayList<>();
		ArrayList<Ficha> coloresAcertados2 = new ArrayList<>();
		
		fichaNegra.setColor(NEGRO + (char) 9210 + RESET);
		fichaRoja.setColor(ROJO + (char) 9210 + RESET);
		fichaBlanca.setColor(BLANCO + (char) 9210 + RESET);

		if (tablero.getTablero().size() == 0) {
			ficha = new Ficha();
			ficha = elegirCombi(2);
			combinacion = new Combinacion(modo);
			for (i = 0; i < modo.getNumCasillas(); i++) {
				combinacion.getCasillas()[i] = ficha;
			}
		} else {
			for (i = 0; i < tablero.getTablero().size(); i++) {
				combis.add(tablero.getTablero().get(i).getCombinacion());
				for (j = 0; j < modo.getNumCasillas(); j++) {
					if (tablero.getTablero().get(i).getRespuesta().getCasillas()[j].equals(fichaNegra)) {
						coloresAcertados.add(tablero.getTablero().get(i).getCombinacion().getCasillas()[j]);

					}
				}
			}
			if (coloresAcertados.size() < modo.getNumCasillas()) {
				do {
					ficha = new Ficha();
					ficha = elegirCombi(2);
					combinacion = new Combinacion(modo);
					for (i = 0; i < modo.getNumCasillas(); i++) {
						combinacion.getCasillas()[i] = ficha;
					}
					if (combis.contains(combinacion) && combis.size() < 10) {
						repetir = true;
					} else {
						repetir = false;
					}
				} while (repetir);
			} else {
				// Ya están encontrados todos los colores, ahora solo falta colocarlos en las
				// posiciones correctas
				combis=new ArrayList<>();
				coloresAcertados2.addAll(coloresAcertados);
				for (i = 0; i < tablero.getTablero().size(); i++) {
					combis.add(tablero.getTablero().get(i).getCombinacion());
				}
				do {
				for (i = 0; i < modo.getNumCasillas(); i++) {
					aleatorio = rnd.nextInt(coloresAcertados.size());
					combinacion.getCasillas()[i] = coloresAcertados.get(aleatorio);
					coloresAcertados.remove(aleatorio);
					
				}
				coloresAcertados.addAll(coloresAcertados2);
				}while(combis.contains(combinacion));
			}
		}

		setAcertarCombinacion(combinacion);
		return acertarCombinacion;
	}

}
