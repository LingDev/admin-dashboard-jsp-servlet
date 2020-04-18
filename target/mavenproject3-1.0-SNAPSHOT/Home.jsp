
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//allow access only if session exists
    String userName = null;
    if (session.getAttribute("userName") == null) {
        response.sendRedirect("/index.jsp");
    } else {
        userName = (String) session.getAttribute("userName");
    }
    String cookieUserName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userName")) {
                cookieUserName = cookie.getValue();
            }
            if (cookie.getName().equals("JSESSIONID")) {
                sessionID = cookie.getValue();
            }
        }
    }
%>
<html>
    <head>
        <title>Home</title>
        <%@include file="parts/Meta.jsp" %> 
        <link rel="stylesheet" type="text/css" href="assets/css/home.css" >
    </head>
    <body>
        <%@include file="parts/Header.jsp" %>


        <!-- Page Content -->
        <div class="container" id="container">
            <h1 class="mt-4">Home</h1>
            <p>This is Home Page</p>
        </div>
        <!-- /.container -->


        <%@include file="parts/Footer.jsp" %>
    </body>
</html>