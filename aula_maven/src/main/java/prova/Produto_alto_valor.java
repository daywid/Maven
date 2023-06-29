package prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Produto_alto_valor extends Produto {

    public double valor_seguro;
    public String tipo_transporte;

    @Override
    public double calcular_preco_total() {
        double preco_total = super.calcular_preco_total();
        preco_total += valor_seguro;
        return preco_total;
    }
    
    
    @Override
    public boolean delete() {
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = Database.getInstance().getConnection();
            
            String sql = "DELETE FROM produto_alto_valor WHERE codigo = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, this.codigo);

            // Executar a exclusão no banco de dados
            int rowsAffected = ps.executeUpdate();

            // Verificar se a exclusão foi bem-sucedida
            if (rowsAffected > 0) {
                this.codigo = 0;
                return true;
            }
        } catch (SQLException e) {//obter mensagem detalhando o erro, caso este ocorra
            System.out.println("Erro ao deletar produto: " + e.getMessage());
            e.printStackTrace();
        } 
        return false;
    }
    
}

