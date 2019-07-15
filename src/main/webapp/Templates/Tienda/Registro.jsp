<%@include file="../controlTemplate.jspf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="description" content="Descripción de la página">
	<meta name="author" content="Hege Refsnes">
	<title>Website</title>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/formulariosRegistro.css">
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
			<article id="formularioRegistro">
				<% if(request.getAttribute("mensaje") != null){	%>
					<div id="errorAncho"><%= request.getAttribute("mensaje") %></div>
				<% } %>

				<form id="formularioPaginaSolo" action="<%= application.getContextPath()%>/registro" method="POST">
					<input type="hidden" name="accion" value="registro"> 
					<input type="hidden" name="nextPage" value="<%= request.getAttribute("nextPage") %>">
					<%@include file="../../WEB-INF/includes/formularioRegistro.jspf" %>
				</form>
			</article>
			<aside>
				<div id="login">
					<form method="POST" action="<%= application.getContextPath()%>/registro">
					<input type="hidden" name="nextPage" value="<%= request.getAttribute("nextPage") %>">
					<input type="hidden" name="accion" value="conectar">
						<ul>
							<li><input name="NOM_USER" type="text" placeholder="Usuario"></li>
							<li><input name="PASS" type="password" placeholder="Contraseña"></li>
							<li><input type="submit" value="Conectar"></li>
						</ul>
					</form>
				</div>
			</aside>
			<div class="clear"></div>
		</div>
		</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>