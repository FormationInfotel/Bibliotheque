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

	<c:choose>
		<c:when test="${user['new']}">
			<h1>Add User</h1>
		</c:when>
		<c:otherwise>
			<h1>Update User</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/users" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="userForm" action="${userActionUrl}">

		<form:hidden path="member_id" />


		<spring:bind path="member_firstname">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Firstname</label>
				<div class="col-sm-10">
					<form:input path="member_firstname" type="text"
						class="form-control" id="firstname" placeholder="Firstname" />
					<form:errors path="member_firstname" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="member_lastname">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Lastname</label>
				<div class="col-sm-10">
					<form:input path="member_lastname" type="text" class="form-control"
						id="lastname" placeholder="Lastname" />
					<form:errors path="member_lastname" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="member_email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="member_email" type="text" class="form-control"
						id="email" placeholder="Email" />
					<form:errors path="member_email" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="member_address">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<form:input path="member_address" type="text" class="form-control"
						id="address" placeholder="Address" />
					<form:errors path="member_address" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="member_Library">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Library</label>
				<div class="col-sm-5">

					<form:select id="ListeLib" name="ListeLib" path="member_Library"
						class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${member_Library}"/>
						<form:options items="${libraryList}" />
					</form:select>
					-

					<form:errors path="member_Library" class="control-label" />
					<%-- 				<p id="${LibId}" hidden="true"></p> --%>
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<spring:bind path="member_password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<form:input path="member_password" type="text" class="form-control"
						id="password" placeholder="Password" />
					<form:errors path="member_password" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${user['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>


</body>
</html>

