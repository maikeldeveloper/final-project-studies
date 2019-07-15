<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Website</title>
	<link rel="stylesheet" href="<%= application.getContextPath() %>/css/reset.css">
	<link rel="stylesheet" href="<%= application.getContextPath() %>/css/style.css">
	<!--[if lt IE 9]>
	<script src="dist/html5shiv.js"></script>
	<![endif]-->
</head>
<body>
	<div id="page-wrapper">
		<header>
			<h1 id="logo"><a href="<%= application.getContextPath() %>/"><span>Esto no se ve es para seo h1</span></a></h1>
		</header>
		<div id="contenido">
			<h6>PAGE NOT FOUND</h6>
			<div id="pageError">
				<a href="<%= application.getContextPath() %>/">
					<img alt="Pagina no encotrada" src="images/pageLogoNotFound.png">
				</a>
			</div>
		</div>
	</div>
	<footer>
			
	</footer>
</body>
</html>