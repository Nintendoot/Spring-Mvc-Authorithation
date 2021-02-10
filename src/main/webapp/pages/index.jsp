
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="_head.jsp"/>
<c:if test="${userSession!=null}">
    Hello ${userSession.name}
</c:if>
<c:if test="${userSession==null}">
    Hello Guess
</c:if>
</body>
</html>
