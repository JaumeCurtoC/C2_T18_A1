package ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMain {
	
	// Declaraci?n del Atributo Connection que se usar? en todo el package
	static Connection connection;
	
	public static void main(String[] args) {
		// Declaraci?n de Variables Locales
		CrearDB cdb = new CrearDB();
		Almacenes a = new Almacenes();
		Cajas c = new Cajas();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Password retirada por seguridad
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.45:3306?useTimezone=true&serverTimezone=UTC","remote","PASSWORD");
			System.out.println("Server Connected");
			// Creaci?n de la base de datos
			cdb.crearDB();
			// Creaci?n de la tabla Almacenes e inserci?n de datos
			a.createTable();
			a.insertAlmacenes();
			// Creaci?n de la tabla Cajas e inserci?n de datos
			c.createTable();
			c.insertCajas();
			// Cerrar conexi?n con la base de datos
			closeConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con la base de datos.");
			System.out.println(ex);
		}
	}
	
	// M?todo para cerrar la conexi?n con la base de datos
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Se ha finalizado la conexi?n con el servidor");
		}catch(SQLException ex) {
			Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
