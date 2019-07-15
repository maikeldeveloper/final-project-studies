package clasesAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBBDD.ConexionMySql;
import beans.BalanceBean;

public class Balance {

	public static BalanceBean getBalance() {
		BalanceBean balanceTotal = null;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		String query = "SELECT COUNT(DISTINCT pe.cod_ped) NUM_PEDIDOS, "
							 + "sum(lp.CANTIDAD*lp.PRECIO_UNI) IMPORTE_TOTAL, "
							 + "sum(lp.CANTIDAD_PERDIDA*lp.PRECIO_UNI_PERDIDO) IMPORTE_PEDIDOS, "
							 + "(sum(lp.CANTIDAD_PERDIDA*lp.PRECIO_UNI_PERDIDO) - sum(lp.CANTIDAD*lp.PRECIO_UNI) ) AS IMPORTE_INCIDENCIAS, "
							 + "(SELECT COUNT(DISTINCT cod_inc) FROM incidencias) AS NUM_INCIDENCIAS "
						+ "FROM lin_ped lp, "
							 + "pedidos pe "
						+ "WHERE pe.COD_PED = lp.COD_PED";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			if (resultado.next()) {
				balanceTotal = new BalanceBean();
				balanceTotal.setNum_pedidos(resultado.getInt("NUM_PEDIDOS"));
				balanceTotal.setNum_incidencias(resultado.getInt("NUM_INCIDENCIAS"));
				balanceTotal.setImporte_incidencias(resultado.getFloat("IMPORTE_INCIDENCIAS"));
				balanceTotal.setImporte_pedidos(resultado.getFloat("IMPORTE_PEDIDOS"));
				balanceTotal.setImporte_total(resultado.getFloat("IMPORTE_TOTAL"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
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
		
		
		return balanceTotal;
	}
	
//	public static void main(String[] args) {
//		BalanceBean b = Balance.getBalance();
//		System.out.println(b.getImporte_incidencias());
//
//	}

}
