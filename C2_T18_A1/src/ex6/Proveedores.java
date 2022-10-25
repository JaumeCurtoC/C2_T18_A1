package ex6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Proveedores {
	// M�todo para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS proveedores";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE proveedores("+
					"id CHAR(4) NOT NULL, "+
					"nombre VARCHAR(100),"+
					"PRIMARY KEY (id))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con �xito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// M�todo para insertar datos en la tabla
	public void insertProveedores() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO proveedores (id, nombre) values"+
					"('id01','Prov1'),"+
					"('id02','Prov2'),"+
					"('id03','Prov3');";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
