package parejas.pruebas.persistencia;

import java.io.FileOutputStream;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlConnection;

public class GenerarDataSetDBUnit {
	public static void main(String[] args) throws Exception, SQLException {
		//creamos un pool de conexiones
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		IDatabaseConnection dbConnection =
			//para oracle OK
			//new DatabaseConnection(dataSource.getConnection(),"test");
			//para MySql OK	
			new MySqlConnection(dataSource.getConnection(),"test");
		
		//Opcion 1. crear un full dataset de la bd
		IDataSet fullDataSet = dbConnection.createDataSet();
		//exportamos a XML
		FlatXmlDataSet.write(fullDataSet, 
				new FileOutputStream("carga-total.xml"));
		FlatDtdDataSet.write(fullDataSet, 
				new FileOutputStream("carga-total.dtd"));
		
		//Opcion 2. crear un dataset de una tabla y sus relacionadas
		String[] employeesDependentTables = TablesDependencyHelper
			.getAllDependentTables(dbConnection, "employees");
		IDataSet employeesDataSet = 
			dbConnection.createDataSet(employeesDependentTables);
		
		//exportamos a XML
		FlatXmlDataSet.write(employeesDataSet, 
				new FileOutputStream("carga-employees.xml"));
		FlatDtdDataSet.write(employeesDataSet, 
				new FileOutputStream("carga-employees.dtd"));
		
		//Opcion 3. crear un dataset de una tabla o de una consulta
		QueryDataSet queryDataSet = new QueryDataSet(dbConnection);
		//queryDataSet.addTable("personas");
		queryDataSet.addTable("personas", "select * from personas where edad > 18");
		
		FlatXmlDataSet.write(queryDataSet, 
				new FileOutputStream("carga-personas.xml"));
		FlatDtdDataSet.write(queryDataSet, 
				new FileOutputStream("carga-personas.dtd"));
		
		
		
	}
}