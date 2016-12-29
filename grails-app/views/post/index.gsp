<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 19/10/16
  Time: 5:54 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title></title>
</head>
<body>
<g:render template="/home/tab"/>
<g:form action="postCreated">
    <table>
        <tr><td>Content : </td><td><g:textArea name="content" required="" placeholder="Write Post....."/></td></tr>
        <g:if test="${userlist==null}">
            <tr><td>User List : </td><td><g:select name="user" from="${userlist}" noSelection="['':'-No Users-']"/></td></tr>
        </g:if>
        <g:else>
            <tr><td>User List : </td><td><g:select name="user" from="${userlist.profile}" value="userlist?.user*.id" optionKey="id" optionValue="fullName" multiple="true"/></td></tr>
        </g:else>
             <tr><td><g:submitButton name="submit" value="Post"/></td></tr>
    </table>
</g:form>
</body>
</html>