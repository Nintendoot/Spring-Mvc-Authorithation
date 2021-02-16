<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<jsp:include page="_head.jsp"/>
<div class="container">
    <form action="/histor" method="get">
        <h2>История</h2>
        <c:forEach var="cl" items="${usersHistory}">
User:<c:out value="${cl.key.name}"/>
            History:<c:out value="${cl.value}"/><br>
        </c:forEach>
    </form>
</div>
</body>
</html>