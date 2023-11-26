DROP DATABASE IF EXISTS simulacaoturfespring;
CREATE DATABASE simulacaoturfespring CHARACTER SET utf8 COLLATE utf8_general_ci;
USE simulacaoturfespring;

DROP TABLE IF EXISTS cavalo;
DROP TABLE IF EXISTS proprietario;

CREATE TABLE proprietario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL UNIQUE,
    cpf VARCHAR(24),
    email VARCHAR(255),
    telefone VARCHAR(20),
    senha VARCHAR(255)
   )ENGINE=INNODB COLLATE=utf8_general_ci;
   
INSERT INTO proprietario(nome, cpf, email, telefone, senha) VALUES
("Saulo", "999.999.999-99", "saulo@gmail.com", "(22) 98104-2279", "123456"),
("Thais", "999.999.999-99", "thais@gmail.com", "(22) 99999-9999", "123456");
   
   
CREATE TABLE cavalo (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL UNIQUE,
    cor VARCHAR(7),
    numero INT(11),
    velocidade INT(11),
    resistencia INT(11),
    preco DECIMAL(9,2),
    id_proprietario INT,
    CONSTRAINT fk_cavalo__id_proprietario FOREIGN KEY (id_proprietario) REFERENCES proprietario(id)
)ENGINE=INNODB COLLATE=utf8_general_ci;