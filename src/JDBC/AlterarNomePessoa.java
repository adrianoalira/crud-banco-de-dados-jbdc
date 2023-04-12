package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {
	
	public static void main(String[] args) throws SQLException {
		// declaração do Scanner
		Scanner entrada = new Scanner(System.in);

		// Para atualizar algo, inicialmente é preciso ter uma conexão
		
		// Abertura de conexão com o banco de dados
		Connection conexao = FarmDeConexao.getConnection();

		// Mensagem que aparecerá para que o usuário informe o valor da pesquisa
		System.out.println("Informe o código da pessoa: ");
		int codigo = entrada.nextInt();

		// Comando sql a ser execudato
		String sql1 = "Select codigo, nome from pessoas where codigo = ?";

		// Cria a preparação da declaração para receber um resultado sql
		PreparedStatement stmt = conexao.prepareStatement(sql1);
		stmt.setInt(1, codigo);// é nesse código que o valor do código substitui o "?"
		ResultSet resultado = stmt.executeQuery(); // não passar nessa parte o comando sql

		// Feito um IF para verificar se teve algum resultado através do
		// "resultado.next()
		if (resultado.next()) {

			// Cria uma nova pessoa setando a coluna 1 e coluna 2, conforme o select acima
			Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));

			// Exibe o nome atual
			System.out.println("Nome atual é: " + p.getNome());
			entrada.nextLine();

			// Exibe uma mensagem pedindo para o usuário digitar o novo nome
			System.out.println("Informe o novo nome: ");
			String novoNome = entrada.nextLine();

			String sql2 = "Update pessoas" 
						+ "set nome = ? " 
						+ "here codigo = ?";

			stmt.close();

			// Abre uma nova conexao para pegar o novo sql (update)
			stmt = conexao.prepareStatement(sql2);
			// Pega como parametro 1 o novoNome indicado e capturado pelo Scanner
			stmt.setString(1, novoNome);
			// Recupera o código que foi digitado pela pessoa no primeiro Scanner
			stmt.setInt(2, codigo);
			// Executa a operação utilizada somente o execute pois não vai pegar o resultado
			// de uma query
			// Vai rodar diretamente o update
			stmt.execute();

			System.out.println("Pessoa alterada com sucesso!");
		}

		// Fecha o Statement
		stmt.close();
		// Fecha a conexão
		conexao.close();
		// Fecha o scaner
		entrada.close();
	}

}
