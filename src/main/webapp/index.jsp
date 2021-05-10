<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1>Manipulation de joueurs avec une servlet</h1>

<form action="JoueurServlet" method="post">
    <table border="1">
        <tr>
            <td>Nom</td> <td><input name="nomJoueur"></td>
        </tr>
        <tr>
            <td>Pseudo</td> <td><input name="pseudo"></td>
        </tr>
        <tr>
            <td>password</td> <td><input name="pwd"></td>
        </tr>
        <tr>
            <td>age</td> <td><input name="age"></td>
        </tr>
        <tr>
            <td>sexe</td> <td><input name="sexe"></td>
        </tr>
        <tr>
            <td>Ville</td> <td><input name="ville"></td>
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
<%--<jsp:forward page="/joueurs?action=listeJoueur.jsp"></jsp:forward>--%>
</body>
</html>