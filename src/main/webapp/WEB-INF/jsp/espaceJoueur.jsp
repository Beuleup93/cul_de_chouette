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

<div class="col col-md-12 row">
    <div class ="col col-md-3 offset-1 jumbotron">
        <ol class="list-group list-group-numbered">
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <div><b>Nom Complet</b></div>
                    <h6><c:out value="${joueur.nomJoueur}" /><br/></h6>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <div><b>Ville</b></div>
                    <h6><c:out value="${joueur.ville}" /><br/></h6>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <div><b>Age</b></div>
                    <h6><c:out value="${joueur.age}" /><br/></h6>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <div><b>Sexe</b></div>
                    <h6><c:out value="${joueur.sexe}" /><br/></h6>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <a href="JoueurServlet?action=modif"><button class="btn btn-success btn-sm">Modifier</button></a>
                </div>
            </li>
        </ol>
    </div>
    <div class ="col col-md-3 offset-1 jumbotron">
        <ol class="list-group list-group-numbered">
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto ml-2">
                    <div>
                        <img src="https://img.icons8.com/small/452/dice.png" width="200" height="280" class="rounded-circle" alt="Cinque Terre">
                    </div>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <a href="JoueurServlet?action=runPartie"><button class="btn btn-success btn-sm">Demarrer la partie</button></a>
                </div>
            </li>
        </ol>
    </div>
    <div class ="col col-md-3 offset-1 jumbotron">
        <ol class="list-group list-group-numbered">
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <div><b>Statistique Globale</b></div>
                </div>
            </li>
        </ol>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
