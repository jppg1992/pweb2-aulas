package modelo;

public class Aluno {

	private int id;
	private String nome;
	private int idade;
	// um construtor sem argumentos
	public Aluno() {
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
	public int getIdade() {
	return idade;
	}
	public void setIdade(int idade) {
	this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " Idade:" + this.idade ; 
	}

}
