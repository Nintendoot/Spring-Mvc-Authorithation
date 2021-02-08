<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<jsp:include page="_head.jsp"/>
<div class="container">
    <form action="/history" method="get">
        <h2>История</h2>
        <c:forEach var="cl" items="${history}">

            <td>${cl}</td>
            <br>
        </c:forEach>
    </form>
</div>
</body>
</html>
