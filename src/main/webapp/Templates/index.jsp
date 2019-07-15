<%@include file="controlTemplate.jspf" %>
<%@page import="java.util.Vector"%>
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
	<!--[if lt IE 9]>
	<script src="dist/html5shiv.js"></script>
	<![endif]-->
</head>
<body>
	<div id="page-wrapper">
		<header>
			<h1 id="logo"><a href="<%= application.getContextPath() %>/"><span>Esto no se ve es para seo h1</span></a></h1>
			<h2></h2>
			<nav>
				<%@include file="../WEB-INF/includes/menu.jspf" %>
			</nav>
			<%@include file="../../WEB-INF/includes/logeo.jspf" %>
		</header>
		<div id="contenido">
			<div id="contenidoIndex">
			<% 	if(request.getAttribute("mensaje")!= null){	%>
				<div class="mensaje"><%= request.getAttribute("mensaje") %></div>
			<%}%>	
			<div id="indexPage">
				<img alt="comida domicilio images" src="images/intro.png">
				<div id="texto">
					<h3>Bienvenido a  Shenron</h3>
					<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum commodo libero ac gravida pharetra. Aenean a posuere nisl. Aliquam non ligula vel massa euismod rhoncus. Cras iaculis ultricies commodo. Aliquam laoreet ipsum nunc, eu hendrerit nibh pellentesque ornare. Vivamus condimentum lacus id ipsum laoreet, in molestie mi pretium. Fusce aliquam posuere ultricies.
In hac habitasse platea dictumst. Praesent convallis massa ut tortor vestibulum commodo. Suspendisse potenti. Quisque eget erat nec augue imperdiet tempus. Vivamus eget eros ultricies, malesuada nunc at, tincidunt tortor. Vivamus commodo ornare ante sit am
					</p>
				</div>
				
			</div>
			</div>
		</div>
		</div>
	<footer>
			<%@include file="../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>