package atividade_Gson;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Conta_Corrente conta = new Conta_Corrente(1234, "corrente", 500.0);
        String contaJson = gson.toJson(conta);
        System.out.println(contaJson);

        Cliente cliente = new Cliente("123456789", "João da Silva", "joao.silva@example.com", conta);
        String clienteJson = gson.toJson(cliente);
        System.out.println(clienteJson);

        Banco banco = new Banco(1, "Meu Banco");
        banco.adicionarCliente(cliente);
        String bancoJson = gson.toJson(banco);
        System.out.println(bancoJson);
    }
}