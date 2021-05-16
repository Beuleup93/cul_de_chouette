<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="WEB-INF/css/style.css" />
</head>
<body>
<jsp:include page="WEB-INF/jsp/navbar.jsp"/>

<div class="container">
    <div class="container py-5">
        <div class="jumbotron text-white jumbotron-image shadow" style="background-image: url(https://cdn.pixabay.com/photo/2016/09/08/18/45/cube-1655118_1280.jpg);">
            <h2 class="mb-4">
                Let's Try Cul De Chouette
            </h2>
        </div>
        <div align="center">
            <a href="JoueurServlet?action=connexion" class="btn btn-success">Demarrer</a>
        </div>
    </div>
   <%-- <div class="col-12 col-md-6 col-sm-6">
        <h4>Manipulation de joueurs avec une servlet</h4>
        <form action="JoueurServlet" method="post">
            <table border="1">
                <tr>
                    <td>Nom</td> <td>
                    <input name="nomJoueur"></td>
                </tr>
                <tr>
                    <td>Pseudo</td> <td>
                    <input name="pseudo"></td>
                </tr>
                <tr>
                    <td>password</td> <td>
                    <input name="pwd"></td>
                </tr>
                <tr>
                    <td>age</td> <td>
                    <input name="age"></td>
                </tr>
                <tr>
                    <td>sexe</td> <td>
                    <input name="sexe"></td>
                </tr>
                <tr>
                    <td>Ville</td> <td>
                    <input name="ville"></td>
                </tr>
            </table>
            <p>
                <input type="radio" name="action" value="creer" checked="checked" />
                Créer<br />
                <input type="radio" name="action" value="modifier" />
                Modifier<br />
                <input type="radio" name="action" value="supprimer" />
                Supprimer<br />
                <input type="radio" name="action" value="afficher" />
                Afficher la liste
            </p>
            <p>
                <input type="submit" value="Enregistrer">
                <input type="reset" value="Effacer">
            </p>
        </form>
    </div>--%>

</div>

<%--<jsp:forward page="/joueurs?action=listeJoueur.jsp"></jsp:forward>--%>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>