package coisas_e_coisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Servicos {
    
    public int id;
    public String nome;
    public String descricao;
    public double valor;
 
    public Servicos(int id, String nome, String descricao, double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static Servicos find_one(int id) {
        try (Connection conexao = ConexaoMySQL.getConnection()) {
            String sql = "SELECT * FROM servicos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Servicos(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("valor")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar serviço: " + e.getMessage());
        }
        return null;
    }

    public void save() {
        try (Connection conexao = ConexaoMySQL.getConnection()) {
            if (this.id == 0) {
                // Inserir novo serviço
                String sql = "INSERT INTO servicos (nome, descricao, valor) VALUES (?, ?, ?)";
                PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setString(1, this.nome);
                ps.setString(2, this.descricao);
                ps.setDouble(3, this.valor);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);

                // Obter o ID gerado automaticamente pelo banco de dados
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.id = rs.getInt(1);
                }
            } else {
                // Atualizar serviço existente
                String sql = "UPDATE servicos SET nome = ?, descricao = ?, valor = ? WHERE id = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, this.nome);
                ps.setString(2, this.descricao);
                ps.setDouble(3, this.valor);
                ps.setInt(4, this.id);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar serviço: " + e.getMessage());
        }
    }
    
    public boolean delete() {
        try (Connection conexao = ConexaoMySQL.getConnection()) {
            String sql = "DELETE FROM servicos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, this.id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                this.id = 0;
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar serviço: " + e.getMessage());
        }
        return false;
    }


}
