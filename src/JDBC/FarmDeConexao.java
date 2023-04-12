package JDBC;                     // //CRUD Padrão MVC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FarmDeConexao {

	public static Connection getConnection() {

		try {

			// Variável da URL para conexão com o banco
			final String url = "jdbc:postgresql://localhost:5432/postgres";
			
			// Variável do usuário do banco
			final String usuario = "postgres";
			
			// Variável da senha do banco
			final String senha = "123";

			return DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

}
