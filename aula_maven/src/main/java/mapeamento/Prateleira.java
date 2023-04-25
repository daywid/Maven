package mapeamento;

import java.util.ArrayList;

public class Prateleira {

	public ArrayList<Livro> Livros = new ArrayList<Livro>();
	
	public ArrayList<String> listar_titulos() {
		ArrayList<String> titulos = new ArrayList<String>();
		
		for(int i=0; i < this.Livros.size();i++) {
			titulos.add(this.Livros.get(i).titulo);
		}
		return titulos;
	}
}
