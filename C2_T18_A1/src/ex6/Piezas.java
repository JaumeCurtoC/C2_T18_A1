package ex6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Piezas {
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS piezas";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE piezas("+
					"codigo INT NOT NULL AUTO_INCREMENT, "+
					"nombre VARCHAR(100),"+
					"PRIMARY KEY (codigo))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con �xito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertPiezas() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO piezas (nombre) values"+
					"('Pieza1'),"+
					"('Pieza2'),"+
					"('Pieza3');";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
