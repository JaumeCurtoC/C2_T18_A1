package ex5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Directores {
	// Método para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS directores";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE directores("+
					"DNI VARCHAR(8) NOT NULL, "+
					"nomApels VARCHAR(100), "+
					"DNIJefe VARCHAR(8),"+
					"despacho INT,"+
					"PRIMARY KEY (DNI),"+
					"CONSTRAINT FK_DespachoDirector FOREIGN KEY (despacho) REFERENCES despachos(numero) ON DELETE CASCADE ON UPDATE CASCADE,"+
					"CONSTRAINT FK_DirectorJefe FOREIGN KEY (DNIJefe) REFERENCES directores(DNI) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertDirectores() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO directores (DNI, nomApels, DNIJefe, despacho) values"+
					"('11112222', 'Dir1', null, 1),"+
					"('33334444', 'Dir2', '11112222', 2),"+
					"('55556666', 'Dir3', '11112222', 3);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
