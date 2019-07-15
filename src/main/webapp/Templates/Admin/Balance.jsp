<%@page import="beans.BalanceBean"%>
<%@include file="../controlTemplate.jspf" %>
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
			<%	if(request.getAttribute("mensaje") != null){	%>
				<h4><%= request.getAttribute("mensaje") %></h4>
			<% } %>
			<h4>Balance del repato</h4>
			<% BalanceBean balance = (BalanceBean)request.getAttribute("balance"); %>
			<div id="balance">
				<table>
					<tr><td>Numero de Pedidos</td><td><%= balance.getNum_pedidos()  %></td><td>Importe de Pedidos</td><td class="textRight"><%= balance.getImporte_pedidos()  %> &euro;</td></tr>
					<tr><td>Numero de Incidencias</td><td><%= balance.getNum_incidencias()  %></td><td>Perdidas/Ganancias en incidencias</td><td class="textRight"><%= balance.getImporte_incidencias() %> &euro;</td></tr>
					<tr><td></td><td></td><td class="textRight">Importe total</td><td class="textRight redBold"><%= balance.getImporte_total()  %> &euro;</td></tr>
				</table>
			</div>
		</div>
	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>