<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conto Ristorante Pinco Pallo</title>
<style type="text/css">
   table,td,th{
      border:1px solid black;
   }
</style>
</head>
<body>
   <h1>Ecco il tuo conto</h1>
   <table>
   <th> Pietanza </th> <th> Prezzo </th>
   <%!double totaleConto=0;%>
   <%if(request.getParameter("margherita")!=null){%>
        <tr> <td> MARGHERITA </td> <td> <%=request.getParameter("margherita")%></td> </tr>
        <% totaleConto=totaleConto+Double.parseDouble(request.getParameter("margherita")); %>
   <%} %>
   <%if(request.getParameter("capricciosa")!=null){%>
        <tr> <td> CAPRICCIOSA </td> <td> <%=request.getParameter("capricciosa")%> </td> </tr>
        <% totaleConto=totaleConto+Double.parseDouble(request.getParameter("capricciosa")); %>
   <%} %>
   <%if(request.getParameter("quattroStagioni")!=null){%>
        <tr> <td> QUATTRO STAGIONI </td> <td> <%=request.getParameter("quattroStagioni")%>  </td> </tr>
        <%totaleConto=totaleConto+Double.parseDouble(request.getParameter("quattroStagioni")); %>
   <%} %>
   <%if(request.getParameter("pugliese")!=null){%>
        <tr> <td> PUGLIESE </td> <td> <%=request.getParameter("pugliese")%> </td> </tr>
   	    <% totaleConto=totaleConto+Double.parseDouble(request.getParameter("pugliese")); %>
   <%} %>
   <%if(request.getParameter("americana")!=null){%>
        <tr> <td> AMERICANA </td> <td> <%=request.getParameter("americana") %> </td> </tr>
 		<% totaleConto=totaleConto+Double.parseDouble(request.getParameter("americana")); %>
   <%} %>
   <tr> <td> COSTO SERVIZIO A DOMICILIO </td> <td> 1.00 <%totaleConto=totaleConto+1; %></td> </tr>
   <tr> <td> TOTALE CONTO </td> <td> <%=totaleConto %> </td> </tr>
   <%totaleConto=0; %>
   </table>
</body>
</html>