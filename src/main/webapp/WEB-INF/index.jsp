<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ideas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>


<body class="container">    
    <div class="d-flex justify-content-evenly">
        <div class="d-flex justify-content-between">
            <form:form action="/users/new" method="POST" modelAttribute="user">
                <h2 class="fs-1 fw-bolder my-5">Register</h2>
                <div class="d-flex justify-content-between fw-bold my-4">
                    <form:label path="name">Name:</form:label>
                    <form:input type="text" path="name" />
                </div>
                    <form:errors class="text-danger" path="name"/>
                <div class="d-flex justify-content-between fw-bold my-4">
                    <form:label path="email">Email:</form:label>
                    <form:input type="email" path="email" />
                </div>
                    <form:errors class="text-danger" path="email"/>
                <div class="d-flex justify-content-between fw-bold my-4">
                    <form:label path="password">Password:</form:label>
                    <form:input type="password" path="password" />
                </div>
                    <form:errors class="text-danger" path="password"/>
                <div class="d-flex justify-content-between fw-bold my-4">
                    <form:label path="passwordConfirmation">Password Conf:</form:label>
                    <form:input type="password" path="passwordConfirmation" />
                </div>
                    <form:errors class="text-danger" path="passwordConfirmation"/>
                <button class="btn btn-secondary">Register</button>
            </form:form>
        </div>

        <div class="d-flex">
            <form action="/login" method="POST">
                <h2 class="fs-1 fw-bolder my-5">Login</h2>
                <div class="d-flex justify-content-between fw-bold my-4">
                    <label for="">Email:</label>
                    <input type="email" name="email">
                </div>
                <div class="d-flex justify-content-between fw-bold my-4">
                    <label for="">Password:</label>
                    <input type="password" name="password" value="12345678">
                </div>
                <span class="text-danger"><c:out value="${error}"/> </span>
                <button class="btn btn-secondary">Login</button>
            </form>
        </div>
    </div>
    
    
    
</body>
</html>