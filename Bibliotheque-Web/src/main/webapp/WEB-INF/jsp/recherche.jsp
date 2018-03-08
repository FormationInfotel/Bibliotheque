<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div>
		<%@include file="pageBase.jsp"%>
	</div>
	<div class="jumbotron jumbotron-fluid" id="criteres">
		<div class="container">
			<h1 class="display-4">Recherche</h1>
			<hr>
			<br>
			<form method="POST" action="/ProjetFinal/Resultat">
				<div>
					<input class="form-control" id="txboxRecherche"
						name="txboxRecherche" type="text"
						placeholder="Votre recherche....">
				</div>
				<br>
				<div>
					<label class="form-check-label" for="defaultCheck1">Pour
						affiner votre recherche :</label>
				</div>
				<br>

				<div class="form-group">
					<input class="form-check-input" type="checkbox" value="checkTitre"
						id="checkTitre"> <label class="form-check-label"
						for="defaultCheck1">Titre du livre</label>
				</div>
				<div class="form-group">
					<input class="form-check-input" type="checkbox" value="checkAutor"
						id="checkAutor"> <label class="form-check-label"
						for="defaultCheck1">Auteur</label>
				</div>
				<div class="form-group">
					<input class="form-check-input" type="checkbox" value="checkEditeur"
						id="checkEditeur"> <label class="form-check-label"
						for="defaultCheck1">Editeur</label>
				</div>
				<div class="form-group">
					<input class="form-check-input" type="checkbox" value="categorie"
						id="checkCategory"> <label class="form-check-label"
						for="defaultCheck1">Catégorie</label>
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