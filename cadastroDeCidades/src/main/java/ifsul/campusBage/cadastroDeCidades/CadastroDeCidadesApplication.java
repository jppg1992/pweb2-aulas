package ifsul.campusBage.cadastroDeCidades;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ifsul.campusBage.cadastroDeCidades.models.Cidade;
import ifsul.campusBage.cadastroDeCidades.repositories.CidadeRepository;

@SpringBootApplication
public class CadastroDeCidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeCidadesApplication.class, args);
	}

	/*@Bean
    public CommandLineRunner demo(CidadeRepository cidadeRepository) {
        return (args) -> {
            // Inserindo 3 cidades no banco de dados
            Cidade cidade1 = new Cidade("Bagé", "RS");
            Cidade cidade2 = new Cidade("Porto Alegre", "RS");
            Cidade cidade3 = new Cidade("Florianópolis", "SC");
            cidadeRepository.save(cidade1);
            cidadeRepository.save(cidade2);
            cidadeRepository.save(cidade3);
            System.out.println("Cidades inseridas no banco de dados!");
        };
    }*/
	
}
