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
			<div id="indexPageAdmin">
				<img alt="comida domicilio images" src="<%= application.getContextPath() %>/images/intro.png">
				<div id="texto">
					<h3>Bienvenido/a <%= request.getAttribute("nombreEncargado") %></h3>
					<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum commodo libero ac gravida pharetra. Aenean a posuere nisl. Aliquam non ligula vel massa euismod rhoncus. Cras iaculis ultricies commodo. Aliquam laoreet ipsum nunc, eu hendrerit nibh pellentesque ornare. Vivamus condimentum lacus id ipsum laoreet, in molestie mi pretium. Fusce aliquam posuere ultricies.
In hac habitasse platea dictumst. Praesent convallis massa ut tortor vestibulum commodo. Suspendisse potenti. Quisque eget erat nec augue imperdiet tempus. Vivamus eget eros ultricies, malesuada nunc at, tincidunt tortor. Vivamus commodo ornare ante sit am
					
					</p>
				</div>
				
			</div>
		</div>
	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>