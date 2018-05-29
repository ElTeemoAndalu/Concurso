package maria;

import java.util.HashMap;
import java.util.Random;

/**
 * Clase hija de Jugador, que corresponde con la Inteligencia Artifical del juego.
 * @author María Muñoz-Cruzado
 * @since 1.0
 * @version 1.0
 */
public class IA extends Jugador {
    private HashMap<Integer, String> mapa = new HashMap<>(); //El mapa se utiliza para no tener repeticion de colores (Fichas)
    private HashMap<String, Integer> coloresCombinacion = new HashMap<>(); //Lo usamos para guardar cuantas veces sale un color
    private Ficha fichaNoColor = null;
    private boolean noColor = false;
    private Ficha ficha = null;
    private int numIntentos = 0;
    private int numColores = 0;

    public IA(Dificultad dificultad) {
        super(dificultad);
    }

    public Combinacion adivinarCombinacionOculta() { //SIN TERMINAR
        boolean fichaColor = false;
        int posicionPosible = 0;
        Combinacion combinacionMaquina = new Combinacion(dificultad);

        if (dificultad == Dificultad.DIFICIL) {
            //Compruebo cual es la primer color que no hay
            if (!noColor && !mapaAciertos.isEmpty() && numeroAciertosCompletos() == 0) {
                fichaNoColor = tablero.getCombinacion(numIntentos - 1).obtenerFichaCombinacion(0);
                noColor = true;
            }
            //Compruebo el número de aciertos completos de la combinacion anterior
            if(numIntentos>0){
                coloresCombinacion.put(ficha.getColor(), numeroAciertosCompletos());
            }
            for (int i = 0; i < dificultad.getNumFichas(); i++) {
                if (numIntentos < dificultad.getNumColores()) {
                    ficha = new Ficha(Colores.asignacionColores(numIntentos, dificultad));
                    combinacionMaquina.agregarFicha(ficha);
                } else {
                    if (coloresCombinacion.containsKey(Colores.asignacionColores(posicionPosible, dificultad)) && i < coloresCombinacion.get(Colores.asignacionColores(numColores, dificultad))) {
                        combinacionMaquina.agregarFicha(posicionPosible, new Ficha(Colores.asignacionColores(numColores, dificultad)));
                        if (!tablero.getRespuestas().isEmpty() && tablero.obtenerRespuestaTablero(numIntentos-1).obtenerFichaCombinacion(0).compararColor(Colores.COLOR)) {
                            combinacionMaquina.agregarFicha(posicionPosible + 1, new Ficha(Colores.asignacionColores(numColores, dificultad)));
                            posicionPosible++;
                        }
                    } else {
                        combinacionMaquina.agregarFicha(fichaNoColor);
                    }
                    numColores++;
                }
            }
            numIntentos++;
        }
        return combinacionMaquina;
    }

    /**
     * Crea una combinación oculta de manera aleatoria.
     * @param conRepeticion si es true crea una combinacion con repeticiones y sino sin ellas.
     * @return Combinacion
     */
    public Combinacion crearCombinacionOculta(boolean conRepeticion) {
        int colorAleatorio;
        Random aleatorio = new Random();
        Combinacion combinacionOculta = new Combinacion(dificultad);
        for (int i = 0; i < dificultad.getNumFichas(); i++) {
            if (!conRepeticion) {
                colorAleatorio = aleatorio.nextInt(dificultad.getNumColores()) + 1;
                if (!mapa.containsKey(colorAleatorio)) {
                    mapa.put(colorAleatorio, Colores.asignacionColores(colorAleatorio, dificultad));
                    combinacionOculta.agregarFicha(new Ficha(Colores.asignacionColores(colorAleatorio, dificultad)));
                } else {
                    i--;
                }
            } else {
                colorAleatorio = aleatorio.nextInt(dificultad.getNumColores());
                combinacionOculta.agregarFicha(new Ficha(Colores.asignacionColores(colorAleatorio, dificultad)));
            }
        }
        mapa.clear();
        return combinacionOculta;
    }
}
