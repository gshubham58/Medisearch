<%-- 
    Document   : sear
    Created on : Aug 9, 2017, 2:09:28 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="blue">
        <%  HttpSession ses = request.getSession();
           String a=ses.getAttribute("name").toString();  %>
        <h1>Welcome <%=a%></h1>
         <form method="get" action="search">
            Enter medicine name<input type="text" name="medicine"><br>
            <input type="submit" value="search">
        </form>
    </body>
</html>
