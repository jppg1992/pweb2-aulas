package controllers;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import models.VendaPagDigital;
import models.VendaPagDigitalDAO;

/**
 * Servlet implementation class ListarVendasServlet
 */
@WebServlet("/ListarVendasServlet")
public class ListarVendasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarVendasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		List<VendaPagDigital> listaVendas = new ArrayList<>(); 
		listaVendas = VendaPagDigitalDAO.listarTodas();
	
		request.setAttribute("vendas", listaVendas);
		RequestDispatcher rd = request.getRequestDispatcher("/ListagemVendas.jsp");
		rd.forward(request,response);
		 	 
		 
	}
 

}
