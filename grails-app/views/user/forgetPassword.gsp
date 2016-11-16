<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 10/11/16
  Time: 11:19 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form action="resetPasswordMail">
    <p align="center">Email Id : <g:textField name="loginId" placeholder="enter email id" required=""/></p>
    <p><g:hiddenField name="counter" value="false"/></p>
    <p align="center"><g:submitButton name="reset" value="Forget-Password"/></p>
</g:form>
</body>
</html>