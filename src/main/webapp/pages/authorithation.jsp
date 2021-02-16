<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authorization</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/authoriz" method="post" style="margin-top: 100px">
        <div class="mb-3" style="margin-top: 100px">
            <h2>Authorization</h2>
            <label class="form-label">Login</label>
            <input type="text" class="form-control" name="login">
            <c:if test="${err.containsKey(\"login\")}">
                <div class="alert alert-primary" role="alert">
                        ${err.get("login")}
                </div>
            </c:if>
        </div>
        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="text" class="form-control" name="password">
            <c:if test="${err.containsKey(\"password\")}">
                <div class="alert alert-primary" role="alert">
                        ${err.get("password")}
                </div>
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
</body>
</html>