<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exclusão de Bairro</title>
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

	<h2>Excluir um Bairro</h2>
	
	 	Id: ${bairro.id}
	 	<br />
		Nome: ${bairro.nome}
		<br />
		
		População: ${bairro.populacao}
		<br />
		
		 
		<br />
		<input type="button" name="btnVoltar" value="Voltar" onclick="history.go(-1);">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 		<a href="excluirBairroBD?id=${bairro.id}">Confirmar</a>	
		
	 

	<br />
	<br />
	<br />
	<c:import url="rodape.jsp" />

</body>
</html>