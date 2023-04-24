package aula_maven;

public class Teste_gson2 {
    public static void main(String[] args) {
        Cliente cli = new Cliente(); // corrigido para Cliente
        cli.cpf = "888";
        cli.nome = "Pedro de lara"; // corrigido para nome
        cli.email = "email";
        
        String jsonString = cli.gerar_json();
        System.out.println(jsonString);
    }
}