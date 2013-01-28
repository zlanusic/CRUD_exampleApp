<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NOVI POS-TERMINAL</title>
</head>
<body>
 
<h1>Dodaj novi POS-Termianl</h1>
 
<c:url var="saveUrl" value="/root/terminals/save" />
<form:form modelAttribute="terminalAttribute" method="POST" action="${saveUrl}">
 <table>
  <tr>
   <td><form:label path="owner">Vlasnik</form:label></td>
   <td><form:input path="owner"/></td>
  </tr>
 
  <tr>
   <td><form:label path=location>Adresa</form:label></td>
   <td><form:input path="location"/></td>
  </tr>
   
  <tr>
   <td><form:label path="activation">Datum aktivacije</form:label></td>
   <td><form:input path="activation"/></td>
  </tr>
 </table>
  
 <input type="submit" value="Save" />
</form:form>
 
</body>
</html>