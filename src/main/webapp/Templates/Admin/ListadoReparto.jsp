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
	<script type="text/javascript" src="<%= request.getContextPath() %>/javascript/jquery-latest.min.js"></script>
	<!--[if lt IE 9]>
	<script src="dist/html5shiv.js"></script>
	<![endif]-->
</head>

<script type="text/javascript">
	  $(document).ready(function() {
	 	 var allPanels = $('#contenedor_tickets > div.ticket_info').hide();
	     
	 	  $('#contenedor_tickets > .ticket_header > ul > li:first-child').click(function() {
	 		 if($(this).parent().parent().next().css('display') == 'none'){
	 				allPanels.slideUp();
	 				$(this).parent().parent().next().slideDown( "slow" );
				}else{
					$(this).parent().parent().next().slideUp( "slow" );
				}
	 	    
	 	    return false;
	 	  });
    });
</script>
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
		
			<%	if(request.getAttribute("mensaje") != null){	%>
				<h4><%= request.getAttribute("mensaje") %></h4>
			<% } %>
			<div id="listado_reparto_pedido">
				<form method="POST" action="<%= application.getContextPath() %>/admin/listar-reparto">
					<input type="text" name="num_pedido" placeholder="Nº Pedido">
					<input type="submit" value="Buscar Pedido">
				</form>
			</div>
		
			<div id="contenedor_tickets">
			<% 
			Vector<TicketsBean> ticketsReparto = (Vector<TicketsBean>)request.getAttribute("listadoReparto");
			float totalReparto = 0;
			for(TicketsBean ticket : ticketsReparto){
				%>
					<div class="ticket_header">
						<ul>
							<li class="ojoVer"></li>
							<li>NºTicket: <%= ticket.getCod_tic() %></li>
							<li><%= ticket.getCliente().getDireccion() %></li>
							<li>nº <%= ticket.getCliente().getNumero() %></li>
							<li><a href="<%= application.getContextPath() %>/admin/incidencias/crear-incidencia/<%= ticket.getCod_tic() %>">Crear incidencia</a></li>
							<li>
							<form method="POST" action="<%= application.getContextPath() %>/admin/listar-reparto">
								<input type="hidden" name="num_pedido" value="<%= ticket.getCod_tic() %>">
								<input type="submit" class="classHref" value="Ver Pedido">
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