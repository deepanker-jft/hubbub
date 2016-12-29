<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 26/10/16
  Time: 11:04 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<g:render template="/home/tab"/>
<br>
<g:form action="followUser">
    <h3 align="center">List of User</h3>
    <g:each in="${user}" var="abc">

         &nbsp;&nbsp; <g:checkBox name="myCheckbox" value="${abc.userId}" checked="false"/>${abc.fullName.toUpperCase()}
        <br>
    </g:each>
    <br>
    &nbsp;&nbsp; <g:submitButton name="submit" value="follow"/>
    </g:form>
</body>
</html>