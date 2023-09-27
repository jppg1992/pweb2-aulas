package servicos;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VendaDAO;
import modelo.Venda;
@WebServlet("/inserirVendaServlet")
public class InserirVendaBDServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {

String item = request.getParameter("nome");
String valorTxt = request.getParameter("valor");
double valor = valorTxt != "" ? Double.parseDouble(valorTxt) : 0;
PrintWriter htmlSaida = response.getWriter();
if(item==null||item ==""||valorTxt==""||valorTxt==null||valor<=0) {
htmlSaida.print("<h1>Preencha corretamente os campos: Não podem ser vazios e o valor deve ser maior que ZERO.</h1>");	
}else {
Venda v = new Venda();
v.setItem(item);
v.setValor(valor);
VendaDAO vendaDAO = new VendaDAO();
int status = vendaDAO.inserir(v);
response.setContentType("text/html");

//htmlSaida.print("resultado: " + status);
if(status>0){
htmlSaida.print("<p style='color: red'>Venda inserida com sucesso!</p>");
request.getRequestDispatcher("index.html").include(request, response);
} else {
htmlSaida.println("Desculpe! Não foi possível inserir a venda.");
}
}
htmlSaida.close();
}
}