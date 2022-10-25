package ex8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Maquinas_Registradoras {
	// Método para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS maquinas_registradoras";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE maquinas_registradoras("+
					"codigo INT NOT NULL AUTO_INCREMENT,"+
					"piso INT,"+
					"PRIMARY KEY (codigo))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertMaquinas() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO maquinas_registradoras (piso) values"+
					"(1),"+
					"(2),"+
					"(0);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
