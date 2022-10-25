package ex6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Suministra {
	// Método para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS suministra";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE suministra("+
					"codigoPieza INT NOT NULL, "+
					"idProveedor CHAR(4) NOT NULL, "+
					"precio INT,"+
					"PRIMARY KEY (codigoPieza, idProveedor),"+
					"CONSTRAINT FK_PiezasSuministra FOREIGN KEY (codigoPieza) REFERENCES piezas(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"+
					"CONSTRAINT FK_ProveedorSuministra FOREIGN KEY (idProveedor) REFERENCES proveedores(id) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertSuministra() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO suministra (codigoPieza, idProveedor, precio) values"+
					"('1', 'id01', 10),"+
					"('2', 'id02', 20),"+
					"('3', 'id03', 30);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
