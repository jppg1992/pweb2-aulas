package ifsul.pweb.CadastroDeAlunos.models;

public class Funcionario {
	private String nome;
	private int numeroSala;
	private float salario;
	
	public Funcionario(String nome, int numeroSala, float salario) {
		super();
		this.nome = nome;
		this.numeroSala = numeroSala;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	
	
}
