<%-- 
    Document   : ViewOrder
    Created on : 21/09/2013, 6:07:51 PM
    Author     : mirji507
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
      <title>Checkout Order</title>
   </head>
   <body>
      
      <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
      <h1><%=bundle.getString("CHECKOUT")%></h1>
      <form action="/shopping/ConfirmOrderServlet" method="post">
      <% 
         Order orders = (Order)session.getAttribute("order");
         Collection<OrderItem> items = orders.getOrderItems(); 
      %>
      <table>
         <thead>
            <tr>
               <th><%=bundle.getString("PRODUCT")%></th>
               <th><%=bundle.getString("PRICE")%></th>
               <th><%=bundle.getString("QUANTITY")%></th>
               <th><%=bundle.getString("TOTAL")%></th>
            </tr>
         </thead>
         <tbody>
            <% for (OrderItem o : items) { %>
            <tr>
               <td><%=o.getProduct()%></td>
               <td><%=o.getProduct().getPrice()%></td>
               <td><%=o.getPurchasedQuantity()%></td>
               <td><%=o.getItemTotal()%></td>
            </tr>
            <% }%>
         </tbody>
      </table>
         <p id="totalcost"><%=bundle.getString("TOTALCOST")%>: <%=orders.getCurrencyTotal()%></p>
         <button type="submit"><%=bundle.getString("CONFIRM")%></button>
     </form>
   </body>
</html>
