CREATE DATABASE simulacao_turfe CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

USE simulacao_turfe;

CREATE TABLE proprietario(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    cpf VARCHAR(24),
    email VARCHAR(255),
    telefone varchar(20),
    senha VARCHAR(255)
);

CREATE TABLE cavalo(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30),
    cor VARCHAR(7),
    numero INT,
    velocidade INT,
    resistencia INT,
    preco FLOAT,
    id_proprietario INT,
    CONSTRAINT fk_cavalo__id_proprietario FOREIGN KEY(id_proprietario) REFERENCES proprietario(id) ON DELETE CASCADE
);

CREATE TABLE corrida(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    data_agendada DATETIME,
    valor_inscricao FLOAT
);

CREATE TABLE cavalo_corrida(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_cavalo INT,
    id_corrida INT,
    CONSTRAINT fk_cavalo_corrida__id_cavalo FOREIGN KEY(id_cavalo) REFERENCES cavalo(id) ON DELETE CASCADE,
    CONSTRAINT fk_cavalo_corrida__id_corrida FOREIGN KEY(id_corrida) REFERENCES corrida(id) ON DELETE CASCADE
);

CREATE TABLE usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(60) NOT NULL,
	email VARCHAR(255) NOT NULL,
	senha VARCHAR(64) NOT NULL
);