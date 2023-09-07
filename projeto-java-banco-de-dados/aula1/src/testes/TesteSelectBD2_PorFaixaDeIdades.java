package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.Scanner;

import auxiliares.FabricaDeConexoesBD;

public class TesteSelectBD2_PorFaixaDeIdades {

	public static void main(String[] args) {
		Connection connection = new FabricaDeConexoesBD().obterConexao();
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Digite a idade mínima: ");
			int idadeMinima = scanner.nextInt();
			System.out.print("Digite a idade máxima: ");
			int idadeMaxima = scanner.nextInt();
			scanner.close();

			String sql = "SELECT id,nome,idade from alunos WHERE idade between ? and ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,idadeMinima);
			preparedStatement.setInt(2, idadeMaxima);
			ResultSet resultSet = preparedStatement.executeQuery();

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
