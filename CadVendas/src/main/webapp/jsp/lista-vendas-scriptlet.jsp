<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%@ page import="modelo.Venda" %>
<%@ page import="DAO.VendaDAO" %>
<h2>Lista de Vendas</h2>
<%
VendaDAO vendadDAO = new VendaDAO();
List<Venda> listaVendas = vendadDAO.listarTodas("id","asc");
%>
<table border="1">
<tr>

<td>id</td><td>item</td><td>valor</td>

</tr>
<% for (Venda v : listaVendas){ %>
<tr>
<td><%= v.getId() %></td><td><%= v.getItem() %></td> <td><%= v.getValor() %></td>
</tr>
<%
} //final do bloco do for
%>
</table>
</body>
</html>