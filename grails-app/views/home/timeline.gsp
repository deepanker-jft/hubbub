<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 23/10/16
  Time: 12:42 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title></title>
</head>

<body>
<g:render template="tab"/>
<div>
<table>

    <tr><th>Number of Post</th><th>Posts</th><th>Tagged By</th><th>Date</th></tr>
<g:each in="${postUsers}" var="post" status="i">
    <tr><td>${post.id}</td><td>${post.content}&nbsp;&nbsp;</td><td>${post.user.profile.fullName}</td><td><g:dateFromNow date="${post.dateCreated}"/></td></tr>
   <div>

    <tr> <td><li><g:link controller="post" action="likeSave" id="${post.id}">like</g:link> ||
    <g:link controller="post" action="unlikeSave" id="${post.id}">dislike</g:link></td><td>
<g:link controller="post" action="addComment" id="${post.id}">comment</g:link>
%{--||   ${LikePost.countByPost(postname)} like ||  ${UnLikePost.countByPost(postname)}unlike--}%
||<g:link controller="post" action="viewLikeUser" id="${post.id}"> ${com.grailsaction.LikePost.countByPost(post)} like</g:link></td><td>
    <g:link controller="post" action="ViewDisLikeUser" id="${post.id}">${com.grailsaction.UnLikePost.countByPost(post)} dislike</g:link>
    || <g:link controller="post" action="viewComments" id="${post.id}">View Comments </g:link>
    </li>
    </td>
    </tr>
    </div>
    </tr>
</g:each>
</table>
<g:paginate total="${numberOfPost}" />
</body>
</html>