<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 17/11/16
  Time: 4:19 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main" >
  <title></title>
</head>
<body>
<g:render template="/home/tab"/>
<h2>Dislikes users</h2>
<g:each var="abc" in="${dislikeUser}" status="i">
  <p> ${abc.user.profile.fullName}</p>
</g:each>
</body>
</html>