package arquivos;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class EscreveJSON {
	public static void main(String[] args) {
		
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
		
		String jsonUser = new Gson().toJson(usuarios);
		
		System.out.println(jsonUser);
	}

}
