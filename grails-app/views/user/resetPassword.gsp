<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 10/11/16
  Time: 12:23 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title></title>
</head>

<body>
<br>
<br>
<g:form action="userForgetVerify">
    <p><g:hiddenField name="id" value="${userId}"/></p>
    <p><g:hiddenField name="counter" value="true"/></p>
    <p align="center">Password    : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<g:passwordField name="passwordHash"/></p>
    <br>
    <p align="center">Repeat Password :  <g:passwordField name="passwordHashRepeat"/></p>
    <br>
    <p align="center"><g:submitButton name="update" value="Update-Password"/></p>
</g:form>
</body>
</html>