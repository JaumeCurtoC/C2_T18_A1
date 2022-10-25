package ex9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Facultad {
	// Método para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS facultad";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE facultad("+
					"codigo INT NOT NULL AUTO_INCREMENT,"+
					"nombre VARCHAR(100),"+
					"PRIMARY KEY (codigo))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertFacultad() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO facultad (nombre) values"+
					"('Fac1'),"+
					"('Fac2'),"+
					"('Fac3');";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
