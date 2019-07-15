<%@include file="../controlTemplate.jspf" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="description" content="Descripción de la página">
	<meta name="author" content="Hege Refsnes">
	<title>Website</title>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/carrito.css">
	<!--[if lt IE 9]>
	<script src="dist/html5shiv.js"></script>
	<![endif]-->
</head>
<body>
<div id="page-wrapper">
		<header>
			<h1 id="logo"><a href="<%= application.getContextPath() %>/"><span>Esto no se ve es para seo h1</span></a></h1>
			<nav>
				<%@include file="../../WEB-INF/includes/menu.jspf" %>
			</nav>
			
		</header>
		<div id="contenido">
			<div id="contenidoIndex">
			<% 	if(request.getAttribute("mensaje")!= null){	%>
				<div class="mensaje"><%= request.getAttribute("mensaje") %></div>
			<%}%>	
			</div>	
		</div>
		
		<div class="clear"></div>

	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>