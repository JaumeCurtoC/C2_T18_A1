package ex7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Asignado_A {
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS asignado_a";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE asignado_a("+
					"cientifico VARCHAR(8) NOT NULL, "+
					"proyecto CHAR(4) NOT NULL, "+
					"PRIMARY KEY (cientifico, proyecto),"+
					"CONSTRAINT FK_CientificoAsignado FOREIGN KEY (cientifico) REFERENCES cientificos(DNI) ON DELETE CASCADE ON UPDATE CASCADE,"+
					"CONSTRAINT FK_ProyectoAsignado FOREIGN KEY (proyecto) REFERENCES proyecto(id) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertAsignados() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO asignado_a (cientifico, proyecto) values"+
					"('11112222', 'id01'),"+
					"('33334444', 'id02'),"+
					"('55556666', 'id03');";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
