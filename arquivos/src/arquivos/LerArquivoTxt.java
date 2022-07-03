package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\Users\\Aluno\\git\\repository12\\arquivos\\src\\arquivos\\arquivo.txt"));
		
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(lerArquivo.hasNext()) {/*enquanto tiver dados nesse arquivo*/
			
			
			String linha = lerArquivo.nextLine();/*minha linha*/
			
			if(linha != null && !linha.isEmpty()) {/*se a linha for válida*/
			
			String[]dados = linha.split("\\;");/*quebra essa linha separando os dados*/
			/*cada linha depois de instanciada é um novo objeto*/
			Pessoa pessoa = new Pessoa();
			pessoa.setEmail(dados[0]);
			pessoa.setNome(dados[1]);
			pessoa.setIdade(Integer.parseInt(dados[2]));
			/*setando as posições na lista*/
			pessoas.add(pessoa);
			/*adicionando na lista*/
				
			}
			
			
		}
		
		System.out.println(pessoas);/*chamando a lista de pessoas*/
		
	}

}
