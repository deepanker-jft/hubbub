/**
 * Created by amit on 14/10/16.
 */
function validateform()
{
    var x=document.forms["form1"]["loginId"];

    if(x.value=="")
    {
        alert("Please enter the login Id")
        x.focus();
        return false;

    }
    else if(x.value.length>100)
    {
        alert("Login ID should be less than 20 Character")
        x.focus();
        return false;
    }
    var x=document.forms["form1"]["password"]
    if(x.value=="")
    {
        alert("Please enter passord")
        x.focus()
        return false;
    }
    else if(x.value.length>8)
    {

        alert("Password should be  8 Character")
        x.focus()
        return false;
    }

}

