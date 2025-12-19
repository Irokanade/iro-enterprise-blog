<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome User</title>
</head>
<body>
    <h1>Welcome home ${currentUser}</h1>

    <form:form action="/logout" method="post">
        <input type="submit" value="Logout" />
    </form:form>

    <button type=button onclick="location.href='/article/create';">Create new article</button>

    <h2>Articles</h2>
    <c:forEach var="article" items="${articles}">
        <div>
            <h3>${article.title}</h3>
            <p>${article.content}</p>
            <p>Author: ${article.authorUsername}</p>
        </div>
        <hr/>
    </c:forEach>
</body>
</html>
