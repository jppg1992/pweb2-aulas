package servico;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/calcular-dobro")
public class CalcularDobro extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		int numero = Integer.parseInt( request.getParameter("numero"));
	 
	
		response.setContentType("text/html");
		PrintWriter saidaHtml = response.getWriter();
		saidaHtml.print("O dobro do número informado é o :" + (2*numero));
 
		if (numero > 10 ) {
			response.sendRedirect("http://www.google.com");
		}else {
			response.sendRedirect("tabuada?numero="+ numero);
		}
		
		saidaHtml.close();
	}

 

}
