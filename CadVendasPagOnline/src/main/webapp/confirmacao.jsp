<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%@ page import="models.VendaPagDigital" %>
<%@ page import="models.VendaPagDigitalDAO" %>
<% VendaPagDigital v   = (VendaPagDigital)request.getAttribute("venda");
 
out.println("<br />");
out.println("<b>Item "+v.getProduto() +"</b>");

 
%> 
</body>
</html>