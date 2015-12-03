package parejas.pruebas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import parejas.pruebas.negocio.ProbarNegocioBusquedaParejasParametrico;
import parejas.pruebas.persistencia.ProbarPersistenciaBaseDatosConELPropioDAO;
import parejas.pruebas.persistencia.ProbarPersistenciaMemoria;

@RunWith(Suite.class)
@SuiteClasses({ ProbarPersistenciaMemoria.class, 
	ProbarPersistenciaBaseDatosConELPropioDAO.class,
	ProbarNegocioBusquedaParejasParametrico.class })
//@IncludeCategory
//@ExcludeCategory(Lentos.class)
public class AllTests {

}
