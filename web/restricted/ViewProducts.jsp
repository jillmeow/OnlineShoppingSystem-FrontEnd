<%-- 
    Document   : ViewProducts
    Created on : 9/09/2013, 2:56:14 PM
    Author     : mirji507
--%>

<!DOCTYPE html>
<%@page import="java.util.*,dao.*,domain.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
      <title>View All Products</title>
   </head>
   <body>
      <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
      <h1><%=bundle.getString("VIEWPRODUCT")%></h1>
      <!-- Get all the ordered products -->
      <%
         Collection<Product> products =
                 new ProductJdbcDao().getAll();
      %>
      <table>
         <thead>
            <tr>
               <th><%=bundle.getString("ID")%></th>
               <th><%=bundle.getString("NAME")%></th>
               <th><%=bundle.getString("DESCRIPT")%></th>
               <th><%=bundle.getString("PRICE")%></th>
               <th><%=bundle.getString("AVAILABLE")%></th>
               <th></th>
            </tr>
         </thead>
         <tbody>
            <% for (Product product: products) { %>
            <tr>
               <td><%=product.getProductID()%></td>
               <td><%=product.getName()%></td>
               <td><%=product.getDescription()%></td>
               <td><%=product.getPrice()%></td>
               <td><%=product.getQuantity()%></td>
               <td><form action="/shopping/BuyServlet"><input type="hidden" name="productId"
                 value="<%=product.getProductID()%>"><input type="submit" value="Buy"></form></td>
            </tr>
            <% }%>
         </tbody>
      </table>
         
   </body>
</html>
