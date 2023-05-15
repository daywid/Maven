package test;

public class consumidor_jogador {

	public static void main(String[] args) {
		jogador j = jogador.getInstance();
		j.id = 1;
		j.nome = "Purga";
		
		System.out.println("nome do jogador 1:" + j.nome);
	
		jogador j2 = jogador.getInstance();
		System.out.println("nome do jogador 2:" +j2.nome);
		
		jogador j3 = jogador.getInstance();
		System.out.println(j3.id + " " + j3.nome);
		
		
		
		
	}

}
