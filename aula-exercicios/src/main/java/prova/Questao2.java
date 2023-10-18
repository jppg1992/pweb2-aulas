package prova;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Questao2
 */
@WebServlet("/processarVenda")
public class Questao2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float p1 = Float.parseFloat(request.getParameter("preco1").replace(',', '.'));
		float p2 = Float.parseFloat(request.getParameter("preco2").replace(',', '.'));
		float p3 = Float.parseFloat(request.getParameter("preco3").replace(',', '.'));
		
		PrintWriter htmlSaida = response.getWriter();
		response.setContentType("text/html");

		htmlSaida.print("totala pagar: R$" + String.valueOf((p1+p2+p3)).replace('.', ','));
		
		htmlSaida.close();
	}

}
