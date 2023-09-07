package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 

import auxiliares.FabricaDeConexoesBD;
import modelo.Aluno;

public class AlunoDAO {
// a conexão com o banco de dados
	private Connection connection;

	public AlunoDAO() {
		this.connection = new FabricaDeConexoesBD().obterConexao();
	}
	
	public void adiciona(Aluno aluno) {
		String sql = "INSERT INTO alunos (nome, idade) VALUES (?,?)";
		try {
// objeto PreparedStatement para inserção com parâmetros
			PreparedStatement stmt = connection.prepareStatement(sql);
// seta os valores dos parâmetros
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
// executa a query
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Aluno consultarPorID(int idAlunoBuscado) {
		try {
			String sql = "SELECT id, nome, idade FROM alunos WHERE id = ?";
			// objeto PreparedStatement para consulta com parâmetros
			PreparedStatement prepStmt = connection.prepareStatement(sql);
			// seta o valor do parâmetro com o valor recebido do método
			prepStmt.setInt(1, idAlunoBuscado);
			// executa a query
			ResultSet resultSet = prepStmt.executeQuery();
			Aluno alunoBD = new Aluno();
			while (resultSet.next()) {
				// pega o valor de cada coluna da linha corrente do cursor
				int idBD = resultSet.getInt("id");
				String nomeBD = resultSet.getString("nome");
				int idadeBD = resultSet.getInt("idade");
				alunoBD.setId(idBD);
				alunoBD.setNome(nomeBD);
				alunoBD.setIdade(idadeBD);
			}
			prepStmt.close();
			resultSet.close();
			return alunoBD;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean excluir(Aluno aluno) {
		 	try {

			String sql = "DELETE FROM alunos WHERE id = ?";

			PreparedStatement preparedStatement =

					connection.prepareStatement(sql);

			preparedStatement.setInt(1, aluno.getId());
			// executa a query
			if (aluno.getId() > 0) {
				preparedStatement.executeUpdate();
				System.out.println("dado excluido no banco");
			} else {
				System.out.println("Nenhum dado excluido no banco, pois o aluno informado não tem um id válido");
			}

			// feche a instrução preparada e a conexão após a conclusão
			preparedStatement.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

	public ArrayList<Aluno> listarTodos() {

		// abrindo a conexão
		Connection connection = new FabricaDeConexoesBD().obterConexao();
		try {
			ArrayList<Aluno> alunos = new ArrayList<Aluno>();
			String sql = "SELECT id,nome,idade from alunos WHERE idade < 34";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Aluno aluno = new Aluno();
				// pega o valor de cada coluna da linha corrente do cursor
				aluno.setId( resultSet.getInt("id"));
				aluno.setNome( resultSet.getString("nome"));
				aluno.setIdade( resultSet.getInt("idade"));
			
				alunos.add(aluno);
			}

			
			resultSet.close();
			statement.close();
			return alunos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		} finally {
			try {
				//fechando aconexão
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	 
	public void close() throws SQLException {
		if (!this.connection.isClosed()) {
		this.connection.close();
		}
	} 
}