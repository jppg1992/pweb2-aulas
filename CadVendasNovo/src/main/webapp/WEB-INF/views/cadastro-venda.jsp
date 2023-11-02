<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Venda</title>
</head>
<body>
<form action="/cad-vendas-novo/processarVenda" method="post">
<label for="item">
Produto:
<input type="text" name="item">
</label>

<label for="valor">
Valor:
<input type="number" name="valor" step=0.1>
</label>

<input type="submit" value="Cadastrar">
</form>

</body>
</html>