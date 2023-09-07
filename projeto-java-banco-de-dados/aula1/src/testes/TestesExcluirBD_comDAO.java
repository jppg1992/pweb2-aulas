package testes;

import DAO.AlunoDAO;
import modelo.Aluno;

public class TestesExcluirBD_comDAO {
	public static void main(String[] args) {
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno umAlunoBD = alunoDAO.consultarPorID(7);
		if (alunoDAO.excluir(umAlunoBD)) {
		System.out.println("Comando de exclusão executado sem erros.");
		}
		else {
			System.out.println("erro ao excluir aluno, verifique os logs;");
				
		}
	}
}