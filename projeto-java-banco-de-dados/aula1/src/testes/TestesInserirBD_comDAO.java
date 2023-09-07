package testes;

import DAO.AlunoDAO;
import modelo.Aluno;

public class TestesInserirBD_comDAO {
	public static void main(String[] args) {
		Aluno umAluno = new Aluno();
		umAluno.setNome("Carlos");
		umAluno.setIdade(23);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.adiciona(umAluno);
		System.out.println("aluno(a) inserido(a) no banco de dados");
	}
}