<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 21/10/16
  Time: 5:43 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title>Deepanker</title>
</head>

<body>
<g:render template="/home/tab"/>
<h1>
<li>${userName.loginId}</li>
<li>${userName.id}</li>
<li>${userName.passwordHash}</li>
    <g:form controller="logout" action="index" methods="post">
        <g:submitButton name="logout" value="Logout"/>
                    </g:form>
</h1>
</body>
</html>