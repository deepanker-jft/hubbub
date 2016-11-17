<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 17/11/16
  Time: 5:16 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form action="commentSaved">
    <table>
        <tr><td><g:hiddenField name="id" value="${pid}"/></td></tr>
        <tr><td>Content : </td><td><g:textArea name="content" required=""/></td></tr>
        <tr><td><g:submitButton name="submit" value="comment"/></td></tr>
    </table>

    </g:form>
</body>
</html>