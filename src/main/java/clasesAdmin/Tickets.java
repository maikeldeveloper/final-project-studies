package clasesAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import beans.ClienteBean;
import beans.EncargadoBean;
import beans.IncidenciaBean;
import beans.Lin_PedBean;
import beans.ProductoBean;
import beans.RepartidorBeans;
import beans.TicketsBean;
import clases.Fecha;
import clases.Lin_Ped;
import clases.Pedido;
import conexionBBDD.ConexionMySql;
import excepciones.MiException;

public class Tickets {
	
	public static Vector<TicketsBean> getTicketsEnReparto(){
		Vector<TicketsBean> ticketsEnReparto = new Vector<TicketsBean>();
		TicketsBean ticketComodin;
		ClienteBean clienteComodin;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		boolean fila;
		String query ="SELECT DIRECCION,NUMERO, COD_TIC, HORA_SALIDA "
					+ "FROM tickets TI, pedidos PE, clientes CL "
					+ "WHERE PE.COD_PED = TI.COD_TIC AND "
							+ "PE.NOM_USER=CL.NOM_USER "
							+ "AND HORA_LLEGADA IS NULL";

		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			fila = resultado.next();
			while(fila){
				ticketComodin = new TicketsBean();
				clienteComodin = new ClienteBean();
				clienteComodin.setDireccion(resultado.getString("DIRECCION"));
				clienteComodin.setNumero(resultado.getString("NUMERO"));
				ticketComodin.setCliente(clienteComodin);
				ticketComodin.setCod_tic(resultado.getInt("COD_TIC"));
				ticketComodin.setHora_salida(resultado.getString("HORA_SALIDA"));
				ticketsEnReparto.add(ticketComodin);
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
		return ticketsEnReparto;
	}
	
	public static int crearTicket(String cod_tic, String cod_enc, String cod_rep, Connection conexion) throws SQLException{
		Statement orden;
		int filaAfectada = 0;
		String hora_salida = Fecha.hoy_HHMMSS();
		String query = "INSERT INTO `tickets`(`COD_TIC`,`COD_ENC`,`COD_REP`,`HORA_SALIDA`)"
						+ "VALUES('"+ cod_tic +"','"+ cod_enc +"','"+ cod_rep +"','"+ hora_salida +"')";
		orden=conexion.createStatement();
		filaAfectada = orden.executeUpdate(query);
		return filaAfectada;
	}
	
	public static void asignarPedidos(String cod_tic1, String cod_tic2, String cod_enc, String cod_rep) throws MiException{
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		int filaUpadate;
		String query = "UPDATE repartidores SET DISPONIBLE = 'N' WHERE COD_TRA =" + cod_rep;
		try {
			conexion.setAutoCommit(false);
			orden = conexion.createStatement();
			int insertadoPedido1 = Tickets.crearTicket(cod_tic1, cod_enc, cod_rep, conexion);
			int insertadoPedido2;
			if (cod_tic2 != null) {
				insertadoPedido2 = Tickets.crearTicket(cod_tic2, cod_enc, cod_rep, conexion);
				if (insertadoPedido1 + insertadoPedido2 == 2) {
					filaUpadate = orden.executeUpdate(query);
					conexion.commit();
				}else{
					conexion.rollback();
				}
			}else{
				if (insertadoPedido1 == 1) {
					filaUpadate = orden.executeUpdate(query);
					conexion.commit();
				}else{
					conexion.rollback();
				}
			}
		} catch (SQLException e) {
			if (e.getErrorCode()==1) {
				throw new MiException("El Pedido ya ha sido asignado a otro repartidor");
			}
			e.printStackTrace();
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

	}
	
	public static void desasignarPedidos(String cod_rep){
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		String hora_llegada = Fecha.hoy_HHMMSS();
		String queryUpdateTicket = "UPDATE tickets SET  HORA_LLEGADA = '"+ hora_llegada +"' WHERE COD_REP = "+ cod_rep + " AND HORA_LLEGADA IS NULL";
		String queryUpdateRepartidor = "UPDATE repartidores SET DISPONIBLE = 'S' WHERE COD_TRA =" + cod_rep;
		int intTicket;
		int intRepar;
		try {
			conexion.setAutoCommit(false);
			orden=conexion.createStatement();
			intTicket = orden.executeUpdate(queryUpdateTicket);
			intRepar = orden.executeUpdate(queryUpdateRepartidor);
			if (intTicket + intRepar == 2 || intTicket + intRepar == 3) {
				conexion.commit();
			}else{
				conexion.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	}
	
	/**
	 * Metodo que nos devuelve un Vector que contiene todos los pedidos realizados por un repartidor
	 * @param cod_rep
	 * @return
	 */
	public static Vector<TicketsBean> getTicketsRepartidor(String cod_rep){
		Vector<TicketsBean> ticketsRepartidos = new Vector<TicketsBean>();
		TicketsBean ticketComodin;
		ClienteBean clienteComodin;
		Vector<Lin_PedBean> lineas_pedido_vector_comodin;
		Lin_PedBean lineaPedidoComodin;
		ProductoBean productoComodin;
		
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		boolean fila;
		String query = "SELECT  TK.COD_TIC COD_TIC, "
								+ "PR.NOMBRE PR_NOMBRE, "
								+ "PR.URL_FOTO PR_URL_FOTO, "
								+ "LP.PRECIO_UNI LP_PRECIO, "
								+ "LP.CANTIDAD LP_CANTIDAD, "
								+ "CL.DIRECCION CL_DIRECCION, "
								+ "CL.NUMERO CL_NUMERO, "
								+ "CL.NOMBRE CL_NOMBRE, "
								+ "CL.APELLIDOS CL_APELLIDOS, "
								+ "CL.COD_POSTAL CL_COD_POSTAL, "
								+ "CL.TELEFONO CL_TELEFONO, "
								+ "TK.HORA_SALIDA TK_HORA_SALIDA, "
								+ "TK.HORA_LLEGADA TK_HORA_LLEGADA "
						+ "FROM productos PR, "
								+ "lin_ped LP, "
								+ "pedidos PE, "
								+ "tickets TK, "
								+ "clientes CL "
						+ "WHERE PR.COD_PRO = LP.COD_PRO AND "
								+ "LP.COD_PED = PE.COD_PED "
								+ "AND PE.COD_PED = TK.COD_TIC "
								+ "AND CL.NOM_USER = PE.NOM_USER AND "
								+ "TK.HORA_LLEGADA IS NOT NULL  ";
								if (cod_rep != null) {
									query += "AND TK.COD_REP = '" + cod_rep + "' ";
								}
								
								query += "ORDER BY TK.COD_TIC";
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			fila = resultado.next();
			int cod_tic_aux;
			float importe;
			while(fila){
				cod_tic_aux= resultado.getInt("COD_TIC");
				ticketComodin = new TicketsBean();
				lineas_pedido_vector_comodin = new Vector<Lin_PedBean>();
				clienteComodin = new ClienteBean();
				clienteComodin.setDireccion(resultado.getString("CL_DIRECCION"));
				clienteComodin.setCod_postal(resultado.getString("CL_COD_POSTAL"));
				clienteComodin.setApellidos(resultado.getString("CL_APELLIDOS"));
				clienteComodin.setNombre(resultado.getString("CL_NOMBRE"));
				clienteComodin.setNumero(resultado.getString("CL_NUMERO"));
				clienteComodin.setTelefono(resultado.getString("CL_TELEFONO"));
				ticketComodin.setHora_llegada(resultado.getString("TK_HORA_LLEGADA"));
				ticketComodin.setHora_salida(resultado.getString("TK_HORA_SALIDA"));
				ticketComodin.setCod_tic(resultado.getInt("COD_TIC"));
				importe = 0;
				while (fila && cod_tic_aux == resultado.getInt("COD_TIC")) {
					lineaPedidoComodin = new Lin_PedBean();
					productoComodin = new ProductoBean();
					lineaPedidoComodin.setCantidad(resultado.getInt("LP_CANTIDAD"));
					lineaPedidoComodin.setPrecio_uni(resultado.getFloat("LP_PRECIO"));
					lineaPedidoComodin.setProducto(productoComodin);
					productoComodin.setNombre(resultado.getString("PR_NOMBRE"));
					productoComodin.setUrl_foto(resultado.getString("PR_URL_FOTO"));
					lineas_pedido_vector_comodin.add(lineaPedidoComodin);
					importe = importe + (resultado.getInt("LP_CANTIDAD")*resultado.getFloat("LP_PRECIO"));
					fila = resultado.next();
				}
				ticketComodin.setImporte_ticket(importe);
				ticketComodin.setLineasPedido(lineas_pedido_vector_comodin);
				ticketComodin.setCliente(clienteComodin);
				ticketsRepartidos.add(ticketComodin);
				fila = resultado.next();
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
		
		return ticketsRepartidos;
	}
	
	public static Vector<TicketsBean> getTicketsConIncidencias(String cod_rep){
		Vector<TicketsBean> ticketsConIncidencias = new Vector<TicketsBean>();
		TicketsBean ticketComodin;
		ClienteBean clienteComodin;
		Vector<Lin_PedBean> lineas_pedido_vector_comodin;
		Lin_PedBean lineaPedidoComodin;
		ProductoBean productoComodin;
		RepartidorBeans repartidorComodin;
		EncargadoBean encargadoComodin;
		IncidenciaBean incidenciaComodin;
		
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		boolean fila;
		String query = "SELECT  TK.COD_TIC COD_TIC, "
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
								+ "IC.COD_INC IC_COD_INC "
						+ "FROM productos PR, "
								+ "lin_ped LP, "
								+ "pedidos PE, "
								+ "tickets TK, "
								+ "clientes CL, "
								+ "incidencias IC "
						+ "WHERE PR.COD_PRO = LP.COD_PRO AND "
								+ "LP.COD_PED = PE.COD_PED "
								+ "AND PE.COD_PED = TK.COD_TIC "
								+ "AND CL.NOM_USER = PE.NOM_USER AND "
								+ "TK.COD_TIC = IC.COD_TIC AND "
								+ "TK.HORA_LLEGADA IS NOT NULL  ";
								if (cod_rep != null) {
									query += "AND TK.COD_REP = '" + cod_rep + "' ";
								}
								
								query += "ORDER BY TK.COD_TIC";
								
		//System.out.println(query);
		
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			fila = resultado.next();
			int cod_tic_aux;
			float importe;
			float importe_perdido;
			while(fila){
				cod_tic_aux= resultado.getInt("COD_TIC");
				ticketComodin = new TicketsBean();
				lineas_pedido_vector_comodin = new Vector<Lin_PedBean>();
				clienteComodin = new ClienteBean();
				incidenciaComodin = new IncidenciaBean();
				clienteComodin.setDireccion(resultado.getString("CL_DIRECCION"));
				clienteComodin.setCod_postal(resultado.getString("CL_COD_POSTAL"));
				clienteComodin.setApellidos(resultado.getString("CL_APELLIDOS"));
				clienteComodin.setNombre(resultado.getString("CL_NOMBRE"));
				clienteComodin.setNumero(resultado.getString("CL_NUMERO"));
				clienteComodin.setTelefono(resultado.getString("CL_TELEFONO"));
				ticketComodin.setHora_llegada(resultado.getString("TK_HORA_LLEGADA"));
				ticketComodin.setHora_salida(resultado.getString("TK_HORA_SALIDA"));
				ticketComodin.setCod_tic(resultado.getInt("COD_TIC"));
				incidenciaComodin.setDescripcion(resultado.getString("IC_DESCRIPCION"));
				incidenciaComodin.setCod_inc(resultado.getInt("IC_COD_INC"));
				importe = 0;
				importe_perdido = 0;
				while (fila && cod_tic_aux == resultado.getInt("COD_TIC")) {
					lineaPedidoComodin = new Lin_PedBean();
					productoComodin = new ProductoBean();
					lineaPedidoComodin.setCantidad(resultado.getInt("LP_CANTIDAD"));
					lineaPedidoComodin.setPrecio_uni(resultado.getFloat("LP_PRECIO"));
					lineaPedidoComodin.setCantidad_perdida(resultado.getInt("LP_CANTIDAD_PERDIDA"));
					lineaPedidoComodin.setPrecio_uni_perdida(resultado.getFloat("LP_PRECIO_UNI_PERDIDA"));
					lineaPedidoComodin.setProducto(productoComodin);
					productoComodin.setNombre(resultado.getString("PR_NOMBRE"));
					productoComodin.setUrl_foto(resultado.getString("PR_URL_FOTO"));
					lineas_pedido_vector_comodin.add(lineaPedidoComodin);
					importe = importe + (resultado.getInt("LP_CANTIDAD")*resultado.getFloat("LP_PRECIO"));
					importe_perdido = importe_perdido +(resultado.getInt("LP_CANTIDAD_PERDIDA")*resultado.getFloat("LP_PRECIO_UNI_PERDIDA"));
					fila = resultado.next();
				}
				ticketComodin.setIncidencia(incidenciaComodin);
				ticketComodin.setImporte_ticket(importe);
				ticketComodin.setImporte_perdido(importe_perdido);
				ticketComodin.setLineasPedido(lineas_pedido_vector_comodin);
				ticketComodin.setCliente(clienteComodin);
				ticketsConIncidencias.add(ticketComodin);
				fila = resultado.next();
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
		
		return ticketsConIncidencias;
	}
	
	public static TicketsBean getTicketByCodTic(int cod_tic){
		TicketsBean ticketInformacion = null;
		ClienteBean clienteComodin;
		EncargadoBean encargadoComodin;
		RepartidorBeans repartidorComodin;
		Vector<Lin_PedBean> lineas_pedido_vector_comodin;
		Lin_PedBean lineaPedidoComodin;
		ProductoBean productoComodin;
		
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		boolean fila;
		String query = "SELECT  TIMESTAMPDIFF(MINUTE, PE.dia_hora, TK.hora_salida) as tiempo_en_salir,"
								+ "TK.COD_TIC COD_TIC, "
								+ "PR.NOMBRE PR_NOMBRE, "
								+ "PR.URL_FOTO PR_URL_FOTO, "
								+ "LP.PRECIO_UNI LP_PRECIO, "
								+ "LP.CANTIDAD LP_CANTIDAD, "
								+ "LP.COD_PRO LP_COD_PRO, "
								+ "CL.DIRECCION CL_DIRECCION, "
								+ "CL.NUMERO CL_NUMERO, "
								+ "CL.NOMBRE CL_NOMBRE, "
								+ "CL.APELLIDOS CL_APELLIDOS, "
								+ "CL.COD_POSTAL CL_COD_POSTAL, "
								+ "CL.TELEFONO CL_TELEFONO, "
								+ "TK.HORA_SALIDA TK_HORA_SALIDA, "
								+ "TK.HORA_LLEGADA TK_HORA_LLEGADA, "
								+ "TK.COD_ENC TK_COD_ENC, "
								+ "PE.DIA_HORA DIA_HORA, " 
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
								+ "repartidores RE, "
								+ "trabajadores TRR, "
								+ "encargados EN, "
								+ "trabajadores TRE "
						+ "WHERE PR.COD_PRO = LP.COD_PRO AND "
								+ "LP.COD_PED = PE.COD_PED AND "
								+ "PE.COD_PED = TK.COD_TIC "
								+ "AND CL.NOM_USER = PE.NOM_USER AND "
								+ "TK.HORA_LLEGADA IS NOT NULL AND "
								+ "TK.COD_REP = RE.COD_TRA AND "
								+ "RE.COD_TRA = TRR.COD_TRA AND "
								+ "TK.COD_ENC = EN.COD_TRA AND "
								+ "EN.COD_TRA = TRE.COD_TRA AND "
								+ "TK.COD_TIC = " + cod_tic;
		
		System.out.println(query);

		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			fila = resultado.next();
			int cod_tic_aux;
			float importe;
			if(fila){
				ticketInformacion = new TicketsBean();
				lineas_pedido_vector_comodin = new Vector<Lin_PedBean>();
				clienteComodin = new ClienteBean();
				encargadoComodin = new EncargadoBean();
				repartidorComodin = new RepartidorBeans();
				encargadoComodin.setNombre(resultado.getString("TRE_NOMBRE_ENCARGADO"));
				encargadoComodin.setApellidos(resultado.getString("TRE_APELLIDOS_ENCARGADO"));
				encargadoComodin.setTelefono(resultado.getString("TRE_TELEFONO_ENCARGADO"));
				repartidorComodin.setNombre(resultado.getString("TRR_NOMBRE_REPARTIDOR"));
				repartidorComodin.setApellidos(resultado.getString("TRR_APPELLIDOS_REPARTIDOR"));
				repartidorComodin.setTelefono(resultado.getString("TRR_TELEFONO_REPARTIDOR"));
				clienteComodin.setDireccion(resultado.getString("CL_DIRECCION"));
				clienteComodin.setCod_postal(resultado.getString("CL_COD_POSTAL"));
				clienteComodin.setApellidos(resultado.getString("CL_APELLIDOS"));
				clienteComodin.setNombre(resultado.getString("CL_NOMBRE"));
				clienteComodin.setNumero(resultado.getString("CL_NUMERO"));
				clienteComodin.setTelefono(resultado.getString("CL_TELEFONO"));
				ticketInformacion.setHora_llegada(resultado.getString("TK_HORA_LLEGADA"));
				ticketInformacion.setHora_salida(resultado.getString("TK_HORA_SALIDA"));
				ticketInformacion.setHora_pedido(resultado.getString("DIA_HORA"));
				ticketInformacion.setCod_tic(resultado.getInt("COD_TIC"));
				ticketInformacion.setTiempo_en_salir(resultado.getString("tiempo_en_salir"));
				importe = 0;
				while (fila) {
					lineaPedidoComodin = new Lin_PedBean();
					productoComodin = new ProductoBean();
					lineaPedidoComodin.setCod_pro(resultado.getInt("LP_COD_PRO"));
					lineaPedidoComodin.setCantidad(resultado.getInt("LP_CANTIDAD"));
					lineaPedidoComodin.setPrecio_uni(resultado.getFloat("LP_PRECIO"));
					lineaPedidoComodin.setProducto(productoComodin);
					productoComodin.setNombre(resultado.getString("PR_NOMBRE"));
					productoComodin.setUrl_foto(resultado.getString("PR_URL_FOTO"));
					lineas_pedido_vector_comodin.add(lineaPedidoComodin);
					importe = importe + (resultado.getInt("LP_CANTIDAD")*resultado.getFloat("LP_PRECIO"));
					fila = resultado.next();
				}
				ticketInformacion.setEncargado(encargadoComodin);
				ticketInformacion.setRepartidor(repartidorComodin);
				ticketInformacion.setImporte_ticket(importe);
				ticketInformacion.setLineasPedido(lineas_pedido_vector_comodin);
				ticketInformacion.setCliente(clienteComodin);
				fila = resultado.next();
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
		
		return ticketInformacion;
	}
	public static void main(String[] args) {
//		Vector<TicketsBean> t = Tickets.getTicketsConIncidencias(null);
//		System.out.println(t.get(0).getLineasPedido().get(0).getCantidad());
		TicketsBean T = Tickets.getTicketByCodTic(2);

	}
	
}
