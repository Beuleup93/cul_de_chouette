<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<br/> <br/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row container col-md-12">
    <div class="col-md-4">
        <div><b>Nom Participant</b></div>
        <c:forEach items="${requestScope.joueurs}" var="sp">
            <ol class="list-group list-group-numbered">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <h6><c:out value="${sp.nomJoueur}" /><br/></h6>
                    </div>
                </li>
        </c:forEach>
    </div>
    <div class="col-md-2 offset-1" >
        <a href="JeuServlet?action=lancer"/>
            <button type="button" class="btn btn-warning btn-lg">Nouveau lancé</button>
        </a>
    </div>
    <div class="col-md-4 offset-1">
        <div><b>Nombre de Point Cumulé</b></div>
        <c:forEach items="${requestScope.joueurs}" var="sp">
        <ol class="list-group list-group-numbered">
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <div><b><c:out value="${sp.nomJoueur}" /></b></div>
                    <h6>Score: <c:out value="${sp.age}" /></h6>
                    <h6>message: <c:out value="${message}" /></h6>
                </div>
            </li>
            </c:forEach>
            <h3>message: <c:out value="${notif}" /></h3>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
