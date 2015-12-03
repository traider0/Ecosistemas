package parejas.pruebas.negocio.concordion;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import parejas.modelo.Persona;
import parejas.negocio.ServicioBusquedaParejas;
import parejas.negocio.ServicioBusquedaParejasImpl;
import parejas.persistencia.PersonaDao;
import parejas.persistencia.PersonaDaoMemoriaImpl;

@RunWith(ConcordionRunner.class)
public class BusquedaParejas {
	private PersonaDao personaDao=new PersonaDaoMemoriaImpl();
	//SUT
	private ServicioBusquedaParejas buscador=new ServicioBusquedaParejasImpl(personaDao);

	public void cargarDatos(Long id,String nombre,int edad,float altura,String sexo){
		Persona persona = new Persona(id,nombre,edad,altura,sexo.charAt(0));
		personaDao.guardar(persona);
		System.out.println("guardar--->"+persona.toString());
	}
	
    public Persona buscarIdeal(String nombre,int edad,float altura,String sexo) {
    	Persona usuario = new Persona(null,nombre,edad,altura,sexo.charAt(0));
    	Persona ideal = buscador.encontrarIdeal(usuario);
    	System.out.println("ideal--->"+ideal.toString());
    	return ideal;
    }
    
    public SortedSet<String> buscarAfines(String nombre,int edad,float altura,String sexo) {
    	Persona usuario = new Persona(null,nombre,edad,altura,sexo.charAt(0));
    	List<Persona> afines = buscador.encontrarAfines(usuario);
    	System.out.println("afines--->"+afines.toString());
    	TreeSet<String> nombres = new TreeSet<>();
    	for (Persona afin : afines) {
			nombres.add(afin.getNombre());
		}
    	return nombres;
    }
}
