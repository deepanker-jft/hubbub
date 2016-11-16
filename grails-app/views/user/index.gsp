<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 13/10/16
  Time: 4:56 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <g:external dir="js" file="validation.js"/>
    <title></title>
</head>
<body>
    <g:form action="employeeRegister" name="form1">
        <table>
            <tr><td>Email Id: * </td><td><g:textField name="loginId" placeholder="enter email id " required=""/></td></tr>
            <tr><td>Password : * </td><td><g:passwordField name="passwordHash" placeholder="enter password" min="6" max="8" required="" /> </td></tr>
            <tr><td>Repeat Password : * </td><td><g:passwordField name="passwordHashRepeat" placeholder="repeat password" min="6" max="8" required=""/> </td></tr>
            <tr><td><g:submitButton name="submit" value="Submit" onclick="return validateform()"/></td></tr>
        </table>
    </g:form>
</body>
</html>