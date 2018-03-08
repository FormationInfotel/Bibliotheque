<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>

<c:set var="titre" value="Registration" scope="session"></c:set>
	<form:form modelAttribute="nouveauMembre" class="form-horizontal">
    <fieldset>
        <legend>Login</legend>
        <div class="form-group">
            <label class="control-label col-lg-2" ">Firstname</label>
            <div class="col-lg-10">
                <form:input id="Firstname" path="member_firstname" type="text" required="required" class="form:input-large" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" >Lastname</label>
            <div class="col-lg-10">
                <form:input id="Lastname" path="member_lastname" type="text" required="required" class="form:input-large" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" >Address</label>
            <div class="col-lg-10">
                <form:input id="Lastname" path="member_address" type="text" class="form:input-large" />
            </div>
        </div>
         <div class="form-group">
            <label class="control-label col-lg-2" >Email</label>
            <div class="col-lg-10">
                <form:input id="Email" path="member_email" type="email" required="required" class="form:input-large" />
            </div>
        </div>
         <div class="form-group">
            <label class="control-label col-lg-2" >Password</label>
            <div class="col-lg-10">
                <form:input id="Password1" path="" type="password" required="required" class="form:input-large" />
            </div>
        </div>
         <div class="form-group">
            <label class="control-label col-lg-2" >Password comfimation</label>
            <div class="col-lg-10">
                <form:input id="Password" path="member_password" type="password" required="required" class="form:input-large" />
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