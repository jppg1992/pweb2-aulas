package servicos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 


@WebServlet("/bemVindoServlet")
public class BemVindoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BemVindoServlet() {
        super(); 
    } 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		 
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		
		if (nome != null) {
		saida.print("<h2>Bem vindo "+nome+"</h2>");
		}else {
			saida.print("<h2>Bem vindo usuário(a)</h2>");
		}
		saida.close();}
 

}
