package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirPessoa {
	
	public static void main(String[] args) throws SQLException{
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o nome:");
		String nome = entrada.nextLine();
		
		Connection conexao = FarmDeConexao.getConnection();
		
		String sql = "Insert Into pessoas (nome) Values (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		System.out.println("Nome inserido com sucesso!");
		
		stmt.setString(1, nome);
		//stmt.setInt(2, 100);
		
		stmt.execute();
				
		entrada.close();
		
	}

}
