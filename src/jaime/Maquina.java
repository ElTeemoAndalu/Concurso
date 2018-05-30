package jaime;

import java.util.ArrayList;
import java.util.Random;

/**
 * Almacena el objeto del usuario maquina que va a jugar
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Maquina extends Usuario{
	
	/**
	 * Almacena un objeto tablero, la dificultad y una instancia de Jugador 
	 * 
	 */
	Tablero tableroMaquina;
	Jugador jugador;
	Dificultad dificultad;
	ArrayList<Integer> listaColoresCombinacion = new ArrayList<Integer>();
	
	/**
	 * Construye un nuevo objeto Maquina que contiene los datos de ésta según el modo en el que esté
	 * @param dificultad La dificultad en la que está en ese momento
	 */
	Maquina(Dificultad dificultad){
		this.dificultad = dificultad;
		if(dificultad == Dificultad.INDIVIDUAL) {
			dificultad.getCasilla();
			dificultad.getIntentos();
			dificultad.getColores();
			dificultad.isRepeticion();
		}else if(dificultad == Dificultad.EXPERTO) {
			dificultad.getCasilla();
			dificultad.getIntentos();
			dificultad.getColores();
			dificultad.isRepeticion();
		}else if(dificultad == Dificultad.AUTOMATICO) {
			dificultad.getCasilla();
			dificultad.getIntentos();
			dificultad.getColores();
			dificultad.isRepeticion();
		}else {
			
		}
	}

	/**
	 * Rellena la combinación secreta que tendrá que adivinar el jugador:
	 *  se crean colores aleatorios y se añaden a la combinacion, controlamos que no se repitan para los modos en los que no puede
	 *   tambien le pasamos el color al mapa jnto con la posicion en la que está
	 * y una vez creada la combinacion completamente se la pasamos al tablero
	 * @return	combinacion
	 */
	//esta combinacion es la que se le pasara al tablero del jugador
	@Override
	protected Combinacion crearCombinacionSecreta() {
		int random;
		boolean repetido = false;
		ArrayList<Integer> listaColorUtilizado= new ArrayList<Integer>();
		Random rnd = new Random();
		Combinacion combinacion = new Combinacion(dificultad);
		
		if(dificultad == Dificultad.INDIVIDUAL || dificultad == Dificultad.EXPERTO) {
			do {
				for(int i=0; i<combinacion.dificultad.getCasilla(); i++) {
					
					random = rnd.nextInt(dificultad.getColores());
					if(listaColorUtilizado.contains(random)) {
						repetido = true;
					}else {
						listaColorUtilizado.add(random);
						mapaComparacion.put(i, random);
						combinacion.añadirFicha(random,i);
					}
					
				}
			}while(repetido==true);
			
		}else {
			for(int i=0; i<combinacion.dificultad.getCasilla(); i++) {
				random = rnd.nextInt(dificultad.getColores());
				mapaComparacion.put(i, random);
				combinacion.añadirFicha(random,i);
			}
		}
		
		
		
		
		
		return combinacion;
	}

	
	@Override/*IA PROCESO DE MEJORA*/
	protected Combinacion rellenarCombinacion() {/*IA, hay que tener en cuenta la dificultad y pasarle la combinacionResultado*/
		int random;
		Random rnd = new Random();
		Combinacion combinacion = new Combinacion(dificultad);
		//este arraylist en lugar de String sera de Combinacion
		ArrayList<Combinacion> listaCombinaciones = new ArrayList<Combinacion>();
		ArrayList<Ficha> listaColoresEncontrados = new ArrayList<Ficha>();
		ArrayList<Ficha> listaColoresDescartados= new ArrayList<Ficha>();
					
			/*una vez creada la combinacion la meteremos en el arrayList, igual que hace el usuario para cuando sea maquina vs maquina*/
			
			if(listaCombinaciones.size()==0) {//si se da esta condicion quiere decir que es el primer intento, ya que no hya nada en la lista aun
				for(int j=0; j<dificultad.getCasilla(); j++) {/*1º Intento: aleatorio*/
					random = rnd.nextInt(dificultad.getColores());
					combinacion.añadirFicha(random,j);
				}
			}else {
				/*aqui sera el intento 2 o mas, por lo tanto, se coge la combinacion anterior y se cambian tanto colores como rojos halla
				 * en la combinacion respuesta*/
				
				/*desglosamos el ultimo resultado, es decir, el de la ultima combinacion*/
				Combinacion res;
				res = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()-1);/*ultima combinacionResultado*/
				int rojo = 0, negro = 0, blanco = 0;
				Ficha colorBlanco = new Ficha(dificultad, 1);
				Ficha colorRojo = new Ficha(dificultad, 2);
				
				/*obtenemos el numero de rojos, negros y blancos que hay en el resultado de la combinacion anterior*/
				for(int k=0; k<res.dificultad.getCasilla();k++) {
					if(res.combinacion[k]== colorRojo) {
						rojo ++ ;
					}else if(res.combinacion[k]== colorBlanco) {
						blanco ++;
					}else {
						negro ++ ; 
					}
				}
				
				//obtenemos la ultima combinacion, a partir de la cual vamos a trabajar
				Ficha colorAuxiliar;
				Combinacion ultimaCombinacion;
				ultimaCombinacion = listaCombinaciones.get(listaCombinaciones.size()-1);/*ultima combinacion*/
				/*segun el resultado, añadir colores usados a la lista correspondiente y crear la nueva*/
				if(rojo == dificultad.getCasilla()) {/*si todos rojos: */
					/*todos los colores de la lista anterior a la ListaColoresDescartados*/
					for(int k=0;k<ultimaCombinacion.dificultad.getCasilla();k++) {
						listaColoresDescartados.add(ultimaCombinacion.combinacion[k]);
					}
					
					//recorrer el array de colores y ver si estan en la lista de descartes, si es que no añadirlos a la de kant 
					for(int k=0;k<ultimaCombinacion.dificultad.getCasilla();k++) {
						colorAuxiliar = new Ficha(dificultad,k);
						if(listaColoresDescartados.contains(colorAuxiliar) == false) {
							listaColoresEncontrados.add(colorAuxiliar);
						}
					}
				
					/*una vez sabidos los colores que estan y los que no, generamos otra nueva combinacion*/
					for(int k =0 ; k<dificultad.getCasilla();k++) {
						/*obtenemos un numero al azar de entre los colores de la lista*/
						random = rnd.nextInt(listaColoresEncontrados.size());
						/*le pasamos a la combinacion en la posicion de k el color que hemos obtenido aleatoriamente*/
						combinacion.combinacion[k] = listaColoresEncontrados.get(random);/*una ficha al azar de este arrayLisy*/;
					}/*una vez terminado este for habra una combinacion creada*/
					
				}else if(blanco == dificultad.getCasilla()) {/*si todos blancos: */
					/*todos los colores de la lista anterior a la ListaColores */
					for(int k=0;k<ultimaCombinacion.dificultad.getCasilla();k++) {
						listaColoresEncontrados.add(ultimaCombinacion.combinacion[k]);
					}
					
					//aqui recorreria el array de colores y añadiria los que no estan en la lista de encontrados a la de no encontrados
//					for(int k=0;k<ultimaCombinacion.dificultad.getCasilla();k++) {
//						colorAuxiliar = new Ficha(dificultad,k);
//						if(listaColoresEncontrados.contains(colorAuxiliar) == false) {
//							listaColoresDescartados.add(colorAuxiliar);
//						}
//					}
				
					/*una vez sabidos los colores que estan y los que no, generamos otra nueva combinacion a partir de los colores que sabemos
					 * que estam*/
					for(int k =0 ; k<dificultad.getCasilla();k++) {
						/*obtenemos un numero al azar de entre los colores de la lista*/
						random = rnd.nextInt(listaColoresEncontrados.size());
						/*le pasamos a la combinacion en la posicion de k el color que hemos obtenido aleatoriamente*/
						combinacion.combinacion[k] = listaColoresEncontrados.get(random);/*una ficha al azar de este arrayLisy*/;
					}/*una vez terminado este for habra una combinacion creada*/
				}else if(negro == dificultad.getCasilla()) {
					/*partida finalizada
					 * aunque pensar en comparar las combinaciones antes para no tener que hacerlo, aunqe
					 * creo que no se puede pq en ningun momento se tiene acceso a la combinacionSecreta*/
					System.out.println("CONGRATS!!!!!  YOU WIN!!!!!");
				}else if(rojo == 0) {
					/*si el resultado es entre blancos y negros: */
				}else if(rojo == 1) {
					/*si solo hay un rojo, crear la misma combinacion y cambiar el ultimo color
					 * MIRAR PENULTIMA FOTO DE JUGADA*/
				}else if(rojo == 2) {
					/*si solo hay un rojo, crear la misma combinacion y cambiar el ultimo color
					 * MIRAR ULTIMA FOTO DE JUGADA*/
				}
				
				
			}/*fin del else donde comienza la 2º o n jugada*/
			
			
			tableroMaquina.añadirCombinacion(combinacion);
		
			return combinacion;

}
	/**
	 * Rellena una combinación: obtiene aleatoriamente un color y crea combinaciones de estos unicamente,
	 * asi hasta que descubra todos los colores de la combinacion, a partir de ahi, creara combinaciones con estos colores,
	 * controlando que no se repitan las combinaciones
	 * una vez creada la combinacion completamente se la pasamos al tablero
	 */
	public Combinacion crearCombinacionPrueba() {
		
		int random;
		Random rnd = new Random();
		Combinacion combinacion = new Combinacion(dificultad);
		ArrayList<Ficha> listaAuxiliar = new ArrayList<Ficha>();
		ArrayList<Ficha> listaColoresEncontrados = new ArrayList<Ficha>();
		ArrayList<Ficha> listaColoresDescartados= new ArrayList<Ficha>();
		
		Ficha aux;
		
		/*en el while: mientras este en este bucle probar combinaciones de colores individuales
		 * despues del while: probar combinaciones con los colores de la lista de encontrados*/
		while(listaColoresEncontrados.size()<dificultad.getCasilla()) {
			/*hacer un numero aleatorio que sera el color con el que se rellena la combinacion, añadirlo a la lista auxiliar
			 * asi despues si ese color esta en la lista no lo volveremos a comprobar*/
			//miramos si es el primer intento
			/*tableroMaquina.listaIntentos.size()==0 || tableroMaquina.listaIntentos == null*/
			if(listaAuxiliar.size()==0 || listaAuxiliar == null) {
				/*1º Intento: empieza probando una combinacion de un solo color de los posibles al azar*/
				random = rnd.nextInt(dificultad.getColores());
				aux = new Ficha(dificultad, random);
				listaAuxiliar.add(aux);
				for(int j=0; j<dificultad.getCasilla(); j++) {
					combinacion.añadirFicha(random,j);
					listaColoresCombinacion.add(random);
				}
				tableroMaquina = new Tablero();
				tableroMaquina.añadirCombinacion(combinacion);
			/*2º intento aleatorio pero controlando repeticion, la cantidad de combinaciones que se hacen dependera de la partida*/
			}else {
				Combinacion res = new Combinacion(dificultad);
				//if(tableroMaquina.listaResultados.size() == 0) {
					//res = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()) ; 
				//}else {
					res = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()-1) ;/*cogemos la ultima combinacionResultado*/
				//}
				
				int rojo = 0, negro = 0, blanco = 0;
				Ficha colorBlanco = new Ficha(dificultad, 1);
				Ficha colorRojo = new Ficha(dificultad, 2);
				
				/*obtenemos el numero de rojos, negros y blancos que hay en el resultado de la combinacion anterior*/
				for(int k=0; k<res.dificultad.getCasilla();k++) {
					if(res.combinacion[k]== colorRojo) {
						rojo ++ ;
					}else if(res.combinacion[k]== colorBlanco) {
						blanco ++;
					}else {
						negro ++ ; 
					}
				}
				
				//si es todo rojo querra decir que no esta
				if(rojo == dificultad.getCasilla()) {
					//si esto se da se coge el ultimo color de la lista auxiliar y se añade a la lista de descartes
					aux = listaAuxiliar.get(listaAuxiliar.size()-1);
					listaColoresDescartados.add(aux);
				//si hay dos blancos o mas, añadiremos ese color tantas vecs como blancos halla
				}else if(blanco>=2) {
					aux = listaAuxiliar.get(listaAuxiliar.size()-1);
					for(int i=0;i<blanco;i++) {
						listaColoresEncontrados.add(aux);
					}
				//si hay dos negros o mas, añadiremos ese color tantas veces como negros halla
				}else if(negro>=2) {
					aux = listaAuxiliar.get(listaAuxiliar.size()-1);
					for(int i=0;i<negro;i++) {
						listaColoresEncontrados.add(aux);
					}
				}
				
				
				/*prueba otro color de los posibles al azar, si ya se ha probado coge otro color*/
				boolean contiene = false;
				do {
					random = rnd.nextInt(dificultad.getColores());
					aux = new Ficha(dificultad, random);
					
					if(listaAuxiliar.contains(aux)) {
						contiene = true;
					}else {
						listaAuxiliar.add(aux);
						for(int j=0; j<dificultad.getCasilla(); j++) {
							combinacion.añadirFicha(random,j);
							listaColoresCombinacion.add(random);
						}
					}
				}while(!contiene);
				
				tableroMaquina.añadirCombinacion(combinacion);	
		}
		
		
	}//acaba el while principal
		
		/*una vez el tamaño de la lista es igual al tamaño de las casillas posibles
		 * con esto sabemos que todos los colores de la combinacion estan en la lista, por lo tanto,
		 * empezaremos a generar combinaciones al azar a partir de esos colores
		 * y controlaremos que las combinaciones no se repitan*/
		boolean repe = false;
		boolean posVacia = false;
		ArrayList<Integer> listaPosicionesOcupadas = new ArrayList<Integer>();
		do {
			//sacamos colores ordenadamente de la lista
			for(int i=0;i<dificultad.getCasilla();i++) {
				//comprobar que no se repita la posicion, es decir, que la posicion no esta ocupada
				do {
					//sacar un aleatorio entre 0 y el numero de casillas, es decir, nos dara una posicion al azar
					random = rnd.nextInt(dificultad.getCasilla());
					if(listaPosicionesOcupadas.contains(random)) {
						posVacia = true;
					}else {
						listaPosicionesOcupadas.add(random);
					}
				}while(posVacia==true);
				
				//colocar el color que corresponda a i en la posicion que nos de el aleatorio
				combinacion.combinacion[random] = listaColoresEncontrados.get(i);
			}
			//comprobamos que la combinacion no este ya en la lista, en ese caso crea otra
			if(tableroMaquina.listaIntentos.contains(combinacion)) {
				repe = true;
			}else {
				tableroMaquina.añadirCombinacion(combinacion);
			}
		}while(repe == true);
		

		//quitar
		tableroMaquina.añadirCombinacion(combinacion);
		
		return combinacion;

	}
	
	
	/**
	 * Rellena una combinacion que será el resultado de la secreta y la del jugador: 
	 * pedimos que cree una combinacion del tamaño de la otra con  los colores correspondientes  al resultado,
	 * una vez creada se pasa al tablero del jugador
	 */
	
	/*debe recibir combinacion que sera la de la maquina*/
	public Combinacion obtenerResultado() {
		boolean encontrado = false;
		int negro=0;
		int blanco=0;
		int rojo=0;
		Jugador ju = new Jugador(dificultad);
		Combinacion combinacionResultado = new Combinacion(dificultad);
		/*nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro 
		 *la clave va a ser la posicion en la lista del que estemos buscando y 
		 * si lo que devuelve es igual a lo que hay en la lista en esa posicion coincide color y posicino*/
			/*nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro*/
		
		//comprobamos si hay negros
		do {
			for(int j=0;j<dificultad.getCasilla();j++) {
				//si el mapa contiene el dato de la lista en j y i = j quiere decir que es el mismo color en la misma posicion, osea negro
				if(ju.mapaComparacion.containsValue(listaColoresCombinacion.get(j)) && ju.mapaComparacion.containsKey(j)) {
					negro++;
					ju.mapaComparacion.remove(j,listaColoresCombinacion.get(j));
					listaColoresCombinacion.remove(j);
					//se incrementa el contador de negros y se borra la clave y el valor del mapa y el de la lista
				}
			}
			encontrado = true;//una vez recorridas todas las posiciones, ya tiene todos los negros, por lo tanto salimos
		}while(encontrado);//este while es para que busque los negros
			
			//comprobamos los blancos, para este hace falta un bucle for doble
			for(int j=0;j<ju.mapaComparacion.size();j++) {
				for(int i=0;i<ju.mapaComparacion.size();i++) {
					if(ju.mapaComparacion.containsValue(listaColoresCombinacion.get(j)) && !ju.mapaComparacion.containsKey(j)) {
						blanco++;
						ju.mapaComparacion.remove(j,listaColoresCombinacion.get(j));
						listaColoresCombinacion.remove(j);
					}
				}
			
				
			}
			
			
		
		rojo = combinacionResultado.dificultad.getCasilla() - negro - blanco;
		for(int i=0;i< negro;i++) {
			combinacionResultado.añadirFicha(0,i);//el 0 es el color negro
		}
		for(int i=0;i< blanco;i++) {
			combinacionResultado.añadirFicha(1,i);//el 1 es el color blanco
		}
		for(int i=0;i< rojo;i++) {
			combinacionResultado.añadirFicha(2,i);//el 3 es el color rojo
		}
		//cuando se cree la combinacion del resultado se añade al tablero que lo mete en la lista de resultados
		ju.tablero.añadirRespuesta(combinacionResultado);
		/*cuando se comparen y se sepa la combinacionResultado se pasara al arrayList listaResultado*/
		return combinacionResultado;
	}
	

	
	public Combinacion IAConcurso() {
		Combinacion combIntento = new Combinacion(dificultad);
		Combinacion ultimaComb = new Combinacion(dificultad);
		ArrayList<Combinacion> listaUltimaComb = new ArrayList<Combinacion>();
		int random;
		Random rnd = new Random();
		
		for (int i = 0; i<dificultad.getCasilla(); i++) {
			random = rnd.nextInt(dificultad.getColores());
			combIntento.añadirFicha(random, i);
		}
		
		if(listaUltimaComb != null && !listaUltimaComb.isEmpty()) {
			ultimaComb = listaUltimaComb.get(listaUltimaComb.size()-1);
			
			if(ultimaComb.equals(combIntento) == true) {
				for (int i = 0; i<dificultad.getCasilla(); i++) {
					random = rnd.nextInt(dificultad.getColores());
					combIntento.añadirFicha(random, i);
				}
			}
		}
		
		return combIntento;
	}
	public static void main(String[] args) {
	Dificultad dificultad  = Dificultad.AUTOMATICO;
	Combinacion c = new Combinacion(dificultad);
//	Combinacion cRespuesta = new Combinacion(dificultad);
//	Maquina m = new Maquina(dificultad);
//	Tablero t = new Tablero();
//	
//	for (int i = 0; i < 10; i++) {
//		c = m.crearCombinacionPrueba();
//		System.out.println(c);
//		cRespuesta = m.obtenerResultado();
//	}
	Maquina m = new Maquina(dificultad);
	
	c = m.IAConcurso();
	
	c.dibujar();
	//t.añadirJugada(c, cRespuesta);
	
	//t.dibujar();

}

}
