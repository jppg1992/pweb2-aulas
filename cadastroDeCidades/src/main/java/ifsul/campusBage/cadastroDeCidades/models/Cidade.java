package ifsul.campusBage.cadastroDeCidades.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cidade implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
 
   @Column(nullable = false)
    private String nome;
 
   @Column(nullable = false)
    private String estado;
 
   public Cidade() {
   } 
 
   public Cidade(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }
 
   public String getNome() {
        return this.nome;
    }
    public String getEstado() {
        return this.estado;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
}