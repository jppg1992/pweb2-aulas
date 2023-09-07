package servico;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/tabuada"})
public class Tabuada extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			  throws IOException {

		int numero = Integer.parseInt( request.getParameter("numero") );
		
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		saida.println("<h1>Tabuada da Multiplicação:</h1>");
		for (int n=1; n<=10; n++) 
			saida.println(numero + " x " + n + " = " + (n*numero) + "<br />");
		saida.close();
	}
}
