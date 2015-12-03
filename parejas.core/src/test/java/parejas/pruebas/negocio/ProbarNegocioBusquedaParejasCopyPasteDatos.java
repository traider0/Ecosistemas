package parejas.pruebas.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import parejas.modelo.Persona;
import parejas.negocio.ServicioBusquedaParejas;
import parejas.negocio.ServicioBusquedaParejasImpl;
import parejas.persistencia.PersonaDao;
import parejas.persistencia.PersonaDaoMemoriaImpl;

public class ProbarNegocioBusquedaParejasCopyPasteDatos {
	//Helpers 
	private PersonaDao personaDao=new PersonaDaoMemoriaImpl();
	//SUT
	private ServicioBusquedaParejas buscador=new ServicioBusquedaParejasImpl(personaDao);
	

	@Before
	public void prepara() throws Exception {
		//preparar el entorno
		List<Persona> personas = Arrays.asList(
			new Persona(1L,"pepe",77,1.67f,Persona.HOMBRE),
			new Persona(2L,"luis",62,1.77f,Persona.HOMBRE),
			new Persona(3L,"ana",71,1.77f,Persona.MUJER),
			new Persona(4L,"maria",79,1.57f,Persona.MUJER));
		for (Persona persona : personas) {
			personaDao.guardar(persona);
		}
	}
	
	
	@Test(timeout=1000)
	public void probarServicio() throws Exception {
		Persona usuario=
			new Persona(null,"Fernando",70,1.79f,Persona.HOMBRE);
		
		Persona ideal=buscador.encontrarIdeal(usuario);
		assertNotNull(ideal);
		assertEquals("ana",ideal.getNombre());
		
		List<Persona>afines=buscador.encontrarAfines(usuario);
		assertEquals(2, afines.size());
		
		Persona usuaria=
				new Persona(null,"Rosa",30,1.69f,Persona.MUJER);
			
		Persona ideal2=buscador.encontrarIdeal(usuaria);
		assertNull(ideal2);
			
		List<Persona>afines2=buscador.encontrarAfines(usuaria);
		assertEquals(2, afines2.size());
		
	}
}
