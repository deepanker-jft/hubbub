<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 14/10/16
  Time: 3:10 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:external dir="js" file="validation.js"/>
    <title></title>
</head>

<body>
<g:render template="/home/tab"/>
<g:uploadForm action="create" name="form2" enctype="multipart/form-data">

    <table>
        <tr><td>Full Name : * </td><td><g:textField name="fullName" placeholder="enter full Name" min="3" max="20" required=""/></td></tr>
        <tr><td>Bio :  </td><td><g:textArea name="bio" placeholder="enter bio" required="" /> </td></tr>
        <tr><td>Email : * </td><td><g:textField name="email" placeholder="enter email"/></td></tr>
        <tr><td>Country :  </td><td><g:textField name="country" placeholder="enter country"/></td></tr>
        <tr><td>Address :  </td><td><g:textField name="address" placeholder="enter address"/></td></tr>
        <tr><td>Photo : </td><td><input type="file" name="photo" ></td></tr>
        <tr><td><g:submitButton name="submit" value="Submit"/></td></tr>
    </table>




</g:uploadForm>

</body>
</html>