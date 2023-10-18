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
<p>nome do(a) cliente: ${param.nome}</p>
<p>idade: ${param.idade}</p>

<c:choose>
	<c:when test="${idade < 18}">
		<p>${param.nome} tem ${param.idade} anos; é um cliente menor de idade. Compras apenas a vista.</p>
	</c:when>
	<c:otherwise>
		<p>${param.nome} é maior de idade. Autorização dada para realizar compras parceladas.</p>
	</c:otherwise>
</c:choose>
</body>
</html>