<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 15/03/2016
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Maak je movie hier aan</title>
</head>
<body>

<form:form method="post" action="${pageContext.request.contextPath}/movies/process.htm" modelAttribute="movie" id="movieForm">

    <!-- titel -->
    <div class="form-group">
        <label for="title">name</label>
        <form:input path="title" id="title" cssclass="form-control" class="form-control"/>
    </div>

    <!-- director -->
    <div class="form-group">
        <label for="director">Director</label>
        <form:input path="director" id="director" cssclass="form-control" class="form-control" />
    </div>

    <!-- jaar -->
    <div class="form-group">
        <label for="jaar">jaar</label>
        <form:input path="jaar" id="jaar" cssclass="form-control" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="genre">genre</label>
        <form:select path="genre" id="genre" cssClass="form-control" class="form-control">
            <form:options/>
        </form:select>
    </div>

    <div class="form-group">
        <label for="rating">rating</label>
        <form:select path="rating" id="rating" cssclass="form-control" class="form-control">
            <form:options/>
        </form:select>
    </div>

    <div class="form-group">
        <label for="evaluation">evaluation</label>
        <form:select path="evaluation" id="evaluation" cssclass="form-control" class="form-control">
            <form:options/>
        </form:select>
    </div>

    <div class="form-group">
        <label class="radio-inline">
        <form:radiobutton path="seen" id="seen" value="True"/>true
        </label>
        <label class="radio-inline">
        <form:radiobutton path="seen" id="seen" value="False"/>False
        </label>
    </div>

    <div>
        <input type="submit" value="submit" class="btn btn-default">
    </div>

</form:form>
</body>
</html>
