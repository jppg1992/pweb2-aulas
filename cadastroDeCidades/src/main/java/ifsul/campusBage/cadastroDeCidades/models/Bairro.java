package ifsul.campusBage.cadastroDeCidades.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bairro {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id;
	 
	   @Column(nullable = false)
	    private String nome;
	 
	   @Column(nullable = true)
	    private int populacao;
	   
	   public Bairro() {
		   
	   }
	public Bairro(String nome, int populacao) {
		super();
		this.nome = nome;
		this.populacao = populacao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	
	
	
	

}
