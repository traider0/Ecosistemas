package com.ejemplo.pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PruebasDeCalculadora {

	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				//a, b, resultadoEsperadoSuma, resultadoEsperadoResta
				{1, 2, 3, -1}, 
				{-1, 2, 1, -3}, 
				{-1, -2, -3, 1}});
	}
	
	private int a;
	private int b;
	private int resultadoEsperadoSuma;
	private int resultadoEsperadoResta;
	
	private Calculadora sut;
	

	public PruebasDeCalculadora(int a, int b, int resultadoEsperadoSuma,
			int resultadoEsperadoResta) {
		super();
		this.a = a;
		this.b = b;
		this.resultadoEsperadoSuma = resultadoEsperadoSuma;
		this.resultadoEsperadoResta = resultadoEsperadoResta;
		
		// SUT
		sut = new Calculadora();
	}

	@Test
	public void testSuma() {
		
		//Ejecutar la logica a probar
		int resultado = sut.sumar(a, b);
		
		//comprobamos (asertos)
		
		assertEquals(resultadoEsperadoSuma, resultado);
		
		//No quitar hasta que el test este completo
		//fail("Not yet implemented");
	}
	
	@Test
	public void testResta(){
		
		//Ejecutar la logica a probar
		int resultado = sut.restar(a, b);
		
		//comprobamos (asertos)
		assertEquals(resultadoEsperadoResta, resultado);
		
		//No quitar hasta que el test este completo
		//fail("Not yet implemented");
	}

}
