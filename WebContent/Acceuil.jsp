<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> -Page Acceuil ::</title>
<style type="text/css">
.style1 { border: 1px solid #000000; margin:100px; } </style>
</head>

<body> 
<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Acceuil TuniBourse ::</h1>
<f:view> 
<br>


  
  



<h:form> 
  <table class="style1" style="width: 80%; height: 418px;">
 <tr> <td > Login:</td> <td >:</td> <td > <h:inputText id="Login" value="#{Cu.ut.login}" style="width: 261px; height: 29px" /> </td> </tr> 
<tr> <td > Password:</td> <td >:</td> <td > <h:inputText id="Password" value="#{Cu.ut.password}" style="width: 261px; height: 29px" /> </td> </tr> 
 
<tr> <td > </td> <td > </td> <td><h:commandButton style="width: 160px; height: 30px" action="#{Cu.Verif_Utilisateur}" value="Se connecter"  /></td> </tr> 
</table>







 


<br>
<br><br>

</h:form> </f:view>

</body>
</html>



