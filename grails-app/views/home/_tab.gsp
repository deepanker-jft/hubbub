<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 23/10/16
  Time: 1:03 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <g:external dir="css" file="tab.css"/>
</head>

<body>
<ul class="tab">
    <li><g:link controller="home" action="index" class="tablinks" method="post">Home</g:link></li>
    <li><g:link controller="post" action="index" class="tablinks" method="post">Post</g:link></li>
    <li><g:link controller="post" action="viewPost" class="tablinks" method="post">View Post</g:link></li>
    <li><g:link controller="home" action="timeline" class="tablinks" method="post">Taged Post</g:link></li>
    %{--<li><g:link controller="profile" action="index" class="tablinks" method="post">Edit Profile</g:link></li>--}%
    <li><g:link controller="profile" action="userprofile" class="tablinks" method="post">View Profile</g:link></li>
    <li><g:link controller="user" action="users" class="tablinks" method="post">Users</g:link></li>
   %{-- <g:form controller="logout" action="index" method="post" name="logged_out">--}%
        %{--<li><g:submitButton name="loggedOut" value="Logout"/></li>--}%
    <form name="submitForm" method="POST" action="${createLink(controller: 'logout',action: 'index')}">
        <input type="hidden" name="" value="">
        <li><a href="javascript:document.submitForm.submit()" class="tablinks">Logout</a></li>
        </form>
   %{-- <li><g:link controller="logout" action="index" class="tablinks">Logout</g:link></li>--}%
  %{--  </g:form>--}%
    %{--<li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'Tokyo')">Tokyo</a></li>--}%
</ul>
</body>
</html>