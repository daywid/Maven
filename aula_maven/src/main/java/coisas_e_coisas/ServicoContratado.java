package coisas_e_coisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ServicoContratado {

    public int id;
    public Date data_atendimento;
    public Cliente cliente;
    public Servicos servico;
    public double valor;

    public ServicoContratado(Date data_atendimento, Cliente cliente, Servicos servico, double valor) {
        this.data_atendimento = data_atendimento;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
    }

    public static ServicoContratado find_one(int id) {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
            String sql = "SELECT sc.*, c.id as id_cliente, c.nome as cliente_nome,  c.endereco as cliente_endereco, c.telefone as cliente_telefone, c.email as cliente_email, s.nome as servico_nome, s.valor as servico_valor FROM servicos_contratados sc INNER JOIN clientes c ON sc.id_cliente = c.id INNER JOIN servicos s ON sc.id_servico = s.id WHERE sc.id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("cliente_nome"), rs.getString("cliente_endereco"), rs.getString("cliente_telefone"), rs.getString("cliente_email"));
                Servicos servico = new Servicos(rs.getString("servico_nome"), "", rs.getDouble("servico_valor"));
                return new ServicoContratado(
                    rs.getDate("data_atendimento"),
                    cliente,
                    servico,
                    rs.getDouble("valor")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar serviço contratado: " + e.getMessage());
        }
        return null;
    }


    public void save() {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
            if (this.id == 0) {
                // Inserir novo serviço contratado
                String sql = "INSERT INTO servicos_contratados (data_atendimento, cliente_id, servico_id, valor) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
                ps.setDate(1, new java.sql.Date(this.data_atendimento.getTime()));
                ps.setInt(2, this.cliente.id);
                ps.setInt(3, this.servico.id);
                ps.setDouble(4, this.valor);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
    
                // Obter o ID gerado automaticamente pelo banco de dados
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.id = rs.getInt(1);
                }
            } else {
                // Atualizar serviço contratado existente
                String sql = "UPDATE servicos_contratados SET data_atendimento = ?, cliente_id = ?, servico_id = ?, valor = ? WHERE id = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setDate(1, new java.sql.Date(this.data_atendimento.getTime()));
                ps.setInt(2, this.cliente.id);
                ps.setInt(3, this.servico.id);
                ps.setDouble(4, this.valor);
                ps.setInt(5, this.id);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar serviço contratado: " + e.getMessage());
        }
    }
    
    public void delete() {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
            String sql = "DELETE FROM servicos_contratados WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, this.id);
            int retorno = ps.executeUpdate();
            System.out.println(retorno);
        } catch (SQLException e) {
            System.out.println("Erro ao excluir serviço contratado: " + e.getMessage());
        }
    }
}    