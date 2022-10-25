package ex5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Despachos {
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS despachos";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE despachos("+
					"numero INT NOT NULL AUTO_INCREMENT, "+
					"capacidad INT,"+
					"PRIMARY KEY (numero))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertDespachos() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO despachos (capacidad) values"+
					"(3),"+
					"(5),"+
					"(7);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
