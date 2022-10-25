package ex8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Productos {
	// Método para crear la tabla
	public void createTable() {
		// Borrar la tabla en caso que exista
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS productos";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE productos("+
					"codigo INT NOT NULL AUTO_INCREMENT,"+
					"nombre VARCHAR(100),"+
					"precio INT,"+
					"PRIMARY KEY (codigo))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertProductos() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO productos (nombre, precio) values"+
					"('Prod1',10),"+
					"('Prod2',20),"+
					"('Prod3',30);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
