package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("dj@hotmail.com");
		pessoa1.setIdade(26);
		pessoa1.setNome("Djailson Silva");
		
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("fulano@hotmail.com");
		pessoa2.setIdade(67);
		pessoa2.setNome("Fulano Santos");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("furoasteca@hotmail.com");
		pessoa3.setIdade(45);
		pessoa3.setNome("Furosteca");
		
		/*pode vir do banco de dados ou qualquer fonte de dados*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		
		File arquivo = new File("C:\\Users\\Aluno\\Pictures\\eclipse\\arquivos\\src\\arquivos\\arquivo.txt");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
			
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + "; " +  p.getEmail() + "; " + p.getIdade() + "\n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
