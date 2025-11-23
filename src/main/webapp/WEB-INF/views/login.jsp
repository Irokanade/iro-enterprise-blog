<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<form:form action="j_spring_security_check" method="post">
    <label>username:
        <input type="text" name="username">
    </label><br>
    <label>password:
        <input type="password" name="password">
    </label><br>
    <input type="submit" value="Login">
</form:form>
</body>
</html>
