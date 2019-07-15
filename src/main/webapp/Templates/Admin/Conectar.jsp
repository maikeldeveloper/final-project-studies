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
			<nav>
				<ul>
					<li><a>DNI: 51212434</a></li>
					<li><a>Pass: 123456</a></li>
				</ul>
			</nav>
		</header>
		<div id="contenido">
		
		<% 
		if(session.getAttribute("ENCARGADO") == null ){
			String clase;
			if(request.getParameter("error") != null){
				clase = "inputIncorrecto";	
			}else{
				clase = "";
			}
			%>
			<div id="divLogeoAdmin">
			<%	if(request.getAttribute("mensaje") != null){	%>
				<h4><%= request.getAttribute("mensaje") %></h4>
			<% }else{%>
				<h4>Introduzca su codigo y contraseña</h4>
			<%} %>			
				<form method="POST" action="<%= application.getContextPath() %>/admin/conectar">
					<ul>
						<li><input class="<%= clase %>" name="COD_TRA" type="text" placeholder="DNI Trabajador"></li>
						<li><input class="<%= clase %>" name="PASS" type="password" placeholder="Contraseña"></li>
						<li><input type="submit" class="botonVerde" value="Iniciar Control"></li>
					</ul>
				</form>
			</div>
			<div class="clear"></div>
			<% 
		}else{
			if(request.getParameter("mesaje") != null){
			%>
				<h4><%= request.getParameter("mesaje") %></h4>
			<% 
			}	
			%>
			<nav>
				<%@include file="../../WEB-INF/includesAdmin/menu.jspf" %>
			</nav>
			<% 
		} %>
		</div>
		</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>