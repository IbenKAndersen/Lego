<%@page import="java.util.List"%>
<%@page import="Lego.data.LegoBrick"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of orders: </h1><br>
        
        <% 
            List<List> lists = (List<List>) session.getAttribute("allOrders"); 
            
            for (List list : lists) {
                out.println(list + "<br><br>");
            }
            
            List<Integer> total = (List<Integer>) session.getAttribute("getTotalBricks");
            out.println("Total number of bricks for all orders [4x2, 2x2, 1x2] = " + total);
            
            
        %>
        
    </body>
</html>
