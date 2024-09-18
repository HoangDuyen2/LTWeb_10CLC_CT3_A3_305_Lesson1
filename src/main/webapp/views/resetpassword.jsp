<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/18/2024
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        button, input {
            display: block;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<form action="/Lesson1s_war_exploded/reset_password" method="post">
    <c:if test=
                  "${alert !=null}">
        <h3 class="alert alertdanger">${alert}</h3>
    </c:if>
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" id="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="confirmPassword" id="psw-repeat" required>

    <button type="submit">Reset password</button>
</form>
</body>
</html>
