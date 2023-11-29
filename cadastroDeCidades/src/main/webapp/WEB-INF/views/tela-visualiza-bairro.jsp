<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div style="color: white; background-color: green; width: 300px; text-align: center;">
			${mensagem}
		</div>
	</c:if>
	<h2>Dados Bairro</h2>
	
	<form action="" method="post">
		
		
		
		Id:
		<br />
		<input type="text" name="id" value="${bairro.id}">

		<br />		
		
		Nome:
		<br />
		<input type="text" name="nome" value="${bairro.nome}">

		<br />		
		<br />
		População:
		<br />
		<input type="number" name="populacao" value="${bairro.populacao}"  >
	
		<br />
		<br />
		<input type="button" name="btnVoltar" value="Voltar" onclick="history.go(-1);">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	
		
	</form>

	<br />
	<br />
	<br />
	<c:import url="rodape.jsp" />

</body>
</html>