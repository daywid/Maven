package aula_maven;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class Cliente {
	public String cpf = "";
	public String nome = "";
	public String email = "";
	
	public String gerar_json() {
		//converte o objeto em json para enviar via internet.
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(this);
	}
}
