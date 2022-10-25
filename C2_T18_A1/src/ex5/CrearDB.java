package ex5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrearDB {
	public void crearDB() {
		Connection c = AppMain.connection;
		try {
			// Eliminar la base de datos en caso que exista
			String query = "DROP DATABASE IF EXISTS directiva";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la base de datos desde cero
			query = "CREATE DATABASE directiva";
			st.executeUpdate(query);
			// Indicar la base de datos
			String querydb = "USE directiva;";
			Statement stdb = c.createStatement();
			stdb.executeUpdate(querydb);
			
			System.out.println("Base de datos creada.");
		}catch(SQLException ex) {
			System.out.println("No se ha podido crear la base de datos.");
			Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
