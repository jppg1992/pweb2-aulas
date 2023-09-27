<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Calculadora de Média</h1>
<%

// Recebe os valores dos parâmetros n1 e n2 da URL
String parametro1 = request.getParameter("n1");
String parametro2 = request.getParameter("n2");
double num1 = Double.parseDouble(parametro1);
double num2 = Double.parseDouble(parametro2);
// Calcula a média
double media = (num1 + num2) / 2;

%>
<p>

Os número informados foram <%= num1 %> e <%= num2 %>.

</p>
<p>

A média destes números é <%=media%>.

</p>
</body>
</html>