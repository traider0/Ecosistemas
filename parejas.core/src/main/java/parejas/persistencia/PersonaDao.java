package parejas.persistencia;

import java.util.List;

import parejas.modelo.Persona;

public interface PersonaDao {
	void guardar(Persona persona);
	void borrar(Persona persona);
	Persona buscar(Long id);
	List<Persona>listar();
}
