package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMain {

	// Declaración del Atributo Connection que se usará en todo el package
	static Connection connection;
	
	public static void main(String[] args) {
		// Declaración de Variables Locales
		CrearDB cdb = new CrearDB();
		Departamentos d = new Departamentos();
		Empleados e = new Empleados();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Password retirada por seguridad
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.45:3306?useTimezone=true&serverTimezone=UTC","remote","PASSWORD");
			System.out.println("Server Connected");
			// Creación de la base de datos
			cdb.crearDB();
			// Creación de la tabla Departamentos e inserción de datos
			d.createTable();
			d.insertDepartamentos();
			// Creación de la tabla Empleados e inserción de datos
			e.createTable();
			e.insertEmpleados();
			// Cerrar conexión con la base de datos
			closeConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con la base de datos.");
			System.out.println(ex);
		}
	}
	
	// Método para cerrar la conexión con la base de datos
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Se ha finalizado la conexión con el servidor");
		}catch(SQLException ex) {
			Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
