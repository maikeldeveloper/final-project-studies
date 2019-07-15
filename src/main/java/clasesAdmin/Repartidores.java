package clasesAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import conexionBBDD.ConexionMySql;
import beans.RepartidorBeans;

public class Repartidores {
	
	public static Vector<RepartidorBeans> getRepartidores(){
		Vector<RepartidorBeans> repartidores = new Vector<RepartidorBeans>();
		RepartidorBeans repartidorComodin;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		boolean fila;
		String query = "SELECT RE.COD_TRA COD_TRA, NOMBRE, APELLIDOS, DISPONIBLE FROM repartidores RE, trabajadores TR WHERE RE.COD_TRA = TR.COD_TRA";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			fila = resultado.next();
			while(fila){
				repartidorComodin = new RepartidorBeans();
				repartidorComodin.setCod_tra(resultado.getString("COD_TRA"));
				repartidorComodin.setNombre(resultado.getString("NOMBRE"));
				repartidorComodin.setApellidos(resultado.getString("APELLIDOS"));
				repartidorComodin.setDisponible(resultado.getString("DISPONIBLE"));
				repartidores.add(repartidorComodin);
				fila = resultado.next();
			}
		} catch (SQLException e) {
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
		return repartidores;
	}

	public static RepartidorBeans getRepartidorById(String cod_rep) {
		RepartidorBeans repartidorSeleccionado = null;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		String query = "SELECT RE.COD_TRA COD_TRA, DNI, NOMBRE, APELLIDOS, DISPONIBLE FROM repartidores RE, trabajadores TR WHERE RE.COD_TRA = TR.COD_TRA AND RE.COD_TRA = '" + cod_rep + "'";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			if(resultado.next()){
				repartidorSeleccionado.setNombre(resultado.getString("NOMBRE"));
				repartidorSeleccionado.setApellidos(resultado.getString("APELLIDOS"));
				repartidorSeleccionado.setDni(resultado.getString("DNI"));
			}
		} catch (SQLException e) {
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
		return repartidorSeleccionado;
	}
}
