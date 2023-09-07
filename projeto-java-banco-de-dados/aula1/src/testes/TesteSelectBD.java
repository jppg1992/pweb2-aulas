package testes;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import auxiliares.FabricaDeConexoesBD;

public class TesteSelectBD {

	public static void main(String[] args) {
		Connection connection = new FabricaDeConexoesBD().obterConexao();
		try {

			String sql = "SELECT id,nome,idade from alunos WHERE idade < 34";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

			//pega o valor de cada coluna da linha corrente do cursor
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			int idade = resultSet.getInt("idade");
			System.out.println("ID: " + id);
			System.out.println("Nome: " + nome);
			System.out.println("Idade: " + idade);
			System.out.println("------");
			}

			resultSet.close();
			statement.close(); 
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
