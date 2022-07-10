package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {
	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("82782383729237");
		usuario1.setLogin("dj");
		usuario1.setSenha("2365");
		usuario1.setNome("djailson Silva");
		
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("98234984238844");
		usuario2.setLogin("mary");
		usuario2.setSenha("8278");
		usuario2.setNome("maria Jane");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Aluno\\git\\repository12\\arquivos\\src\\arquivos\\filjson.json");/*PARA ESCREVER*/
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		/*-------------LENDO O ARQUIVO JSON---------------*/
		
		FileReader fileReader = new FileReader("C:\\\\Users\\\\Aluno\\\\git\\\\repository12\\\\arquivos\\\\src\\\\arquivos\\\\filjson.json");
		
		JsonArray jsonArray =  (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuario);
			
		}
		System.out.println("Leitura do arquivo JSON: " + listUsuarios);
		
	}

}
