package test;

public class jogador {

	public int id;
	public String nome;
	//passo 1: o construtor padrão dever ser inacessível pelos consumidores
	private jogador() {
		
	}
	
	public jogador getInstance() {
		jogador j = new jogador();//constrói um objeto do tipo jogador.
		return j;
	}
}
