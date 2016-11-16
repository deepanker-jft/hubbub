<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 24/10/16
  Time: 1:00 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>

</head>

<body>
<g:render template="/home/tab"/>
<h1>Its my Profile</h1>
    <table>
        <tr><b><td>User ID : </td></b><td>${userid}</td></tr>
        <tr><b><td>Name : </td></b><td>${profileView.fullName}</td></tr>
        <tr><b><td>Bio : </td></b><td>${profileView.bio}</td></tr>
        <tr><b><td>Email : </td></b><td>${profileView.email}</td></tr>
        %{--<img class="avatar" width="150" height="150" src="${createLink(controller:'profile', action:'viewprofile')}" />--}%
        <tr><b><td>Profile Picture : </td></b><td><g:img width="150" height="150" dir="usersImage" file="${userid}.jpg"/></td></tr>
        <tr><b><td>Countery: </td></b><td>${profileView.country}</td></tr>
        <tr><b><td>Address : </td></b><td>${profileView.address}</td></tr>
    </table>

</body>
</html>