<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import='org.cert.parse.model.*'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<h2>Displaying Certificate Details</h2>
</head>
<body>
<% CertBean cb = (CertBean)request.getAttribute("cBean");
%>
<table>
<tr><td>Issuer : </td><td><%cb.getIssuer(); %></td></tr>
<tr><td>Subject : </td><td><%cb.getSubject(); %></td></tr>
<tr><td>Serial Number : </td><%cb.getSerialNumber(); %><td></td></tr>
<tr><td>Is Valid : </td><td><%cb.isValid(); %></td></tr>
<tr><td>From Date : </td><%cb.getFromDate(); %><td></td></tr>
<tr><td>To Date : </td><%cb.getToDate(); %><td></td></tr>
</table>

</body>
</html>