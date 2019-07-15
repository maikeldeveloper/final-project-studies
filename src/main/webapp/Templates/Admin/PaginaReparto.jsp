<%@include file="../controlTemplate.jspf" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Website</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/reset.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/controlReparto.css">
	
	<script type="text/javascript" src="<%= request.getContextPath() %>/javascript/jquery-latest.min.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/javascript/ajaxControlReparto.js"></script>
	
</head>
<body>
<div id="page-wrapper">
		<header>
			<h1 id="logo"><a href="<%= application.getContextPath() %>/admin"><span>Esto no se ve es para seo h1</span></a></h1>
			<h2></h2>
			<nav>
				<%@include file="../../../WEB-INF/includesAdmin/menu.jspf" %>
			</nav>
			<%@include file="../../WEB-INF/includesAdmin/sesion.jspf" %>
		</header>
		<div id="contenido">
		<div id="mensajesControlReparto"></div>
			<div id="reparto">
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<footer>
		<%@include file="../../WEB-INF/includes/footer.jspf" %>
	</footer>
</body>
</html>