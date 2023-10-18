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
<ul> <h1>Lista de alunos:</h1>
<c:forEach var="aluno" items="${alunos}">
<li> - ${aluno.nome} - idade: ${aluno.idade}</li>
</c:forEach>
</ul>
</body>
</html>