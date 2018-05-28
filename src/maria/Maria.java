package maria;
import java.util.Random;

import concurso.Participante;

public class Maria extends Participante{
	private Dificultad dificultad;
	private IA maquina;

    public Maria() {
        dificultad = Dificultad.DIFICIL;
        maquina = new IA(dificultad);
    }

    public byte[] crearCombPropuesta(){
    	Combinacion combinacion;
        byte [] combinacionPropuesta = new byte[dificultad.getNumFichas()];
        combinacion = maquina.crearCombinacionOculta(true);
        for(int i=0; i<dificultad.getNumFichas(); i++) {
        	combinacionPropuesta[i] = Colores.asignacionNumero(combinacion.getCombinacion().get(i).getColor());
        }
        return combinacionPropuesta;
    }

    public byte[] crearCombSecreta(){
    	Combinacion combinacion;
        byte [] combinacionSecreta = new byte[dificultad.getNumFichas()];
        combinacion = maquina.crearCombinacionOculta(true);
        for(int i=0; i<dificultad.getNumFichas(); i++) {
        	combinacionSecreta[i] = Colores.asignacionNumero(combinacion.getCombinacion().get(i).getColor());
        }
        return combinacionSecreta;
    }
}
