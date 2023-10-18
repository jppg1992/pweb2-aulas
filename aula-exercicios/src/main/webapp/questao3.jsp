<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p> número 1: ${param.numero1} </p>
<p> número 2: ${param.numero2} </p>
<p> multiplicação: ${param.numero1*param.numero2} </p>
<p> divisão: ${param.numero1/param.numero2} </p>

<c:if test="${param.numero1==param.numero2}">
	<p>os dois números recebidos são o ${param.numero1}, são números iguais</p>
 </c:if>

</body>
</html>