<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastrar Bairro</title>
</head>
<body style="margin-top: -20px;">

	<c:import url="cabecalho.jsp" />

	 
<c:if test="${not empty mensagem}">
		<br />
		<br />
		<div style="color: white; background-color: red; width: 300px; text-align: center;">
			${mensagem}
		</div>
	</c:if>

	<h2>Consultar Bairro</h2>
	
	<form action="consultaPorNome" method="post">
	 	
		
		Nome:
		<br />
		<input type="text" name="nome" value="${bairro.nome}">
		<br />
		<br />
		<input type="button" name="btnVoltar" value="Voltar" onclick="history.go(-1);">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	<input type="submit" name="btnConsultar" value="Consultar">	
		
	</form>

	<br />
	<br />
	<br />
	<c:import url="rodape.jsp" />

</body>
</html>