<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 24/10/16
  Time: 4:00 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title></title>
</head>

<body>
    <g:render template="/home/tab"/>
        <h1>&nbsp;&nbsp; Post By Me</h1>
            <table border="1">
                <tr><th>Sr No.</th><th>Posts</th><th>Date Created</th></tr>
                    <g:each in="${viewPost}" var="post" status="i">
                        <tr><td>${i+1}</td><td>${post.content.encodeAsHTML()}</td><td><g:dateFromNow date="${post.dateCreated}"/></td></tr>
                    </g:each>
            </table>
<g:paginate total="${postCount}"/>
</body>
</html>