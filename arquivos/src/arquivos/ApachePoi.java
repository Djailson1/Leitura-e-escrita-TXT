package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Aluno\\git\\repository12\\arquivos\\src\\arquivos\\arquivo_excel.xls");
		
		if(file.exists()) {
			file.createNewFile();
			
		}
		
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
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("blindao@hotmail.com");
		pessoa4.setIdade(55);
		pessoa4.setNome("Blindão");
		
		/*pode vir do banco de dados ou qualquer fonte de dados*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /*vai ser usado para escrever a planilha*/
		
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev Treinamento");/*criar a planilha*/
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
		
			Row linha = linhasPessoa.createRow(numeroLinha++);/*criando a linha na planlha*/
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++);/*celula 1*/
			celNome.setCellValue(p.getNome());

			Cell celEmail = linha.createCell(celula++);/*celula 2*/
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++);/*celula 3*/
			celIdade.setCellValue(p.getIdade());
			
			
		}/*terminou de montar a planilha*/
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);/*escreve planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
	}

}
