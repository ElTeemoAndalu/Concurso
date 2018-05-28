package lolo;

public class Jugada implements Dibujable{
	private Combinacion combinacion;
	private Respuesta respuesta;
	
	Jugada(Combinacion combinacion, Respuesta respuesta, Modo modo) {
		this.combinacion = combinacion;
		this.respuesta = respuesta;
	}

	public Combinacion getCombinacion() {
		return combinacion;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	
	public void dibujar() {
		combinacion.dibujar();
		System.out.print("| ");
		respuesta.dibujar();
	}
	
}
