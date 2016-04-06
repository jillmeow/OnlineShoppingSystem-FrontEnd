<%-- 
    Document   : login
    Created on : 9/09/2013, 3:50:11 PM
    Author     : mirji507
--%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
      <title></title>
   </head>
   <body>
      <% // get the locale from the request, which will be 
         //determined by the language set.
      Locale locale = request.getLocale();
      // load the bundle for the preferred locale
      ResourceBundle bundle =
              ResourceBundle.getBundle("i18n/Bundle", locale);
      %>
      <%
      //get the status code to see why the log in page was requested
      Integer statusCode = (Integer)
              request.getAttribute("javax.servlet.error.status_code");
      //default message to display to the user
      String message = "Please log in to continue.";
      //if the status code was 401(UNAUTHORIZED) then extract the message
      //from the request
      if(statusCode != null &&
              statusCode == HttpServletResponse.SC_UNAUTHORIZED){
         message =
                 request.getAttribute("javax.servlet.error.message").toString();
      }
      %>
      <p><%=message%></p>
      <h1><%=bundle.getString("LOGIN")%></h1>
      <form action="/shopping/LoginCustomerServlet" method="post">
         <fieldset id="login">
            <legend><%=bundle.getString("LOGINDETAILS")%></legend>
            <label><%=bundle.getString("USERNAME")%>:<input type="text" name="username"></label>
            <label><%=bundle.getString("PASSWORD")%>:<input type="password" name="password"></label>
            <button type="submit"><%=bundle.getString("LOGIN")%></button>
         </fieldset>
      </form>
   </body>
</html>
