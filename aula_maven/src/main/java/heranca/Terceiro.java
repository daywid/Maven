package heranca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Terceiro extends Pessoa {

    // Construtor sem id
    public Terceiro(String nome, String email) {
        super(nome, email);
    }

    // Construtor com id
    public Terceiro(int cpf, String nome, String email) {
        super(cpf, nome, email);
    }

    // Implementação do método find_one para buscar uma pessoa pelo CPF
    public static Terceiro find_one(int cpf) {
        Terceiro terceiro = null;
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = ConexaoMySQL.getInstance().getConnection();
            
            // Preparar a consulta SQL para buscar o terceiro pelo CPF
            String sql = "SELECT * FROM terceiros WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cpf);
            
            // Executar a consulta SQL
            ResultSet rs = ps.executeQuery();

            // Verificar se há um resultado e criar um objeto Terceiro com os dados
            if (rs.next()) {
               terceiro = new Terceiro(
                    rs.getInt("cpf"),
                    rs.getString("nome"),
                    rs.getString("email")
                );
                return terceiro;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar terceiro: " + e.getMessage());
        } 
        
        return terceiro;
    }

    // Implementação do método save para salvar a pessoa
    public void save() {
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = ConexaoMySQL.getInstance().getConnection();
            
            if (this.cpf == 0) {
                // Inserir novo terceiro
                String sql = "INSERT INTO terceiros (nome, email) VALUES (?, ?)";
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                // Definir os valores dos parâmetros na consulta SQL
                ps.setString(1, this.nome);
                ps.setString(2, this.email);
                
                // Executar a atualização no banco de dados
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
            } else {
                // Atualizar terceiro existente
                String sql = "UPDATE terceiros SET nome = ?, email = ? WHERE cpf = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                // Definir os valores dos parâmetros na consulta SQL
                ps.setString(1, this.nome);
                ps.setString(2, this.email);
                ps.setInt(3, this.cpf);
                
                // Executar a atualização no banco de dados
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar terceiro: " + e.getMessage());
        }
    }

    // Implementação do método delete para deletar a pessoa
    public boolean delete() {
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = ConexaoMySQL.getInstance().getConnection();
            
            String sql = "DELETE FROM terceiros WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, this.cpf);

            // Executar a exclusão no banco de dados
            int rowsAffected = ps.executeUpdate();

            // Verificar se a exclusão foi bem-sucedida
            if (rowsAffected > 0) {
                this.cpf = 0;
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar terceiro: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
