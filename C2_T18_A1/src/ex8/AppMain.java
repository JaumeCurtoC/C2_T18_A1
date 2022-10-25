package ex8;

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
		Productos p = new Productos();
		Cajeros c = new Cajeros();
		Maquinas_Registradoras m = new Maquinas_Registradoras();
		Venta v = new Venta();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Password retirada por seguridad
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.45:3306?useTimezone=true&serverTimezone=UTC","remote","PASSWORD");
			System.out.println("Server Connected");
			// Creación de la base de datos
			cdb.crearDB();
			// Creación de la tabla Productos e inserción de datos
			p.createTable();
			p.insertProductos();
			// Creación de la tabla Cajeros e inserción de datos
			c.createTable();
			c.insertCajeros();
			// Creación de la tabla Maquinas_Registradoras e inserción de datos
			m.createTable();
			m.insertMaquinas();
			// Creación de la tabla Venta e inserción de datos
			v.createTable();
			v.insertVentas();
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
