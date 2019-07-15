<%@include file="../controlTemplate.jspf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="description" content="Descripción de la página">
	<meta name="author" content="Hege Refsnes">
	<title>Website</title>
	<link rel="stylesheet" href="<%=application.getContextPath()%>/css/reset.css">
	<link rel="stylesheet" href="<%=application.getContextPath()%>/css/style.css">
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
			<%@include file="../../WEB-INF/includes/logeo.jspf" %>
		</header>
		<div id="contenido">
			<article>
				<div id="subMenu">
					<%@include file="../../WEB-INF/includes/subMenu.jspf" %>
				</div>
				<div class="clear"></div>
				<%@include file="../../WEB-INF/includes/productos.jspf" %>
			</article>
			<aside>
				<% 	if(request.getAttribute("mensaje")!= null){	%>
					<div class="mensaje"><%= request.getAttribute("mensaje") %></div>
				<%}%>
				<%@include file="../../WEB-INF/includes/mostrarCarrito.jspf" %>
			</aside>
			<div class="clear"></div>
		</div>
		</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>