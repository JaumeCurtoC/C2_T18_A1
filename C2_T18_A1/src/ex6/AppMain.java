package ex6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMain {

	// Declaraci�n del Atributo Connection que se usar� en todo el package
	static Connection connection;
	
	public static void main(String[] args) {
		// Declaraci�n de Variables Locales
		CrearDB cdb = new CrearDB();
		Piezas p = new Piezas();
		Proveedores p1 = new Proveedores();
		Suministra s = new Suministra();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Password retirada por seguridad
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.45:3306?useTimezone=true&serverTimezone=UTC","remote","PASSWORD");
			System.out.println("Server Connected");
			// Creaci�n de la base de datos
			cdb.crearDB();
			// Creaci�n de la tabla Piezas e inserci�n de datos
			p.createTable();
			p.insertPiezas();
			// Creaci�n de la tabla Proveedores e inserci�n de datos
			p1.createTable();
			p1.insertProveedores();
			// Creaci�n de la tabla Suministra e inserci�n de datos
			s.createTable();
			s.insertSuministra();
			// Cerrar conexi�n con la base de datos
			closeConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con la base de datos.");
			System.out.println(ex);
		}
	}
	
	// M�todo para cerrar la conexi�n con la base de datos
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Se ha finalizado la conexi�n con el servidor");
		}catch(SQLException ex) {
			Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
