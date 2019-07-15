package conexionBBDD;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.ServletException;

import beans.FamiliaProductoBean;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import conexionBBDD.ConnectionPoolContextListener;

/**
 * 
 * @author Angel
 * 
 */
public class ConexionMySql {
	// atributos
	/**
	 * objeto de conexion a la base de datos Mysql
	 * */
	private Connection objconexion;

	// metodos
	/**
	 * permite capturar el objeto de conexion a la base de datos Mysql que se
	 * creo en el costructor
	 * 
	 * @return una conexion a la base de datos Mysql
	 */
	public Connection getConexion() {
		return objconexion;
	}


	
//	public static Connection getConexionMySql() {
//		Connection con = null;
//		
//		return con;
//	}
	
	public static Connection getConexionMySql(){		
		
		
		Connection con = null;

        String url = "jdbc:sqlite:final_project.db";
        
		try {
			Class.forName("org.sqlite.JDBC");

		
	        try {
	            con = DriverManager.getConnection(url);        
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } 
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		return con;
	}
	


	public static void main(String[] args) {
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		String query = "SELECT COD_FAM, NOM_FAM, POSICION FROM familia_producto";
		
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			while (resultado.next()) {
				System.out.println(resultado.getString("NOM_FAM"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if (conexion != null && !conexion.isClosed())
					conexion.close();
				if (orden != null && !orden.isClosed())
					orden.close();
				if (resultado != null && !resultado.isClosed())
					resultado.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
}// fin de la clase



