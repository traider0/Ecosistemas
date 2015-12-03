package com.biblioteca.modelo.ln.unitarias;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.biblioteca.dao.IBibliotecaDAO;
import com.biblioteca.modelo.entidades.Libro;
import com.biblioteca.modelo.ln.BibliotecaLN;

public class BibliotecaNegocioTest {

	//Sut
	private static BibliotecaLN negocio = new BibliotecaLN();
	
	//Datos de Prueba
	private static Libro libroBueno = new Libro("Pinocho","Anonimo");
	private static Libro libroMaloPorTamañoDeTituloMayor = new Libro("El Quijote de la Mancha", "Cervantes");
	
	//Datos Esperados
	private static int dataEsperadoParaLibroBueno = 1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Definimos el Dummy
		IBibliotecaDAO dao = Mockito.mock(IBibliotecaDAO.class);
		
		//Inyectamos el Mock al SUT para que lo pueda emplear
		negocio.setDao(dao);
		
		//Definimos las funcionalidades del Mock
		Mockito.when(dao.insertLibro(libroMaloPorTamañoDeTituloMayor)).thenThrow(SQLException.class);
		Mockito.when(dao.insertLibro(libroBueno)).thenReturn(dataEsperadoParaLibroBueno);
		
	}

	@Test(expected=SQLException.class)
	public void pruebaAltaLibroMalo() throws Exception {
		
		negocio.insertLibro(libroMaloPorTamañoDeTituloMayor);
		
		fail("Este test ha fallado, porque se esperaba que lanzase una excepcion");
	}
	
	@Test
	public void pruebaAltaLibroBueno() throws Exception {
		
		int resultadoObtenidoParaAltaDelLibroBueno = negocio.insertLibro(libroBueno);
		
		Assert.assertEquals(dataEsperadoParaLibroBueno, resultadoObtenidoParaAltaDelLibroBueno);
	}
}
