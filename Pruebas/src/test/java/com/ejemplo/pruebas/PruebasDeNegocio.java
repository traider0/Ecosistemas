package com.ejemplo.pruebas;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PruebasDeNegocio {

	@Mock
	private IPersistencia persistencia;
	
	private static int resultadoEsperado = 1;
	
	@Before
	public void init(){
		when(persistencia.insercion(anyObject())).thenReturn(1);
	}
	
	@Test
	public void pruebaInsercion(){
		
		/*IPersistencia persintenciaDummy = new IPersistencia() {
			public int insercion(Object obj) {
				System.out.println("En la persistencia insertando el objeto");
				return 1;
			}
		};*/
		
		Negocio negocio = new Negocio(persistencia);
		
		int resultado = negocio.alta(new Object());
		
		assertEquals(resultadoEsperado, resultado);
	}
	
}
