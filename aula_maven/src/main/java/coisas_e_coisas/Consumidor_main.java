package coisas_e_coisas;

import java.util.Date;

public class Consumidor_main {
    public static void main(String[] args) {
        // Criar instâncias dos objetos
        Cliente cliente = new Cliente( "João da Silva","rua almeida 399" ,"(11) 9999-8888","joao.silva@example.com" );
        Servicos servico = new Servicos("Reparos elétricos", "Realização de reparos em instalações elétricas residenciais e comerciais", 120.00);
        //PrestadorDeServicos prestador = new PrestadorDeServicos(5, "João da Silva", "(11) 9999-8888", "joao.silva@coisasecoisas.com");
        //Date dataAtendimento = new Date();
        //double valor = 100.00;

        // Salvar objetos no banco de dados
        cliente.save();
        servico.save();
        //prestador.save();

        // Criar serviço contratado
       // ServicoContratado servicoContratado = new ServicoContratado(5, dataAtendimento, cliente, servico, valor);
      //  servicoContratado.save();

        // Buscar um cliente pelo ID
        Cliente clienteEncontrado = Cliente.find_one(cliente.id);
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.nome);
        }
        
        // Deletar um cliente
       // if (clienteEncontrado != null && clienteEncontrado.delete()) {
       //     System.out.println("Cliente deletado com sucesso");
        //}
        
        Servicos servicoEncontrado = Servicos.find_one(servico.id);
        if (servicoEncontrado != null) {
        	System.out.println("serviço encontrado: " + servicoEncontrado.nome);
        }
        
        
        
        
        
        
        
        
        
        
    }
}

