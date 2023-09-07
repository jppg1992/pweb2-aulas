package servico;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numero1 = Integer.parseInt( request.getParameter("numero1"));
		int numero2 = Integer.parseInt(request.getParameter("numero2"));
		
		int soma = numero1+numero2;
		
		
		
		response.setContentType("text/html");
		PrintWriter saidaHtml = response.getWriter();
		saidaHtml.print("Soma:");
		saidaHtml.print("<br/>");
		saidaHtml.print(soma);
		
		saidaHtml.close();
		}

}
