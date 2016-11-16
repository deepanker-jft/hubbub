<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 28/10/16
  Time: 12:38 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>
<g:hasErrors>
    <g:renderErrors bean="${user}" as = 'list'>

    </g:renderErrors>
    <br>
    <br>
    <p>
        <g:link controller="user" name="register" action="index">Sign up Again</g:link>
    </p>
</g:hasErrors>
