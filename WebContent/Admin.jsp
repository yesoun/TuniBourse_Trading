<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
			<!--
			function fonct(){
				document.forms['NewsLetter'].action = "test2.php?val=true";
				document.forms['NewsLetter'].submit();
			}
			//-->
		</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Admin</title>
</head>
<body>


<f:view> 
<h:form> 

<h4>Welcome Admin  <h:outputText value="#{Cu.ut.login}"  /> </h4>
<h1>Ajout  ut ilisateur :</h1>

  <table class="style1" style="width: 80%; height: 518px;">
 <tr> <td > Login</td> <td >:</td> <td > <h:inputText id="Login" value="#{Cu.ut.login}" style="width: 261px; height: 29px" /> </td> </tr> 
 <tr> <td > Password</td> <td >:</td> <td > <h:inputText id="Password" value="#{Cu.ut.password}" style="width: 261px; height: 29px" /> </td> </tr> 
 <!--<tr> <td > type</td> <td >:</td> <td > <h:inputText id="Type" value="#{Cu.ut.type}" style="width: 261px; height: 29px" /> </td> </tr> 
 -->
  <tr><td style="width: 71px">Type Utilisateur</td> <td style="width: 69px">:</td>
    <td> <h:selectOneMenu style="width: 225px" value="#{Cu.ut.type}"> 
    
    
   <f:selectItem itemValue ="" /> 
   <f:selectItem itemValue ="admin" /> <f:selectItem itemValue ="client" /> 
    </h:selectOneMenu>
    </td> </tr> 
    
<tr> <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Cu.Ajout_Utilisateur}" value="Valider" /></td> </tr> 
</table>





<h1>Misea à jour prix : </h1>

 <table class="style1" style="width: 90%; height: 208px;">
 <tr> <td >nouveau prix action telecom</td> <td >:</td> <td > <h:inputText id="Prix_actuel_telecom" value="#{Cte.te.prixActuel}" style="width: 261px; height: 29px" /> </td> 
  <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Cte.Modifier_prix}" value="Modifier" /></td> </tr> 
</table>







 <table class="style1" style="width: 90%; height: 208px;">
 <tr> <td >nouveaux prix tunisiana :</td> <td >:</td> <td > <h:inputText id="Prix_actuel_tunisiana" value="#{Ctu.tu.prixActuel}" style="width: 261px; height: 29px" /> </td> 
 <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Ctu.Modifier_prix}" value="Modifier" /></td> </tr> 
</table>



<table class="style1" style="width: 90%; height: 208px;">
 <tr> <td >nouveaux prix orange:</td> <td >:</td> <td > <h:inputText id="Prix_actuel_orange" value="#{Co._Orange.prixActuel}" style="width: 261px; height: 29px" /> </td> 
 <td > </td> <td > </td> <td><h:commandButton style="width: 180px; height: 30px;" action="#{Co.Modifier_prix}" value="Modifier" /></td> </tr> 
</table>










</h:form> </f:view>

</body>
</html>
