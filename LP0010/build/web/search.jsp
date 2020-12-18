<%-- 
    Document   : search
    Created on : Dec 16, 2020, 11:42:44 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <form action="DispatcherServlet">
        <input type="submit" value="Logout" name="btAction" /> <br/>
    </form>
    <c:if test="${empty sessionScope.USERDTO}">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>
    <c:if test="${not empty sessionScope.USERDTO}">
        <font color="red">Welcome, ${sessionScope.USERDTO.fullName}</font> <br/>
        <body>
            <h1>Search Page</h1
        </body>
    </c:if>
</html>
