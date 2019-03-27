<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register here</h1>
        <form method="POST"  action="FrontController">
            <input type="hidden" name="origin" value="register">

            Email:<br>
            <input type="email" name="email" value=""><br>
            Password:<br>
            <input type="password" name="password" value=""><br><br><br>

            <input type="submit" value="Create user">
        </form> 
    </body>
</html>
