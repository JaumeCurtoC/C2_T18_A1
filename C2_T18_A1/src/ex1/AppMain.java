package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AppMain {

	static Connection connection;
	
	public static void main(String[] args) {
		CreateDB cdb = new CreateDB();
		Fabricantes f = new Fabricantes();
		Articulos a = new Articulos();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.45:3306?useTimezone=true&serverTimezone=UTC","remote","Arcangel1999!");
			System.out.println("Server Connected");
			cdb.crearDB();
			
			f.createTable();
			f.insertFabricantes();
			
			a.createTable();
			a.insertArticulos();
			
			closeConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con la base de datos.");
			System.out.println(ex);
		}
	}
	
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Se ha finalizado la conexión con el servidor");
		}catch(SQLException ex) {
			Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
