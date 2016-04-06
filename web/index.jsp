<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="style.css">
      <title>Home: Phone World</title>
   </head>
   <body>
      
      <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
      <h1><%=bundle.getString("WELCOME")%></h1>
      <h2><%=bundle.getString("WELCOME")%></h2>
      <div>
         <a href="phonecase.jpg">
            
            <img src="phonecase.jpg" width="900px" height="500px" alt="Phone cases">
         
         </a>
      </div>
   </body>
</html>
