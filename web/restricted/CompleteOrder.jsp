<%-- 
    Document   : CompleteOrder
    Created on : 21/09/2013, 6:08:18 PM
    Author     : mirji507
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
      <title>Order complete</title>
   </head>
   <body>
      <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
      <h1><%=bundle.getString("THANKYOU")%></h1>
      <p><%=bundle.getString("RECEIVE7DAYS")%></p>
   </body>
</html>
