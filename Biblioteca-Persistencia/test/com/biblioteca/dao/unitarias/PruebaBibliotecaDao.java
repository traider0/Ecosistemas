package com.biblioteca.dao.unitarias;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.InputSource;

import com.biblioteca.dao.BibliotecaDAO;
import com.biblioteca.dao.util.DbUtil;
import com.biblioteca.modelo.entidades.Libro;

public class PruebaBibliotecaDao {

	//Sut
	private static BibliotecaDAO dao = new BibliotecaDAO();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// Preparar el entorno de nuestra, antes era crear en Mock.
		DatabaseOperation.CLEAN_INSERT.execute(DbUtil.getConnection(), DbUtil.getDataSet("input"));
		
		//Preparar el SUT
		SessionFactory sessionFactory = new Configuration().
				configure("com/biblioteca/dao/unitarias/hibernate.cfg.xml").
				buildSessionFactory();
		
		dao.setSessionFactory(sessionFactory);
		
	}
	
	@Test
	public void test() throws Exception {
		
		//Prueba del Dao
		int idGenerado = dao.insertLibro(new Libro("Gato", "Grim"));
		
		Assert.assertTrue(idGenerado > 0);

		//Prueba del estado del entorno, tras haber ejecutado el Dao
		QueryDataSet partialDataSetObtenido = new QueryDataSet(DbUtil.getConnection());
		partialDataSetObtenido.addTable("LIBROS");
		
		IDataSet dataSetEsperado = DbUtil.getDataSet("esperado");
		
		Assertion.assertEquals(dataSetEsperado, partialDataSetObtenido);
		
	}

}
