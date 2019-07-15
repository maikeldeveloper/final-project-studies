<%@include file="../controlTemplate.jspf" %>
<%@page import="beans.Lin_PedBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Vector"%>
<%@page import="beans.TicketsBean"%>
<%@page import="beans.RepartidorBeans"%>


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

<body>
	<div id="page-wrapper">
		<header>
			<h1 id="logo"><a href="<%= application.getContextPath() %>/admin"><span>Esto no se ve es para seo h1</span></a></h1>
			<h2></h2>
			<nav>
				<%@include file="../../WEB-INF/includesAdmin/menu.jspf" %>
			</nav>
			<%@include file="../../WEB-INF/includesAdmin/sesion.jspf" %>
		</header>
		<div id="contenido">
			<%	if(request.getAttribute("mensaje") != null){	%>
				<h4><%= request.getAttribute("mensaje") %></h4>
			<% } %>
			<div id="menu_incidencia">
				<ul>
					<li>
						<form action="<%= request.getContextPath() %>/admin/incidencias/incidencia" method="post">
							<label>Buscar Incidencia:</label><input type="text" name="numero_ticket_buscar">
							<input type="submit" value="Buscar Incidencia">
						</form>
					</li>
					<li>
						<form action="<%= request.getContextPath() %>/admin/incidencias/crear-incidencia" method="post">
							<label>Crear Incidenca:</label><input type="text" name="numero_ticket_crear">
							<input type="submit" value="Crear Incidencia">
						</form>
					</li>	
					<%-- <li>
						<form action="<%= request.getContextPath() %>/incidencias/repartidor" method="post">
							Incidencias Repartidor:
							<select>
								<%
								Vector<RepartidorBeans> repartidores = (Vector<RepartidorBeans>)request.getAttribute("repartidores");
								for(RepartidorBeans repartidor: repartidores){
									%>
									<option value="<%= repartidor.getCod_tra() %>"><%= repartidor.getNombre() + ", " + repartidor.getApellidos() %></option>
									<%
								}
								%>
							</select>
							<input type="submit" value="Buscar Incidencias">
							<input type="text" name="opcion_menu_incidencia" value="buscarIncidenciaPorCod_Rep" hidden>
						</form> 
					</li>--%>
				</ul>
			</div>
			<div id="contenedor_tickets">
			<% 
			Vector<TicketsBean> ticketsReparto = (Vector<TicketsBean>)request.getAttribute("ticketsConIncidencia");
			float totalReparto = 0;
			for(TicketsBean ticket : ticketsReparto){
				%>
					<div class="ticket_header">
						<ul>
							<li>NºTicket: <%= ticket.getCod_tic() %></li>
							<li><%= ticket.getCliente().getDireccion() %></li>
							<li>nº <%= ticket.getCliente().getNumero() %></li>
							<li>
								<form action="<%= application.getContextPath() %>/admin/incidencias/incidencia" method="post">
									<input type="hidden" name="numero_ticket_buscar" value="<%= ticket.getCod_tic() %>">
									<input class="classHref" type="submit" value="Ver Incidencia">
							
								</form>
							</li>
							<li class="fl mr0">Total: <%= (double)Math.round(ticket.getImporte_ticket() * 100) / 100 %> &euro;</li>
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
									<td class="talign-r pr10"><%= linea_pedido.getCantidad() %> ud.</td>
									<td class="talign-r pr10"><%= linea_pedido.getPrecio_uni() %>  &euro;</td>
									<td class="talign-r pr10"><%= (double)Math.round(linea_pedido.getCantidad() * linea_pedido.getPrecio_uni() * 100) / 100 %> &euro;</td>
								</tr>
								<%
							}
							%>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td class="talign-r bold  pr10">Total</td>
								<td class="talign-r  pr10"><%= (double)Math.round(ticket.getImporte_ticket() * 100) / 100 %> &euro;</td>
								<% totalReparto = totalReparto + ticket.getImporte_ticket(); %>
							</tr>
						</table>
					</div>
				
				<div class="separadorTablas"></div>
				<%
			}
			%>
			</div>
		</div>
	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>