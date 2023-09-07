package modelo;

public class Disciplina {
	
	private int id;
	private String nome;
	private int cargaHoraria;
	private boolean ativa;
	// um construtor sem argumentos
	public Disciplina() {
	}
	// métodos de acesso do tipo get e set para cada um dos métodos
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getNome() {
	return nome;
	}
	public void setNome(String nome) {
	this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
 

}
