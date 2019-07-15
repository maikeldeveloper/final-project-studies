package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import conexionBBDD.ConexionMySql;

import beans.ProductoBean;

public class Producto {
	
	public static Vector<ProductoBean> getProductos(String familia, String subfamilia){
		Vector<ProductoBean> productos = new Vector<ProductoBean>();
		Connection conexion = ConexionMySql.getConexionMySql();
		
		Statement orden = null;
		ResultSet resultadoQuery = null;
		String query = "SELECT COD_PRO, COD_SUB, DESCRIPCION, NOMBRE, PRECIO, URL_FOTO "
					+ "FROM productos  "
					+ "WHERE COD_SUB IN (SELECT COD_SUB "
										+ "FROM subfamilia_producto "
										+ "WHERE COD_FAM IN (SELECT COD_FAM "
															+ "FROM familia_producto "
															+ "WHERE NOM_FAM='"+ familia +"')) ";
		if(subfamilia != null){
			query += "AND COD_SUB IN (SELECT COD_SUB "
									+ "FROM subfamilia_producto "
									+ "WHERE NOM_SUB = '" + subfamilia + "') ";
		}
		try {
			orden = conexion.createStatement();
			resultadoQuery = orden.executeQuery(query);
			while (resultadoQuery.next()) {
				ProductoBean productoComodin = new ProductoBean();
				productoComodin.setCod_pro(resultadoQuery.getString("COD_PRO"));
				productoComodin.setCod_sub(resultadoQuery.getString("COD_SUB"));
				productoComodin.setDescripcion(resultadoQuery.getString("DESCRIPCION"));
				productoComodin.setNombre(resultadoQuery.getString("NOMBRE"));
				productoComodin.setPrecio(resultadoQuery.getFloat("PRECIO"));
				productoComodin.setUrl_foto(resultadoQuery.getString("URL_FOTO"));
				productos.add(productoComodin);
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
				if (resultadoQuery != null && !resultadoQuery.isClosed())
					resultadoQuery.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return productos;
	}

	public static ProductoBean getProductoByCodigo(String cod_pro){
		ProductoBean productoComodin = new ProductoBean();
		Connection conexion = ConexionMySql.getConexionMySql();
		
		Statement orden = null;
		ResultSet resultadoQuery = null;
		String query = "SELECT COD_PRO, COD_SUB, NOMBRE, PRECIO, DESCRIPCION, URL_FOTO "
						+ "FROM productos "
						+ "WHERE COD_PRO = '"+cod_pro+"'";
		try {
			orden = conexion.createStatement();
			resultadoQuery = orden.executeQuery(query);
			while(resultadoQuery.next()){
				productoComodin.setCod_pro(resultadoQuery.getString("COD_PRO"));
				productoComodin.setCod_sub(resultadoQuery.getString("COD_SUB"));
				productoComodin.setDescripcion(resultadoQuery.getString("DESCRIPCION"));
				productoComodin.setNombre(resultadoQuery.getString("NOMBRE"));
				productoComodin.setPrecio(resultadoQuery.getFloat("PRECIO"));
				productoComodin.setUrl_foto(resultadoQuery.getString("URL_FOTO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if (conexion != null && !conexion.isClosed())
					conexion.close();
				if (orden != null && !orden.isClosed())
					orden.close();
				if (resultadoQuery != null && !resultadoQuery.isClosed())
					resultadoQuery.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productoComodin;
	}
	/*
	public static void main(String[] args){
		ProductoBean productoComodin = Producto.getProductoByCodigo("1203");
		System.out.println(productoComodin.getNombre());
	}
	*/
	
}
