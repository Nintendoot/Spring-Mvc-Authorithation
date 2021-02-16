<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/regist" method="post" class="row g-3" style="margin-top: 100px">
        <h2>Registration</h2>
        <div class="col-md-6">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="name" >
            <c:if test="${errors.containsKey(\"name\")}">
                <div class="alert alert-primary" role="alert">
                        ${errors.get("name")}
                </div>
            </c:if>
        </div>
        <div class="col-md-6">
            <label class="form-label">Surname</label>
            <input type="text" class="form-control" name="surname">
            <c:if test="${errors.containsKey(\"surname\")}">
                <div class="alert alert-primary" role="alert">
                        ${errors.get("surname")}
                </div>
            </c:if>
        </div>
        <div class="col-md-6">
            <label class="form-label">Login</label>
            <input type="text" class="form-control" name="login">
            <c:if test="${errors.containsKey(\"login\")}">
                <div class="alert alert-primary" role="alert">
                        ${errors.get("login")}
                </div>
            </c:if>
        </div>
        <div class="col-md-6">
            <label class="form-label">Password</label>
            <input type="text" class="form-control" name="password">
            <c:if test="${errors.containsKey(\"password\")}">
                <div class="alert alert-primary" role="alert">
                        ${errors.get("password")}
                </div>
            </c:if>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
</body>
</html>