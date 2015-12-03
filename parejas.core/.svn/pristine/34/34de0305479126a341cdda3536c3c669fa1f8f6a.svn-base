package parejas.pruebas.persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import parejas.modelo.Persona;
import parejas.persistencia.PersonaDao;

@RunWith(MockitoJUnitRunner.class)
public class ProbarPersistenciaMock {
	//SUT
	@Mock private  PersonaDao personaDao;
	//Helper 
	private List<Persona> personas;
	//Helper2
	private List<Persona> personas2;

	@BeforeClass
	public static void alPrincipio() throws Exception {	}
	

	@Before
	public void prepara()  {
		//preparar el entorno
		personas = 
				Arrays.asList(
					new Persona(1L,"pepe",77,1.67f,Persona.HOMBRE),
					new Persona(2L,"luis",62,1.77f,Persona.HOMBRE),
					new Persona(3L,"ana",71,1.77f,Persona.MUJER),
					new Persona(4L,"maria",79,1.57f,Persona.MUJER));
	
		//stubbing o adiestramiento del mock

		when(personaDao.buscar(1L)).thenReturn(new Persona(1L,"pepe",77,1.67f,Persona.HOMBRE));
		when(personaDao.listar()).thenReturn(personas2);

	}
	


	@Test
	public void pruebaPersonaDao() {
		for (Persona persona : personas) {
			personaDao.guardar(persona);
		}
		
			
		Persona persona = personaDao.buscar(1L);
		assertNotNull(persona);
		assertEquals("pepe", persona.getNombre());
		
		//verificamos las invocaciones
		verify(personaDao,times(4)).guardar(any(Persona.class));

		
		
	}

}
