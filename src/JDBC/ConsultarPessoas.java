package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas {
	
	public static void main(String[] args) throws SQLException{
		 
		//Para consultar algo, inicialmente é preciso  ter uma conexão:
		Connection conexao = FarmDeConexao.getConnection();
		
		//Comendo SQL a ser executado
		String sql = "Select * from pessoas order by codigo";
		
		// Cria a declaração para receber um resultado do sql
		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		
		
		//Cria uma lista de pessoas para armazenar os dados vindo do banco
		List<Pessoa> pessoas = new ArrayList<>();
		
		// Percorre todas as linhas do ResultSet
		while (resultado.next()) {
			//Pega o resultado do codigo e nome
			int codigo  = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			
			//cria uma pessoa
			pessoas.add(new Pessoa(codigo, nome));
			
		}
		// para exibir na tela as pessoas que vieram no select executado
		for (Pessoa p: pessoas) {
			System.out.println(p.getCodigo()+" ---> "+p.getNome());
		}
		stmt.close();
		conexao.close();
	}

}
