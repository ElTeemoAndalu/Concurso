package lolo;

public class Ficha implements Dibujable {
	private Color color;

	Ficha(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Ficha && color.equals(((Ficha)obj).color))
				resultado=true;
		return resultado;		
	}

	public void dibujar() {
		System.out.printf("%s ", color.getCodigo()+Constantes.CIRCULO+Colores.RESET );
	}
	
	
}
