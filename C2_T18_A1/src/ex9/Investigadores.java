package ex9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Investigadores {
	// Método para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS investigadores";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE investigadores("+
					"DNI VARCHAR(8) NOT NULL, "+
					"nomApels VARCHAR(255),"+
					"facultad INT,"+
					"PRIMARY KEY (DNI),"+
					"CONSTRAINT FK_FacultadInvestigador FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertInvestigadores() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO investigadores (DNI, nomApels, facultad) values"+
					"('11112222','Inv1', 1),"+
					"('33334444','Inv2', 2),"+
					"('55556666','Inv3', 3);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
