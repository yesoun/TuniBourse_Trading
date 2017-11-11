<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
 <%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
  <%@ taglib uri="http://richfaces.org/rich" prefix="rich"%> 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
     <head> 
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Exemple rich:dataTable</title>
       </head>
        <body>
         <f:view>
          <h:form>
           <p style="text-align: center;">La liste des personnes ::</p>
  
       <center> 
    <rich:tabPanel style="width:500px;"> 
 <rich:tab label="Admin">          
 <center> <rich:dataTable value ="#{Cc.listpersonne}" var="l" rows="5">
            
  <rich:column sortBy="#{l.idClients}" filterBy="#{l.idClients}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
   <f:facet name="header"> <f:verbatim>ID</f:verbatim> </f:facet> <h:outputText value="#{l.idClients}" /> 
   </rich:column>

<rich:column sortBy="#{l.utilisateurs.login}" filterBy="#{l.utilisateurs.login}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>Login</f:verbatim> </f:facet> <h:outputText value="#{l.utilisateurs.login}" /> 
  </rich:column>
 
  
   
    <rich:column sortBy="#{l.nbreOrange}" filterBy="#{l.nbreOrange}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
<f:facet name="header"> <f:verbatim>nbreOrange</f:verbatim> </f:facet> <h:outputText value="#{l.nbreOrange}" /> </rich:column>

 <rich:column sortBy="#{l.nbreTelecom}" filterBy="#{l.nbreTelecom}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>nbreTelecom</f:verbatim> </f:facet> <h:outputText value="#{l.nbreTelecom}" /> 
  </rich:column>
   
 

 
 
 <rich:column sortBy="#{l.nbreTunisiana}" filterBy="#{l.nbreTunisiana}" filterEvent="onkeyup" style="text-align: center; " styleClass="spec">
  <f:facet name="header"> <f:verbatim>nbreTelecom</f:verbatim> </f:facet> <h:outputText value="#{l.nbreTunisiana}" /> 
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



