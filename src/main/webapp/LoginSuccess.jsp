<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    head {
        color: bisque;
    }
    body {
        background-color: darkgrey;
        color: #05490d;
        align-content: center;
        size: 40px;
    }
</style>
<head>
    <title>Login Success</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user")%>,Login Successful</h3>

<a href="login.html">Home page</a>
</body>
</html>