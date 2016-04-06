<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
   <title>Customer Management System</title>
   <link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body>
        <% // get the locale from the request, which will be 
         //determined by the language set.
      Locale locale = request.getLocale();
      // load the bundle for the preferred locale
      ResourceBundle bundle =
              ResourceBundle.getBundle("i18n/Bundle", locale);
      %>
        <h1><%=bundle.getString("CREATEACCOUNT")%></h1>
        <form action="/shopping/AddCustomerServlet" method="post">
            <fieldset>
                <legend><%=bundle.getString("CUSTOMERDETAILS")%></legend>
                <label><%=bundle.getString("NAME")%>:<input type="text" name="name" required/></label>
                <label><%=bundle.getString("ADDRESS")%>:<input type="text" name="address" required/></label>
                <label><%=bundle.getString("USERNAME")%>:<input type="text" name="username" required/></label>
                <label><%=bundle.getString("PASSWORD")%>:<input type="password" name="password"required/></label>
                <label><%=bundle.getString("CREDITCARD")%>:<input type="text" name="creditcard"required/></label>
                <button type="submit"><%=bundle.getString("SUBMIT")%></button>
            </fieldset>
        </form>
    </body>
</html> 
