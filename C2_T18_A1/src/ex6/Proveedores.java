package ex6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Proveedores {
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS proveedores";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE proveedores("+
					"id CHAR(4) NOT NULL, "+
					"nombre VARCHAR(100),"+
					"PRIMARY KEY (id))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
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
