<%@include file="../controlTemplate.jspf" %>
<%@page import="beans.Lin_PedBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.TicketsBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Website</title>
	<link rel="stylesheet" href="../css/reset.css">
	<link rel="stylesheet" href="../css/style.css">
	<!--[if lt IE 9]>
	<script src="dist/html5shiv.js"></script>
	<![endif]-->
</head>
<body>
	<div id="page-wrapper">
		<header>
			<h1 id="logo"><a href="<%= application.getContextPath() %>/admin"><span>Esto no se ve es para seo h1</span></a></h1>
			<%@include file="../../WEB-INF/includesAdmin/sesion.jspf" %>
		</header>
		<div id="contenido">
			<%
				TicketsBean ticketInformation = (TicketsBean)request.getAttribute("ticketInformation");
			%>
			<div>
				<h4>Ticket nº: <%= ticketInformation.getCod_tic() %></h4>
				<div id="incidencia_informacion_encargado">
					<h4>Informacion</h4>
					<ul>
						<li>Encargado: <%= ticketInformation.getEncargado().getNombre() + " " + ticketInformation.getEncargado().getApellidos() + " Telefono: " + ticketInformation.getEncargado().getTelefono() %></li>
						<li>Repartidor: <%= ticketInformation.getRepartidor().getNombre() + " " + ticketInformation.getRepartidor().getApellidos() + " Telefono: " + ticketInformation.getRepartidor().getTelefono() %></li>
					</ul>
				</div>
				<div id="incidencia_informacion_repartidor"></div>
				<form action="">
					<fieldset>
						<h5>Datos cliente</h5>
						<ul>
							<li>
								Nombre <input type="text" name="NOMBRE" value="<%= ticketInformation.getCliente().getNombre()%>"> 
								Apellidos <input type="text" name="APELLIDOS" value="<%= ticketInformation.getCliente().getApellidos()%>">
							</li>
							<li> 
								Domicilio <input type="text" name="DIRECCION" value="<%= ticketInformation.getCliente().getDireccion()%>">  
								Nº <input type="text" name="NUMERO" value="<%= ticketInformation.getCliente().getNumero()%>">
							</li>
						</ul>
					</fieldset>
					<fieldset>
						<h5></h5>
						<table>
							<tr>
								<th></th>
								<th>Producto</th>
								<th>Cantidad</th>
								<th>Importe/Ud</th>
								<th>Cantidad perdida</th>
								<th>Importe/Ud perdido</th>
							</tr>
							<% for(Lin_PedBean lin_ped : ticketInformation.getLineasPedido()){
								%>
								<tr>
									<td><img width="75" height="38" src="../imagenes_productos/<%= lin_ped.getProducto().getUrl_foto() %>.jpg"></td>
									<td><%= lin_ped.getProducto().getNombre() %></td>
									<td><input type="text" name="cantidad" value="<%= lin_ped.getCantidad() %>"></td>
									<td><input type="text" name="precio" value="<%= lin_ped.getPrecio_uni()%>"></td>
									<td><input type="text" name="cantidad_perdida" value="<%= lin_ped.getCantidad_perdida() %>"></td>
									<td><input type="text" name="precio" value="<%= lin_ped.getPrecio_uni_perdida() %>"></td>
								</tr>
								<%
							}%>
							<tr>
								<tr></tr>
							</tr>
						</table>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>