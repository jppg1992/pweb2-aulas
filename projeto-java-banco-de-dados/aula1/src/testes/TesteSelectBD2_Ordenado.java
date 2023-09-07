package testes;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import auxiliares.FabricaDeConexoesBD;

public class TesteSelectBD2_Ordenado {

	public static void main(String[] args) {
		Connection connection = new FabricaDeConexoesBD().obterConexao();
		try {

			String sql = "SELECT nome  from alunos ORDER BY nome ASC";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

			//pega o valor de cada coluna da linha corrente do cursor 
			String nome = resultSet.getString("nome"); 
			System.out.println("Nome: " + nome); 
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
