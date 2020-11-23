<%@ page language="java" contentType="text/html; charset=ISO-8859-1; text/xml"
    pageEncoding="ISO-8859-1" import="java.util.*,esercizi.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Prevsioni settimanali</title>
<style type="text/css">
   .btn{
      border-radius:10px;
      background-color:green;
      color:white;
      margin-left:10px;
   }
   .btn:hover{
      cursor:pointer;
      background-color:red;
   }
   div{
      margin-top:10px;
   }
</style>
<script type="text/javascript">
  function viewDetails(giorno){
	  var req=new XMLHttpRequest();
	  req.onreadystatechange=function(){
		  if(req.readyState==4 && req.status==200){
			  var xmlFile=req.responseXML;
			  document.getElementById("dettaglio").style.visibility="visible";
	  		  document.getElementById("dettaglio").innerHTML="";
			  var quadro=document.getElementById("dettaglio");
			  var intes=document.createElement("h2");
			  //alert(xmlFile);
			  //var giornoXML=xmlFile.getElementsByTagName("giorno");
			  //intes.appendChild(document.createTextNode(giorno[0].firstChild.data));
			  intes.appendChild(document.createTextNode("DETTAGLIO"));
			  quadro.appendChild(intes);
		  }
	  };
	  req.open("GET","ServletMeteo?day="+giorno,true);
	  req.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	  req.send(null);
  }
</script>
</head>
<body>
    <h1> Previsioni Meteo Salerno </h1>
    <div>
    </div>
    <table>
    <%List<Temperatura> list=(List<Temperatura>)request.getAttribute("temperature");%>
    <tr>
    <% for(Temperatura t:list){%>
         <td> Min: <%=t.getMin() %> </td> 
      <%} %>
     </tr> <tr>
      <% for(Temperatura t:list){%>
         <td> Max: <%=t.getMax() %> </td> 
      <%} %>
     </tr>
    <tr>
    <td> <input type="button" value="LUN" class="btn" onclick="viewDetails('lunedi')"> </td>
    <td> <input type="button" value="MAR" class="btn" onclick="viewDetails('martedi')"> </td>
    <td> <input type="button" value="MER" class="btn" onclick="viewDetails('mercoledi')"> </td>
    <td> <input type="button" value="GIO" class="btn" onclick="viewDetails('giovedi')"> </td>
    <td> <input type="button" value="VEN" class="btn" onclick="viewDetails('venerdi')"> </td>
    <td> <input type="button" value="SAB" class="btn" onclick="viewDetails('sabato')"> </td>
    <td> <input type="button" value="DOM" class="btn" onclick="viewDetails('domenica')"> </td>
    </tr>
    </table>
    <div id="dettaglio" style="visibility:hidden;">
    </div>
</body>
</html>