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
	<%@ page import="java.text.DecimalFormat"%>
	<%
	List<VendaPagDigital> listaVendas = (List<VendaPagDigital>) request.getAttribute("vendas");
	%>
	<%=listaVendas.get(0).getCliente()%>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Cliente</th>
				<th>Produto</th>
				<th>Valor Pago(R$)</th>
				<th>Pagamento</th>
				<th>Entrega</th>
				<th>Status Pagamento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="li" items="${listaVendas}">
				<tr>
					<td><c:out value="${li.getId()}" /></td>
					<td><c:out value="${li.getCliente()}" /></td>
					<td><c:out value="${li.getProduto()}" /></td>
					<td><c:out value="${li.getValorPago()}" /></td>
					<td><c:out value="${li.getTipoPagamento()}" /></td>
					<td><c:out value="${li.getTipoEntrega()}" /></td>
					<td><c:out value="${li.getStatusPagamento()}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:import url="/components-jstl/rodape.jsp" />
</body>
</html>