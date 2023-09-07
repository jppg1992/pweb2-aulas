package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auxiliares.FabricaDeConexoesBD;

public class TesteInserirBD {
	public static void main(String[] args) {
		Connection connection = new FabricaDeConexoesBD().obterConexao();
		try {
			
			String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";

			PreparedStatement preparedStatement =

					connection.prepareStatement(sql);

			preparedStatement.setString(1, "João4");
			preparedStatement.setInt(2, 33);
			// executa a query
			preparedStatement.executeUpdate();
			System.out.println("dado inserido no banco");
			// feche a instrução preparada e a conexão após a conclusão
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}