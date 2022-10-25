package ex2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Departamentos {
	
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS departamentos";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE departamentos("+
					"codigo INT NOT NULL AUTO_INCREMENT, "+
					"nombre VARCHAR(100) NOT NULL, "+
					"presupuesto INT,"+
					"PRIMARY KEY (codigo))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertDepartamentos() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO departamentos (nombre, presupuesto) values"+
					"('Dep1', 1000),"+
					"('Dep2', 2000),"+
					"('Dep3', 3000);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
