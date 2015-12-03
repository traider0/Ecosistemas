package parejas.negocio;

import java.util.ArrayList;
import java.util.List;

import parejas.modelo.Persona;
import parejas.persistencia.PersonaDao;

public class ServicioBusquedaParejasImpl implements ServicioBusquedaParejas {
	private PersonaDao personaDao;
	
	public ServicioBusquedaParejasImpl() {
	}
	
	
	
	public ServicioBusquedaParejasImpl(PersonaDao personaDao) {
		super();
		this.personaDao = personaDao;
	}



	@Override
	public Persona encontrarIdeal(Persona usuario) {
		//TODO hacer listados por sexo
		List<Persona>candidatos=personaDao.listar();
		Persona ideal = null;
		for (Persona candidato : candidatos) {
			if(candidato.getSexo()!=usuario.getSexo()&& 
					candidato.esIdeal(usuario)){
				ideal=candidato;
				break;
			}
		}
		return ideal;
	}

	@Override
	public List<Persona> encontrarAfines(Persona usuario) {
		List<Persona>candidatos=personaDao.listar();
		List<Persona> afines = new ArrayList<>();
		for (Persona candidato : candidatos) {
			if(candidato.getSexo()!=usuario.getSexo()&& 
					candidato.esAfin(usuario)){
				afines.add(candidato);
			
			}
		}
		return afines;
	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

}
