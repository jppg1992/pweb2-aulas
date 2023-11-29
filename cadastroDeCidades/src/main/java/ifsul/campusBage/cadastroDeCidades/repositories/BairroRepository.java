package ifsul.campusBage.cadastroDeCidades.repositories;

import java.util.List; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ifsul.campusBage.cadastroDeCidades.models.Bairro;
import ifsul.campusBage.cadastroDeCidades.models.BairroProcejao; 

public interface BairroRepository extends CrudRepository<Bairro, Long> {
    
	   @Query(value = "SELECT * FROM public.bairro  ", nativeQuery = true)	
	   List<Bairro> listarTodos();
	 
	   @Query(value = "SELECT * FROM public.bairro ORDER BY populacao DESC LIMIT 5", nativeQuery = true)	
	   List<Bairro> listarBairrosPopulosos();
	

	 
	   @Query(value = "SELECT * FROM public.bairro WHERE nome = :nome ORDER BY nome DESC Limit 1", nativeQuery = true)
	   Bairro consultarPorNome(@Param("nome") String valor);
	   
	   
	   @Query(value = " SELECT estado, count(*) as qtd_cidades FROM public.cidade GROUP BY estado HAVING count(*) >= :qtdMinBairros", nativeQuery = true)	
	   List<BairroProcejao> countCidadesByEstadoHaving(@Param("qtdMinBairros") int qtdMinBairros);
}


