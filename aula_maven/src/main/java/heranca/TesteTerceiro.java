package heranca;

public class TesteTerceiro {
    
    public static void main(String[] args) {
      // Criando um novo objeto de terceiro com nome e email
      Terceiro terceiro1 = new Terceiro(123456789, "Fulano de Tal", "fulano@example.com", true, true);
    
      // Salvando o terceiro no banco de dados
      terceiro1.save();

      // Recuperando um terceiro do banco de dados pelo CPF
      Terceiro terceiro2 = Terceiro.find_one(123456789);
      if (terceiro2 != null) {
          System.out.println("Terceiro encontrado: " + terceiro2.nome);

          // Inativando o terceiro
          terceiro2.inativar();

          // Atualizando o terceiro no banco de dados
          terceiro2.save();
      } else {
          System.out.println("Terceiro não encontrado.");
      }
    }
}
