<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 24/10/16
  Time: 5:15 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title></title>
</head>

<body>
<g:render template="/home/tab"/>
<h1 align="center">No Profile Available</h1>

<g:link controller="profile" action="createprofile" style="text-decoration: none;"><button>Create Profile</button></g:link>
</body>
</html>