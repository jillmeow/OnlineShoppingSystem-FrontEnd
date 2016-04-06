<%-- 
    Document   : BuyProduct
    Created on : 21/09/2013, 5:40:47 PM
    Author     : mirji507
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
      <title>Buy Product</title>
   </head>
   <body>
      <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
      <h1><%=bundle.getString("HOWMANYHEADING")%></h1>
      
      <% Product p = (Product)session.getAttribute("product"); %>
      
      <p class="selectedproduct"><%=bundle.getString("CHOOSE")%>: <%=p.getName() %></p>
      <p class="selectproduct"><%=bundle.getString("AVAILABLE")%>: <%=p.getQuantity()%></p>
      
      <form action="/shopping/AddToOrderServlet" method="post">
         <fieldset>
            <legend><%=bundle.getString("QUANTITYLEGEND")%></legend>
            <label><%=bundle.getString("HOWMANY")%>:<input type="number" name="quantity"></label>
            <button type="submit"><%=bundle.getString("ADDTOORDER")%></button>
         </fieldset>
      </form>
      
   </body>
</html>
