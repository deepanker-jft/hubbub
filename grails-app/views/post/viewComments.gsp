<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 17/11/16
  Time: 11:42 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main">
  <title></title>
</head>
<body>
<g:render template="/home/tab"/>
<table>
<tr><th>Comment</th><th>Comment By</th></tr>
<g:each var="coment"in="${comments}">


<tr><td>${coment.content} </td><td> ${coment.user.profile.fullName}</td></tr>

</g:each>
</table>
</body>
</html>