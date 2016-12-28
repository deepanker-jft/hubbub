<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 18/11/16
  Time: 5:15 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<g:render template="/home/tab"/>
<br>
<g:each var="reply" in="${rc}">
<li align="center">${reply.content} reply by ${reply.user.profile.fullName} </li>
</g:each>
</body>
</html>