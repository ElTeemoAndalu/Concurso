package concurso.pablo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class Maquina extends Jugador {
    // ATRIBUTO QUE SERA UTILIZADO EN LA INTRODUCCION DEL CODIGO.
    private ArrayList<Ficha> fichasAcertadas = new ArrayList<>();
    private LinkedList<Integer> posicionesUtilizadas = new LinkedList<>();
    private ArrayList<Ficha> fichasUtilizados = new ArrayList<>();
    int fichasNegrasTotales = 0;

    public Maquina(String nombre, Dificultad dificultad) {
        super(nombre, dificultad);
    }

    protected Ficha pedirFicha() {
        Random rnd = new Random();
        Colores color = Colores.SC;
        int numero;

        if (dificultad == Dificultad.DIFICIL) {
            numero = rnd.nextInt(10);
        } else {
            numero = rnd.nextInt(8);
        }

        switch (numero) {
            case 0:
                color = Colores.AZUL;
                break;
            case 1:
                color = Colores.AMARILLO;
                break;
            case 2:
                color = Colores.VERDE;
                break;
            case 3:
                color = Colores.ROJO;
                break;
            case 4:
                color = Colores.ROSA;
                break;
            case 5:
                color = Colores.CELESTE;
                break;
            case 6:
                color = Colores.MARRON;
                break;
            case 7:
                color = Colores.NARANJA;
                break;
            case 8:
                color = Colores.GRIS;
                break;
            case 9:
                color = Colores.LILA;
                break;

        }
        return new Ficha(color);
    }

    @Override
    public void introducirCodigoPrivado() {
        tablero.setCombinacionOculta(crearCombinacionAzar());
    }

    private Combinacion crearCombinacionAzar() {
        ArrayList<Ficha> fichas = new ArrayList<>();
        Colores ficha;
        for (int i = 0; i < dificultad.getNumeroCasillas(); i++) {
            if (dificultad != Dificultad.DIFICIL) {
                do {
                    ficha = pedirFicha().getColor();
                } while (fichas.contains(new Ficha(ficha)));
                fichas.add(new Ficha(ficha));
            } else {
                fichas.add(new Ficha(pedirFicha().getColor()));
            }
        }
        return new Combinacion(fichas.toArray(new Ficha[fichas.size()]));
    }

    
//    Dependiendo de la combinacion ultima y la posicion seleccionada, introduce una ficha u otra.
    private void seleccionarFicha(Combinacion combinacion, int posicion) {
        Ficha ficha = null;
        boolean encontrado = false;

        if (!fichasUtilizados.contains(combinacion.getCodigo()[posicion])) {
            fichasUtilizados.add(combinacion.getCodigo()[posicion]);
        }

        do {
            ficha = pedirFicha();
            if (!(fichasUtilizados.contains(ficha) && !(fichasAcertadas.contains(ficha)))) {
                encontrado = true;
            }
        } while (!encontrado);
        fichasUtilizados.add(ficha);
        combinacion.getCodigo()[posicion] = ficha;
    }

    //Introduce un codigo. La primera ugada es aleatoria, las siguientes dependiendo de la combinacion respuesta resultante de dicha jugada, va comprobando las respuestas hasta conseguir la combinacion oculta.
    @Override
    public Combinacion introducirCodigo(boolean respuesta) {
        Combinacion combinacion = null;
        Random rnd = new Random();
        int fichasNegras = 0;
        int posicion;


        if (tablero.getTableroCombinaciones().size() == 0) {
            combinacion = crearCombinacionAzar();
        } else {
            // Calcular Las fichas Negras en la ultima introducida
            for (int j = 0; j < tablero.getTableroCombinaciones().getFirst()[1].getCodigo().length; j++) {
                if (tablero.getTableroCombinaciones().getFirst()[1].getCodigo()[j].equals(new Ficha(Colores.NEGRO))) {
                    fichasNegras++;
                }
            }
            //Si todavia no he utilizado ninguna posicion, cambiamos el color de esta en la combinacion elegida


            if (posicionesUtilizadas.isEmpty()) {
                fichasNegrasTotales = fichasNegras;
                posicion = rnd.nextInt(dificultad.getNumeroCasillas());
                posicionesUtilizadas.addFirst(posicion);
                combinacion = (Combinacion) tablero.getTableroCombinaciones().getFirst()[0].clone();
                seleccionarFicha(combinacion, posicion);
            } else {
                //Si hemos utilizado posiciones y tengo mas negras que antes, cogemos una nueva posicion y cambiamos un color de la misma.
                if (fichasNegrasTotales < fichasNegras) {
                    fichasNegrasTotales = fichasNegras;
                    fichasAcertadas.add(tablero.getTableroCombinaciones().getFirst()[0].getCodigo()[posicionesUtilizadas.getFirst()]);

                    do {
                        fichasUtilizados.clear();
                        posicion = rnd.nextInt(dificultad.getNumeroCasillas());
                    } while (posicionesUtilizadas.contains(posicion));
                    posicionesUtilizadas.addFirst(posicion);
                    combinacion = (Combinacion) tablero.getTableroCombinaciones().getFirst()[0].clone();
                    fichasUtilizados.clear();
                    seleccionarFicha(combinacion, posicion);
                    //Si tengo las mismas negras que antes seguimos cambiando colores
                } else if (fichasNegrasTotales == fichasNegras) {
                    combinacion = (Combinacion) tablero.getTableroCombinaciones().getFirst()[0].clone();
                    seleccionarFicha(combinacion, posicionesUtilizadas.getFirst());
                    //Si tengo menos negras que antes, introduzco el color anterior y cambio de posicion.
                } else if (fichasNegrasTotales > fichasNegras) {
                    combinacion = (Combinacion) tablero.getTableroCombinaciones().getFirst()[0].clone();
                    combinacion.getCodigo()[posicionesUtilizadas.getFirst()] = fichasUtilizados.get(fichasUtilizados.size() - 2);
                    do {
                        fichasUtilizados.clear();
                        posicion = rnd.nextInt(dificultad.getNumeroCasillas());
                    } while (posicionesUtilizadas.contains(posicion));
                    posicionesUtilizadas.addFirst(posicion);
                }
            }
        }
        return combinacion;
    }

    /* Utilizo el metodo del padre que comprueba automaticamente todas las fichas */
    @Override
    public Combinacion comprobarColores(Combinacion filaIntroducida) {
        Combinacion respuesta;


        ArrayList<Ficha> combinacionRespuesta = new ArrayList<>();
        ArrayList<Integer> fichasNegrasUtilizadas = new ArrayList<>();
        ArrayList<Integer> fichasTotalesUtilizadas = new ArrayList<>();
        boolean comprobado = false;
        Colores color = Colores.SC;

        // COMPROBAMOS LAS NEGRAS
        for (int i = 0; i < filaIntroducida.getCodigo().length; i++) {
            if (filaIntroducida.getCodigo()[i].equals(tablero.getCombinacionOculta().getCodigo()[i])) {
                combinacionRespuesta.add(new Ficha(Colores.NEGRO));
                fichasNegrasUtilizadas.add(i);
            }
        }

        fichasTotalesUtilizadas.addAll(fichasNegrasUtilizadas);
        // SEPARAMOS NEGRAS DE BLANCAS

        for (int i = 0; i < filaIntroducida.getCodigo().length; i++) {
            if (!fichasNegrasUtilizadas.contains(i)) {
                for (int j = 0; j < filaIntroducida.getCodigo().length && !comprobado; j++) {
                    if (!fichasTotalesUtilizadas.contains(j)) {
                        if (filaIntroducida.getCodigo()[i].equals(tablero.getCombinacionOculta().getCodigo()[j])) {
                            color = Colores.BLANCO;
                            fichasTotalesUtilizadas.add(j);
                            comprobado = true;
                        } else {
                            color = Colores.SC;
                        }
                    }
                }
                combinacionRespuesta.add(new Ficha(color));
                comprobado = false;
            }
        }

        combinacionRespuesta.sort(new Comparator<Ficha>() {
            @Override
            public int compare(Ficha o1, Ficha o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        respuesta = new Combinacion(combinacionRespuesta.toArray(new Ficha[combinacionRespuesta.size()]));

        // MODO MEDIO Y FACIL

        return respuesta;
    }
}
