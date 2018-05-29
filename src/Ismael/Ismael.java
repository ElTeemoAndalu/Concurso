package Ismael;

public class Ismael extends Participante{

	Maquina maquina = new Maquina(Modos.DIFICIL);
	Tablero tablero = new Tablero();
	
	@Override
	public byte[] crearCombPropuesta() {
		byte comb[] = new byte[Modos.DIFICIL.getCasillas()];
		Combinacion aux = new Combinacion(Modos.DIFICIL);
		
		aux = maquina.IA(tablero);
		
		tablero.añadirAlTablero(aux, traducirByte(resultado));
		
		for (int i=0; i<Modos.DIFICIL.getCasillas();i++) {
			comb[i] = traducirColor(aux.combinacion[i].getColor());
		}
		return comb;
	}

	@Override
	public byte[] crearCombSecreta() {

		byte comb[] = new byte[Modos.DIFICIL.getCasillas()];
		Combinacion aux = new Combinacion(Modos.DIFICIL);
		
		aux = maquina.generarCombinacion();
		
		for (int i=0; i<Modos.DIFICIL.getCasillas();i++) {
			comb[i] = traducirColor(aux.combinacion[i].getColor());
		}
		return comb;
	}

	
	
	@SuppressWarnings("unused")
	private byte traducirColor(String color) {
		byte traduccion = 0;

		switch (color) {
		case Colores.NEGRO + "  " + Colores.RESET:
			traduccion = 0;
			break;
		case Colores.ROJO + "  " + Colores.RESET:
			traduccion = 1;
			break;
		case Colores.VERDE + "  " + Colores.RESET:
			traduccion = 2;
			break;
		case Colores.AMARILLO + "  " + Colores.RESET:
			traduccion = 3;
			break;
		case Colores.AZUL + "  " + Colores.RESET:
			traduccion = 4;
			break;
		case Colores.MORADO + "  " + Colores.RESET:
			traduccion = 5;
			break;
		case Colores.CELESTE + "  " + Colores.RESET:
			traduccion = 6;
			break;
		case Colores.BLANCO + "  " + Colores.RESET:
			traduccion = 7;
			break;
		case Colores.VERDECLARO + "  " + Colores.RESET:
			traduccion = 8;
			break;
		case Colores.ROSA + "  " + Colores.RESET:
			traduccion = 9;
			break;

		}
		return traduccion;
	}
	
	@SuppressWarnings("unused")
	private Combinacion traducirByte(byte num[]) {
		Combinacion comb = new Combinacion(Modos.DIFICIL);
		int i;
		
		for (i = 0; i < num[0]; i++) {
			comb.combinacion[i] = new Casilla(Colores.NEGRO + "  " + Colores.RESET);
		}
		
		while (i < num[0] + num[1]) {
			comb.combinacion[i] = new Casilla(Colores.ROJO + "  " + Colores.RESET);
			i++;
		}
		
		for (i = 0; i < Modos.DIFICIL.getCasillas(); i++) {
			if (comb.combinacion[i] == null) {
				comb.combinacion[i] = new Casilla(Colores.BLANCO + "  " + Colores.RESET);
			}
		}
		
		return comb;
	}
	
	
	
	
}
