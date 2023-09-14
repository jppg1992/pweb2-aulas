package servicos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VendaDAO; 

@WebServlet("/updateVendaServlet")
public class UpdateVendaBDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameterNames());
		String item = request.getParameter("nome");
		float valor = Float.parseFloat(request.getParameter("valor")); 
		int id = Integer.parseInt(request.getParameter("idText"));
		VendaDAO vendaDAO = new VendaDAO(); 
		 
		int status = vendaDAO.atualizar(item,id,valor);
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		// saida.print("status: "+status);
		if (status > 0) {
			saida.print("<p style='color: red'>Venda atualizada com sucesso!</p>");
			// request.getRequestDispatcher("/listarVendasServlet").include(request,
			// response);
			response.sendRedirect("listarVendasServlet");
		} else {
			saida.println("Desculpe! Não foi possível atualizar a venda.");
		}
		saida.close();
	}

}
