package prova;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Questao4
 */
@WebServlet("/cliente")
public class Questao4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int idade = Integer.parseInt( request.getParameter("idade"));
		
		request.setAttribute("nome", nome);
		request.setAttribute("idade", idade);
		 
		RequestDispatcher rd = request.getRequestDispatcher("/dadosCliente.jsp");
		rd.forward(request, response);
	}
 
 

}
