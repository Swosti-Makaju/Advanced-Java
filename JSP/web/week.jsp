<%-- 
    Document   : week
    Created on : Dec 1, 2025, 8:46:21 AM
    Author     : swosti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! int day = 3; %> 
<html> 
   <head><title>IF...ELSE Example</title></head> 
   
   <body>
      <% if (day == 1 || day == 7) { %>
         <p> Today is weekend</p>
      <% } else { %>
         <p> Today is not weekend</p>
      <% } %>
   </body> 
</html>
