package com.biblioteca.dao.util;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlWriter;
import org.dbunit.ext.mysql.MySqlConnection;
import org.xml.sax.InputSource;

public class DbUtil {
	
	public static void main(String[] args) throws Exception {
		
		QueryDataSet partialDataSet= new QueryDataSet(getConnection());
		//Especificar que tablas formaran parte del Dataset 
		partialDataSet.addTable("LIBROS");
		//Especificar la ubicación del fichero a generar 
		FlatXmlWriter datasetWriter= new FlatXmlWriter(new FileOutputStream("db/input.xml"));
		//Generar el fichero 
		datasetWriter.write(partialDataSet);
		
	}
	
	public static IDatabaseConnection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection(
				"jdbc:mysql://localhost/biblioteca", "root", "root");
		return new MySqlConnection(jdbcConnection, "biblioteca");
	}

	public static IDataSet getDataSet(String nombre) throws Exception {
		FlatXmlDataSet loadedDataSet = new FlatXmlDataSet(new InputSource("db/" + nombre + ".xml"));
		return loadedDataSet;
	}
}
