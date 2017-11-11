<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Client</title>
</head>
<body>
<f:view>
<h:form>

<h1>Welcome Client <h:outputText value="#{Cu.ut.login}" /> </h1>
<br></br>
<br></br>
<br></br>



 
 <table class="style1" style="width: 82%; height: 208px;">
 <tr> <td ><h2>Achat tunisiana:</h2> </td> <td ></td> <td > <h:inputText id="nbre_tuni" value="#{Ctu.tu.nbreVente}" style="width: 261px; height: 29px" /> </td>  
 <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Ctu.Achat_tunisiana}" value="Achat" /></td> </tr> 
</table>


 <table class="style1" style="width: 82%; height: 208px;">
 <tr> <td ><h2>Vente tunisiana:</h2> </td> <td ></td> <td > <h:inputText id="nbre_tunivent" value="#{Ctu.tuv.nbreVente}" style="width: 261px; height: 29px" /> </td>  
 <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Ctu.Vente_tunisiana}" value="Vente" /></td> </tr> 
</table>

<h:inputText>--------------------------------------------------------------------------------</h:inputText>

 <table class="style1" style="width: 80%; height: 208px;">
 <tr> <td ><h2>Achat telecom:</h2> </td> <td ></td> <td > <h:inputText id="nbre_tele" value="#{Cte.te.nbreVente}" style="width: 261px; height: 29px" /> </td> 
 <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Cte.Achat_telecom}" value="Achat" /></td> </tr> 
</table>

 <table class="style1" style="width: 82%; height: 208px;">
 <tr> <td ><h2>Vente teelcom:</h2> </td> <td ></td> <td > <h:inputText id="nbre_televent" value="#{Cte.tev.nbreVente}" style="width: 261px; height: 29px" /> </td>  
 <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Cte.Vente_telecom}" value="Vente" /></td> </tr> 
</table>

<h:inputText>--------------------------------------------------------------------------------</h:inputText>

<table class="style1" style="width: 80%; height: 208px;">

 <tr> <td ><h2>Achat orange:</h2> </td> <td ></td> <td > <h:inputText id="nbre_oran" value="#{Co._Orange.nbreVente}" style="width: 261px; height: 29px" /> </td> 
 <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Co.Achat_orange}" value="Achat" /></td> </tr> 
</table>


<table class="style1" style="width: 82%; height: 208px;">
 <tr> <td ><h2>Vente orange:</h2> </td> <td ></td> <td > <h:inputText id="nbre_oranvent" value="#{Co.tov.nbreVente}" style="width: 261px; height: 29px" /> </td>  
 <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Co.Vente_orange}" value="Vente" /></td> </tr> 
</table>



</h:form>
</f:view>
</body>
</html>