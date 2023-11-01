package ifsul.pweb.CadastroDeAlunos.controllers; 

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ifsul.pweb.CadastroDeAlunos.models.Funcionario;

@Controller
public class FuncionarioEscolaController {

	@GetMapping("/listar-funcionarios")
	public String gerarListaFuncionarios(Model model) {

		 List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		 Funcionario f1 = new Funcionario("Aline Santos",205,2000.00f);
		 Funcionario f2 = new Funcionario("Paulo Vieira",306,4000.00f);
		 Funcionario f3 = new Funcionario("Bianca Gomes",205,2500.00f);
		 Funcionario f4 = new Funcionario("Luís Santana",112,2000.00f);
		 Funcionario f5 = new Funcionario("Vitor Brito",307,4000.00f);
		 funcionarios.add(f1);
		 funcionarios.add(f2);
		 funcionarios.add(f3);
		 funcionarios.add(f4);
		 funcionarios.add(f5);
		 
		 model.addAttribute("funcionarios", funcionarios); 
			

		 
		return "funcionarios.jsp";

	}

}
