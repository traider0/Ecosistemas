package parejas.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parejas.modelo.Persona;

public class PersonaDaoMemoriaImpl implements PersonaDao {
	private Map<Long,Persona>bd=new HashMap<>();
	
	@Override
	public void guardar(Persona persona) {
		bd.put(persona.getId(),persona);
	}

	@Override
	public void borrar(Persona persona) {
		bd.remove(persona.getId());
	}

	@Override
	public Persona buscar(Long id) {
		return bd.get(id);
	}

	@Override
	public List<Persona> listar() {
		return new ArrayList<Persona>(bd.values());
	}

}
