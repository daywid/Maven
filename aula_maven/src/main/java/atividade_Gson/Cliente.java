package atividade_Gson;

public class Cliente {

	public String cpf;
	public String nome; 
	public String email;
	public Conta_Corrente conta;
	
	public Cliente(String cpf, String nome, String email, Conta_Corrente conta) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.conta = conta;
    }

	public String nome() {
		return this.nome;
	}
}