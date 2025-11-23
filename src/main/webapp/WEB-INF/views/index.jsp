<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <link rel="shortcut icon" href='<c:url value="/resources/images/favicon.ico" />' type="image/x-icon">
    <link rel="icon" href='<c:url value="/resources/images/favicon.ico" />' type="image/x-icon">
    <title>Home</title>
</head>
<body>
    <button type="button" onclick="location.href='/signup'">Sign Up!</button>
    <button type="button" onclick="location.href='/login'">Login</button>

    <h1>Hello world!</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
