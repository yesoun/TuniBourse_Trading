<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
<h:form>

<div id="header">
			<ul id="user">
				<li class="first"><strong>Bienvenue Client :</strong></li>
				<li class="last highlight"><a target="_blank"><h:commandLink value="Accueil" action="#{Cte.PasseClients}"/></a></li>
			</ul>
			<div style="clear:both"></div>
		</div>

</h:form>

</f:view>
</body>

</html>