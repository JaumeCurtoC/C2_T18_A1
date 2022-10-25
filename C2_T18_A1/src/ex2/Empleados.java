package ex2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Empleados {
	// Método para crear la tabla
	public void createTable() {
		Connection c = AppMain.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS empleados";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE empleados("+
					"DNI VARCHAR(8) NOT NULL, "+
					"nombre VARCHAR(100) NOT NULL, "+
					"apellidos VARCHAR(255) NOT NULL, "+
					"departamento INT NOT NULL,"+
					"PRIMARY KEY (DNI),"+
					"CONSTRAINT FK_DepartamentoEmpleado FOREIGN KEY (departamento) REFERENCES departamentos(codigo) ON DELETE CASCADE ON UPDATE CASCADE"+
					")";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}
	// Método para insertar datos en la tabla
	public void insertEmpleados() {
		Connection c = AppMain.connection;
		try {
			String query = "INSERT INTO empleados (DNI, nombre, apellidos, departamento) values"+
					"('11112222', 'Nom1', 'Ap1', 1),"+
					"('33334444', 'Nom2', 'Ap2', 2),"+
					"('55556666', 'Nom3', 'Ap3', 3);";
		
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
	
}
