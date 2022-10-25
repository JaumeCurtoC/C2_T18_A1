package ex3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cajas {
	
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS cajas";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE cajas("+
					"numReferencia CHAR(5) NOT NULL, "+
					"contenido VARCHAR(100), "+
					"valor INT, "+
					"almacen INT NOT NULL,"+
					"PRIMARY KEY (numReferencia),"+
					"CONSTRAINT FK_AlmacenCaja FOREIGN KEY (almacen) REFERENCES almacenes(codigo) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertCajas() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO cajas (numReferencia, contenido, valor, almacen) values"+
					"('NR100', 'Con1', 10, 1),"+
					"('NR200', 'Con2', 20, 2),"+
					"('NR300', 'Con3', 30, 3);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
