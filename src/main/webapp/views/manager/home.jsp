<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/17/2024
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  Trang chu cua manager

  <button type="button" class="Logoutbtn" style="background-color: burlywood" onclick="redirectToLogout()">Logout</button>
  <script>
      function redirectToLogout() {
          window.location.href = '/Lesson1s_war_exploded/manager/logout';
      }
  </script>
</body>
</html>
