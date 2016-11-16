<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 20/10/16
  Time: 2:40 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:each in="${post}" var="p">
    <li>${p.content}</li>
</g:each>
</body>
</html>