package servicos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VendaDAO;
import modelo.Venda;

@WebServlet("/atualizarVenda")
public class AtualizarVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idTxt = request.getParameter("id");
		int id = Integer.parseInt(idTxt);
		VendaDAO vendaDAO = new VendaDAO();
		Venda v = vendaDAO.consultarPorId(id);
		response.setContentType("text/html");

		PrintWriter saida = response.getWriter();
		saida.print("<h2>Atualizar Venda</h2>");
		saida.print("<form action=\"updateVendaServlet\" method=\"post\">");
		saida.print("<br /><b>id</b>: <br/> <input type=\"text\" name=\"idText\" value='" + id+"' hidden >"+id);
		saida.print("<br /><b>item</b>: <br/> <input type=\"text\" name=\"nome\" value='" + v.getItem()+"'>");
		saida.print("<br /><b>valor</b>: <br/> <input type=\"text\" name=\"valor\" value='" + v.getValor()+"'>");
		saida.print("<br /><input type=\"submit\" name=\"enviar\" value=\"Atualizar\"> 	</form>");

		saida.close();
	}
}
