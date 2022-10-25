package ex7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cientificos {
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS cientificos";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE cientificos("+
					"DNI VARCHAR(8) NOT NULL, "+
					"nomApels VARCHAR(255),"+
					"PRIMARY KEY (DNI))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertCientificos() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO cientificos (DNI, nomApels) values"+
					"('11112222','Nom1'),"+
					"('33334444','Nom2'),"+
					"('55556666','Nom3');";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
