<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
<%@include file="../../resources/css/footer.css"%>
<%@include file="../../resources/css/navbar.css"%>
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<c:set var="context" value="${pageContext.request.contextPath }"></c:set>
	<!-- /////////////////// -->
	<!-- Header avec nav bar -->
	<!-- /////////////////// -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">Bibliothèque</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExample05" aria-controls="navbarsExample05"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExample05">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="/ProjetFinal/">Accueil <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="/ProjetFinal/recherche">Recherche <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="/ProjetFinal/login">Espace Membre <span class="sr-only">(current)</span>
			</a></li>
		</ul>
		<form class="form-inline" method="POST" action="${context}/recherche">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Nom de livre" aria-label="Search" id="txboxRecherche"
				name="txboxRecherche">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
	</nav>




	<!-- //////////////////// -->
	<!-- Footer avec mentions -->
	<!-- //////////////////// -->
	<footer class="footer">
	<div class="container">
		<a class="text-muted" href="/ProjetFinal/MentionLegale">Mentions
			Légales</a>
	</div>
	</footer>
</body>
</html>