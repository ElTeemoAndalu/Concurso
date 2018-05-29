package concurso.pablo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase Jugador abstracta que posee metodos abstractos que son sobreescritos en sus hijos. Es padre de las clases Maquina y Humano.
 * @author pablo
 *
 */
public abstract class Jugador {
    protected String nombre;
    protected Dificultad dificultad;
    protected Tablero tablero;


    /**
     * Constructor de Jugador.
     * @param nombre Nombre del jugador 
     * @param dificultad Dificultad utilizada por el jugador.
     */
    public Jugador(String nombre, Dificultad dificultad) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        tablero = new Tablero(dificultad);
    }

    /**
     * @return Devuelve el nombre del Jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Devuelve el tablero del jugador.
     */
    public Tablero getTablero() {
        return tablero;
    }


    /**
     * Metodo abstracto. Sera desarrollado en los hijos. Crea el codigo privado del jugador.
     */
    public abstract void introducirCodigoPrivado();
    
    /**
     * @return Devuelve la dificultad guardada en el jugador.
     */
    public Dificultad getDificultad() {
    	return dificultad;
    }

   
    /**
     * Metodo que hace la comprobacion de la combinacion introducida con la combinacion oculta.
     * @param filaIntroducida combinacion introducida por el otro jugador.
     * @return devuelve una combinacion respuesta.
     */
    protected Combinacion comprobarColoresAuto(Combinacion filaIntroducida) {
        ArrayList<Ficha> combinacionRespuesta=new ArrayList<>();
        Colores color=Colores.SC;
        boolean comprobado=true;
        for(int i = 0; i < filaIntroducida.getCodigo().length;i++) {
            comprobado=false;
            for(int j = 0; j<filaIntroducida.getCodigo().length && !comprobado;j++){
                if(filaIntroducida.getCodigo()[j].equals(tablero.getCombinacionOculta().getCodigo()[i]) && i==j){
                    color=Colores.NEGRO;
                    comprobado=true;
                }else if(filaIntroducida.getCodigo()[j].equals(tablero.getCombinacionOculta().getCodigo()[i])){
                    color=Colores.BLANCO;
                    comprobado=true;
                }else{
                    color=Colores.SC;
                }
            }
            combinacionRespuesta.add(new Ficha(color));
        }

        combinacionRespuesta.sort(new Comparator<Ficha>(){
            @Override
            public int compare(Ficha o1, Ficha o2) {
                return  o1.getColor().compareTo(o2.getColor());
            }
        });

        return new Combinacion(combinacionRespuesta.toArray(new Ficha[combinacionRespuesta.size()]));
    }


    /*Devuelve un codigo de colores, si es de respuesta solo pueden utilizar blanco, negro y SC,
    de lo contrario puede utilizar todos los colores disponibles menos esos tres*/
    public abstract Combinacion introducirCodigo(boolean respuesta);


    /*Metodo que comprueba si ha acertado o no. Devuelve un array de colores*/
    public abstract Combinacion comprobarColores(Combinacion filaIntroducida);

}
