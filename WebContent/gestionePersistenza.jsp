<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="esercizi.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
   table,td,th{
     border:1px solid black; 
   }
</style>
<meta charset="ISO-8859-1">
<title>Risposta Persistenza</title>
</head>
<body>
   <% 
      InformazioniUtente iu=(InformazioniUtente)request.getAttribute("bean");
      if(iu!=null){
   %>
     <table>
        <th> Campo </th> <th> Valore </th>
        <tr> <td> Nome Utente </td> <td> <%=iu.getNome() %></td>
        <tr> <td> Password </td> <td> <%=iu.getPassword() %></td>
        <tr> <td> Argomento </td> <td> <%=iu.getArgomento() %></td>
     </table>
   <%
     }else{
   %>
      <p> Non esiste record con argomento xml </p><br>
   <%} %>
      <h1>QUERY EFFETTUATA</h1>
</body>
</html>