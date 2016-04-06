<%-- 
    Document   : InputErrorPage
    Created on : 23/09/2013, 4:33:18 PM
    Author     : mirji507
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="/style.css">
      <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
      <title>Invalid Input</title>
   </head>
   <body>
      <%=(String)request.getAttribute("javax.servlet.error.message")%>
   </body>
</html>
