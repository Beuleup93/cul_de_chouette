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
<div class="container" align="center">
    <a href="JeuServlet?action=demarrerPartie"><button class="btn btn-warning btn-lg">Veuillez selectionner vos adversaires pour lancer la Partie !!</button></a>
</div>
<br>
<div class="col row col-md-12 mt-2">
    <div class="col-md-4 offset-1">
        <table class="table table-striped table-hover" border="0" cellpadding="5" cellspacing="1" >
            <tr>
                <th>Nom</th>
                <th>Age</th>
                <th>Sexe</th>
                <th>Ville</th>
                <th> Statut</th>
                <th>Choisir</th>

            </tr>
            <c:forEach items="${requestScope.joueurs}" var="sp">
                <tr>
                    <td>${sp.nomJoueur}</td>
                    <td>${sp.age}</td>
                    <td>${sp.sexe}</td>
                    <td>${sp.ville}</td>
                        <%--
                     <td><a href="JoueurServletSecondaire?action=editJoueur&idJoueur=<c:out value="${sp.idJoueur}"/>"><button type="button" class="btn btn-default btn-sm">edit</button></a></td>
                     <td><a href="JoueurServletSecondaire?action=deleteJoueur&idJoueur=<c:out value="${sp.idJoueur}"/>"><button type="button" class="btn btn-danger btn-sm">del</button></a></td>--%>
                    <td><a href="#"><button type="button" class="btn btn-success btn-sm">actif</button></a></td>
                    <td>
                        <a href="JoueurServlet?action=choose&pseudo=<c:out value="${sp.pseudo}"/>">
                            <button type="button" class="btn btn-default btn-sm">choisir</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-4 offset-1">
        <ol class="list-group list-group-numbered">
            <div><b>Nom</b></div>
            <c:forEach items="${requestScope.listeJoueurs}" var="sp">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="col-md-3 ms-2 me-auto">
                        <h6><c:out value="${sp.nomJoueur}" /><br/></h6>
                    </div>
                </li>
            </c:forEach>
        </ol>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
