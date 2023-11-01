package ifsul.pweb.CadastroDeAlunos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlunoController {

	@GetMapping("/calcular-media")
	public String calcularMedia(Model model, @RequestParam("nota1") float n1, @RequestParam("nota2") float n2) {

		float media = (n1 + n2) / 2;

		model.addAttribute("mediaCalculada", media);

		return "media.jsp";

	}

	@GetMapping("/validar-frequencia")
	public String validarFrequencia(Model model, @RequestParam("nome") String nome, @RequestParam("frequencia") int freq) {

		 String frase;
		if (freq>5)  frase = "reprovado(a) por frequência";
		else frase = "aprovado(a) por frequência.";
		model.addAttribute("nome", nome);
		model.addAttribute("frase",frase);
		model.addAttribute("freq",freq);
		

		return "resultado.jsp";

	}
}
