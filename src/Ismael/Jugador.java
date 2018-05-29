package Ismael;

import java.util.ArrayList;

/**
 * Esta clase abstracta representa a los jugadores de la partida (usuarios y máquinas), almacena 2 objetos Combinacion, un objeto enum y un número int
 * 
 * @author Ismael Raqi Picardo
 * @version 1.0
 * @since 1.0
 *
 */
public abstract class Jugador {

	/**
	 * Almacena un objeto Combinacion que representa la combinación secreta del jugador
	 */
	public Combinacion combSecreta;
	/**
	 * Almacena un objeto Combinacion que representa la combinación con la que va a intentar adivinar la del rival
	 */
	public Combinacion combRespuesta;
	/**
	 * Almacena un enum Modos indicando que tipo de partida se está jugando
	 */
	private Modos modo;
	/**
	 * Almacena un número int que lleva la cuenta de los intentos del jugador
	 */
	private int intentos;

	/**
	 * Construye un nuevo objeto Jugador que contiene los 2 objetos Combinacion, un enum y un número
	 * @param modo  El modo que determinará los intentos del jugador
	 */
	protected Jugador(Modos modo) {
		if (modo == Modos.FACIL) {
			intentos = 10;
			this.modo = modo;
		} else if (modo == Modos.MEDIO) {
			intentos = 15;
			this.modo = modo;
		} else {
			intentos = 0;
			this.modo = modo;
		}
	}
	
	/**
	 * Método get del atributo modo
	 * @return		Modos		Modo del enum Modos
	 */
	protected Modos getModo() {
		return modo;
	}
	
	/**
	 * Método get del atributo combSecreta
	 * @return		combSecreta	Objeto de la clase Combinacion que será el atributo combSecreta
	 */
	protected Combinacion getCombSecreta() {
		return combSecreta;
	}
	
	/**
	 * Método set del atributo combSecreta
	 * @param		combSecreta		Objeto de la clase Combinacion que será el atributo combSecreta
	 */
	protected void setCombSecreta(Combinacion combSecreta) {
		this.combSecreta = combSecreta;
	}
	
	/**
	 * Método get del atributo combRespuesta
	 * @return		combRespuesta		Objeto de la clase Combinacion que será el atributo combRespuesta
	 */
	protected Combinacion getCombRespuesta() {
		return combRespuesta;
	}
	
	/**
	 * Método set del atributo combRespuesta
	 * @param		combRespuesta	Objeto de la clase Combinacion que será el atributo combRespuesta
	 */
	protected void setCombRespuesta(Combinacion combRespuesta) {
		this.combRespuesta = combRespuesta;
	}
	
	/**
	 * Método get del atributo intentos
	 * @return		intentos		Número que representan los intentos restantes (modo fácil y medio) y el intento actual (modo difícil)
	 */
	protected int getIntentos() {
		return intentos;
	}
	
	/**
	 * Método set del atributo intentos
	 * @param		intentos		Número que representan los intentos restantes (modo fácil y medio) y el intento actual (modo difícil)
	 */
	protected void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	
	/**
	 * Compara el atributo combSecreta con el combRespuesta del contrincante
	 * @param 		contrincante	La combRespuesta del contrincante
	 * @return 		true: si son iguales. 
	 * 				false: si son diferentes.
	 */
	protected boolean comprobarCombinacion(Combinacion contrincante) {
		boolean igual = true;

		for (int i = 0; i < modo.getCasillas(); i++) {
			if (!combSecreta.getCombinacion()[i].getColor().equals(contrincante.getCombinacion()[i].getColor())) {
				igual = false;
			}
		}
		return igual;
	}

	/**
	 * Método abstracto que devuelve un objeto Combinacion
	 * @return		Combinacion		Objeto de la clase Combinacion que luego será el atributo combSecreta
	 */
	abstract Combinacion generarCombinacion();

	/**
	 * Método abstracto que dibuja en consola un objeto Combinacion
	 */
	abstract void dibujarCombinacionSecreta();

	/**
	 * Devuelve un objeto Combinacion con la pista resultante de la combSecreta y la CombRespuesta del contrincante
	 * @param		contrincante	El objeto Jugador, que es el contrincante de el Jugador que llama al método
	 * @return		pista		Un objeto Combinacion con la pista
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Combinacion generarPista(Jugador contrincante) {

		Casilla[] pintado = new Casilla[modo.getCasillas()];
		int i = 0, negro = 0, rojo = 0;
		Casilla[] respuesta = new Casilla[modo.getCasillas()];
		ArrayList<String> lista1 = new ArrayList();
		ArrayList<String> lista2 = new ArrayList();

		Combinacion comb = new Combinacion(modo);
		int colores1[] = new int[modo.getColores()];
		int colores2[] = new int[modo.getColores()];


		// for (i=0;i<modo.colores;i++) {
		// colores[i] ++;
		// }

		for (i = 0; i < contrincante.combRespuesta.getCombinacion().length; i++) {
			if (!lista1.contains(contrincante.combRespuesta.getCombinacion()[i].getColor())) {
				lista1.add(contrincante.combRespuesta.getCombinacion()[i].getColor());
				if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.NEGRO + "  " + Colores.RESET)) {
					colores1[0] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.ROJO + "  " + Colores.RESET)) {
					colores1[1] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.VERDE + "  " + Colores.RESET)) {
					colores1[2] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.AMARILLO + "  " + Colores.RESET)) {
					colores1[3] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.AZUL + "  " + Colores.RESET)) {
					colores1[4] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.MORADO + "  " + Colores.RESET)) {
					colores1[5] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.CELESTE + "  " + Colores.RESET)) {
					colores1[6] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.BLANCO + "  " + Colores.RESET)) {
					colores1[7] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.VERDECLARO + "  " + Colores.RESET)) {
					colores1[8] ++;
				}else if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.ROSA + "  " + Colores.RESET)) {
					colores1[9] ++;
				}
			} else {
				if (contrincante.combRespuesta.getCombinacion()[i].getColor().equals(Colores.NEGRO + "  " + Colores.RESET)) {
					colores1[0]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.ROJO + "  " + Colores.RESET)) {
					colores1[1]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.VERDE + "  " + Colores.RESET)) {
					colores1[2]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.AMARILLO + "  " + Colores.RESET)) {
					colores1[3]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.AZUL + "  " + Colores.RESET)) {
					colores1[4]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.MORADO + "  " + Colores.RESET)) {
					colores1[5]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.CELESTE + "  " + Colores.RESET)) {
					colores1[6]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.BLANCO + "  " + Colores.RESET)) {
					colores1[7]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.VERDECLARO + "  " + Colores.RESET)) {
					colores1[8]++;
				} else if (contrincante.combRespuesta.getCombinacion()[i].getColor()
						.equals(Colores.ROSA + "  " + Colores.RESET)) {
					colores1[9]++;
				}
			}

		}

		for (i = 0; i < combSecreta.getCombinacion().length; i++) {
			if (!lista2.contains(combSecreta.getCombinacion()[i].getColor())) {
				lista2.add(combSecreta.getCombinacion()[i].getColor());
				if (combSecreta.getCombinacion()[i].getColor().equals(Colores.NEGRO + "  " + Colores.RESET)) {
					colores2[0] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.ROJO + "  " + Colores.RESET)) {
					colores2[1] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.VERDE + "  " + Colores.RESET)) {
					colores2[2] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.AMARILLO + "  " + Colores.RESET)) {
					colores2[3] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.AZUL + "  " + Colores.RESET)) {
					colores2[4] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.MORADO + "  " + Colores.RESET)) {
					colores2[5] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.CELESTE + "  " + Colores.RESET)) {
					colores2[6] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.BLANCO + "  " + Colores.RESET)) {
					colores2[7] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.VERDECLARO + "  " + Colores.RESET)) {
					colores2[8] ++;
				}else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.ROSA + "  " + Colores.RESET)) {
					colores2[9] ++;
				}
			} else {
				if (combSecreta.getCombinacion()[i].getColor().equals(Colores.NEGRO + "  " + Colores.RESET)) {
					colores2[0]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.ROJO + "  " + Colores.RESET)) {
					colores2[1]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.VERDE + "  " + Colores.RESET)) {
					colores2[2]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.AMARILLO + "  " + Colores.RESET)) {
					colores2[3]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.AZUL + "  " + Colores.RESET)) {
					colores2[4]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.MORADO + "  " + Colores.RESET)) {
					colores2[5]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.CELESTE + "  " + Colores.RESET)) {
					colores2[6]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.BLANCO + "  " + Colores.RESET)) {
					colores2[7]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.VERDECLARO + "  " + Colores.RESET)) {
					colores2[8]++;
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.ROSA + "  " + Colores.RESET)) {
					colores2[9]++;
				}
			}

		}

		for (i = 0; i < modo.getCasillas(); i++) {
			if (contrincante.combRespuesta.getCombinacion()[i].equals(combSecreta.getCombinacion()[i])) {
				negro++;
			} else {

				if (combSecreta.getCombinacion()[i].getColor().equals(Colores.NEGRO + "  " + Colores.RESET)) {
					if (colores1[0] > 0 && colores2[0] > 0) {
						colores1[0]--;
						colores2[0]--;
						rojo++;
					}					
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.ROJO + "  " + Colores.RESET)) {
					if (colores1[1] > 0 && colores2[1] > 0) {
						colores1[1]--;
						colores2[1]--;
						rojo++;
					}
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.VERDE + "  " + Colores.RESET)) {
					if (colores1[2] > 0 && colores2[2] > 0) {
						colores1[2]--;
						colores2[2]--;
						rojo++;
					}
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.AMARILLO + "  " + Colores.RESET)) {
					if (colores1[3] > 0 && colores2[3] > 0) {
						colores1[3]--;
						colores2[3]--;
						rojo++;
					}
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.AZUL + "  " + Colores.RESET)) {
					if (colores1[4] > 0 && colores2[4] > 0) {
						colores1[4]--;
						colores2[4]--;
						rojo++;
					}
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.MORADO + "  " + Colores.RESET)) {
					if (colores1[5] > 0 && colores2[5] > 0) {
						colores1[5]--;
						colores2[5]--;
						rojo++;
					}
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.CELESTE + "  " + Colores.RESET)) {
					if (colores1[6] > 0 && colores2[6] > 0) {
						colores1[6]--;
						colores2[6]--;
						rojo++;
					}
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.BLANCO + "  " + Colores.RESET)) {
					if (colores1[7] > 0 && colores2[7] > 0) {
						colores1[7]--;
						colores2[7]--;
						rojo++;
					}
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.VERDECLARO + "  " + Colores.RESET)) {
					if (colores1[8] > 0 && colores2[8] > 0) {
						colores1[8]--;
						colores2[8]--;
						rojo++;
					}
				} else if (combSecreta.getCombinacion()[i].getColor().equals(Colores.ROSA + "  " + Colores.RESET)) {
					if (colores1[9] > 0 && colores2[9] > 0) {
						colores1[9]--;
						colores2[9]--;
						rojo++;
					}
				}
			}
		}

		for (i = 0; i < negro; i++) {
			respuesta[i] = new Casilla(Colores.NEGRO + "  " + Colores.RESET);
		}
		rojo += i;
		
		for (; i < rojo; i++) {
			respuesta[i] = new Casilla(Colores.ROJO + "  " + Colores.RESET);
		}
		for (; i < modo.getCasillas(); i++) {
			respuesta[i] = new Casilla(Colores.BLANCO + "  " + Colores.RESET);
		}

		for (i = 0; i < modo.getCasillas(); i++) {
			pintado[i] = respuesta[i];
		}
		comb.setCombinacion(pintado);

		return comb;
	}

}
