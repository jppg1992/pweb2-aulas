package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auxiliares.FabricaDeConexoesBD;

public class TesteExcluirBD {
	public static void main(String[] args) {
		Connection connection = new FabricaDeConexoesBD().obterConexao(); 
		try {
			
			String sql = "DELETE FROM alunos WHERE id = ?";

			PreparedStatement preparedStatement =

					connection.prepareStatement(sql);
 
			preparedStatement.setInt(1, 1);
			// executa a query
			preparedStatement.executeUpdate();
			System.out.println("dado excluido no banco");
			// feche a instrução preparada e a conexão após a conclusão
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}