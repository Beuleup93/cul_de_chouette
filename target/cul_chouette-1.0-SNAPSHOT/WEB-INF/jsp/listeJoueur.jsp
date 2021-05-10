<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp"/> <br/>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="row col-md-12">
		<div class="card col-md-4 offset-1">
			<div class="card-header">
				Formulaire d'ajout Joueurs
			</div>
			<div class="card-body">
				<h4 align="center">Formulaire d'ajout Joueurs</h4>
				<form method="Post" action="ControleurSecondaire">
					<div class="form-group">
						<label for="name">Nom</label>
						<input type="text" name="ref" class="form-control" id="name" placeholder="Nom">
					</div>
					<div class="form-group">
						<label for="pseudo">Pseudo</label>
						<input type="text" class="form-control" name="pseudo" id="pseudo" placeholder="Pseudo">
					</div>
					<div class="form-group">
						<label for="pwd">Password</label>
						<input type="password" name="pwd" class="form-control" id="pwd" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="age">Age</label>
						<input type="text" class="form-control" name="age" id="age" placeholder="Age">
					</div>
					<div class="form-group">
						<label for="age">Sexe</label>
						<input type="text" class="form-control" name="sexe" id="sexe" placeholder="Sexe">
					</div>
					<div class="form-group">
						<label for="ville">Ville</label>
						<input type="text" class="form-control" name="ville" id="ville" placeholder="ville">
					</div>
					<div class="form-group">
						<input type="hidden" class="btn btn-primary" name="addJoueur" value="Add Joueur"/>
						<input type="submit" class="btn btn-success"/>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-6 offset-1">
			<table class="table table-striped table-hover table-dark" border="0" cellpadding="5" cellspacing="1" >
				<h4 align="center">Liste des joueurs</h4>
				<tr>
					<th>Nom</th>
					<th>Pseudo</th>
					<th>Age</th>
					<th>Sexe</th>
					<th>Ville</th>
				</tr>
				<c:forEach items="${requestScope.joueurs}" var="sp">
					<tr>
						<td>${sp.nomJoueur}</td>
						<td>${sp.pseudo}</td>
						<td>${sp.age}</td>
						<td>${sp.sexe}</td>
						<td>${sp.ville}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 </body>
</html>