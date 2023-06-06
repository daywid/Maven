package heranca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Pessoa {
    protected int cpf;
    protected String nome;
    protected String email;

    // Construtor sem cpf
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Construtor com cpf
    public Pessoa(int cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }
    
    
    // Método abstrato para buscar uma pessoa pelo CPF
    public static Pessoa find_one(int cpf) {
        // Lógica de busca do CPF na tabela de pessoas
        // Implementação específica será feita nas subclasses
        return null;
    }

    // Método abstrato para salvar a pessoa
    public abstract void save();

    // Método abstrato para deletar a pessoa
    public abstract boolean delete();
}
