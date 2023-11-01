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
<h1>Listagem de funcionários</h1>
<table border="1" >
<thead>
<tr>
<th>Nome</th>
<th>Sala</th>
<th>Salário</th>

</tr>
</thead>
<tbody>
<c:forEach var="funcionario" items="${funcionarios}">
<tr>
<td>${funcionario.getNome()}</td>
<td>${funcionario.getNumeroSala()}</td>
<td>${funcionario.getSalario()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>