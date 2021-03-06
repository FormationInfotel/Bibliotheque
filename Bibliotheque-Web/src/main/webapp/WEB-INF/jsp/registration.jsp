<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<div>
		<%@include file="pageBase.jsp"%>
	</div>
	<c:set var="titre" value="Registration" scope="session"></c:set>
	<div class="jumbotron jumbotron-fluid">
	<div class="container">
	<form:form modelAttribute="nouveauMembre" class="form-horizontal">
		<fieldset>
			<legend>Sign up</legend>
			<div class="form-group">
				<label class="control-label col-lg-2">Firstname</label>

				<form:input id="Firstname" path="member_firstname" type="text"
					required="required" class="form:input-large" />

			</div>
			<div class="form-group">
				<label class="control-label col-lg-2">Lastname</label>

				<form:input id="Lastname" path="member_lastname" type="text"
					required="required" class="form:input-large" />

			</div>
			<div class="form-group">
				<label class="control-label col-lg-2">Postal address</label>

				<form:input id="Postaladdress" path="member_address" type="text"
					class="form:input-large" />

			</div>
			<div class="form-group">
				<label class="control-label col-lg-2">Member's Library</label>

				<form:select path="member_Library" modelAttribute="biblioDuMembre">
					<form:option value="NONE" label="Library" />
					<form:options value="" items="${libraryList}" />
				</form:select>

			</div>
			<div class="form-group">
				<label class="control-label col-lg-2">Email</label>

				<form:input id="Email" path="member_email" type="email"
					required="required" class="form:input-large" />

			</div>
			<div class="form-group">
				<label class="control-label col-lg-2">Password</label>

				<form:input id="Password1" path="" type="password"
					required="required" class="form:input-large" />

			</div>
			<div class="form-group">
				<label class="control-label col-lg-2">Password confirmation</label>

				<form:input id="Password" path="member_password" type="password"
					required="required" class="form:input-large" />

			</div>
			<div class="form-group">

				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Register" />

			</div>
		</fieldset>
	</form:form>
	</div>
	</div>

</body>
</html>

