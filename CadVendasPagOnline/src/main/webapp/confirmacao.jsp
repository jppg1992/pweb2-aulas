<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CadVendasPagOnline</title>
</head>
<body>
	<c:import url="/components-jstl/cabecalho.jsp" />
	<%@ page import="java.util.*"%>
	<%@ page import="models.VendaPagDigital"%>
	<%@ page import="models.VendaPagDigitalDAO"%>
	<%@ page import= "java.text.DecimalFormat" %>
	<%
	VendaPagDigital v = (VendaPagDigital) request.getAttribute("venda");
	double total = 0.0f;
	double valorOr = Float.parseFloat(request.getParameter("valorOriginal"));
	%>
	<p style='color: red'>Venda inserida com sucesso!</p>

	<br />
	<b>Cliente: </b><%=v.getCliente()%>
	<br />
	<b>E-mail: </b><%=v.getClienteEmail()%>
	<br />
	<br />
	<b>Produto: </b><%=v.getProduto()%><br>
	<span style='color: blue'>
		Valor do produto: R$<%=new DecimalFormat("#.00").format(valorOr)%></span> <br>
 
	<c:set var="tipoPAg" value="<%=v.getTipoPagamento()%>"/>
<br>
<c:choose>
  <c:when test="${tipoPAg.equals('Pix') }">
  
    <b>Forma de pagamento:</b> Pix(10% de desconto)
    <br><span style='color: blue'>
		Valor a pagar no pix: R$<%=new DecimalFormat("#.00").format(total= (valorOr-valorOr*0.1f))%></span>
	<br>Chave pix enviada para o e-mail do cliente
  </c:when>
  <c:when test="${tipoPAg.equals('Boleto bancário') }">
    <b>Forma de pagamento:</b> Boleto bancário(5% de desconto)
    <br><span style='color: blue'>
		Valor a pagar no Boleto: R$<%=new DecimalFormat("#.00").format(total=valorOr-valorOr*0.05f)%></span>
	<br>Boleto enviado para o e-mail do cliente
  </c:when>
   <c:when test="${tipoPAg.equals('Cartão de crédito') }">
     <b>Forma de pagamento:</b> Cartão de Crédito(á vista sem desconto)
    <span style='color: blue'><br>
		Valor a pagar no cartão: R$<%=new DecimalFormat("#.00").format(total=valorOr)%></span><br>
	Nota fiscal eletrônica enviada para o e-mail do cliente
  </c:when>
</c:choose>

<br><br>
<c:set var="entrega" value="<%=v.getTipoEntrega()%>"/>

<c:choose>
  <c:when test="${entrega.equals('sedex')}">
   Taxa de entrega: R$ 60,00 (será enviado por <u>Sedex</u>)
  <br><br>
  <b>Total da venda: R$<%=new DecimalFormat("#.00").format(v.getValorPago()) %></b>
  </c:when>
  <c:otherwise>
   Taxa de entrega: R$ 40,00 (será enviado por <u>transportadora</u>)
  <br><br>
  <b>Total da venda: R$<%=new DecimalFormat("#.00").format(v.getValorPago()) %></b>
  </c:otherwise>
</c:choose>
<br><br>
status : <span style='color: red'> <%=v.getStatusPagamento() %></span>

 <br><br>
 <a href="ListarVendasServlet">Lista de Vendas com pagamento digital</a>

	<c:import url="/components-jstl/rodape.jsp" />
</body>
</html>