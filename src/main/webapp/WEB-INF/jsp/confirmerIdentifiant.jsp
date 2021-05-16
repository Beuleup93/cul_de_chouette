<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<br/><br/>
<div class="container">
    <h6 style="align-content: center;color:green;font-family: 'Times New Roman';"><c:out value="${success}" /></h6>
</div>
<div class="container card">
    <div class="card-header">
        <h4 align="center" style="color:red;font-family: 'Times New Roman';"> Veuillez confirmer votre identité pour acceder à ton profil!!</h4>
    </div>
    <div class="card-body">
        <div classe="col-md-10 offset-3">
            <form method="Post" action="JoueurServletSecondaire">
                <div class="form-group col-md-5 offset-3">
                    <label for="exampleInputEmail1">User</label>
                    <input type="text" class="form-control" name="pseudonyme" value="${joueur.pseudo}" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Pseudo">
                </div>
                <div class="form-group col-md-5 offset-3">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="form-group col-md-5 offset-3">
                    <a href="JoueurServlet?action=inscription">Creez un compte si vous en avez pas!</a>
                </div>
                <div class="form-check col-md-5 offset-3">
                    <input type="hidden" class="btn btn-primary" name="confirmer" value="confirmer"/>
                    <input type="submit" class="btn btn-success" value="confirmer"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>