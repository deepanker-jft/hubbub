<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 9/11/16
  Time: 12:28 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<h3>Greetings</h3>
<p>Welcome to Forget Password for Hubbub Apps</p>
%{--<p><a href="${contact}">Verify Email</a></p>--}%
<g:link base="${contact}" controller="user" action="resetPassword" params='[uid:"${name}"]'>Verify Account</g:link>
%{--<p><a href="${createLink(controller:"post", action: "userid",params: "[id:'${name}']")}">my link</a></p>--}%
<p>Click and them reset your password!</p>
</body>
</html>