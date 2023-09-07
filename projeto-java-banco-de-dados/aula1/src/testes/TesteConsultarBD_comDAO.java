package testes;

import DAO.AlunoDAO;
import modelo.Aluno;

public class TesteConsultarBD_comDAO {

	public static void main(String[] args) {
		 
		AlunoDAO alunoDAO = new AlunoDAO();
		try {
		Aluno umAluno  = alunoDAO.consultarPorID(5);
		System.out.println("aluno(a) "+ umAluno.getNome()+" tem "+ umAluno.getIdade()+ " anos de idade.");
		}finally {
			try {
			alunoDAO.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
