package heranca;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gerente extends Pessoa {

    public double salario;
    public Date aniversario;
    public String telefone;
    public String departamento;
    public double gratificacao;


    // Construtor com cpf
    public Gerente(int cpf, String nome, String email, double salario, Date aniversario, String telefone, String departamento, double gratificacao) {
        super(cpf, nome, email);
        this.salario = salario;
        this.aniversario = aniversario;
        this.telefone = telefone;
        this.departamento = departamento;
        this.gratificacao = gratificacao;
    }

    public static Gerente find_one(int cpf) {
        Gerente gerente = null;
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = ConexaoMySQL.getInstance().getConnection();

            // Preparar a consulta SQL para buscar o gerente pelo CPF
            String sql = "SELECT * FROM gerentes WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cpf);

            // Executar a consulta SQL
            ResultSet rs = ps.executeQuery();

            // Verificar se há um resultado e criar um objeto Gerente com os dados
            if (rs.next()) {
                gerente = new Gerente(
                        rs.getInt("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getDouble("salario"),
                        rs.getDate("aniversario"),
                        rs.getString("telefone"),
                        rs.getString("departamento"),
                        rs.getDouble("gratificacao")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar gerente: " + e.getMessage());
        }

        return gerente;
    }


    public void save() {
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = ConexaoMySQL.getInstance().getConnection();

             // Verificar se o gerente já existe no banco de dados
             Gerente gerenteExistente = Gerente.find_one(this.cpf);

            if (gerenteExistente == null) {
                // Inserir novo gerente
                String sql = "INSERT INTO gerentes (cpf, nome, email, salario, aniversario, telefone, departamento, gratificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                // Definir os valores dos parâmetros na consulta SQL
                ps.setInt(1, this.cpf);
                ps.setString(2, this.nome);
                ps.setString(3, this.email);
                ps.setDouble(4, this.salario);
                ps.setDate(5, this.aniversario);
                ps.setString(6, this.telefone);
                ps.setString(7, this.departamento);
                ps.setDouble(8, this.gratificacao);

                // Executar a atualização no banco de dados e obter as chaves geradas automaticamente
                int retorno = ps.executeUpdate();
                System.out.println(retorno);

            } else {
                // Atualizar gerente existente
                String sql = "UPDATE gerentes SET nome = ?, email = ?, salario = ?, aniversario = ?, telefone = ?, departamento = ?, gratificacao = ? WHERE cpf = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);

                // Definir os valores dos parâmetros na consulta SQL
                ps.setString(1, this.nome);
                ps.setString(2, this.email);
                ps.setDouble(3, this.salario);
                ps.setDate(4, this.aniversario);
                ps.setString(5, this.telefone);
                ps.setString(6, this.departamento);
                ps.setDouble(7, this.gratificacao);
                ps.setInt(8, this.cpf);

                // Executar a atualização no banco de dados
                int retorno = ps.executeUpdate();
                System.out.println(retorno);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar gerente: " + e.getMessage());
        }
    }

    public boolean delete() {
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = ConexaoMySQL.getInstance().getConnection();

            String sql = "DELETE FROM gerentes WHERE cpf = ?";
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
            System.out.println("Erro ao deletar gerente: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public double calcular_bônus() {
        return salario * 0.3; // Retorna 30% do salário do gerente como bônus
    }
   
}
