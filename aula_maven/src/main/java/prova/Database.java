package prova;

//nao implementar o save

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // Declaração de variáveis e objetos
    private static Database instance;
    private Connection conexao;

    private Database() {
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
             // Configurações de conexão com o banco de dados
            String url = "jdbc:mysql://localhost:3306/prova";
            String usuario = "root";
            String senha = "positivo";
            
            // Estabelece a conexão com o banco de dados
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
    // Obtém a instância única da classe ConexaoMySQL
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {//synchronized garante que a criação da instância seja feita de forma thread-safe, evitando problemas de concorrência. garantirá que apenas uma thread de cada vez acesse
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }
    
    // Retorna a conexão com o banco de dados
    public Connection getConnection() {
        return conexao;
    } 

}
