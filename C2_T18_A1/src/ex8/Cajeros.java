package ex8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cajeros {
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS cajeros";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE cajeros("+
					"codigo INT NOT NULL AUTO_INCREMENT,"+
					"nomApels VARCHAR(255),"+
					"PRIMARY KEY (codigo))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertCajeros() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO cajeros (nomApels) values"+
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
