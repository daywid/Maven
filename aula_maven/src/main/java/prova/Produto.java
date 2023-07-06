package prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// b777c6a8ff8c44d7a64cc432d0a3ca40
public class abstract Produto {

	public int codigo;
	public String nome;
	public double preco_sugerido;
	public double custo_armazenagem;
	
	 public double calcular_preco_total() {
	        double preco_total = preco_sugerido + custo_armazenagem;
	        return preco_total;
	    }
	
	
	public boolean delete() {
        Connection conexao = null;
        try {
            // Obter a conexão com o banco de dados
            conexao = Database.getInstance().getConnection();
            
            String sql = "DELETE FROM produto WHERE codigo = ?";
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
