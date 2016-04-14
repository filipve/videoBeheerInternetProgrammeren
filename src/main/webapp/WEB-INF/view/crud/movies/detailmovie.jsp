<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 24/03/2016
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Titel film</th>
            <th>Director film</th>
            <th>Jaar film</th>
            <th>genre film</th>
            <th>rating film</th>
            <th>evaluation film</th>
            <th>gezien of niet</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.jaar}</td>
            <td>${movie.genre.toString()}</td>
            <td>${movie.rating.toString()}</td>
            <td>${movie.evaluation.toString()}</td>
            <td>${movie.seen}</td>
        </tr>
        </tbody>
    </table>

    <a class="btn btn-info" href="<c:url value="/movies/showmovies.htm"/>">Show all movies</a>


</div>


</body>
</html>
