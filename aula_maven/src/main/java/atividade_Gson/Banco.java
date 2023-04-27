package atividade_Gson;

import java.util.ArrayList;

public class Banco {

	   public int id;
    public String nome;
    public ArrayList<Cliente> clientes;
	
    public Banco(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.clientes = new ArrayList<Cliente>();
    }
    
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.nome());
        }
}
    }