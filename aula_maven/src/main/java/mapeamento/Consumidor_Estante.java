package mapeamento;

public class Consumidor_Estante {

	public static void main(String[] args) {
		Livro livro = new Livro();
		Prateleira prateleira = new Prateleira();
		Estante estante = new Estante();
		
		//Criar 2 livros e adicionar a prateleira
		livro.autor = "Graciliano Ramos";
		livro.titulo = "Vidas Secas";
		livro.edicao = "2a. Edição";
		prateleira.Livros.add(livro);
		
		//Criar um novo objeto livro
		livro = new Livro();
		livro.autor = "Jorge Amado";
		livro.titulo = "Capitães da Areia";
		livro.edicao = "3a. Edição";
		prateleira.Livros.add(livro);
		
		estante.prateleiras.add(prateleira);
		
		System.out.println("Qtd de livros:" + prateleira.Livros.size());
		System.out.println(prateleira.listar_titulos());
		
		/*System.out.println(prateleira.Livros.size());
		
		for (int i=0;i<prateleira.Livros.size();i++) {
			System.out.println(prateleira.Livros.get(i));
			
		}
		
	}*/
		
		System.out.println("Numero de prateleiras na estante:" + estante.prateleiras.size());
		System.out.println("Numero de livros na 1a. prateleira:" + prateleira.Livros.size());
		
		//navegar em todas as prateleiras da estante e imprimir os titulos de todos os livros
		for (int j=0;j<=estante.prateleiras.size();j++) {
			
			System.out.println("Prateleira "+j + ":");
			//navegar na prateleira
			for (int i=0;i<estante.prateleiras.get(j).Livros.size();i++) {
				
			}
			
		}
}
	}
