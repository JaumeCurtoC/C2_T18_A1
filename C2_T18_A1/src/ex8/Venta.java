package ex8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Venta {
	// M�todo para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS venta";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE venta("+
					"cajero INT NOT NULL, "+
					"maquina INT NOT NULL, "+
					"producto INT NOT NULL,"+
					"PRIMARY KEY (cajero,maquina,producto),"+
					"CONSTRAINT FK_CajeroVenta FOREIGN KEY (cajero) REFERENCES cajeros(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"+
					"CONSTRAINT FK_MaquinaVenta FOREIGN KEY (maquina) REFERENCES maquinas_registradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"+
					"CONSTRAINT FK_ProductoVenta FOREIGN KEY (producto) REFERENCES productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con �xito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// M�todo para insertar datos en la tabla
	public void insertVentas() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO venta (cajero,maquina,producto) values"+
					"(1,1,1),"+
					"(2,2,2),"+
					"(3,3,3);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
