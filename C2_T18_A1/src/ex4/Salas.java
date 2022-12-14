package ex4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Salas {
	// M?todo para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS salas";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE salas("+
					"codigo INT NOT NULL AUTO_INCREMENT, "+
					"nombre VARCHAR(100), "+
					"pelicula INT NOT NULL,"+
					"PRIMARY KEY (codigo),"+
					"CONSTRAINT FK_PeliculaSala FOREIGN KEY (pelicula) REFERENCES peliculas(codigo) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con ?xito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// M?todo para insertar datos en la tabla
	public void insertSalas() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO salas (nombre, pelicula) values"+
					"('Sala1', 1),"+
					"('Sala2', 2),"+
					"('Sala3', 3);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
