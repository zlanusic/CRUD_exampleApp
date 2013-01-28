<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8s">
<title>POS-TERMINAL</title>
</head>
<body>
<h1>Terminali</h1>
 
<c:url var="saveUrl" value="/root/terminals/save" />
<table style="border: 1px solid; width: 500px; text-align:center">
 <thead style="background:#fcf">
  <tr>
   <th>Vlasnik</th>
   <th>Adresa</th>
   <th>Datum aktivacije</th>
   <th colspan="3"></th>
  </tr>
 </thead>
 <tbody>
 <c:forEach items="${terminals}" var="terminal">
   <c:url var="updateUrl" value="/root/terminals/update?id=${terminal.id}" />
   <c:url var="deleteUrl" value="/root/terminals/delete?id=${terminal.id}" />
  <tr>
   <td><c:out value="${terminal.owner}" /></td>
   <td><c:out value="${terminal.location}" /></td>
   <td><c:out value="${terminal.activation}" /></td>
   <td><a href="${updateUrl}">Uredi</a></td>
   <td><a href="${deleteUrl}">Izbriši</a></td>
   <td><a href="${saveUrl}">Spremi</a></td>
  </tr>
 </c:forEach>
 </tbody>
</table>
 
<c:if test="${empty terminals}">
 Trenutno nema terminala u kolekciji. <a href="${saveUrl}">Dodaj</a> novi terminal.
</c:if>
 
</body>
</html>