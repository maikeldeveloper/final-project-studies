<%@include file="../controlTemplate.jspf" %>
<%@page import="beans.TicketsBean"%>
<%@page import="java.util.Vector"%>
<%@page import="beans.Lin_PedBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<% TicketsBean pedidoSeleccionado = (TicketsBean)request.getAttribute("pedidoSeleccionado"); %>
			<h4>Detalles del Pedido: Ticket <%= pedidoSeleccionado.getCod_tic() %> - <a href="<%= application.getContextPath() %>/admin/incidencias/crear-incidencia/<%= pedidoSeleccionado.getCod_tic() %>">Crear incidencia</a></h4>
			<div id="detalle_pedido">
				<div id="horas_reparto">	
					<ul>
						<li><h5>Datos pedido</h5></li>
						<li><span>Tiempo de salida:</span><%= pedidoSeleccionado.getTiempo_en_salir() %> Minutos</li>
						<li><span>Pedido realizado:</span><%= pedidoSeleccionado.getHora_pedido().substring(10,16) %></li>
						<li><span>Salida de tienda:</span><%= pedidoSeleccionado.getHora_salida().substring(10,16) %></li>
						<li><span>Vuelta del repartidor:</span><%= pedidoSeleccionado.getHora_llegada().substring(10,16) %></li>
						<li><span>Encargado:</span><%= pedidoSeleccionado.getEncargado().getNombre() + " " + pedidoSeleccionado.getEncargado().getApellidos() %></li>
						<li><span>Repartidor:</span><%= pedidoSeleccionado.getRepartidor().getNombre() + " " + pedidoSeleccionado.getRepartidor().getApellidos() %></li>
					</ul>				
					<ul>
						<li><h5>Datos cliente</h5></li>
						<li><span>Nombre:</span><%= pedidoSeleccionado.getCliente().getNombre() + " " + pedidoSeleccionado.getCliente().getApellidos() %></li>
						<li><span>Direccion:</span><%= pedidoSeleccionado.getCliente().getDireccion() + " nº:" + pedidoSeleccionado.getCliente().getNumero() %></li>
						<li><span>Telefono:</span><%= pedidoSeleccionado.getCliente().getTelefono() %></li>
					</ul>
				</div>
				<div id="datos_pedido">
					<table>
						<tr><th></th><th>Articulo</th><th>Ud.</th><th>&euro;</th><th>Total</th></tr>
						<% for(Lin_PedBean linea_pedido : pedidoSeleccionado.getLineasPedido()){ %>
							<tr>
								<td><img src="<%= application.getContextPath() + "/imagenes_productos/" + linea_pedido.getProducto().getUrl_foto() %>.jpg"></td>
								<td class="talign-r pr10"><%= linea_pedido.getProducto().getNombre() %></td>
								<td class="talign-r pr10"><%= linea_pedido.getCantidad() %></td>
								<td class="talign-r pr10"><%= linea_pedido.getPrecio_uni() %>&euro;</td>
								<td class="talign-r pr10"><%= (double)Math.round(linea_pedido.getCantidad()*linea_pedido.getPrecio_uni() * 100) / 100 %>&euro;</td>
							</tr>
						<% } %>
						<tr><td></td><td></td><td></td><td><b>Total</b></td><td><b><%= (double)Math.round(pedidoSeleccionado.getImporte_ticket() * 100) / 100  %>&euro;</b></td></tr>
					</table>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>