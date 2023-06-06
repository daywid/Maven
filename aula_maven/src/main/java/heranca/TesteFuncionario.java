package heranca;

import java.sql.Date;

public class TesteFuncionario {
    public static void main(String[] args) {
        // Criando um novo objeto de funcionário com nome, email, salário, aniversário, telefone e departamento
        Funcionario funcionario1 = new Funcionario(123456789, "Fulano de Tal", "fulano@example.com", 5000.0,
                Date.valueOf("1990-01-01"), "123456789", "Departamento A");

        // Salvando o funcionário no banco de dados
        funcionario1.save();

        // Recuperando um funcionário do banco de dados pelo CPF
        Funcionario funcionario2 = Funcionario.find_one(123456789);
        if (funcionario2 != null) {
            System.out.println("Funcionário encontrado: " + funcionario2.nome);
        }

        // Atualizando o funcionário
        funcionario2.salario = 6000.0;
        funcionario2.save();

        // Deletando o funcionário do banco de dados
        boolean deleteSuccess = funcionario2.delete();
        if (deleteSuccess) {
            System.out.println("Funcionário deletado com sucesso");
        }
    }
}
