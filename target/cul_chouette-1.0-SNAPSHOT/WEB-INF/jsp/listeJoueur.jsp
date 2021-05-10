<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
 <body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Liste des joueurs</h2>
<table border="0" cellpadding="5" cellspacing="1" >
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
</body>
</html>