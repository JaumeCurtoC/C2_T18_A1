package ex3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Almacenes {
	// M�todo para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS almacenes";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE almacenes("+
					"codigo INT NOT NULL AUTO_INCREMENT, "+
					"lugar VARCHAR(100) NOT NULL, "+
					"capacidad INT,"+
					"PRIMARY KEY (codigo))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con �xito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// M�todo para insertar datos en la tabla
	public void insertAlmacenes() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO almacenes (lugar, capacidad) values"+
					"('Lug1', 1000),"+
					"('Lug2', 2000),"+
					"('Lug3', 3000);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
