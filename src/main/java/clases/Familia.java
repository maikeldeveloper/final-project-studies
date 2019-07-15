package clases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import conexionBBDD.ConexionMySql;

import beans.FamiliaProductoBean;;

public class Familia {
	
	public static Vector<FamiliaProductoBean> getFamilias(){
		Vector<FamiliaProductoBean> familias = new Vector<FamiliaProductoBean>();
		Connection conexion = ConexionMySql.getConexionMySql();
		
		Statement orden = null;
		ResultSet resultado = null;
		String query = "SELECT COD_FAM, NOM_FAM, POSICION FROM familia_producto";
		
		try {
			System.out.println("1");
			orden = conexion.createStatement();
			System.out.println("2");
			resultado = orden.executeQuery(query);
			System.out.println("3");
			while (resultado.next()) {
				FamiliaProductoBean familiaComodin = new FamiliaProductoBean();
				familiaComodin.setCod_familia(resultado.getString("COD_FAM"));
				familiaComodin.setNombreFamilia(resultado.getString("NOM_FAM").toLowerCase());
				familiaComodin.setOrdenMenuFamilias(resultado.getString("POSICION"));
				familias.add(familiaComodin);
			}
			System.out.println("4");
			
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
		return familias;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<FamiliaProductoBean> fami = Familia.getFamilias();
		System.out.println(fami.get(0).getNombreFamilia());
	}
	
}
