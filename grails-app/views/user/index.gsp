
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <g:external dir="js" file="validation.js"/>
    <g:javascript src="jquery-3.1.1.min.js"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#loginId").blur(function(){
                $("#msgbox").removeClass().addClass('messagebox').text('Checking...').fadeIn("slow");
                if($(this).length>0){
                    var url = "${createLink(controller:'user', action:'checkAvailable')}"
                    // async ajax request pass username entered as id parameter
                    $.getJSON(url,{id:$(this).val()},function(json){
                        if(!json.available){
                            $("#msgbox").fadeTo(200,0.1,function() {  //start fading the messagebox
                                $(this).html('Please choose different emailid').addClass('messageboxerror').fadeTo(900,1);
                            });
                        }
                        else{
                            $("#msgbox").fadeTo(200,0.1,function() {  //start fading the messagebox
                                $(this).html('This email id is available').addClass('messageboxerror').fadeTo(900,1);
                            });
                        }
                    });
                }
            });
        });
    </script>
    <title></title>
</head>
<body>
<h1 align="center">User Registration Form</h1>
<g:form action="employeeRegister" name="form1">
    <table style="width: auto   ">
        <tr><td>Email Id: * </td><td><g:textField id="loginId" name="loginId" placeholder="enter valid email id " required=""/></td>
            <td><span id="msgbox" style="display:none"></span></td>
            <td><div id="msgbox"></div></td>
        </tr>
        <tr><td>Password : * </td><td><g:passwordField name="passwordHash" placeholder="enter password" min="6" max="8" required="" /> </td></tr>
        <tr><td>Repeat Password : * </td><td><g:passwordField name="passwordHashRepeat" placeholder="repeat password" min="6" max="8" required=""/> </td></tr>
        <tr><td><g:submitButton name="submit" value="Submit" onclick="return validateform()"/></td></tr>
    </table>
</g:form>
<td><g:link controller="login" action="auth" ><button style="text-decoration: none;">Login</button></g:link></td>
</body>
</html>