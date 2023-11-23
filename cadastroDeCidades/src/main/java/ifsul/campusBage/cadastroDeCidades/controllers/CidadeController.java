package ifsul.campusBage.cadastroDeCidades.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import ifsul.campusBage.cadastroDeCidades.models.Cidade;
import ifsul.campusBage.cadastroDeCidades.repositories.CidadeRepository;

@Controller
public class CidadeController {

	@Autowired   //instancia e injeta neste atributo um objeto CidadeRepository
	CidadeRepository cidadeRepository;

	
	@GetMapping("/formCidade")
	public String exibirFormCadastrarCidade(Model model) {
		
		Cidade cidadeAux = new Cidade();
		cidadeAux.setNome("digite aqui");
		cidadeAux.setEstado("");
		
		model.addAttribute("umaCidade", cidadeAux);
		
		return "form-cadastro-cidade.jsp";
	}
	
	@PostMapping("/cadastrarCidade")
	public String inserirCidadeNoBD(Model model, Cidade cidade) {

		//se o método recebe uma classe model como argumento,
		//o framework Spring cria automaticamente um objeto cidade 
		//com os dados recebidos do formulário de cadastro de cidade (se os campos e atributos têm mesmo nome) 
		
		//salva no banco de dados a cidade
		cidadeRepository.save(cidade);
		
		model.addAttribute("mensagem", "Cidade cadastrada com sucesso");
		
		return "form-cadastro-cidade.jsp";
	}	
	
	@GetMapping("/listarCidades")
	public String buscarTodasCidades(Model model) {
		
		List<Cidade> listaDeCidades = (List<Cidade>) cidadeRepository.findAll();
		
		model.addAttribute("listaCids", listaDeCidades);
		
		return "lista-de-cidades.jsp";
	}
}
