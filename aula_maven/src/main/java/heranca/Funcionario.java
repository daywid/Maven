package heranca;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Funcionario extends Pessoa {
    public double salario;
    public Date aniversario;
    public String telefone;
    public String departamento;

    // Construtor com cpf
    public Funcionario(int cpf, String nome, String email, double salario, Date aniversario, String telefone, String departamento) {
        super(cpf, nome, email);
        this.salario = salario;
        this.aniversario = aniversario;
        this.telefone = telefone;
        this.departamento = departamento;
    }

    public static Funcionario find_one(int cpf) {
        Funcionario funcionario = null;
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = ConexaoMySQL.getInstance().getConnection();
    
            // Preparar a consulta SQL para buscar o funcionário pelo CPF
            String sql = "SELECT * FROM funcionarios WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cpf);
    
            // Executar a consulta SQL
            ResultSet rs = ps.executeQuery();
    
            // Verificar se há um resultado e criar um objeto Funcionario com os dados
            if (rs.next()) {
                funcionario = new Funcionario(
                        rs.getInt("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getDouble("salario"),
                        rs.getDate("aniversario"),
                        rs.getString("telefone"),
                        rs.getString("departamento")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
    
        return funcionario;
    }
    
        public void save() {
            Connection conexao = null;
            try {
                // Obter a conexão com o banco de dados
                conexao = ConexaoMySQL.getInstance().getConnection();
        
                // Verificar se o funcionário já existe no banco de dados
                Funcionario funcionarioExistente = Funcionario.find_one(this.cpf);

                if (funcionarioExistente == null) {
                    // Inserir novo funcionário
                    String sql = "INSERT INTO funcionarios (cpf, nome, email, salario, aniversario, telefone, departamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
                    // Definir os valores dos parâmetros na consulta SQL
                    ps.setInt(1, cpf);
                    ps.setString(2, this.nome);
                    ps.setString(3, this.email);
                    ps.setDouble(4, this.salario);
                    ps.setDate(5, new java.sql.Date(this.aniversario.getTime()));
                    ps.setString(6, this.telefone);
                    ps.setString(7, this.departamento);
        
                    // Executar a atualização no banco de dados e obter as chaves geradas automaticamente
                    int retorno = ps.executeUpdate();
                    System.out.println(retorno);
                    
                } else {
                    // Atualizar funcionário existente
                    String sql = "UPDATE funcionarios SET nome = ?, email = ?, salario = ?, aniversario = ?, telefone = ?, departamento = ? WHERE cpf = ?";
                    PreparedStatement ps = conexao.prepareStatement(sql);
        
                    // Definir os valores dos parâmetros na consulta SQL
                    ps.setString(1, this.nome);
                    ps.setString(2, this.email);
                    ps.setDouble(3, this.salario);
                    ps.setDate(4, new java.sql.Date(this.aniversario.getTime()));
                    ps.setString(5, this.telefone);
                    ps.setString(6, this.departamento);
                    ps.setInt(7, this.cpf);
        
                    // Executar a atualização no banco de dados
                    int retorno = ps.executeUpdate();
                    System.out.println(retorno);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao salvar funcionário: " + e.getMessage());
            }
        }        

        public boolean delete() {
            Connection conexao = null;
            try {
                // Obter a conexão com o banco de dados
                conexao = ConexaoMySQL.getInstance().getConnection();
        
                String sql = "DELETE FROM funcionarios WHERE cpf = ?";
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
                System.out.println("Erro ao deletar funcionário: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
        
}

        
        






