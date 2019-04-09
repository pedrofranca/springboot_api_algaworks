CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    logradouro VARCHAR(255),
    complemento VARCHAR(255),
    bairro VARCHAR(255),    
    cep VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Pedro Caputo", true, "Rua das laranjeiras, 666", null, "Jardim voador", "6547-555", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Enzo Gabriel", false, "Rua topzera, 111", "321", "Jardim Da Patagônia", "6547-555", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Valentina Vitória", true, "Rua Topázio, 22", "123", "Aclimação", "6547-555", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Maria Josefina", false, "Rua Onyx, 33", null, "Aclimação", "6547-555", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Marcos Castro", true, null, null, null, null, null, null);
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Paulo Bonfá", false, null, null, null, null, null, null);
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Cauê Moura", true, "Ruam das Calibrada, 66", null, "Jardim voador", "6547-555", "São Paulo", "SP");
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("NANO Moura", false, "Rua, 0", null, "Jardim voador", "6547-555", null, "SP");
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Victor ComC", true, "Ruanda, 88", null, "Jardim voador", "6547-555", null, null);
INSERT INTO pessoa (nome, ativo, logradouro, complemento, bairro, cep, cidade, estado) 
			VALUES ("Vitor SemC", false, "Rua noventa e nove, 99", null, "Jardim voador", "6547-555", "São Paulo", null);