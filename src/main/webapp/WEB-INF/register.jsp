<%-- 
    Document   : register
    Created on : Feb 18, 2022, 9:50:11 PM
    Author     : Vidhy Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form method="POST" action="ShoppingList">
            <input type="hidden" name="action" value="register">

            <label for="username">Username: </label>
            <input type="text" name="username">
            
            <button type="submit">Register Name</button>
        </form>
    </body>
</html>
