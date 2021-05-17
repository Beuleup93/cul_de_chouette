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
	<div class="container mb-2">
		<h5 align="center">Liste des joueurs</h5>
		<table class="table table-striped table-hover table-dark" border="0" cellpadding="5" cellspacing="1" >
			<tr>
				<th>Nom</th>
				<th>Pseudo</th>
				<th>Sexe</th>
				<th>Ville</th>
				<th colspan=3 scope="col"> Action</th>
			</tr>
			<c:forEach items="${requestScope.joueurs}" var="sp">
				<tr>
					<td>${sp.nomJoueur}</td>
					<td>${sp.pseudo}</td>
					<td>${sp.sexe}</td>
					<td>${sp.ville}</td>
					<%--<td><a href="JoueurServletSecondaire?action=editJoueur&idJoueur=<c:out value="${sp.idJoueur}"/>"><button type="button" class="btn btn-default btn-sm">edit</button></a></td>
					<td><a href="JoueurServletSecondaire?action=deleteJoueur&idJoueur=<c:out value="${sp.idJoueur}"/>"><button type="button" class="btn btn-danger btn-sm">del</button></a></td>--%>
					<td><a href="JoueurServlet?action=viewJoueur&idJoueur=<c:out value="${sp.idJoueur}"/>"><button type="button" class="btn btn-default btn-sm">view</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 </body>
</html>