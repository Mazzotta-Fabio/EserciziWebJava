<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Esercizio 1 tabella </title>
<style type="text/css">
   table, th, td{
      border: 1px solid black;
   }
   td,th{
     text-align:center;
     padding:5px;
   }
   th{
      background: yellow;
   }
   tr:nth-child(even){
      background:green;
   }
    tr:nth-child(odd){
      background:red;
   }
    tr:nth-child(3n+0){
      background:pink;
   }
</style>
</head>
<body>
   <table>
        <th> Numero </th> <th> Riga </th> 
       <%!int i,risultato;%>
       <%for(i=1;i<13;i++){ %>
       <tr> <td> <%=risultato=5*i %> </td> <td> riga <%=i %> </td> </tr>
       <%} %>
   </table>
   
</body>
</html>