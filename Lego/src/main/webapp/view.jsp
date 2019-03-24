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
            List<List> total = (List<List>) session.getAttribute("total");
            
            for (int i = 0; i < lists.size(); i++) {
                out.println(lists.get(i) + "<br><br>");
                out.println("Total number of bricks for this order [4x2, 2x2, 1x2] = " + total.get(i) + "<br><br>");
            }
            
        %>
        
    </body>
</html>
