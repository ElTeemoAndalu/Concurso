package testRespuestaJunit;

import static mastermind.Colores.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import mastermind.Combinacion;
import mastermind.Ficha;
import mastermind.Jugador;
import mastermind.Maquina;
import mastermind.Modos;
import mastermind.Usuario;

class TestRespuesta {
	Jugador j1;
	Jugador j2;
	Modos modo;
	Combinacion respuesta;

	@Test
	@DisplayName("Pruebas para el método darAciertosRival en Facil")
	void darAciertosTestFacil() {
		/*
		 * Utilizamos una combinacion para igualarla al metodo a comprobar que recibe
		 * como parametros dos combinaciones, las cuales iran variando segun el tipo de
		 * prueba que le hagamos.
		 */
		// ------NEGROS--------------------------!!
		// ------PRUEBA 1--------------------------!!
		int i;
		Ficha ficha;
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 2--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 1; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 3--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 2; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 4--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 3; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------ROJOS--------------------------!!
		// ------PRUEBA 1--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 2--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 1; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 3--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 2; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 4--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 3; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------BLANCOS--------------------------!!
		// ------PRUEBA 1--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------NEGROS-ROJOS--------------------------!!
		// ------PRUEBA 1--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 2; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 2--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		respuesta.getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 3--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		respuesta.getCasillas()[0] = ficha;
		respuesta.getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 4--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		respuesta.getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------No Válidas-Null Pointer--------------------------!!
		// ------PRUEBA 1--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = null;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertThrows(NullPointerException.class, () -> {
			j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion());
		});

		// ------PRUEBA 2--------------------------!!
		modo = Modos.Facil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getCombinacionSecreta().getCasillas()[3] = null;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertThrows(NullPointerException.class, () -> {
			j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion());
		});

	}

	@Test
	@DisplayName("Pruebas para el método darAciertosRival en Medio")
	void darAciertosTestMedio() {
		/*
		 * Utilizamos una combinacion para igualarla al metodo a comprobar que recibe
		 * como parametros dos combinaciones, las cuales iran variando segun el tipo de
		 * prueba que le hagamos.
		 */
		// ------NEGROS--------------------------!!
		// ------PRUEBA 1--------------------------!!
		int i;
		Ficha ficha;
		modo = Modos.Medio;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 2--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 1; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[4] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 3--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 2; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 4--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 3; i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 5--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		respuesta.getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------ROJOS--------------------------!!
		// ------PRUEBA 1--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 4--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[0] = ficha;
		respuesta.getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 5--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(MORADO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------NEGROS-ROJOS--------------------------!!
		// ------PRUEBA 1--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas() - 2; i++) {
			respuesta.getCasillas()[i] = ficha;
		}

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 3--------------------------!!

		modo = Modos.Medio;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		respuesta.getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------No Validas-NullPointer--------------------------!!
		// ------PRUEBA 1--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;

		ficha = new Ficha();
		ficha.setColor(AZUL + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;

		ficha = new Ficha();
		ficha.setColor(CELESTE + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[4] = null;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertThrows(NullPointerException.class, () -> {
			j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion());
		});
	}

	@Test
	@DisplayName("Pruebas para el método darAciertosRival en Difícil")
	void darAciertosTestDificil() {
		/*
		 * Utilizamos una combinacion para igualarla al metodo a comprobar que recibe
		 * como parametros dos combinaciones, las cuales iran variando segun el tipo de
		 * prueba que le hagamos.
		 */
		// ------NEGROS--------------------------!!
		// ------PRUEBA 1--------------------------!!
		int i;
		Ficha ficha;
		modo = Modos.Dificil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 2--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 3--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 4--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 5--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[4] = ficha;
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 6--------------------------!!
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 7--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 8--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------ROJOS--------------------------!!
		// ------PRUEBA 1--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 2--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 3--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 4--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 5--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[4] = ficha;
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 6--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 7--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 8--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[1] = ficha;
		j1.getCombinacionSecreta().getCasillas()[3] = ficha;
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[0] = ficha;

		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[1] = ficha;
		j2.getAcertarCombinacion().getCasillas()[2] = ficha;
		j2.getAcertarCombinacion().getCasillas()[3] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[1] = ficha;
		respuesta.getCasillas()[2] = ficha;
		respuesta.getCasillas()[3] = ficha;
		respuesta.getCasillas()[4] = ficha;
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------BLANCOS--------------------------!!
		// ------PRUEBA 1--------------------------!!

		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		for (i = 0; i < modo.getNumCasillas(); i++) {
			ficha = new Ficha();
			ficha.setColor(ROJO + (char) 9209 + RESET);
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			ficha = new Ficha();
			ficha.setColor(AMARILLO + (char) 9209 + RESET);
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}

		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------ROJO-NEGRO--------------------------!!
		// ------PRUEBA 1--------------------------!!

		modo = Modos.Dificil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------PRUEBA 2--------------------------!!

		modo = Modos.Dificil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		ficha = new Ficha();
		ficha.setColor(AMARILLO + (char) 9209 + RESET);
		j1.getCombinacionSecreta().getCasillas()[5] = ficha;
		j1.getCombinacionSecreta().getCasillas()[7] = ficha;
		j2.getAcertarCombinacion().getCasillas()[4] = ficha;
		ficha = new Ficha();
		ficha.setColor(VERDE + (char) 9209 + RESET);
		j2.getAcertarCombinacion().getCasillas()[5] = ficha;
		j2.getAcertarCombinacion().getCasillas()[6] = ficha;
		j2.getAcertarCombinacion().getCasillas()[7] = ficha;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9210 + RESET);
		respuesta.getCasillas()[4] = ficha;
		ficha = new Ficha();
		ficha.setColor(BLANCO + (char) 9210 + RESET);
		respuesta.getCasillas()[5] = ficha;
		respuesta.getCasillas()[6] = ficha;
		respuesta.getCasillas()[7] = ficha;
		assertEquals(respuesta, j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion()));

		// ------No Valida-NullPointer--------------------------!!
		// ------PRUEBA 1--------------------------!!
		modo = Modos.Dificil;
		j1 = new Usuario(modo);
		j2 = new Maquina(modo);
		respuesta = new Combinacion(modo);

		ficha = new Ficha();
		ficha.setColor(ROJO + (char) 9209 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			j1.getCombinacionSecreta().getCasillas()[i] = ficha;
			j2.getAcertarCombinacion().getCasillas()[i] = ficha;
		}
		j1.getCombinacionSecreta().getCasillas()[7] = null;

		ficha = new Ficha();
		ficha.setColor(NEGRO + (char) 9210 + RESET);
		for (i = 0; i < modo.getNumCasillas(); i++) {
			respuesta.getCasillas()[i] = ficha;
		}
		assertThrows(NullPointerException.class, () -> {
			j2.darAciertosRival(j1.getCombinacionSecreta(), j2.getAcertarCombinacion());
		});
	}

}