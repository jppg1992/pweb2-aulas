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
<%  String item = request.getParameter("nome");
String valorTxt = request.getParameter("valor");
double valor = Double.parseDouble(valorTxt);
Venda v = new Venda();
v.setItem(item);
v.setValor(valor);
VendaDAO vendaDAO = new VendaDAO();
out.println("<br />");
out.println("<b>Item "+item+"</b>");

int status = vendaDAO.inserir(v);
%>
<%if (status ==1){
	out.println("<br />");
	out.println("<b>Item inserido com sucesso !</b>");

}else{
	out.println("<br />");
	out.println("<b>Não foi possivel inserir o item !</b>");
	
} %>
</body>
</html>