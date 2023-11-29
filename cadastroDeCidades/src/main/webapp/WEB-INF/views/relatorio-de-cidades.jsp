<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Relatório de cidades</title>
</head>
<body style="margin-top: -20px;">

	<c:import url="cabecalho.jsp" />

	<h2>Relatório de cidades</h2>
	
	<table border="1">
		<tr bgcolor="gray">
			 <th>Estado</th><th>Qtd_Cidades</th>
		</tr>
     <c:forEach var="cidadeCorrente" items="${cidades}">
		<tr>
		 
			<td width="400">${cidadeCorrente.estado}</td>
			<td width="50">${cidadeCorrente.qtd_cidades}</td>
		</tr>
	  </c:forEach>

	</table>

	<br />	
	<input type="button" name="btnVoltar" value="Voltar" onclick="history.go(-1);">

	<br />
	<br />
	<c:import url="rodape.jsp" />

</body>
</html>