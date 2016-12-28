<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 18/11/16
  Time: 4:28 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>

<body>
<g:form action="addReplyComment">
  <table>
    <tr><td><g:hiddenField name="id" value="${id}"/></td></tr>
    <tr><td>Content : </td><td><g:textArea name="content" required=""/></td></tr>
    <tr><td><g:submitButton name="submit" value="Reply Post"/></td></tr>
  </table>

</g:form>
</body>
</html>