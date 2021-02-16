<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_head.jsp"/>
<div class="container">
    <label class="form-label">Calculator</label>
    <form action="/calculat" method="post">
        <div class="mb-3">
            <c:if test="${calculator.numOne==null}">
                <input type="text" class="form-control" name="numOne" placeholder="First Number"
                       style="width:260px; height:50px;">
            </c:if>
            <c:if test="${calculator.numOne!=null}">
                <input type="text" class="form-control" name="numOne" placeholder="${calculator.numOne}"
                       style="width:260px; height:50px;">
            </c:if>
        </div>
        <br>

        <div class="mb-3">
            <c:if test="${calculator.numOne!=null}">
                <input type="text" class="form-control" name="numTwo" placeholder="${calculator.numTwo}"
                       style="width:260px; height:50px;">
            </c:if>
            <c:if test="${calculator.numOne==null}">
                <input type="text" class="form-control" name="numTwo" placeholder="Second Number"
                       style="width:260px; height:50px;">
            </c:if>
        </div>
        <br>

        <div class="btn-group" role="group" aria-label="Basic outlined example">
            <input type="submit" class="btn btn-primary" name="simbol" value="+"
                   style="width:66px; height:50px;"></input>
            <input type="submit" class="btn btn-primary" name="simbol" value="-"
                   style="width:66px; height:50px;"></input>
            <input type="submit" class="btn btn-primary" name="simbol" value="*"
                   style="width:66px; height:50px;"></input>
            <input type="submit" class="btn btn-primary" name="simbol" value="/"
                   style="width:66px; height:50px;"></input>
        </div>
        <br><br>
        <div class="mb-3">
            <c:if test="${calculator.numOne==null}">
                <input type="text" class="form-control" placeholder="Result" style="width:260px; height:50px;">
            </c:if>

            <c:if test="${calculator.numOne!=null}">
                <input type="text" class="form-control" placeholder="${calculator.result}"
                       style="width:260px; height:50px;">
            </c:if>
        </div>
        <br>
        </span>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
</body>
</html>
