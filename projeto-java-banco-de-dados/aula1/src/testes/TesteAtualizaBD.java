package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auxiliares.FabricaDeConexoesBD;

public class TesteAtualizaBD {
	public static void main(String[] args) {

		Connection connection = new FabricaDeConexoesBD().obterConexao();
		try {

			String sql = "UPDATE alunos set nome = ? WHERE id = ?";

			PreparedStatement preparedStatement =

					connection.prepareStatement(sql);

			preparedStatement.setString(1, "João2 ATUALIZADO CONEXAO FABRICA no pacote aux");
			preparedStatement.setInt(2, 7);
			// executa a query
			int saida = preparedStatement.executeUpdate();
			System.out.println("dado atualizado no banco");
			System.out.println("retorno do SGDB  "+saida);
			
			// feche a instrução preparada e a conexão após a conclusão
			preparedStatement.close();

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