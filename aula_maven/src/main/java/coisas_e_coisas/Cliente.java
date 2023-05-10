package coisas_e_coisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
    
    public int id;
    public String nome;
    public String endereco;
    public String telefone;
    public String email;
 
    public Cliente(int id, String nome, String email, String telefone) {
    }

    public static Cliente find_one(int id) {
        try (Connection conexao = ConexaoMySQL.getConnection()) {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }
        return null;
    }

    public void save() {
        try (Connection conexao = ConexaoMySQL.getConnection()) {
            if (this.id == 0) {
                // Inserir novo cliente
                String sql = "INSERT INTO clientes (nome, email, telefone) VALUES (?, ?, ?)";
                PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setString(1, this.nome);
                ps.setString(2, this.email);
                ps.setString(3, this.telefone);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);

                // Obter o ID gerado automaticamente pelo banco de dados
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.id = rs.getInt(1);
                }
            } else {
                // Atualizar cliente existente
                String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE id = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, this.nome);
                ps.setString(2, this.email);
                ps.setString(3, this.telefone);
                ps.setInt(4, this.id);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }
    
    public boolean delete() {
        try (Connection conexao = ConexaoMySQL.getConnection()) {
            String sql = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, this.id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                this.id = 0;
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
        return false;
    }


}
