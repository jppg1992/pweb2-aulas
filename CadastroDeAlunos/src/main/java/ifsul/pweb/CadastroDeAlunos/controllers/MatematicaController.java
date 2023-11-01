package ifsul.pweb.CadastroDeAlunos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MatematicaController {

	@GetMapping("mostrar-maior")
	public String mostrarMaior(Model model, @RequestParam("n1") float n1, @RequestParam("n2") float n2) {
		
		model.addAttribute("maior",(n1>n2)?n1:n2);
		return "maior.jsp";
	}
	
	@GetMapping("mostrar-tabuada")
	public String mostrarTabuada(Model model, @RequestParam("n1") int n1) {
		
		int[] nros = {1,2,3,4,5,6,7,8,9,10};
		model.addAttribute("n1",n1);
		
		model.addAttribute("numeros",nros);
		return "tabuada.jsp";
	}
	
	@GetMapping("mostrar-pessoas")
	public String mostrarPessoas(Model model, @RequestParam("p1") String[] p1) {
		
		model.addAttribute("pessoas",p1);
		
 
		return "pessoas.jsp";
	}
	
	
}
