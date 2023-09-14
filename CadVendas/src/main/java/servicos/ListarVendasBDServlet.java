package servicos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.VendaDAO;
import modelo.Venda;

@WebServlet(urlPatterns = "/listarVendasServlet")
public class ListarVendasBDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Venda> listaVendas = new ArrayList<Venda>();
		VendaDAO vendaDAO = new VendaDAO();
		listaVendas = vendaDAO.listarTodas();
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		saida.print("<html>");
		saida.print("<head>");
		saida.print(" <meta charset=\"UTF-8\">");
		saida.print(" <title>Lista de Vendas</title>");
		saida.print(" <link rel='stylesheet' type='text/css' href='./css/tabelaListaVendas.css'>");

		saida.print("</head>");
		saida.print("<body>");
		saida.print("<a href=\"index.html\" class='btn-type'> Inserir nova venda</a>");
		saida.print("<h2>Lista de Vendas</h2>");
		saida.print("<table border='1' class='styled-table'>");
		saida.print(" <tr>");
		saida.print("<th>id</th><th>item</th><th>Valor</th><th>Consultar</th><th>Atualizar</th><th>Remover</th>");

		saida.print(" </tr>");
		for(int i=0; i<listaVendas.size(); i++) {
		Venda v = listaVendas.get(i);
		saida.print(" <tr>");
		saida.print(" <td style='padding: 15px;'>" + v.getId() + "</td><td>"+v.getItem() +"</td><td>"+ v.getValor()
		+"</td>");

		saida.print(" <td style='padding: 15px;'><a href='consultarVendaServlet?id="+v.getId()+"' class='btn-type'>consultar</a></td>");
		saida.print(" <td style='padding: 15px;'><a href='atualizarVenda?id="+v.getId()+"' class='btn-type'>atualizar</a></td>");

		saida.print(" <td style='padding: 15px;'><a href='removerVendaServlet?id="+v.getId()+"' class='btn-type-at'>remover</a></td>");
		saida.print(" </tr>");
		}
		saida.print("<table>");
		saida.print("</body>");
		saida.print("</html>");
		saida.close();
	}
}