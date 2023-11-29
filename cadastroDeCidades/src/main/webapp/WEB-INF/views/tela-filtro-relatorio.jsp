<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatório de cidades</title>
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
	
	<h2>Relatório de cidades</h2>
	
	 	
	 <form action="relatorioCidades" method="post">
	 Quantidade mínima de cidades por estado:  
	 <input type="number" name="quantidade" required   >
		<br />
		<br />
		<input type="button" name="btnVoltar" value="Voltar" onclick="history.go(-1);">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 		<input type="submit" name="btnSubmit" value="Gerar Relatório"  >
		
	 </form>


	<br />
	<br />
	<br />
	<c:import url="rodape.jsp" />

</body>
</html>