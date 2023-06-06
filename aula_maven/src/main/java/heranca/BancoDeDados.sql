create database heranca;

use database heranca;

-- Criação da tabela 'funcionarios'
CREATE TABLE funcionarios (
  cpf INT PRIMARY KEY,
  nome VARCHAR(100),
  email VARCHAR(100),
  salario DECIMAL(10, 2),
  aniversario DATE,
  telefone VARCHAR(20),
  departamento VARCHAR(100)
);

-- Inserts para 'funcionarios'
INSERT INTO funcionarios (cpf, nome, email, salario, aniversario, telefone, departamento) VALUES 
(123456789, 'João Silva', 'joao.silva@example.com', 3500.00, '1990-05-10', '9999-9999', 'Departamento A'),
(987654321, 'Maria Santos', 'maria.santos@example.com', 2800.50, '1992-09-22', '8888-8888', 'Departamento B');


-- Criação da tabela 'gerentes'
CREATE TABLE gerentes (
  cpf INT PRIMARY KEY,
  nome VARCHAR(100),
  email VARCHAR(100),
  salario DECIMAL(10, 2),
  aniversario DATE,
  telefone VARCHAR(20),
  departamento VARCHAR(100),
  gratificacao DECIMAL(10, 2)
);

-- Inserts para 'gerentes'
INSERT INTO gerentes (cpf, nome, email, salario, aniversario, telefone, departamento, gratificacao) VALUES 
(111222333, 'Carlos Oliveira', 'carlos.oliveira@example.com', 5000.00, '1985-02-15', '7777-7777', 'Departamento C', 10.00),
(444555666, 'Ana Costa', 'ana.costa@example.com', 4800.75, '1988-07-29', '6666-6666', 'Departamento D', 8.00);

-- Criação da tabela 'terceiros'
CREATE TABLE terceiros (
  cpf INT PRIMARY KEY,
  nome VARCHAR(100),
  email VARCHAR(100)
);

-- Inserts para 'terceiros'
INSERT INTO terceiros (cpf, nome, email) VALUES 
(777888999, 'Fernando Pereira', 'fernando.pereira@example.com'),
(222333444, 'Juliana Lima', 'juliana.lima@example.com');
