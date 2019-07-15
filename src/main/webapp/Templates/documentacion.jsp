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
				<ul><li><a style="background: #34530C;">Bienvenido a la documentacion de Shenron</a></li></ul>
			</nav>
			<%@include file="../../WEB-INF/includes/logeo.jspf" %>
		</header>
		<div id="contenido">
			<div id="contenidoIndex">
				<div class="mensaje">MER de la base de datos</div>
				<img alt="MER" src="images/arquitecetura.jpg">
				<div style="height: 40px"></div>
				<div class="mensaje">MER de la base de datos</div>
				<div id="indexPage">
					<img alt="MER" src="images/MER.jpg">
				</div>
			</div>
			<div class="clear"></div>
		</div>
		</div>
	<footer>
			<%@include file="../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>