package ifsul.pweb.CadVendasNovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ifsul.pweb.CadVendasNovo.models.Venda;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class VendaContoller {

	@GetMapping("exibirVenda")
	public String recebeDadosPorObjetoRequest(Model model,HttpServletRequest req) {

		 String produto = req.getParameter("produto"); 
		 float preco = Float.parseFloat(req.getParameter("preco"));
		 
		Venda venda = new Venda(produto,preco);
		
		model.addAttribute(venda); 
		model.addAttribute("ip",req.getRemoteAddr());
		return "venda.jsp";
		
	}
	@GetMapping("exibirVendaNovo")
	public String recebeDadosNovo(Model model,@RequestParam("produto") String produto,@RequestParam("preco")float preco) {
	Venda venda = new Venda(produto,preco);
		
		model.addAttribute(venda); 
		return "venda.jsp";
	}
	
	@GetMapping("calcularPrecoFinal/{taxaDeEntrega}")
	public String recebeDadosPorURLDinamica(Model model,@PathVariable("taxaDeEntrega")float taxa) {
		Venda venda = new Venda("Teclado",100.00f+taxa);
		
		model.addAttribute(venda); 
		return "venda.jsp";
	}
	
	@GetMapping("form-venda")
	public String cadastrarVenda() {
		
		return "cadastro-venda.jsp";
		
	}
	
	@PostMapping("processarVenda")
	public String aplicarDescontoVenda (Model model,Venda venda){
		
		venda.setValor(venda.getValor()-10);
		model.addAttribute("venda",venda);
		return "venda.jsp";	
	}
}
