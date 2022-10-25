package ex7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Proyecto {
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS proyecto";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE proyecto("+
					"id CHAR(4) NOT NULL, "+
					"nombre VARCHAR(255),"+
					"horas INT,"+
					"PRIMARY KEY (id))";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertProyectos() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO proyecto (id, nombre, horas) values"+
					"('id01','Proy1', 5),"+
					"('id02','Proy2', 10),"+
					"('id03','Proy3', 15);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
