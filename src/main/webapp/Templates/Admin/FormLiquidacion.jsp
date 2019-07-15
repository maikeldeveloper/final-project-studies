<%@include file="../controlTemplate.jspf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Vector"%>
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
			<h2></h2>
			<nav>
				<%@include file="../../WEB-INF/includesAdmin/menu.jspf" %>
			</nav>
			<%@include file="../../WEB-INF/includesAdmin/sesion.jspf" %>
		</header>
		<div id="contenido">
			<div id="select_repartidor_liquidacion">
				<h4>Selecciona repartidor</h4>
				<% 
				Vector<RepartidorBeans> repartidores = (Vector<RepartidorBeans>)request.getAttribute("repartidores");
				%>
				<ul>
				<% 
				for(RepartidorBeans repartidor : repartidores){
					%>
					<li><a class="botonVerde" href="<%= request.getContextPath() %>/admin/liquidacion/<%= repartidor.getCod_tra() %>"><%= repartidor.getNombre() + " " + repartidor.getApellidos() %></a></li>
					<%
				}
				%>
				</ul>
			</div>
		</div>
	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>