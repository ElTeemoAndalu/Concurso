package concurso.pablo;

import concurso.pablo.Teclado.Incluido;
import concurso.pablo.Teclado.Tipos;

import java.util.ArrayList;
import java.util.Comparator;

public class Humano extends Jugador {
	/**
	 * 
	 * @param nombre
	 * @param dificultad
	 */
	
    public Humano(String nombre, Dificultad dificultad) {
        super(nombre, dificultad);
    }


    protected Ficha pedirFicha(boolean respuesta) {
        Ficha ficha = null;
        if(!respuesta) {
            System.out.printf("Selecciona uno de los siguientes colores:%n1-Rojo: %s%n2-Verde: %s%n3-Amarillo: %s%n4-Azul: %s%n5-Marron: " +
                    "%s%n6-Celeste: %s%n7-Rosa: %s%n8-Naranja: %s%n", Colores.ROJO.getCodigo(),Colores.VERDE.getCodigo(),Colores.AMARILLO.getCodigo(),Colores.AZUL.getCodigo(),Colores.MARRON.getCodigo(),Colores.CELESTE.getCodigo(),Colores.ROSA.getCodigo(),Colores.NARANJA.getCodigo());
            switch(Teclado.leerEntre(1,8,Incluido.TODOS,Tipos.INT)){
                case 1:
                    ficha=new Ficha(Colores.ROJO);
                    break;
                case 2:
                    ficha=new Ficha(Colores.VERDE);
                    break;
                case 3:
                    ficha=new Ficha(Colores.AMARILLO);
                    break;
                case 4:
                    ficha=new Ficha(Colores.AZUL);
                    break;
                case 5:
                    ficha=new Ficha(Colores.MARRON);
                    break;
                case 6:
                    ficha=new Ficha(Colores.CELESTE);
                    break;
                case 7:
                    ficha=new Ficha(Colores.ROSA);
                    break;
                case 8:
                    ficha=new Ficha(Colores.NARANJA);
                    break;
            }
        }else{
            System.out.printf("%nSelecciona uno de los siguientes colores:%n1-Color en posicion correcta: " +
                    "%s%n2-Color en codigo sin posicion correcta: %s%n3-Color no en el codigo: %s%n",Colores.NEGRO.getCodigo(),Colores.BLANCO.getCodigo(),Colores.SC.getCodigo());
            switch(Teclado.leerEntre(1,3,Incluido.TODOS,Tipos.INT)){
                case 1:
                    ficha=new Ficha(Colores.NEGRO);
                    break;
                case 2:
                    ficha=new Ficha(Colores.BLANCO);
                    break;
                case 3:
                    ficha=new Ficha(Colores.SC);
                    break;
            }
        }

        return ficha;
    }

    @Override
	public void introducirCodigoPrivado() {
        boolean resultado = true;
        System.out.println("\nIntroducimos el codigo privado a averiguar:\n");
        do {
            tablero.setCombinacionOculta(introducirCodigo(false));
            if (tablero.getCombinacionOculta() != null)
                resultado = false;
        } while (resultado);
    }

    @Override
    public Combinacion introducirCodigo(boolean respuesta) {
        ArrayList<Ficha> fichas = new ArrayList<>();
        Colores ficha;
        System.out.printf("Introduce una combinacion de %d fichas:%n%n",dificultad.getNumeroCasillas());
        for(int i = 0; i<dificultad.getNumeroCasillas();i++){
            do {
                ficha=pedirFicha(false).getColor();
                if(fichas.contains(new Ficha(ficha))){
                    
                
                    System.out.println("\nNo se puede repetir el color de la combinacion.\n");
                    System.out.print("Combinacion actual: ");
                    for(Ficha fi:fichas) {
                        System.out.printf("|%s",fi.dibujar());
                    }
                    System.out.println(fichas.size()==0?"Vacio\n":"|\n");
                }
            }while(fichas.contains(new Ficha(ficha)));
            
            fichas.add(new Ficha(ficha));
            System.out.print("Coombinacion actual: ");
            for(Ficha fi:fichas) {
                System.out.printf("|%s",fi.dibujar());
            }
            System.out.println(fichas.size()==0?"Vacio\n":"|\n");
        
        }
        return new Combinacion(fichas.toArray(new Ficha[fichas.size()]));
    }


    @Override
    public Combinacion comprobarColores(Combinacion filaIntroducida) {
        Combinacion respuestaAutomatica=super.comprobarColoresAuto(filaIntroducida);
        ArrayList<Ficha> combinacion = new ArrayList<>();

        do {
        	//Limpio el array antes de volver a hacerlo
        	combinacion.clear();
            System.out.println("Colores a introducir:");
            System.out.println(respuestaAutomatica.dibujar());


            for(int i = 0;i<filaIntroducida.getCodigo().length;i++) {
                System.out.printf("Color: %s Posicion: %d%n",filaIntroducida.getCodigo()[i].dibujar(),i+1);
                System.out.printf("Codigo: %s%n",tablero.getCombinacionOculta().dibujar());
                combinacion.add(pedirFicha(true));
            }
            combinacion.sort(new Comparator<Ficha>(){
                @Override
                public int compare(Ficha o1, Ficha o2) {
                    return  o1.getColor().compareTo(o2.getColor());
                }
            });

            if(!respuestaAutomatica.equals(new Combinacion(combinacion.toArray(new Ficha[combinacion.size()])))){
                System.out.println("Error, vuelva a empezar.");
            }else{
                System.out.println("Respuesta introducida correctamente.");
            }

        }while(!respuestaAutomatica.equals(new Combinacion(combinacion.toArray(new Ficha[combinacion.size()]))));
        return new Combinacion( combinacion.toArray(new Ficha[combinacion.size()]));
    }
}
