<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Nome: ${param.nome} ${param.sobrenome}</p>
	<c:forEach var="mes" items="${meses}">
		<p>
		<c:if test="${mes.equals('janeiro')}">
				O Ano começa em: 
		</c:if>
			<c:choose>
				<c:when test="${mes.equals('dezembro')}">  
    			 Chegou o fim do ano !!!
    			</c:when>
			<c:otherwise>
    			${mes}
    		</c:otherwise>
			</c:choose>
		</p>
	</c:forEach>

</body>
</html>