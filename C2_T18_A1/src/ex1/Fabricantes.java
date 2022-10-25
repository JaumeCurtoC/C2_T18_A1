package ex1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Fabricantes {
	// M�todo para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS fabricantes";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE fabricantes("+
					"codigo INT NOT NULL AUTO_INCREMENT, "+
					"nombre VARCHAR(100) NOT NULL, "+
					"PRIMARY KEY (codigo))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con �xito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// M�todo para insertar datos en la tabla
	public void insertFabricantes() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO fabricantes (nombre) values"+
					"('Nom1'),"+
					"('Nom2'),"+
					"('Nom3');";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
