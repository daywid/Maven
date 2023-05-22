package coisas_e_coisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrestadorDeServicos {
    
    public int id;
    public String nome;
    public String telefone;
    public String email;
 
    public PrestadorDeServicos(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public static PrestadorDeServicos find_one(int id) {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
            String sql = "SELECT * FROM prestador_de_servicos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new PrestadorDeServicos(
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar prestador de serviços: " + e.getMessage());
        }
        return null;
    }

    public void save() {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
            if (this.id == 0) {
                // Inserir novo prestador de serviços
                String sql = "INSERT INTO prestador_de_servicos (nome, telefone, email ) VALUES (?, ?, ?)";
                PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setString(1, this.nome);
                ps.setString(2, this.telefone);
                ps.setString(3, this.email);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);

                // Obter o ID gerado automaticamente pelo banco de dados
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.id = rs.getInt(1);
                }
            } else {
                // Atualizar prestador de serviços existente
                String sql = "UPDATE prestador_de_servicos SET nome = ?, telefone = ?, email = ? WHERE id = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, this.nome);
                ps.setString(2, this.telefone);
                ps.setString(3, this.email);
                ps.setInt(4, this.id);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar prestador de serviços: " + e.getMessage());
        }
    }
    
    public boolean delete() {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
            String sql = "DELETE FROM prestador_de_servicos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, this.id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                this.id = 0;
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar prestador de serviços: " + e.getMessage());
        }
        return false;
    }


}
