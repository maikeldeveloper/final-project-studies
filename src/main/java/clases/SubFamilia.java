package clases;

import java.sql.*;
import java.util.Vector;

import conexionBBDD.ConexionMySql;
import beans.MenuSubFamiliaBean;

public class SubFamilia {
	public static Vector<MenuSubFamiliaBean>  cargarMenuSubfamilia(String familia){
		Vector<MenuSubFamiliaBean> subMenu = new Vector<MenuSubFamiliaBean>();
		
		Connection conexion = ConexionMySql.getConexionMySql(); 
		Statement orden = null;
		ResultSet resultado = null;
		String query = "SELECT NOM_SUB, SF.COD_FAM COD_FAM, SF.COD_SUB COD_SUB, IMG_SUB " +
				"FROM subfamilia_producto SF, familia_producto F " +
				"WHERE SF.COD_FAM = F.COD_FAM AND NOM_FAM = '"+familia+"' ";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			while (resultado.next()){
				MenuSubFamiliaBean subFamilia = new MenuSubFamiliaBean();
				subFamilia.setCod_fam(resultado.getString("COD_FAM"));
				subFamilia.setCod_sub(resultado.getString("COD_SUB"));
				subFamilia.setNom_sub(resultado.getString("NOM_SUB").toLowerCase());
				subFamilia.setImg_sub(resultado.getString("IMG_SUB"));
				subMenu.add(subFamilia);
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
		return subMenu;
	}
}
