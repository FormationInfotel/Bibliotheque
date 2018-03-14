<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<c:url value="/resources/img/" var="img" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BibliGestion !</title>
</head>
<body>
	<div>
		<%@include file="pageBase.jsp"%>
	</div>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">BibliGestion</h1>
			<p class="lead">Bienvenue dans l'espace de gestion de votre
				bibliothèque !</p>
		</div>
	</div>
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row">
				<c:forEach items="${recommendedBooks}" var="book">
					<div class="col-md-4">
						<div class="card mb-4 box-shadow">
							<img class="card-img-top" src="${img}${book.image_path}.jpg" />
							<div class="card-body">
								<p class="card-text">${book.book_title}</p>
								<p class="card-text">${book.book_description}</p>
								<p class="card-text">${book.book_price}     euros</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">Voir
											Livre</button>
										<button type="button" class="btn btn-sm btn-outline-secondary">Ajouter
											au panier</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
</html>