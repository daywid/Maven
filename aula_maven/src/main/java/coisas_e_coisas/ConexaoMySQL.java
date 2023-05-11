package coisas_e_coisas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

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

CREATE TABLE prestadores_de_servicos (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO prestadores_de_servicos (nome, telefone, email) VALUES
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
#DROP DATABASE coisas_e_coisas;


*/

