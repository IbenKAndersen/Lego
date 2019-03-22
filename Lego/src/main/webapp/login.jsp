<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Log in</h1>
        <form method="post" action="/Lego/FrontController?">
            <input type="hidden" name="origin" value="login">
            Email:<br>
            <input type="text" name="email" value="Test1@Test1.dk"/><br>
            Password:<br> 
            <input type="password" name="password" value="Test1"/> <br><br>
            <input type="submit" value="Log in">
        </form>
    </body>
</html>
