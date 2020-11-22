<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,esercizi.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Script Bici</title>
<style type="text/css">
   div{
      float:left;
      margin-left:10px;
   }
   table{
       border-style:double;
    }
    td,th{
       border-style:solid;
       border-width:1px;
    }
    th{
       background-color:white;
    }
    .princ:nth-child(odd){
        background-color:green;
    }
    .princ:nth-child(even){
        background-color:pink;
    }
    .princ:hover{
       cursor:pointer;
       background-color:blue;
    }
    .int{
       border-style:none;
    }
</style>
<script type="text/javascript">
    function viewModel(smodello,s27,s29){
    	var modello=document.getElementById("modello");
    	var c27=document.getElementById("27.5");
    	var c29=document.getElementById("29");
    	modello.innerHTML=smodello;
    	c27.innerHTML=s27;
    	c29.innerHTML=s29;
    	document.getElementById("tabModello").style.visibility="visible";
    	window.setTimeout("hiddenDiv()",5000);
    }
    function hiddenDiv(){
    	document.getElementById("tabModello").style.visibility="hidden";
    }
</script>
</head>
<body id ="corpo">
  <div id="contenitore">
    <table>
      <th> Modello </th> <th> 27.5 </th> <th> 29 </th>
      <% List<Modello> listaModelli=(List<Modello>)request.getAttribute("listaModelli");
         for(Modello m:listaModelli){%>
         	<tr class="princ"> 
         		<td onclick="viewModel('<%=m.getMarca() %>','<%=m.getS275() %>','<%=m.getS29() %>')" id="nomeProdotto" name="<%=m.getMarca() %>" value="<%=m.getMarca() %>" > <%=m.getMarca() %> </td> 
         		<td id="valore1" onclick="viewModel('','','')"> <%=m.getS275() %> </td> 
         		<td id="valore2" onclick="viewModel('','','')"> <%=m.getS29() %> </td> 
         	</tr>
         <%} %>	
     </table>
   </div>  
   <div style="visibility:hidden" id="tabModello">
   <table class="int" >
      <tr> <th class="int"> Bici Selezionata </th>
      <tr> <td class="int"> Modello </td> <td id="modello">  </td>
      <tr> <td class="int"> Misura 27.5 </td> <td id="27.5">  </td>
      <tr> <td class="int"> Misura 29 </td> <td id="29">  </td>
   </table>
   </div>
</body>
</html>