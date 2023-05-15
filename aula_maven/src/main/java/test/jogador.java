package test;

public class jogador {

	public int id;
	public String nome;
	static jogador instance;
	//passo 1: o construtor padrão dever ser inacessível pelos consumidores
	private jogador() {
		
	}
	
	static jogador getInstance() {
		if(instance == null) {
		instance = new jogador();//constrói um objeto do tipo jogador.
		}
		return instance;
	}
	
	
	
	
	
	
}
