package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
	
	public static void main(String[] args) throws SQLException{
		
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Informe o código a ser excluido: ");
		int codigo = entrada.nextInt();
		
		Connection conexao = FarmDeConexao.getConnection();
		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);
		
		//Utilizando o IF para confirmar se realmente alguma linha sofreu algum impacto durante o processo de exclusão
		//O "stmt.executeUpdate()" verifica a quantidade de linhas que foram excluidas
		if (stmt.executeUpdate() > 0 ){
			//mensagem de sucesso na operação de exclusão da pessoa
			System.out.println("Pessoa exluida com sucesso!");
		
		}else {
			// caso não tenha a pessoa a ser excluida ou o código não existe na base, irá retornar a seguinte mensagem:
			System.out.println("Pessoa não excluída: código de pessoa não existente na base");
		}
		
		//fecha a conexão com o banco
		conexao.close();
		//fecha o scanner
		entrada.close();
		//fecha o PreparedStatement
		stmt.close();
		
		
		
	}

}
