<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body class="container">
    
    <div class="container w-75">
        <h1 class="my-5">Welcome, <c:out value="${user.name}"/></h1>
        <table class="table">
            <thead class="table-secondary">
                <tr>
                    <th scope="col">Idea</th>
                    <th scope="col">Creado By</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Maasdasdasdadrk</td>
                    
                    
                </tr>
            <c:forEach var="ideas" items="${ideas}">
                <tr>
                    <td><a href="/ideas/${ideas.id}"><c:out value="${ideas.description}"/></a></td>
                    <td><c:out value="${ideas.user.name}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/logout" class="btn btn-secondary">Cerrar Sesion</a>
        <a href="/ideas/new" class="btn btn-secondary">Create an idea</a>
    </div>
    

    
</body>
</html>