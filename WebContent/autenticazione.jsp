<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="esercizi.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Benvenuto</title>
<style type="text/css">
   label{
      color:magenta;
      font-size:20px;
      font-weight:bold;
   }
   div{
      margin-left:20px;
      float:left;
      height:180px;
      width:390px;
      background-color:grey;
      text-align:center;
   }
</style>
<script type="text/javascript">
function vediOpzioni(id){
	var div=document.getElementById("formato");
	//usato per riferirsi al contenuto del tag (INNER) ---usato per riferirsi a tutto il tag e contenuto(OUTER)
	div.innerHTML="";
	var intest=document.createElement("label");
	intest.appendChild(document.createTextNode("Formato"));
	div.appendChild(intest);
	div.appendChild(document.createElement("br"));
	div.style.background="green";
	var n;
	if(id=='radioVideo'){n=4;}else{n=3;}
	var etichetta;
	for(var i=0;i<n;i++){
		if(n==4){
			switch (i){
			case 0:etichetta="WMV";break;
			case 1:etichetta="MPEG";break;
			case 2:etichetta="AVI";break;
			case 3:etichetta="PROPRIETARIO";break;
			}
		}else{
			switch(i){
			case 0:etichetta="MP3";break;
			case 1:etichetta="AU";break;
			case 2:etichetta="MIDI";break;
			}
		}
		var radio=document.createElement("input");
		var lblradio=document.createElement("label");
		radio.setAttribute("name","sceltaAudio");
		radio.setAttribute("type","radio");
		lblradio.appendChild(document.createTextNode(etichetta));
		div.appendChild(radio);
		div.appendChild(lblradio);
		div.appendChild(document.createElement("br"));
	}
	div.style.visibility="visible";
	
}
</script>
</head>
<body id="corpo"> 
   <div>
   <% Autenticazione aut=(Autenticazione)request.getAttribute("Autenticazione");%>
     <form action="ServletUpload?utente=<%=aut.getUser() %>" method="POST">
     	<label> Benvenuto <%=aut.getUser()%> </label> <br>
     	<label>Scegli il documento che vuoi trasferire</label><br>
     	<input type="radio" id="radioVideo" name="scelta" value="Video" onclick="vediOpzioni('radioVideo')"> Video 
     	<input type="radio" id="radioAudio" name="scelta" value="Audio" onclick="vediOpzioni('radioAudio')"> Audio <br>
     	<label>Documento:</label>
     	<input type="file" id="sceltaFile" name="myfile" value="sfoglia"><br>
     	<input type="hidden" name="utente" value="<%=aut.getUser() %>">
     	<input type="submit" value="Invia">
     	<input type="reset" value="Annulla">
     </form>
   </div>
     <div style="visibility:hidden;" id="formato"></div>
     
</body>
</html>