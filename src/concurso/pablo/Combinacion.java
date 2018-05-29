package concurso.pablo;

import java.util.Arrays;
/**
 *  La clase Combinacion se utiliza para almacenar Fichas.Estas combinaciones son la parte principal del juego MasterMind. Implementa la interfaz Dibujable y Cloneable, ya que se puede dibujar y clonar. 
 * @author pablo
 * @see Dibujable
 */
public class Combinacion implements Dibujable, Cloneable {
	private Ficha[] combinacion;

	
	/**
	 * Constructor de la clase Combinacion.
	 * @param colores Array de colores que se le pasa por parametros para crear la combinacion.
	 */
	public Combinacion(Ficha[] colores) {
		combinacion = colores;
	}

	/**
	 * @return Devuelve el array de fichas de la combinacion.
	 */
	public Ficha[] getCodigo() {
		return combinacion;
	}

	public Object clone() {
		Combinacion clonado;
		try {
			clonado = (Combinacion) super.clone();
			clonado.combinacion=combinacion.clone();
			for (int i = 0; i < combinacion.length; i++) {
				clonado.combinacion[i]=(Ficha) combinacion[i].clone();
			}
		} catch (CloneNotSupportedException e) {
			clonado=null;
		}

		return clonado;
	}

	public boolean equals(Object obj) {
		boolean resultado = false;

		if (obj instanceof Combinacion && Arrays.equals(combinacion, ((Combinacion) obj).combinacion)) {
			resultado = true;
		}
		return resultado;
	}

	@Override
	public String dibujar() {
		String cadena = "|";
		for (int i = 0; i < combinacion.length; i++) {
			cadena += String.format("%s|", combinacion[i].dibujar());
		}
		return cadena;
	}
}
