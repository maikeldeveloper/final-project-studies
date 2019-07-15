package clasesAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Statement;



import beans.PaginaAdminBean;
import conexionBBDD.ConexionMySql;

public class PaginaAdministracion {
	
	public static Vector<PaginaAdminBean> getPaginasAdministracion(){
		Vector<PaginaAdminBean> paginasAdministracion = new Vector<PaginaAdminBean>();
		PaginaAdminBean paginaComodin;
		
		String query = "SELECT opcion, path FROM paginas_admin ";
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			while(resultado.next()){
				paginaComodin = new PaginaAdminBean();
				paginaComodin.setOpcion(resultado.getString("opcion"));
				paginaComodin.setPath(resultado.getString("path"));
				paginasAdministracion.add(paginaComodin);
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
		return paginasAdministracion;
	}
}
