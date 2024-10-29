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
    <h2 class="fs-1 fw-bolder my-5"> Create a new idea</h2>
    <div class="d-flex align-items-center gap-2">
        <form:form action="/ideas/new" method="POST" modelAttribute="idea" class="d-flex align-items-center gap-2">
            <div class="d-flex gap-2 fw-bold my-4">
                <form:label path="description">Content</form:label>
                <form:input type="text" path="description"/>
            </div>
                <form:errors class="text-danger" path="description"/>
            <button class="btn btn-secondary">Create</button>
        </form:form>
        <a href="/ideas" class="btn btn-secondary ">Volver</a>
    </div>
</body>
</html>