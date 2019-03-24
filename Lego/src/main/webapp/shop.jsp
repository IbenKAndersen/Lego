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
            out.println(" " + user.getEmail());%> </h1>

        <img src="img/lego.jpg" alt="" width="100"/>
        <img src="img/lego.jpg" alt="" width="100"/>
        <img src="img/lego.jpg" alt="" width="100"/>
        <img src="img/lego.jpg" alt="" width="100"/>
        <img src="img/lego.jpg" alt="" width="100"/>

        <br><br><br>

        <form method="POST" action="/Lego/FrontController">
            <input type="hidden" name="origin" value="order">    

            Design your Lego House: <br>
            <input type="number" name="length" placeholder="Type in length" /> <br>
            <input type="number" name="width" placeholder="Type in wisth" /> <br>
            <input type="number" name="height" placeholder="Type in hight" /> <br><br>
            <input type="submit" value="Select"> <br>
        
        </form>  
        
        <a href="view.jsp" >View orders </a>

            <br><br><br><br>

            <img src="img/lego.jpg" alt="" width="100"/>
            <img src="img/lego.jpg" alt="" width="100"/>
            <img src="img/lego.jpg" alt="" width="100"/>
            <img src="img/lego.jpg" alt="" width="100"/>
            <img src="img/lego.jpg" alt="" width="100"/>




    </body>
</html>
