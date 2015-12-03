package com.ejemplo.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebasDeCalculadoraDivisonPorCero {

	@Test(expected=ArithmeticException.class)
	public void testDivison(){
		Calculadora sut = new Calculadora();
		
		int resultado = sut.division(1, 0);
		
		fail("No deberia de llegar a ejecutar esta linea");
		
		//comprobamos (asertos)
		//assertEquals(resultadoEsperadoDivision, resultado);
	}

}
