<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 10/11/16
  Time: 12:49 PM
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
       Please chose same password both field
    </p>
</g:hasErrors>
