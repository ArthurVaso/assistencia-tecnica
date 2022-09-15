CREATE TABLE cliente (
						codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
						nome VARCHAR(50) NOT NULL,
						email VARCHAR(50) NOT NULL,
						telefone VARCHAR(20),
						cpf VARCHAR(15),
						logradouro VARCHAR(30),
						numero VARCHAR(30),
						complemento VARCHAR(30),
						bairro VARCHAR(30),
						cidade VARCHAR(30),
						estado VARCHAR(30),
						cep VARCHAR(30),
						ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cliente 
		(nome, email, telefone, cpf, 
		logradouro, numero, complemento, bairro, cidade, estado, cep, ativo) 
	VALUES 
		('Arthur', 'arthur.v@aluno.ifsp.edu.br', '3412-8216', '123.452.478-89',
		'Rua um', '13', null, 'Bairro', 'cidade', 'estado', '12.258-569', true);