/*package banco_de_dados;

import java.sql.*;

public class Conectando {
    public static void main(String[] args) {
        // informações de conexão com o MySQL
        String url = "jdbc:mysql://localhost:3306/exemplo";
        String usuario = "root";
        String senha = "positivo";

        try {
            // carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // estabelece a conexão com o MySQL
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // realiza operações com o banco de dados aqui...

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
*/

/*create database dayyyexemplo;
use dayyyexemplo;

create table clientes (
id int NOT NULL,
cpf varchar(255) NOT NULL,
nome varchar(255) NOT NULL,
email varchar(255) DEFAULT NULL,
primary key (id)
);

insert into clientes(id,cpf,nome,email) values
(1,'888', 'pedro de lara', 'plara@gmail.com');

insert into clientes(id,cpf,nome,email) values
(2,'999', 'pEEEedro de lara', 'pleeara@gmail.com');

insert into clientes(id,cpf,nome,email) values
(3,'777', 'pedrao de laraaa', 'plaraao@gmail.com');

select * from clientes;

*/