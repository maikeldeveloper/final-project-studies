package clasesAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.EncargadoBean;
import beans.TrabajadorBean;
import conexionBBDD.ConexionMySql;

public class Encargados {
	
	public static TrabajadorBean autentificarEncargado( String cod_tra, String pass){
		Connection conexion = ConexionMySql.getConexionMySql();
		TrabajadorBean encargado = null;
		Statement orden = null;
		ResultSet resultado = null;
		boolean encontrado;
		String query = "SELECT TR.COD_TRA COD_TRA, "
										+ "DNI, "
										+ "NOMBRE, "
										+ "APELLIDOS, "
										+ "NACIONALIDAD, "
										+ "TELEFONO, "
										+ "PASS "
						+ "FROM trabajadores TR,  encargados EN "
						+ "WHERE TR.COD_TRA = EN.COD_TRA AND "
										+ "DNI = '"+cod_tra+"' AND "
										+ "PASS='"+pass+"'";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			encontrado = resultado.next();
			System.out.println("resultado.getString DNI)" +resultado.getString("DNI") + " cod " + cod_tra);
			if (encontrado && resultado.getString("DNI").equals(cod_tra) && resultado.getString("PASS").equals(pass)){
				encargado = new TrabajadorBean();
				encargado.setCod_tra(resultado.getString("COD_TRA"));
				encargado.setDni(resultado.getString("DNI"));
				encargado.setNombre(resultado.getString("NOMBRE"));
				encargado.setApellidos(resultado.getString("APELLIDOS"));
				encargado.setNacionalidad(resultado.getString("NACIONALIDAD"));
				encargado.setTelefono(resultado.getString("TELEFONO"));		
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
		return encargado;
	}
	
	public static EncargadoBean getEncargadoByCodEnc(String cod_enc){
		Connection conexion = ConexionMySql.getConexionMySql();
		EncargadoBean encargado = new EncargadoBean();
		Statement orden = null;
		ResultSet resultado = null;
		boolean encontrado;
		String query="SELECT EN.COD_TRA COD_TRA, DNI, NOMBRE, APELLIDOS, TELEFONO, NACIONALIDAD "
					+ "FROM encargados EN, trabajadores TR "
					+ "WHERE EN.COD_TRA = TR.COD_TRA AND "
							+ "EN.COD_TRA='" + cod_enc + "'";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			encontrado = resultado.next();
			if (encontrado) {
				encargado.setNombre(resultado.getString("NOMBRE"));
				encargado.setApellidos(resultado.getString("APELLIDOS"));
				encargado.setDni(resultado.getString("DNI"));
				encargado.setTelefono(resultado.getString("TELEFONO"));
				encargado.setNacionalidad(resultado.getString("NACIONALIDAD"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
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
		return encargado;	
	}
	/*public static void main(String[] args) {
		EncargadoBean miEncargado = Encargados.getEncargadoByCodEnc("3");
		System.out.println(miEncargado.getNacionalidad());
	}*/
}
