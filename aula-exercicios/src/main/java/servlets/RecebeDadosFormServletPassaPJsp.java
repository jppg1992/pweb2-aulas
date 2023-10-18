package servlets;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

/**
 * Servlet implementation class RecebeDadosFormServlet
 */
@WebServlet("/recebeDadosFormServletJsp")
public class RecebeDadosFormServletPassaPJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String[] meses = {"janeiro","fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"};

		request.setAttribute("nome", nome);
		request.setAttribute("sobrebome", sobrenome);
		request.setAttribute("meses", meses);
		 
		RequestDispatcher rd = request.getRequestDispatcher("/DadosForm.jsp");
		rd.forward(request, response);
		}
	}
