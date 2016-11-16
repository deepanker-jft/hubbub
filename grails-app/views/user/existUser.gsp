<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 22/10/16
  Time: 9:04 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<p>
     <h1 align="center">User Id Is Already Exist!!!!!!</h1>
    <h1 align="center">Please Login Again Or Choose Another Email Id!!!!!!</h1>

</p>
<p>
    <g:link controller="user" action="index">Sign Up </g:link>

</p>
<br>
<br>
<p>
    <g:link controller="login" action="auth">Login Again</g:link>
</p>
</body>
</html>