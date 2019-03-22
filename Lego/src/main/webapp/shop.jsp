<%@page import="Lego.data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Welcome <% User user = (User) session.getAttribute("user");
            out.println(" " + user.getEmail());%> </h1> <br><br>
        
        <form method="POST" action="/Webshop/FrontController?">
            <input type="hidden" name="origin" value="order">    
            
            Design your Lego House: <br>
            <input type="text" name="length" placeholder="Type in length" /> <br>
            <input type="text" name="width" placeholder="Type in wisth" /> <br>
            <input type="text" name="hight" placeholder="Type in hight" /> <br><br>
            <input type="submit" value="Select">
        </form> 
            
    </body>
</html>
