<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">


<body>

<div>
		<%@include file="pageBase.jsp"%>
</div>

	<div class="container">

		 <c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if> 

		<h1>All Users</h1>

		 <table class="table table-striped">
			<thead>
				<tr>
				<!-- 	<th>#ID</th> -->
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
<!-- 					<th>Address</th> -->
<!-- 					<th>Password</th> -->
					<th>Library</th>
				</tr>
			</thead>

			<c:forEach var="user" items="${users}">
			    <tr>
				<%-- <td>
					${user.member_id}
				</td> --%>
				<td>${user.member_firstname}</td>
				<td>${user.member_lastname}</td>
				<td>${user.member_email}</td>
				<%-- <td>${user.member_address}</td>
				<td>${user.member_password}</td> --%>
				<td>${user.member_Library.library_name}</td>
				<td>
				  <spring:url value="/users/${user.member_id}" var="userUrl" />
				  <spring:url value="/users/${user.member_id}/delete" var="deleteUrl" />
				  <spring:url value="/users/${user.member_id}/update" var="updateUrl" />

				  <button class="btn btn-info" onclick="location.href='${userUrl}'">Details</button>
				  <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
<%-- 				  <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button> --%>
				  <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
			    </tr>
			</c:forEach>
		</table>

	</div> 
	


</body>
</html>


