<%-- 
    Document   : login
    Created on : Dec 16, 2020, 11:26:37 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <c:set var="error" value="${requestScope.LOGINERROR}"/>
        <c:if test="${not empty error}">
            <font color="red">Invalid username or password!</font>
        </c:if>
        <form action="" method="POST">
            UserID: <input type="text" name="txtUserID" value="${param.txtUserID}" /> <br/>
            <font color="red">
            <c:if test="${not empty error.userIDLength}">
                ${error.userIDLength} <br/>
            </c:if>
            </font>
            Password: <input type="password" name="txtPassword" value="${param.txtPassword}" /> <br/>
            <font color="red">
            <c:if test="${not empty error.passwordLength}">
                ${error.passwordLength} <br/>
            </c:if>
            </font>
            <input type="submit" value="Login" name="btAction" />
            <input type="submit" value="Register" name="btAction" />
        </form>
        <font color="red">
        <c:if test="${ empty error.userIDLength && empty error.passwordLength && error.invalidAccount == true}">
            Try Again! <br/>
        </c:if>
        </font>

    </body>
</html>
