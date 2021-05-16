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
    <div class="container">
        <div class="card offset-1">
            <div class="card-header">
                <h5 align="center">Formulaire d'ajout Joueurs</h5>
            </div>
            <div class="card-body">
                <form method="Post" action="JoueurServletSecondaire">
                    <div class="form-group">
                        <label for="name">Nom</label>
                        <input type="text" name="name" class="form-control" id="name" value="${joueur.nom}" placeholder="Nom">
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
                        <label for="ville">Ville</label>
                        <input type="text" class="form-control" name="ville" id="ville" placeholder="ville">
                    </div>
                    <div class="form-group">
                        <label for="ville">Sexe</label>
                        <div class="row">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" value="M" name="flexRadioDefault" id="flexRadioDefault1">
                                <label class="form-check-label" for="flexRadioDefault1">
                                    Masculin
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" value="F" name="flexRadioDefault" id="flexRadioDefault2" checked>
                                <label class="form-check-label" for="flexRadioDefault2">
                                    Feminin
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="hidden" class="btn btn-primary" name="addJoueur" value="Add"/>
                        <input type="submit" class="btn btn-success"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
