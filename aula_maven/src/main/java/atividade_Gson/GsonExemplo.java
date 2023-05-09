package atividade_Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExemplo {

	public static void main(String[] args) {
		estudante Estudante = new estudante();
		String jsonEstudante = "{\"id\":"123\","nome\":"Pedro de lara\"}";
		System.out.println(jsonEstudante);
		
		//criar um construtor de Json
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();//construtor json
		
		//converter string sjon em objeto da classe estudante
		estudante Aluno = gson.fromJson(jsonEstudante,estudante.class);
		Aluno.imprime;
		
		//converter objeto aluno em string json
		Aluno.id = 888;
		Aluno.nome = "Araci"
		String alunojson = gson.toJson(Aluno);
		
	}

}
