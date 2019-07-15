<%@include file="../controlTemplate.jspf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.TicketsBean" %>
<%@page import="java.util.Vector"%>
<%@page import="beans.Lin_PedBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
	<title>Website</title>
	<link rel="stylesheet" href="<%= application.getContextPath() %>/css/reset.css">
	<link rel="stylesheet" href="<%= application.getContextPath() %>/css/style.css">
	<link rel="stylesheet" href="<%= application.getContextPath() %>/css/styleAdmin.css">
	<!--[if lt IE 9]>
	<script src="dist/html5shiv.js"></script>
	<![endif]-->
</head>
</head>
<body>
<% 	TicketsBean ticketParaIncidencia = (TicketsBean)request.getAttribute("ticket"); %>
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
			<% }else{ %>
				<h4>Crear Incidencia Ticket: <%= ticketParaIncidencia.getCod_tic() %></h4>
			<% }%>
			<div id="detalle_pedido">
				<div id="horas_reparto">
					<ul>
						<li><h5>Datos pedido</h5></li>
						<li><span>Tiempo de salida:</span><%= ticketParaIncidencia.getTiempo_en_salir() %> Minutos</li>
						<li><span>Pedido realizado:</span><%= ticketParaIncidencia.getHora_pedido().substring(10,16) %></li>
						<li><span>Salida de tienda:</span><%= ticketParaIncidencia.getHora_salida().substring(10,16) %></li>
						<li><span>Vuelta del repartidor:</span><%= ticketParaIncidencia.getHora_llegada().substring(10,16) %></li>
						<li><span>Encargado:</span><%= ticketParaIncidencia.getEncargado().getNombre() + " " + ticketParaIncidencia.getEncargado().getApellidos() %></li>
						<li><span>Repartidor:</span><%= ticketParaIncidencia.getRepartidor().getNombre() + " " + ticketParaIncidencia.getRepartidor().getApellidos() %></li>
					</ul>
					<ul>
						<li><span>Nombre: </span><%= ticketParaIncidencia.getCliente().getNombre() + " " + ticketParaIncidencia.getCliente().getApellidos() %></li>
						<li><span>Direccion: </span><%= ticketParaIncidencia.getCliente().getDireccion() + " nº:" + ticketParaIncidencia.getCliente().getNumero() %></li>
						<li><span>Telefono: </span><%= ticketParaIncidencia.getCliente().getTelefono() %></li>
					</ul>
			</div>
			<div id="datos_pedido">
				<form method="POST" action="<%= application.getContextPath() %>/admin/incidencias/grabar-incidencia-ticket">
				<table>
				<tr><th></th><th>Articulo</th><th>Ud.</th><th>&euro;</th><th>Total</th></tr>
					<% for(Lin_PedBean linea_pedido : ticketParaIncidencia.getLineasPedido()){ %>
						<tr>
							<td><img src="<%= application.getContextPath() + "/imagenes_productos/" + linea_pedido.getProducto().getUrl_foto() %>.jpg"></td>
							<td><%= linea_pedido.getProducto().getNombre() %></td>
							<td><input type="text" name="<%= linea_pedido.getCod_pro() %>" value="<%= linea_pedido.getCantidad() %>"></td>
							<td><input type="text" name="<%= linea_pedido.getCod_pro() %>" value="<%= linea_pedido.getPrecio_uni() %>"></td>
							<td><%= (double)Math.round(linea_pedido.getCantidad()*linea_pedido.getPrecio_uni()*100)/100 %>&euro;</td>
							<input type="hidden" name="<%= linea_pedido.getCod_pro() %>" value="<%= linea_pedido.getCantidad() %>">
							<input type="hidden" name="<%= linea_pedido.getCod_pro() %>" value="<%= linea_pedido.getPrecio_uni() %>">
							<input type="hidden" name="<%= linea_pedido.getCod_pro() %>" value="<%= linea_pedido.getProducto().getNombre() %>">
						</tr>
					<% } %>
					<tr><td></td><td></td><td></td><td>Total</td><td><%= (double)Math.round(ticketParaIncidencia.getImporte_ticket()*100)/100 %>&euro;</td></tr>
				</table>
					<div class="headerMotivo">Motivo Incidencia</div>
					<textarea name="descripcion"></textarea>
					<input type="hidden" name="numeroCodTic" value="<%= ticketParaIncidencia.getCod_tic()%>">
					<input type="submit" class="botonVerde" value="Crear Incidencia">
				</form>
			</div>
			<div class="clear"></div>
		</div>
		</div><!-- FIN #contenido -->
	</div><!-- FIN WRAPPER -->
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>