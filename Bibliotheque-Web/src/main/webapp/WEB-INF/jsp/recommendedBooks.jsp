<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Recommended Books</title>
</head>

<body>
	<div>
		<div class="jumbotron">
			<div class="container">
				<h1>Books</h1>
				<p>Recommended Books available in our store</p>
			</div>
		</div>
	</div>


	<div class="container">
		<div class="row">
			<c:forEach items="${recommendedBooks}" var="book">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">

							<h3>${book.book_title}</h3>
							<p>${book.ISBN}</p>
							<p>${book.book_description}</p>
							<p>${book.book_price}</p>
							<!--  <p>${book.image_path}</p> -->
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


</body>
</html>