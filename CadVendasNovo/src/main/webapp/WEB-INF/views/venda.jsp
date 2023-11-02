<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Venda</title>
</head>
<body>
<h1>Dados da venda</h1>

Produto:${venda.getItem()}
<br/>
Preço:R$ ${venda.getValor()}
<br/>
IP: ${ip}
<br/>
</body>
</html>