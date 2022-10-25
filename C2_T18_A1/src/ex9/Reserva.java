package ex9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Reserva {
	// Método para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS reserva";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE reserva("+
					"DNI VARCHAR(8) NOT NULL, "+
					"numSerie CHAR(4) NOT NULL, "+
					"comienzo DATETIME,"+
					"fin DATETIME,"+
					"PRIMARY KEY (DNI, numSerie),"+
					"CONSTRAINT FK_InvestigadorReserva FOREIGN KEY (DNI) REFERENCES investigadores(DNI) ON DELETE CASCADE ON UPDATE CASCADE,"+
					"CONSTRAINT FK_EquipoReserva FOREIGN KEY (numSerie) REFERENCES equipos(numSerie) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertReserva() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO reserva (DNI, numSerie, comienzo, fin) values"+
					"('11112222', 'NS01', '2020-08-01 12:00:00', '2020-08-05 12:00:00'),"+
					"('33334444', 'NS02', '2020-09-01 12:00:00', '2020-09-05 12:00:00'),"+
					"('55556666', 'NS03', '2020-10-01 12:00:00', '2020-10-05 12:00:00');";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
