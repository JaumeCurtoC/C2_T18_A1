package ex1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Articulos {

	public void createTable() {
		Connection c = AppMain.connection;
		try {
			String query = "DROP TABLE IF EXISTS articulos";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE articulos("+
					"codigo INT NOT NULL AUTO_INCREMENT, "+
					"nombre VARCHAR(100) NOT NULL, "+
					"precio INT,"+
					"fabricante INT NOT NULL,"+
					"PRIMARY KEY (codigo),"+
					"CONSTRAINT FK_FabricanteArticulo FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	
	public void insertArticulos() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO articulos (nombre, precio, fabricante) values"+
					"('Art1', 10, 1),"+
					"('Art2', 20, 2),"+
					"('Art3', 30, 3);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
	
}
