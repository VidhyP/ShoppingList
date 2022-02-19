<%-- 
    Document   : shoppingList
    Created on : Feb 18, 2022, 9:50:39 PM
    Author     : Vidhy Patel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${user}
            <a href="/ShoppingList">Logout</a>
        </p>
        <h2>List</h2>
        <form method="POST" action="ShoppingList">
            <input type="hidden" name="action" value="add">

            <label for="item">Add item: </label>
            <input type="text" name="item" >

            <button type="submit">Add</button>
        </form>

        <form>
            <input type="hidden" name="action" value="delete">

            <c:forEach items="${items}" var="item">
                <p>
                    <input type="radio" name="item" value="${item}">
                    ${item}
                </p>
            </c:forEach>

            <button type="submit">Delete</button>
        </form>

    </body>
</html>
