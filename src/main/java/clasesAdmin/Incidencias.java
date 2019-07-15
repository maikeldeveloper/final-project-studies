package clasesAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import clases.Cliente;
import conexionBBDD.ConexionMySql;
import excepciones.MiException;
import beans.ClienteBean;
import beans.EncargadoBean;
import beans.IncidenciaBean;
import beans.Lin_PedBean;
import beans.PedidoBean;
import beans.ProductoBean;
import beans.RepartidorBeans;
import beans.TicketsBean;

public class Incidencias {
	
	public static IncidenciaBean getDetalleIncidencia(int cod_tic) {
		IncidenciaBean detalleIncidencia = null;
		TicketsBean ticketComodin = null; 
		ClienteBean clienteComodin = null;
		PedidoBean pedidoComodin = null;
		ProductoBean productoComodin = null;
		Lin_PedBean linPedidoComodin = null;
		Vector<Lin_PedBean> lineasPedido = null;
		EncargadoBean encargadoComodin = null;
		RepartidorBeans repartidorComodin = null;
		float dinero_perdido;
		float dinero_ganado;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		boolean fila;
		String query = "SELECT  TIMESTAMPDIFF(MINUTE, PE.dia_hora, TK.hora_salida) as tiempo_en_salir, "
								+ "TK.COD_TIC COD_TIC, "
								+ "PR.NOMBRE PR_NOMBRE, "
								+ "PR.URL_FOTO PR_URL_FOTO, "
								+ "LP.PRECIO_UNI LP_PRECIO, "
								+ "LP.CANTIDAD LP_CANTIDAD, "
								+ "LP.PRECIO_UNI_PERDIDO LP_PRECIO_UNI_PERDIDA, "
								+ "LP.CANTIDAD_PERDIDA LP_CANTIDAD_PERDIDA, "
								+ "CL.DIRECCION CL_DIRECCION, "
								+ "CL.NUMERO CL_NUMERO, "
								+ "CL.NOMBRE CL_NOMBRE, "
								+ "CL.APELLIDOS CL_APELLIDOS, "
								+ "CL.COD_POSTAL CL_COD_POSTAL, "
								+ "CL.TELEFONO CL_TELEFONO, "
								+ "TK.HORA_SALIDA TK_HORA_SALIDA, "
								+ "TK.HORA_LLEGADA TK_HORA_LLEGADA, "
								+ "IC.DESCRIPCION IC_DESCRIPCION, "
								+ "IC.COD_INC IC_COD_INC,"
								+ "DIA_HORA, "
								+ "TRR.NOMBRE TRR_NOMBRE_REPARTIDOR, "
								+ "TRR.APELLIDOS TRR_APPELLIDOS_REPARTIDOR, "
								+ "TRR.TELEFONO TRR_TELEFONO_REPARTIDOR, "
								+ "TRE.NOMBRE TRE_NOMBRE_ENCARGADO, "
								+ "TRE.APELLIDOS TRE_APELLIDOS_ENCARGADO, "
								+ "TRE.TELEFONO TRE_TELEFONO_ENCARGADO "
						+ "FROM productos PR, "
								+ "lin_ped LP, "
								+ "pedidos PE, "
								+ "tickets TK, "
								+ "clientes CL, "
								+ "incidencias IC, "
								+ "repartidores RE, "
								+ "trabajadores TRR, "
								+ "encargados EN, "
								+ "trabajadores TRE "
						+ "WHERE PR.COD_PRO = LP.COD_PRO AND "
								+ "LP.COD_PED = PE.COD_PED AND "
								+ "PE.COD_PED = TK.COD_TIC AND "
								+ "IC.COD_TIC = TK.COD_TIC AND "
								+ "CL.NOM_USER = PE.NOM_USER AND "
								+ "TK.HORA_LLEGADA IS NOT NULL AND "
								+ "TK.COD_REP = RE.COD_TRA AND "
								+ "RE.COD_TRA = TRR.COD_TRA AND "
								+ "TK.COD_ENC = EN.COD_TRA AND "
								+ "EN.COD_TRA = TRE.COD_TRA AND "
								+ "IC.COD_TIC = " + cod_tic;
		
		
		System.out.println(query);
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			fila = resultado.next();
			if (fila) {
				pedidoComodin = new PedidoBean();
				clienteComodin = new ClienteBean();
				ticketComodin = new TicketsBean();
				detalleIncidencia = new IncidenciaBean();
				lineasPedido = new Vector<Lin_PedBean>();
				encargadoComodin = new EncargadoBean();
				repartidorComodin = new RepartidorBeans();
				dinero_perdido = 0;
				dinero_ganado = 0;
								
				clienteComodin.setNombre(resultado.getString("CL_NOMBRE"));
				clienteComodin.setApellidos(resultado.getString("CL_NOMBRE"));
				clienteComodin.setDireccion(resultado.getString("CL_DIRECCION"));
				clienteComodin.setNumero(resultado.getString("CL_NUMERO"));
				clienteComodin.setTelefono(resultado.getString("CL_TELEFONO"));
				encargadoComodin.setNombre(resultado.getString("TRE_NOMBRE_ENCARGADO"));
				encargadoComodin.setApellidos(resultado.getString("TRE_APELLIDOS_ENCARGADO"));
				encargadoComodin.setTelefono(resultado.getString("TRE_TELEFONO_ENCARGADO"));
				repartidorComodin.setNombre(resultado.getString("TRR_NOMBRE_REPARTIDOR"));
				repartidorComodin.setApellidos(resultado.getString("TRR_APPELLIDOS_REPARTIDOR"));
				repartidorComodin.setTelefono(resultado.getString("TRR_TELEFONO_REPARTIDOR"));
				detalleIncidencia.setDescripcion(resultado.getString("IC_DESCRIPCION"));
				detalleIncidencia.setCod_inc(resultado.getInt("IC_COD_INC"));
				detalleIncidencia.setCod_ped(resultado.getInt("COD_TIC"));
				ticketComodin.setTiempo_en_salir(resultado.getString("tiempo_en_salir"));
				ticketComodin.setHora_llegada(resultado.getString("TK_HORA_LLEGADA"));
				ticketComodin.setHora_salida(resultado.getString("TK_HORA_SALIDA"));
				ticketComodin.setHora_pedido(resultado.getString("DIA_HORA"));
				while(fila){
					linPedidoComodin = new Lin_PedBean();
					productoComodin = new ProductoBean();
					productoComodin.setNombre(resultado.getString("PR_NOMBRE"));
					productoComodin.setUrl_foto(resultado.getString("PR_URL_FOTO"));
					linPedidoComodin.setProducto(productoComodin);
					linPedidoComodin.setCantidad(resultado.getInt("LP_CANTIDAD"));
					linPedidoComodin.setCantidad_perdida(resultado.getInt("LP_CANTIDAD_PERDIDA"));
					linPedidoComodin.setPrecio_uni(resultado.getFloat("LP_PRECIO"));
					linPedidoComodin.setPrecio_uni_perdida(resultado.getFloat("LP_PRECIO_UNI_PERDIDA"));
					lineasPedido.add(linPedidoComodin);
					dinero_ganado = dinero_ganado + (resultado.getFloat("LP_CANTIDAD") * resultado.getFloat("LP_PRECIO"));
					dinero_perdido = dinero_perdido + (resultado.getFloat("LP_CANTIDAD_PERDIDA") * resultado.getFloat("LP_PRECIO_UNI_PERDIDA"));
					fila = resultado.next();
				}
				ticketComodin.setCliente(clienteComodin);
				ticketComodin.setImporte_perdido(dinero_perdido);
				ticketComodin.setImporte_ticket(dinero_ganado);
				ticketComodin.setLineasPedido(lineasPedido);
				ticketComodin.setEncargado(encargadoComodin);
				ticketComodin.setRepartidor(repartidorComodin);
				detalleIncidencia.setTicketIncindecia(ticketComodin);
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
		return detalleIncidencia;	
	}
	

	public static boolean creaIncidencia(IncidenciaBean incidencia) throws MiException {
		boolean incidenciaCreada = false;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		int incidenciaInsert;
		try {
			conexion.setAutoCommit(false);
			
			// 1� BORRO SI EXISTE INCIDENCIA ANTIGUA
			String borrarIncidencia = "delete from incidencias where COD_TIC = "+ incidencia.getCod_ped();
			orden = conexion.createStatement();
			orden.execute(borrarIncidencia);
			
			// 2� CREO LA NUEVA INCIDENCIA
			String insertIncidencia = "INSERT INTO `incidencias`(`COD_TIC`,`DESCRIPCION`)VALUES("+ incidencia.getCod_ped() +",'" + incidencia.getDescripcion() + "')";
			//System.out.println(insertIncidencia);
			int contador = 0;
			incidenciaInsert = orden.executeUpdate(insertIncidencia);
			if (incidenciaInsert == 1) {
				System.out.println("HOLA!");
				
				// 3� UPDATE A LAS LINEAS DE PEDIDO
//				String updateLinPed = "UPDATE `lin_ped` SET `CANTIDAD`= ? , `PRECIO_UNI`= ? WHERE `COD_PED`= ? AND `COD_PRO`= ? ";
//				PreparedStatement orden_lin_ped = conexion.prepareStatement(updateLinPed);
//				int update;
//				for (Lin_PedBean linea_pedido : incidencia.getTicketIncindecia().getLineasPedido()) {
//					orden_lin_ped.setInt(1, linea_pedido.getCantidad());
//					orden_lin_ped.setFloat(2, linea_pedido.getPrecio_uni());
//					orden_lin_ped.setInt(3, incidencia.getCod_ped());
//					orden_lin_ped.setInt(4, linea_pedido.getCod_pro());
//					System.out.println(updateLinPed);
//					if(orden.executeUpdate(updateLinPed) == 1)
//						contador++;
//				}		
				String updateLinPed = "";
				for (Lin_PedBean linea_pedido : incidencia.getTicketIncindecia().getLineasPedido()) {
					updateLinPed = "UPDATE `lin_ped` SET `CANTIDAD`= " + linea_pedido.getCantidad()  + " , `PRECIO_UNI`= " + linea_pedido.getPrecio_uni() + " WHERE `COD_PED`= " + incidencia.getCod_ped() + " AND `COD_PRO`= "+ linea_pedido.getCod_pro() + " ";
					orden = conexion.createStatement();
					System.out.println(updateLinPed);
					if(orden.executeUpdate(updateLinPed) == 1)
						contador++;
				}	
			
			if (contador == incidencia.getTicketIncindecia().getLineasPedido().size()) {
				conexion.commit();
			}else{
				conexion.rollback();
			}
		}else{
			conexion.rollback();
		}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		return false;
	}


	public static boolean checkTicket(int numeroPedido) {
		boolean incidenciaCreada = false;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet result= null;
		try {
			orden = conexion.createStatement();
			result = orden.executeQuery("select * from incidencias where cod_tic = " + numeroPedido);
			incidenciaCreada = result.next();
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			try {
				if (conexion != null && !conexion.isClosed())
					conexion.close();
				if (orden != null && !orden.isClosed())
					orden.close();
				if (result != null && !result.isClosed())
					result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return incidenciaCreada;
	}

}
