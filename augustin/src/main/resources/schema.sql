DROP TABLE IF EXISTS CONTA;
 
CREATE TABLE CONTA (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    dinheiro INT NOT NULL
);
