package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TesteConexao {
	public static void main(String[] args) throws SQLException{
		
		// Variável da URL para conexão com o banco
		final String url = "jdbc:postgresql://localhost:5432/postgres";
		
		// Variável do usuário do banco
		final String usuario = "postgres";
		
		// Variável da senha do banco
		final String senha = "123";
		
		// O método getConnection 
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		System.out.println("Conexão efetuada com sucesso!");
		
		JOptionPane.showMessageDialog(null, "Conexao realizada com sucesso!");
		
		conexao.close();
		
		
		
	}

}
