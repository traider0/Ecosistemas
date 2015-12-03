package parejas.pruebas.persistencia;

import java.io.FileInputStream;

import org.apache.commons.dbcp.BasicDataSource;
import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;

import parejas.modelo.Persona;
import parejas.persistencia.PersonaDao;
import parejas.persistencia.PersonaDaoJDBCImpl;

public class ProbarPersistenciaDbUnit extends DatabaseTestCase{
	
	private static BasicDataSource dataSource;
	//SUT
	private PersonaDao personaDao=new PersonaDaoJDBCImpl(dataSource);
	
	static{
		//creamos un pool de conexiones
		dataSource=new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
	}

	

	//implementacion por defecto
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.CLEAN_INSERT;
	}
	
	//implementacion por defecto
	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}
	
	
	//metodo abstracto a implementar siempre
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		
		IDatabaseConnection dbConnection =
			//para oracle OK
			//new DatabaseConnection(dataSource.getConnection(),"test");
			//para MySql OK	
			new MySqlConnection(dataSource.getConnection(),"test");
		
		return dbConnection;
	}

	//metodo abstracto a implementar siempre
	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder()
			.build(new FileInputStream("src/test/resources/parejas/pruebas/persistencia/carga-personas-inicial.xml"));
	}
	
	//Metodo de test
	public void testPersonaDao() throws  Exception {
			
		int ti=personaDao.listar().size();
		assertEquals("se incrementa en...",4,ti);
		
		Persona persona = personaDao.buscar(1L);
		assertNotNull(persona);
		assertEquals("pepe", persona.getNombre());
		
		personaDao.borrar(persona);
		persona = personaDao.buscar(1L);
		assertNull(persona);
		
		//obtenermos el dataset de la tabla personas
		IDataSet actualDataSet=getConnection()
				.createDataSet(new String[]{"personas"});
		
		IDataSet expectedDataSet=new FlatXmlDataSetBuilder()
			.build(new FileInputStream("src/test/resources/parejas/pruebas/persistencia/carga-personas-final.xml"));
		//hacemos assertos de tablas  (de dataset)
		Assertion.assertEquals(expectedDataSet, actualDataSet);
	}
	

}
