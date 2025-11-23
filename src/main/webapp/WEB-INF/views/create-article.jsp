<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Article</title>
</head>
<body>
<form:form action="/create-article" method="post">
    <label>Title:
        <input type="text" name="title">
    </label><br>
    <label>Content:
        <textarea name="content" rows="10" cols="50"></textarea>
    </label><br>
    <input type="submit">
</form:form>
</body>
</html>
