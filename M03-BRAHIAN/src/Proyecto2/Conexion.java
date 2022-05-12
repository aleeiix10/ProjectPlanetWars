package Proyecto2;

import java.sql.*;
import javax.swing.*;

public class Conexion {
	private String user;
	private String pass;
	private String url;
	private Connection cn;
	public Conexion(String url1, String user1, String pass1) {
		user=user1;
		pass=pass1;
		url=url1;
		conectar();
		
	}
	public void conectar() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      
            cn = DriverManager.getConnection(url, user, pass);
			System.out.println("Va de putos locos");
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No va una mierda");
		}
	}
	
}

