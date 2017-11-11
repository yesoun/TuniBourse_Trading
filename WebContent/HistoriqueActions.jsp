<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
 <%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
  <%@ taglib uri="http://richfaces.org/rich" prefix="rich"%> 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
     <head> 
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Hsitorique_Orange $::: :</title>
       </head>
        <body>
         <f:view>
            <style>
				.active-row 
				{
	    		background-color: #FFA500;
				}
			</style>
          <h:form>
           <p style="text-align: center;">L'ensemble des transaction Orange :::</p>
  
       <center> 
    <rich:tabPanel style="width:500px;  this.style.backgroundColor='#F1F1F1';"> 
 <rich:tab label="Orange">          
 <center> <rich:dataTable value ="#{Co.listorange}" var="l" rows="5" >
            
 
  
<rich:column sortBy="#{l.idOrange}" filterBy="#{l.idOrange}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
   <f:facet name="header"> <f:verbatim>N° :</f:verbatim> </f:facet> <h:outputText value="#{l.idOrange}" /> 
   </rich:column>
  
<rich:column sortBy="#{l.login}" filterBy="#{l.login}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Login</f:verbatim> </f:facet> <h:outputText value="#{l.login}" /> 
  </rich:column>
 
  
   
    <rich:column sortBy="#{l.type}" filterBy="#{l.type}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
<f:facet name="header"> <f:verbatim>Type </f:verbatim> </f:facet> <h:outputText value="#{l.type}" /> </rich:column>

 <rich:column sortBy="#{l.prixActuel}" filterBy="#{l.prixActuel}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Prix </f:verbatim> </f:facet> <h:outputText value="#{l.prixActuel}" /> 
  </rich:column>
   
 
 
 <rich:column sortBy="#{l.nbreVente}" filterBy="#{l.nbreVente}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Nombre </f:verbatim> </f:facet> <h:outputText value="#{l.nbreVente}" /> 
  </rich:column>
   
 <rich:column sortBy="#{l.nbreActionRest}" filterBy="#{l.nbreActionRest}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Action restants </f:verbatim> </f:facet> <h:outputText value="#{l.nbreActionRest}" /> 
  </rich:column>

        <f:facet name="footer">
         <rich:datascroller id="ds" renderIfSinglePage="false">
         </rich:datascroller> 
         </f:facet> 
         </rich:dataTable>
         </center>
          </rich:tab>
          </rich:tabPanel>
          
          
             <p style="text-align: center;">L'ensemble des transaction Telecom :::</p>
  
       <center> 
    <rich:tabPanel style="width:500px;  this.style.backgroundColor='#F1F1F1';"> 
 <rich:tab label="Telecom">          
 <center> <rich:dataTable value ="#{Cte.listtelecom}" var="l" rows="5" >
            
 
  
<rich:column sortBy="#{l.idTelecom}" filterBy="#{l.idTelecom}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
   <f:facet name="header"> <f:verbatim>N° :</f:verbatim> </f:facet> <h:outputText value="#{l.idTelecom}" /> 
   </rich:column>
  
<rich:column sortBy="#{l.login}" filterBy="#{l.login}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Login</f:verbatim> </f:facet> <h:outputText value="#{l.login}" /> 
  </rich:column>
 
  
   
    <rich:column sortBy="#{l.type}" filterBy="#{l.type}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
<f:facet name="header"> <f:verbatim>Type </f:verbatim> </f:facet> <h:outputText value="#{l.type}" /> </rich:column>

 <rich:column sortBy="#{l.prixActuel}" filterBy="#{l.prixActuel}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Prix </f:verbatim> </f:facet> <h:outputText value="#{l.prixActuel}" /> 
  </rich:column>
   
 
 
 <rich:column sortBy="#{l.nbreVente}" filterBy="#{l.nbreVente}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Nombre </f:verbatim> </f:facet> <h:outputText value="#{l.nbreVente}" /> 
  </rich:column>
   
 <rich:column sortBy="#{l.nbreActionRest}" filterBy="#{l.nbreActionRest}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Action restants </f:verbatim> </f:facet> <h:outputText value="#{l.nbreActionRest}" /> 
  </rich:column>

        <f:facet name="footer">
         <rich:datascroller id="ds" renderIfSinglePage="false">
         </rich:datascroller> 
         </f:facet> 
         </rich:dataTable>
         </center>
          </rich:tab>
          </rich:tabPanel>
          
          
          
          
          
          
          
             <p style="text-align: center;"> L'ensemble des transaction Tunisiana :::</p> 
  
       <center> 
    <rich:tabPanel style="width:500px;  this.style.backgroundColor='#F1F1F1';"> 
 <rich:tab label="Telecom">          
 <center> <rich:dataTable value ="#{Ctu.listtunisiana}" var="l" rows="5" >
            
 
 
  
<rich:column sortBy="#{l.idTunisiana}" filterBy="#{l.idTunisiana}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
   <f:facet name="header"> <f:verbatim>N° :</f:verbatim> </f:facet> <h:outputText value="#{l.idTunisiana}" /> 
   </rich:column>
  
<rich:column sortBy="#{l.login}" filterBy="#{l.login}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Login</f:verbatim> </f:facet> <h:outputText value="#{l.login}" /> 
  </rich:column>
 
  
   
    <rich:column sortBy="#{l.type}" filterBy="#{l.type}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
<f:facet name="header"> <f:verbatim>Type </f:verbatim> </f:facet> <h:outputText value="#{l.type}" /> </rich:column>

 <rich:column sortBy="#{l.prixActuel}" filterBy="#{l.prixActuel}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Prix </f:verbatim> </f:facet> <h:outputText value="#{l.prixActuel}" /> 
  </rich:column>
   
 
 
 <rich:column sortBy="#{l.nbreVente}" filterBy="#{l.nbreVente}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Nombre </f:verbatim> </f:facet> <h:outputText value="#{l.nbreVente}" /> 
  </rich:column>
   
 <rich:column sortBy="#{l.nbreActionRest}" filterBy="#{l.nbreActionRest}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Action restants </f:verbatim> </f:facet> <h:outputText value="#{l.nbreActionRest}" /> 
  </rich:column>

        <f:facet name="footer">
         <rich:datascroller id="ds" renderIfSinglePage="false">
         </rich:datascroller> 
         </f:facet> 
         </rich:dataTable>
         </center>
          </rich:tab>
          </rich:tabPanel>
          
          
         
          
          
          
          
          
          
          </center>
          </h:form>




</f:view> </body> </html>