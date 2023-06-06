package heranca;

import java.sql.Date;

public class TesteGerente {
    public static void main(String[] args) {
        // Criando um novo objeto de gerente com CPF, nome, email, salário, aniversário, telefone, departamento e gratificação
        Gerente gerente1 = new Gerente(123456789, "Fulano de Tal", "fulano@example.com", 5000.0,
                Date.valueOf("1990-01-01"), "123456789", "Departamento A", 1000.0);

        // Salvando o gerente no banco de dados
        gerente1.save();

        // Buscando um gerente pelo CPF
        Gerente gerenteEncontrado = Gerente.find_one(123456789);
        if (gerenteEncontrado != null) {
            System.out.println("Gerente encontrado: " + gerenteEncontrado.nome);
        } else {
            System.out.println("Gerente não encontrado.");
        }

        // Calculando o bônus do gerente
        double bonus = gerente1.calcular_bônus();
        System.out.println("Bônus do gerente: " + bonus);

        // Deletando o gerente
        boolean deletado = gerente1.delete();
        if (deletado) {
            System.out.println("Gerente deletado com sucesso.");
        } else {
            System.out.println("Erro ao deletar gerente.");
        }
    }
}
