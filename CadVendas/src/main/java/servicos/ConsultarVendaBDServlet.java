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

@WebServlet("/consultarVendaServlet")
public class ConsultarVendaBDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String idTxt = request.getParameter("id");
		int id = Integer.parseInt(idTxt);
		String confirmar = request.getParameter("confirmar");
		
		List<Venda> listaVendas = new ArrayList<>();
		VendaDAO vendaDAO = new VendaDAO();
		listaVendas = vendaDAO.listarTodas("id", "asc");
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();

		int atual = 0;
		for (atual = 0; atual < listaVendas.size(); atual++) {
			if (listaVendas.get(atual).getId() == id) {
				break;
			}
		}
		saida.print("<h2>Consultar Venda</h2>");
		saida.print("<br /><b>id</b>: " + listaVendas.get(atual).getId());
		saida.print("<br /><b>item</b>: " + listaVendas.get(atual).getItem());
		saida.print("<br /><b>quantidade</b>: " + listaVendas.get(atual).getValor());
		saida.print("<br /><b>quantidade</b>: " + listaVendas.get(atual).getValor());

		System.out.println(Integer.parseInt(confirmar) = 1);
		System.out.println(confirmar);
		System.out.println("sim");
		
		
		if (confirmar == "sim" ) {
			saida.print("<br /><a href ='removerVendaServlet?id=" + id + "'> Confirmar Exclusão</a>");
		} else {

			if (atual > 0 && listaVendas.get(atual - 1) != null) {
				saida.print("<br /><a href='consultarVendaServlet?id=" + listaVendas.get(atual - 1).getId()
						+ "'> Venda Anterior  </a>");
			} else {
				saida.print("<br /><a href='#'> Venda Anterior  </a>");
			}

			if (atual < listaVendas.size() - 1) {
				saida.print("<br /><a href='consultarVendaServlet?id=" + listaVendas.get(atual + 1).getId()
						+ "'> Próxima Venda   </a>");
			} else {
				saida.print("<br /><a href='#'> Próxima Venda  </a>");
			}
		}
		saida.close();
	}
}