<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

// Recebe os valores dos parâmetros n1 e n2 da URL
String parametro1 = request.getParameter("numero"); 
int num = Integer.parseInt(parametro1); 
%>

<% for(int i =1; i<=10;i++){ %>
 <p><span> <%=i %> </span> x <span><%=num%> </span> = <span><%= num*i %></span> </p>
<%
	} 
%>
</body>
</html>