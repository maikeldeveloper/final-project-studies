package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Vector;


import beans.ClienteBean;
import beans.PedidoBean;
import conexionBBDD.ConexionMySql;
import excepciones.MiException;

public class Pedido {
	
	public static Vector <PedidoBean> obtenerPedidosPendientes(){
		Vector <PedidoBean> pedidos = new Vector<PedidoBean>();
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		boolean fila;
		String query = "SELECT COD_PED, DIA_HORA, DIRECCION, PISO, NUMERO, LETRA, ESCALERA, COD_POSTAL, TELEFONO, NOMBRE, APELLIDOS, CL.NOM_USER NOM_USER "
				+ "FROM pedidos PE, clientes CL "
				+ "WHERE PE.NOM_USER = CL.NOM_USER AND "
						+ "COD_PED NOT IN(SELECT COD_TIC "
										+ "FROM tickets) "
				+ "ORDER BY COD_PED";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			fila = resultado.next();
			while (fila) {
				PedidoBean pedidoComodin = new PedidoBean();
				ClienteBean clienteComodin = new ClienteBean();
				clienteComodin.setDireccion(resultado.getString("DIRECCION"));
				clienteComodin.setPiso(resultado.getString("PISO"));
				clienteComodin.setNumero(resultado.getString("NUMERO"));
				clienteComodin.setLetra(resultado.getString("LETRA"));
				clienteComodin.setEscalera(resultado.getString("ESCALERA"));
				clienteComodin.setCod_postal(resultado.getString("ESCALERA"));
				clienteComodin.setTelefono(resultado.getString("TELEFONO"));
				clienteComodin.setNom_user(resultado.getString("NOM_USER"));
				clienteComodin.setNombre(resultado.getString("NOMBRE"));
				clienteComodin.setApellidos(resultado.getString("APELLIDOS"));
				pedidoComodin.setCliente(clienteComodin);
				pedidoComodin.setCod_ped(resultado.getString("COD_PED"));
				pedidoComodin.setDia_hora(resultado.getString("DIA_HORA"));
				pedidos.add(pedidoComodin);
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
		return pedidos;
	}
	
	public static int getNumPedido(){
		int numeroPedido = 0;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		String query = "SELECT NUM_PED FROM num_pedido WHERE NUM_PEDIDO='A'";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			resultado.next();
			numeroPedido = resultado.getInt("NUM_PED");
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
		return numeroPedido;
	}
		
	public static boolean realizarPedido(Vector<Lin_Ped> carrito, String nom_user) throws MiException{
		boolean pedidoRealizado = false;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		int resultadoPedido;
		try {
			conexion.setAutoCommit(false);
			
			// 1º CREAR PEDIDO (NOM_USER, COD_PED, DIA_HORA)
			String dia_hora = Fecha.hoy_HHMMSS();
			int cod_ped = Pedido.getNumPedido();
			cod_ped++;
			String queryPedido = "INSERT INTO `pedidos`(`COD_PED`,`NOM_USER`,`DIA_HORA`)VALUES("+cod_ped+",'"+ nom_user +"','"+ dia_hora +"')";
			orden = conexion.createStatement();
			resultadoPedido = orden.executeUpdate(queryPedido);
			
			// 2º SI INSERTA PEDIDO AÑADO LAS LINEAS DEL PEDIDO
			if(resultadoPedido == 1){
				String insert_lin_ped = "INSERT INTO `lin_ped` (`COD_PED`, `COD_PRO`, `CANTIDAD`, `PRECIO_UNI`,`CANTIDAD_PERDIDA`,`PRECIO_UNI_PERDIDO`) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement orden_lin_ped = conexion.prepareStatement(insert_lin_ped);
				int contador = 0;
				for (Lin_Ped linea_pedido : carrito) {
					orden_lin_ped.setInt(1, cod_ped);
					orden_lin_ped.setString(2, linea_pedido.getProducto().getCod_pro());
					orden_lin_ped.setInt(3, linea_pedido.getCantidadProducto());
					orden_lin_ped.setFloat(4, linea_pedido.getProducto().getPrecio());
					orden_lin_ped.setFloat(5, linea_pedido.getCantidadProducto());
					orden_lin_ped.setFloat(6, linea_pedido.getProducto().getPrecio());
					if(orden_lin_ped.executeUpdate() == 1){
						contador++;
					}
				}
				if(contador == carrito.size()){
					
					// 3º AUMENTO EL NUMERO DEL PEDIDO
					String queryNumPed = "UPDATE num_pedido SET NUM_PED = NUM_PED + 1 WHERE NUM_PEDIDO='A'";
					int update;
					update = orden.executeUpdate(queryNumPed);
					conexion.commit();
					pedidoRealizado = true;
				}else{
					conexion.rollback();
					throw new MiException("No se a podido completar su pedido: " + contador + " == " + carrito.size());
				}
			}else{
				System.out.println("NO CREO PEDIDO");
				throw new MiException("NO CREO PEDIDO");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new MiException("No se a podido completar su pedido");		
		} finally{
			try {
				if (conexion != null && !conexion.isClosed())
					conexion.close();
				if (orden != null && !orden.isClosed())
					orden.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pedidoRealizado;
	}	
	
//	public static void main(String[] args) {
//		Vector <PedidoBean> pedidos = Pedido.obtenerPedidosPendientes();
//		//System.out.println(Pedido.getNumPedido());
//	}
	
}
