package ifsul.campusBage.cadastroDeCidades.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ifsul.campusBage.cadastroDeCidades.models.Bairro;
import ifsul.campusBage.cadastroDeCidades.models.BairroProcejao;
import ifsul.campusBage.cadastroDeCidades.models.Cidade;
import ifsul.campusBage.cadastroDeCidades.repositories.BairroRepository;

@Controller
public class BairroController {
	@Autowired // instancia e injeta neste atributo um objeto CidadeRepository
	BairroRepository bairroRepository;

	@GetMapping("/cadastrarBairro")
	public String exibirFormCadastrarBairro(Model model) {

		Bairro bairroAux = new Bairro("", 0);
		model.addAttribute("umBairro", bairroAux);

		return "form-cadastro-bairro.jsp";
	}

	@PostMapping("/inserirBairro")
	public String inserirBairro(Model model, Bairro bairro) {

		bairroRepository.save(bairro);

		model.addAttribute("mensagem", "Bairro cadastrado com sucesso");

		return "form-cadastro-bairro.jsp";
	}

	@GetMapping("/listarTodosBairros")
	public String buscarTodosBairros(Model model) {

		List<Bairro> listaDeBairros = (List<Bairro>) bairroRepository.findAll();

		model.addAttribute("listaBairros", listaDeBairros);

		return "lista-de-bairros.jsp";
	}

	@GetMapping("/bairrosPopulosos")
	public String buscarBairrosPopulosos(Model model) {

		List<Bairro> listaDeBairros = (List<Bairro>) bairroRepository.listarBairrosPopulosos();

		model.addAttribute("listaBairros", listaDeBairros);

		return "lista-de-bairros.jsp";
	}

	@GetMapping("/excluirBairro")
	public String telaExcluirBairro(Model model, @RequestParam("id") Long id) {

		Optional<Bairro> bairroOpt = bairroRepository.findById(id);
		if (bairroOpt.get() != null) {
			Bairro bairrro = bairroOpt.get();
			model.addAttribute("bairro", bairrro);

		} else {
			model.addAttribute("mensagem,", "Bairro não encontrado");
		}

		return "tela-exclusao-bairro.jsp";
	}

	@GetMapping("/excluirBairroBD")
	public String excluirBairro(Model model, @RequestParam("id") Long id) {
		System.out.println(id);
		Optional<Bairro> bairroOpt = bairroRepository.findById(id);
		if (bairroOpt.get() != null) {
			Bairro bairrro = bairroOpt.get();
			bairroRepository.delete(bairrro);
			model.addAttribute("mensagem", "Bairro excluido com sucesso");
		}
		List<Bairro> listaDeBairros = (List<Bairro>) bairroRepository.findAll();
		model.addAttribute("listaBairros", listaDeBairros);
		return "lista-de-bairros.jsp";
	}

	@GetMapping("/consultar")
	public String telaConsultarBairro(Model model, @RequestParam("id") Long id) {

		Optional<Bairro> bairroOpt = bairroRepository.findById(id);
		if (bairroOpt.get() != null) {
			Bairro bairrro = bairroOpt.get();
			model.addAttribute("bairro", bairrro);

		} else {
			model.addAttribute("mensagem,", "Bairro não encontrado");
		}

		return "tela-visualiza-bairro.jsp";
	}

	@GetMapping("/consultaDireta")
	public String consultaDireta() {

		return "tela-consulta-bairro.jsp";
	}

	@PostMapping("/consultaPorNome")
	public String consultarPorNome(Model model, String nome) {

		Bairro bairro = bairroRepository.consultarPorNome(nome);
		System.out.println(bairro);
		if (bairro != null) {
			model.addAttribute("bairro", bairro);

			return "tela-visualiza-bairro.jsp";
		}else {
			model.addAttribute("mensagem", "Bairro não encontrado") ;

			return "tela-consulta-bairro.jsp";
		}
	}
	
	@GetMapping("/relatorio")
	public String relatorio() {
		
		
		return "tela-filtro-relatorio.jsp";
	}
	
	@PostMapping("/relatorioCidades")
	public String buscarCidades(Model model, int quantidade) {
		
		List<BairroProcejao> cidades = bairroRepository.countCidadesByEstadoHaving(quantidade);
		
		model.addAttribute("cidades", cidades);
		
		return "relatorio-de-cidades.jsp";
	}

}
