package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exemplo_Banco_de_Dados {

	 public static void main(String[] args) {
	        // informações de conexão com o MySQL
	        String url = "jdbc:mysql://localhost:3306/dayyyexemplo";
	        String usuario = "root";
	        String senha = "positivo";

	        try {
	            // carrega o driver JDBC do MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // estabelece a conexão com o MySQL
	            Connection conexao = DriverManager.getConnection(url, usuario, senha);
	            System.out.println(conexao.isValid(0));
	           
	            /*exemplo para select
	            // realiza operações com o banco de dados aqui...

	            // define a instrução SQL para selecionar os registros
	            String sql = "SELECT * FROM clientes WHERE nome = ?";

	            // cria um objeto PreparedStatement a partir da instrução SQL
	            PreparedStatement ps = conexao.prepareStatement(sql);

	            // atribui valores aos parâmetros da instrução SQL
	            ps.setString(1, "pedro de lara");

	            // executa a instrução SQL de seleção
	            ResultSet rs = ps.executeQuery();	            
	            
	            // percorre os registros retornados pela instrução SQL
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String nome = rs.getString("nome");
	                String email = rs.getString("email");
	                System.out.println(id + " " + nome + " " + email);

	                // faz algo com os valores dos campos aqui...
	            }
				*/ 
	            //####################################################
	            //FIM DO EXEMPLO
	            
	            
	            //EXEMPLO INSERT
	            /*
	            String sql = "insert into clientes(id,cpf, nome, email) values (?,?,?,?)";
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setInt(1, 7);
	            ps.setString(2, "101010");
	            ps.setString(3, "Sérgio Malandro");
	            ps.setString(4, "sergiomalandro@gmail.com");
	            
	            
	            int retorno = ps.executeUpdate();
	            System.out.println(retorno);
	            #######################################################
	            FIM DO EXEMPLO
	            */
	            
	            String sql = "Update clientes set email = ? where cpf = ?";
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            
	            ps.setString(1, "pedraodoslara@gmail.com");
	            ps.setString(2, "888");
	            int retorno = ps.executeUpdate();
	            System.out.println(retorno);
	            
	            // fecha a conexão
	            conexao.close();
	        } catch (ClassNotFoundException e) {
	            System.out.println("Não foi possível carregar o driver JDBC.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Não foi possível estabelecer a conexão com o MySQL.");
	            e.printStackTrace();
	        }

}
}
