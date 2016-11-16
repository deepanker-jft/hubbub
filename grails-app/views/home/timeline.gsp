<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 23/10/16
  Time: 12:42 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title></title>
</head>

<body>
<g:render template="tab"/>
<table>

    <tr><th>Number of Post</th><th>Posts</th><th>Tagged By</th><th>Date</th></tr>
<g:each in="${postUsers}" var="post" status="i">
    <tr><td>${post.id}</td><td>${post.content}&nbsp;&nbsp;<g:link>Like</g:link></td><td>${post.user.profile.fullName}</td><td><g:dateFromNow date="${post.dateCreated}"/></td></tr>
<tr></tr>
</g:each>
</table>
<g:paginate total="${numberOfPost}" />
</body>
</html>