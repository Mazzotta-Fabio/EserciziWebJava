<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,esercizi.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Script Bici</title>
<style type="text/css">

   table{
       border-style:double;
    }
    td,th{
       border-style:solid;
       border-width:1px;
    }
    tr:nth-child(odd){
        background-color:green;
    }
    tr:nth-child(even){
        background-color:pink;
    }
    th{
       background-color:white;
    }
    
    tr:hover{
       cursor:pointer;
       background-color:blue;
    }
</style>
<script type="text/javascript">
    function onView(){
	  alert("Ho premuto una cella");
    }
</script>
</head>
<body id ="corpo">
  <div id="contenitore">
    <table>
      <th> Modello </th> <th> 27.5 </th> <th> 29 </th>
      <% List<Modello> listaModelli=(List<Modello>)request.getAttribute("listaModelli");
         for(Modello m:listaModelli){%>
         	<tr> 
         		<td onclick="onView()" id="nomeProdotto" name="<%=m.getMarca() %>" value="<%=m.getMarca() %>" > <%=m.getMarca() %> </td> 
         		<td id="valore1" onclick="onView()" name="<%=m.getS275() %>" value="<%=m.getS275() %>"> <%=m.getS275() %> </td> 
         		<td id="valore2" onclick="onView()" name="<%=m.getS29() %>" value="<%=m.getS29() %>"> <%=m.getS29() %> </td> </tr>
         
         <%} %>	
     </table>
   </div>  
</body>
</html>