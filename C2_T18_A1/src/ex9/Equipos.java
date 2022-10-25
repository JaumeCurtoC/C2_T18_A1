package ex9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipos {
	public void createTable() {
		// Método para crear la tabla
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS equipos";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE equipos("+
					"numSerie CHAR(4) NOT NULL, "+
					"nombre VARCHAR(100),"+
					"facultad INT,"+
					"PRIMARY KEY (numSerie),"+
					"CONSTRAINT FK_FacultadEquipo FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertEquipos() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO equipos (numSerie, nombre, facultad) values"+
					"('NS01','Eq1', 1),"+
					"('NS02','Eq2', 2),"+
					"('NS03','Eq3', 3);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
