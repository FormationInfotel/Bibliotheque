<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<c:set var="context" value="${pageContext.request.contextPath }"></c:set>
	<div>
		<%@include file="pageBase.jsp"%>
	</div>
	<div class="jumbotron jumbotron-fluid" id="criteres">
		<div class="container">
			<h1 class="display-4">Recherche</h1>
			<hr>
			<br>
			<form method="POST" action="${context}/recherche">
				<br>
				<div>
					<label class="form-check-label" for="defaultCheck1">Pour
						faire votre recherche :</label>
				</div>
				<br>

				<div>
					<input class="form-control" id="txboxRecherche" name="txboxRecherche"
						type="text" placeholder="Recherche">
				</div>
				<br> <br>
				<div>
					<button type="submit" id="btnRecherche" class="btn btn-primary">Rechercher</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>