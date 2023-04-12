package JDBC;

import java.util.ArrayList;

public class ListaDeArrays {
	
	public static void main(String[] args) {
		
		ArrayList<String> cores = new ArrayList<String>();
		cores.add("Branco");
		cores.add("Azul");
		cores.add("Preto");
		cores.add("Verde");
		cores.add("Vermelho");
		
		System.out.println("Todos os elementos: " + cores.toString()); //exibe todos os elementos do Array
		System.out.println("Tamanho do Array: " + cores.size()); //exibe o tamanho do Array
		System.out.println("Posição do Aarray: " + cores.get(2)); // exibe a posição 2 do Array
		System.out.println("Indice da cor Branco: " + cores.indexOf("Branco"));// exibe o indice da cor Branco
		
		cores.remove("Vermelho"); //remove Vermelho
 		System.out.println("Todos os elementos: " + cores.toString()); //exibe todos os elementos do Array menos o Vermelho
		System.out.println("Tem Azul? " + cores.contains("Azul"));// verifica se tem a cor Azul
		System.out.println("Tem Vermelho? " + cores.contains("Vermelho"));// verifica se tem a cor Vermelho
			
	}
	
	
	

}
