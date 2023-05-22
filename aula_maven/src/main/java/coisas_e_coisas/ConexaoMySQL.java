package coisas_e_coisas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	/*private static ConexaoMySQL instance;
	private Connection conexao;
	
	
    public static Connection getConnection() throws SQLException {
        // informações de conexão com o MySQL
        String url = "jdbc:mysql://localhost:3306/coisas_e_coisas";
        String usuario = "root";
        String senha = "positivo";
  
        try {
            // carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Não foi possível carregar o driver JDBC.", e);
        }
    
        // estabelece a conexão com o MySQL
        return DriverManager.getConnection(url, usuario, senha);
    }
  */  
   
	//singleton:
	
	private static ConexaoMySQL instance;
    private Connection conexao;

    private ConexaoMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
            String usuario = "seu_usuario";
            String senha = "sua_senha";
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static ConexaoMySQL getInstance() {
        if (instance == null) {
            synchronized (ConexaoMySQL.class) {
                if (instance == null) {
                    instance = new ConexaoMySQL();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return conexao;
    }
    
    
}


    /*CREATE DATABASE coisas_e_coisas;

USE coisas_e_coisas;

CREATE TABLE clientes (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO clientes (nome, endereco, telefone, email) VALUES 
('João da Silva', 'Rua A, 123', '(11) 9999-8888', 'joao.silva@example.com'),
('Ana Silva', 'Rua das Flores, 123', '(11) 98888-7777', 'ana.silva@gmail.com'),
('José Santos', 'Avenida Paulista, 456', '(11) 97777-6666', 'jose.santos@hotmail.com');


CREATE TABLE servicos (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  descricao TEXT NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO servicos (nome, descricao, valor) VALUES
('Reparos elétricos', 'Realização de reparos em instalações elétricas residenciais e comerciais', 120.00),
('Reparos hidráulicos', 'Realização de reparos em encanamentos e tubulações hidráulicas', 150.00),
('Reparos em alvenaria', 'Realização de reparos em estruturas e superfícies em alvenaria', 180.00);

CREATE TABLE prestador_de_servicos (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO prestador_de_servicos (nome, telefone, email) VALUES
('João da Silva', '(11) 9999-8888', 'joao.silva@coisasecoisas.com'),
('Maria dos Santos', '(11) 9888-7777', 'maria.santos@coisasecoisas.com'),
('Pedro Oliveira', '(11) 9777-6666', 'pedro.oliveira@coisasecoisas.com');

CREATE TABLE servicos_contratados (
  id INT NOT NULL AUTO_INCREMENT,
  data_atendimento DATE NOT NULL,
  id_cliente INT NOT NULL,
  id_servico INT NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id),
  FOREIGN KEY (id_servico) REFERENCES servicos(id)
);

INSERT INTO servicos_contratados (data_atendimento, id_cliente, id_servico, valor) VALUES
('2022-01-10', 1, 2, 100.00),
('2022-01-15', 2, 3, 200.00),
('2022-01-20', 3, 1, 150.00);


SELECT * FROM clientes;
SELECT * FROM servicos;
SELECT * FROM prestador_de_servicos;
SELECT * FROM servicos_contratados;
SELECT sc.*, c.id as id_cliente, c.nome as cliente_nome,  c.endereco as cliente_endereco, c.telefone as cliente_telefone, c.email as cliente_email, s.nome as servico_nome, 
s.valor as servico_valor FROM servicos_contratados sc 
INNER JOIN clientes c ON sc.id_cliente = c.id INNER JOIN servicos s ON sc.id_servico = s.id WHERE sc.id = 1
#DROP DATABASE coisas_e_coisas;



*/

