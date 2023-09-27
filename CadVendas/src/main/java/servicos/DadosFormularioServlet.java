package servicos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

/**
 * Servlet implementation class dadosFormularioServlet
 */
@WebServlet("/dadosFormularioServlet")
public class DadosFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DadosFormularioServlet() {
        super(); 
    }

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String diaSemana = request.getParameter("diaSemana");
		String cadastrarEmail = request.getParameter("cadastrarEmail");
		String[] frutas = request.getParameterValues("frutas");
		 
	 
	 
		response.setContentType("text/html");
		PrintWriter htmlSaida = response.getWriter();
	 
		
		
		htmlSaida.print("<h1 style='color: red'>DADOS DO FORMULÁRIO</h1>");
		htmlSaida.print("<p> Dia da Semana: "+diaSemana+"</p>");
		htmlSaida.print("<p> Cadastrar E-mail: "+cadastrarEmail+"</p>");
		htmlSaida.print("<ul> FRUTAS");
		for(int i =0;i<frutas.length;i++) {
			htmlSaida.print("<li>"+frutas[i]+"</li>");	
		}
		htmlSaida.print("</ul>");
		 
		htmlSaida.close();
		}	 
	 

}
