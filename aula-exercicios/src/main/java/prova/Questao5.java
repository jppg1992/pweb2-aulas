package prova;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Questao5
 */
@WebServlet("/listarAlunos")
public class Questao5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Aluno a1 = new Aluno("Ana Silva",15);
		Aluno a2 = new Aluno("Bruno Castro",34);
		Aluno a3 = new Aluno("Paulo Gomes",26);
		
		List<Aluno>  alunos = new ArrayList<Aluno>();
		
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		
		request.setAttribute("alunos", alunos);
		 
		RequestDispatcher rd = request.getRequestDispatcher("/lista-de-alunos.jsp");
		rd.forward(request, response);

		

	}

	 

}
