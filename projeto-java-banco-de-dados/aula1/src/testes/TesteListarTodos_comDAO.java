package testes;

import DAO.AlunoDAO;

public class TesteListarTodos_comDAO {

	public static void main(String[] args) {
		
		AlunoDAO alunoDAO = new AlunoDAO();
		
		System.out.println(alunoDAO.listarTodos());
	}

}
