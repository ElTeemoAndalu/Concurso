package concurso.pablo;


/**
 *  La clase Ficha se utiliza para almacenar colores que daran a su vez pie a la creacion de combinaciones. Implementa la interfaz Dibujable y Cloneable, ya que se puede dibujar y clonar. 
 * @author pablo
 * @see Dibujable
 */

public class Ficha implements Dibujable,Cloneable{
    private Colores color;


    public Ficha(Colores color){
        this.color=color;
    }

    
    /**
     * @return Devuelve el color.
     */
    public Colores getColor(){
        return color;
    }

    
    public Object clone() {
    	Ficha clonado;
    	 try {
			clonado=(Ficha) super.clone();
		} catch (CloneNotSupportedException e) {
			clonado=null;
		}
    	 return clonado;
    }
    
    
    public int hashCode() {
    	return color.hashCode();
    }
    public boolean equals(Object obj) {
        boolean resultado=false;
        if(obj instanceof Ficha && ((Ficha)obj).color==color){
            resultado=true;
        }
        return resultado;
    }
    @Override
    public String dibujar() {
        return color.getCodigo();
    }
}
