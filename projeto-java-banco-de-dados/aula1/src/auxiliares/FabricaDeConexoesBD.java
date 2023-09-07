package auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoesBD {
	public Connection obterConexao() {
		try {

			String jdbcUrl = "jdbc:postgresql://localhost:5432/ifsul";
			String usuario = "postgres";
			String senha = "postgres";
			Connection connection = DriverManager.getConnection(jdbcUrl, usuario, senha);
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void droparConnection(Connection connection) {

		try {
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

}