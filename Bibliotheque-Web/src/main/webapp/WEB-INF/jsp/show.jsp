<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<div>
		<%@include file="pageBase.jsp"%>
</div>

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">�</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>User Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${user.member_id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Firstname</label>
		<div class="col-sm-10">${user.member_firstname}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Lastname</label>
		<div class="col-sm-10">${user.member_lastname}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${user.member_email}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Address</label>
		<div class="col-sm-10">${user.member_address}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Password</label>
		<div class="col-sm-10">${user.member_password}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Library</label>
		<div class="col-sm-10">${user.member_Library.library_name}</div>
	</div>

</div>


</body>
</html>

