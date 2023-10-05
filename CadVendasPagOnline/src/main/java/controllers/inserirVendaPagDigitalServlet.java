package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import models.VendaPagDigital;
import models.VendaPagDigitalDAO;

/**
 * Servlet implementation class insertVenda
 */
@WebServlet("/inserirVendaPagDigitalServlet")
public class inserirVendaPagDigitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public inserirVendaPagDigitalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeCLiente = request.getParameter("nomeCLiente");
		String emailCLiente = request.getParameter("emailCLiente");
		String nomeProduto = request.getParameter("nomeProduto");
		String valorProduto = request.getParameter("valorProduto");
		double valor = valorProduto != "" ? Double.parseDouble(valorProduto) : 0;
		String formaPagamento = request.getParameter("formaPagamento");
		String tipoDeEntrega = request.getParameter("tipoDeEntrega");
		double valorOriginal = valor;
		
		double valorFinal = valor;
		
		if (formaPagamento.equals("Pix")) {
			valorFinal -= valor*0.1f;
		}else if(formaPagamento.equals("Boleto bancário")) {
			valorFinal -= valor*0.05f;
		}
		
		if (tipoDeEntrega.equals("sedex")) {
			valorFinal+= 60;
		}else {
			valorFinal+=40;
		}
		PrintWriter htmlSaida = response.getWriter();
		if (nomeCLiente == null || nomeCLiente == "" || valorProduto == "" || valorProduto == null || valor <= 0) {
			htmlSaida.print(
					"<h1>Preencha corretamente os campos: Não podem ser vazios e o valor deve ser maior que ZERO.</h1>");
		} else {
			VendaPagDigital v = new VendaPagDigital();

			v.setCliente(nomeCLiente);
			v.setClienteEmail(emailCLiente);
			v.setProduto(nomeProduto);
			 
			if (formaPagamento.equals("Cartão de crédito")) {
				v.setStatusPagamento("Pagamento Confirmado");	
			}else {
			v.setStatusPagamento("Aguardando o pagamento");
			}
			v.setTipoEntrega(tipoDeEntrega);
			v.setTipoPagamento(formaPagamento);
			v.setValorPago(valorFinal);
			VendaPagDigitalDAO vendaDAO = new VendaPagDigitalDAO();
			int status = vendaDAO.inserir(v);
			System.out.println(status);
 
			if (status > 0) {
				request.setAttribute("venda", v);
				RequestDispatcher rd = request.getRequestDispatcher("/confirmacao.jsp?valorOriginal="+valorOriginal);
				rd.forward(request,response);
				 	 
			} else {
				htmlSaida.println("Desculpe! Não foi possível inserir a venda.");
			}
		}
		htmlSaida.close();
	}
}
