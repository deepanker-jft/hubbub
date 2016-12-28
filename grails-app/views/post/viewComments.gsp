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
<tr><th>Comment</th><th>Comment By</th><th>Date</th></tr>
<g:each var="coment" in="${comments}">
<tr><td>${coment.content} <g:link controller="replyComment" action="index" id="${coment.id}">Reply</g:link> ||
<g:link controller="replyComment" action="viewReply" id="${coment.id}">ViewReplyComments</g:link>
</td><td> ${coment.user.profile.fullName}</td><td><g:dateFromNow date="${coment.dateCreated}"></g:dateFromNow></td></tr>
</g:each>
</table>
</body>
</html>