<%-- 
    Document   : login
    Created on : Aug 9, 2017, 1:14:22 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="Blue">
 <form method="get" action="loginsrv">
     <center><h1>Enter details</h1></center>
            Enter Userid     <input type="text" name="userid" style="margin: 5px 46px"><br>
            Enter Password <input type="text" name="passwrd" style="margin: 5px 30px"><br>
            <input type="submit" value="login"><br>
            <a href="sign.jsp">New user? click here</a>
        </form>
    </body>
</html>
