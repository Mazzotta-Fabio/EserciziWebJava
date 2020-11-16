<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risposta Form</title>
<style type="text/css">
   table,td{
      border:1px solid black;
   }
</style>
</head>
<body>
   <%String nome=request.getParameter("Nome");
     String indirizzo=request.getParameter("indirizzoMail");
     String password=request.getParameter("password");
     String confermaPassword=request.getParameter("confermaPassword");
     if(password.equals(confermaPassword)){%>
        <h1>Password Corrette</h1>
     	<table>
     		<tr> <td> Nome </td> <td> <%=nome %> </td> </tr>
     		<tr> <td> Indirizzo Mail </td> <td> <%=indirizzo %> </td> </tr>
     		<tr> <td> Password </td> <td> <%=password %> </td> </tr>
     		<tr> <td> Conferma Password </td> <td> <%=confermaPassword %> </td> </tr>
     	</table>
     <%}else{%>
         <h1>ERRORE!</h1> <h2>le password non sono uguali</h2>
     <% } %>
</body>
</html>