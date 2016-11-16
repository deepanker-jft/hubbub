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
<p>Welcome to Hubbub Application</p>
%{--<p><a href="${contact}">Verify Email</a></p>--}%
<g:link base="${contact}" controller="user" action="accountVerify" params='[uid:"${name}"]'>Verify Account</g:link>
%{--<p><a href="${createLink(controller:"post", action: "userid",params: "[id:'${name}']")}">my link</a></p>--}%
<p>Click Link and Verify them</p>
</body>
</html>