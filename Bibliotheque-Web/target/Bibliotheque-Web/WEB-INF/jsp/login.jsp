<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign in</title>
</head>
<body>

<c:set var="titre" value="Login" scope="session"></c:set>
<form:form modelAttribute="nouveauMembre" class="form-horizontal">
    <fieldset>
        <legend>Login</legend>
        <div class="form-group">
            <label class="control-label col-lg-2" for="email">Email</label>
            <div class="col-lg-10">
                <form:input id="email" path="member_email" type="email" required="required" class="form:input-large" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="mdp">Mot de passe</label>
            <div class="col-lg-10">
                <form:input id="mdp" path="member_password" type="password" required="required" class="form:input-large" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
                <input type="submit" id="btnAdd" class="btn btn-primary" value="Créer" />
            </div>
        </div>
    </fieldset>
</form:form>
</body>
</html>
	