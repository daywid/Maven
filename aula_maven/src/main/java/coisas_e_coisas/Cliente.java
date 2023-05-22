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
 
    public Cliente(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public static Cliente find_one(int id) {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }
        return null;
    }

    public void save() {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
            if (this.id == 0) {
                // Inserir novo cliente
                String sql = "INSERT INTO clientes (nome, endereco, telefone, email) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setString(1, this.nome);
                ps.setString(2, this.endereco);
                ps.setString(3, this.telefone);
                ps.setString(4, this.email);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);

                // Obter o ID gerado automaticamente pelo banco de dados
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.id = rs.getInt(1);
                }
            } else {
                // Atualizar cliente existente
                String sql = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, this.nome);
                ps.setString(2, this.endereco);
                ps.setString(3, this.telefone);
                ps.setString(4, this.email);
                ps.setInt(5, this.id);
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }
    
    public boolean delete() {
        try (Connection conexao = ConexaoMySQL.getInstance().getConnection()) {
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
