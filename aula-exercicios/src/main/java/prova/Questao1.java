package prova;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Questao1
 */
@WebServlet("/matematica")
public class Questao1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		int n1 = Integer.parseInt(request.getParameter("numero1"));
		int n2 = Integer.parseInt(request.getParameter("numero2"));
		PrintWriter htmlSaida = response.getWriter();
		response.setContentType("text/html");

		htmlSaida.print("soma: " + (n1+n2));

		htmlSaida.print("<br/> subtração: " + (n1-n2));

		if (n1==n2) {
			htmlSaida.print("<br/> <i> os números "+ n1+" e "+n2+ " são números iguais</i>");		
		}else
		{
			htmlSaida.print("<br/> <u> os números "+ n1+" e "+n2+ " são números diferentes</u>");		
		}
	
		
		htmlSaida.close();
	}
 
}
