package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

/**
 * Servlet implementation class RecebeDadosFormServlet
 */
@WebServlet("/recebeDadosFormServlet")
public class RecebeDadosFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		PrintWriter htmlSaida = response.getWriter();
		response.setContentType("text/html");

		htmlSaida.print("Nome: " + nome + " " + sobrenome);
		
		htmlSaida.close();
		}
	}
