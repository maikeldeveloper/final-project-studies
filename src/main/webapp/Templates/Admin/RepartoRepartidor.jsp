<%@include file="../controlTemplate.jspf" %>
<%@page import="beans.Lin_PedBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Vector"%>
<%@page import="beans.TicketsBean"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Website</title>
	<link rel="stylesheet" href="<%= application.getContextPath() %>/css/reset.css">
	<link rel="stylesheet" href="<%= application.getContextPath() %>/css/style.css">
	<link rel="stylesheet" href="<%= application.getContextPath() %>/css/styleAdmin.css">
	<!--[if lt IE 9]>
	<script src="dist/html5shiv.js"></script>
	<![endif]-->
</head>
<%
/*
if(session.getAttribute("ENCARGADO") == null){
	response.sendRedirect("IndexAdmin.jsp");
}
*/
%>
<body>
	<div id="page-wrapper">
		<header>
			<h1 id="logo"><a href="<%= application.getContextPath() %>/admin"><span>Esto no se ve es para seo h1</span></a></h1>
			<nav>
				<%@include file="../../WEB-INF/includesAdmin/menu.jspf" %>
			</nav>
			<%@include file="../../WEB-INF/includesAdmin/sesion.jspf" %>
		</header>
		<div id="contenido">
			<div id="listado_reparto_repartidor">
			<% 
			Vector<TicketsBean> ticketsRepartidor = (Vector<TicketsBean>)request.getAttribute("ticketsRepartidor");
			float totalReparto = 0;
			for(TicketsBean ticket : ticketsRepartidor){
				totalReparto = totalReparto + ticket.getImporte_ticket();
			%>
				<div class="ticket_container">
					<div class="ticket_header">
						<ul>
							<li>Ticket <%= ticket.getCod_tic() %></li>
							<li><%= ticket.getCliente().getDireccion() %></li>
							<li>nº: <%= ticket.getCliente().getNumero() %></li>
							<li><a href="<%= application.getContextPath() %>/admin/incidencias/crear-incidencia/<%= ticket.getCod_tic() %>">Crear incidencia</a></li>
							<li class="fl mr0"><%= (double)Math.round(ticket.getImporte_ticket()* 100) / 100 %> &euro;</li>
						</ul>
					</div>
					<div class="ticket_info">
						<table>
							<tr><th></th><th>Articulo</th><th class="talign-r">Cantidad</th><th class="talign-r">Precio</th><th class="talign-r">Total</th></tr>
							<%
							for(Lin_PedBean linea_pedido : ticket.getLineasPedido()){
								%>
								<tr>
									<td><img width="75" height="38" src="<%= application.getContextPath() %>/imagenes_productos/<%= linea_pedido.getProducto().getUrl_foto() %>.jpg"></td>
									<td><%= linea_pedido.getProducto().getNombre() %></td>
									<td class="talign-r pr10"><%= linea_pedido.getCantidad() %> Uds</td>
									<td class="talign-r pr10"><%= linea_pedido.getPrecio_uni() %> &euro;</td>
									<td class="talign-r pr10"><%= (double)Math.round(linea_pedido.getCantidad() * linea_pedido.getPrecio_uni()* 100) / 100 %> &euro;</td>
								</tr>
								<%
							}
							%>
							<tr><td></td><td></td><td></td><td class="talign-r bold  pr10">Total</td><td class="talign-r  pr10"><%= (double)Math.round(ticket.getImporte_ticket()* 100) / 100 %> &euro;</td></tr>
						</table>
					</div>
				</div>
				<%
			}
			%>
			<div id="importe_reparto_total">Importe Total: <%= (double)Math.round(totalReparto * 100) / 100 %> &euro;</div>
			<div class="clear"></div>
			</div>
		</div>
	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>