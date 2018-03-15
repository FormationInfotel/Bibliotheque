<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign in</title>
</head>
<body>

	<div>
		<%@include file="pageBase.jsp"%>
	</div>
	<%-- 	<c:set var="titre" value="Login" scope="session"></c:set> --%>
	<%-- 	<form:form modelAttribute="membre" class="form-horizontal"> --%>
	<!-- 		<fieldset> -->
	<!-- 			<legend>Login</legend> -->
	<!-- 			<div class="form-group"> -->
	<!-- 				<label class="form-check-label" for="email">Email</label> -->
	<!-- 				<div class="col-lg-10"> -->
	<%-- 					<form:input id="email" path="member_email" type="email" --%>
	<%-- 						required="required" class="form:input-large" /> --%>
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 			<div class="form-group"> -->
	<!-- 				<label class="form-check-label" for="mdp">Mot de passe</label> -->
	<!-- 				<div class="col-lg-10"> -->
	<%-- 					<form:input id="mdp" path="member_password" type="password" --%>
	<%-- 						required="required" class="form:input-large" /> --%>
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 			<div class="form-group"> -->
	<!-- 				<div class="col-lg-10 col-lg-offset-2"> -->
	<!-- 					<input type="submit" id="btnAdd" class="btn btn-primary" -->
	<!-- 						value="Log in" /> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</fieldset> -->
	<%-- 	</form:form> --%>
	<div class="jumbotron jumbotron-fluid" id="criteres">
		<div class="container">
			<h1 class="display-4">Connexion</h1>
			<hr>
			<br>
			<form method="POST" action="${context}/login">
				<br>
				<div>
					<label class="form-check-label" for="defaultCheck1">Se connecter</label>
				</div>
				<br>

				<div>
					<input class="form-control" id="txtboxEmail"
						name="txtboxEmail" type="text" placeholder="Email">
				</div>
				<div>
					<input class="form-control" id="txtboxPswd"
						name="txtboxPswd" type="text" placeholder="Mot de Passe">
				</div>
				<br> <br>
				<div>
					<button type="submit" id="btnConnexion" class="btn btn-primary">Se connecter</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>