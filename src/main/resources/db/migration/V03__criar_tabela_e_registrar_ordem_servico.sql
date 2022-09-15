CREATE TABLE ordem_servico (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	data_emissao DATE NOT NULL,
	data_finalizacao DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	status VARCHAR(20) NOT NULL,
	codigo_pagamento BIGINT(20) NOT NULL,
	codigo_cliente BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_pagamento) REFERENCES forma_pagamento(codigo),
	FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ordem_servico (descricao, data_emissao, data_finalizacao, valor, observacao, status, codigo_pagamento, codigo_cliente) values ('Rendimento da Poupança', '2022-08-25', null, 100.00, null, 'EM_APROVAÇÃO', 1, 1);
INSERT INTO ordem_servico (descricao, data_emissao, data_finalizacao, valor, observacao, status, codigo_pagamento, codigo_cliente) values ('Compra da semana', '2022-08-25', '2022-08-25', 120.00, null, 'FINALIZADA', 2, 1);
INSERT INTO ordem_servico (descricao, data_emissao, data_finalizacao, valor, observacao, status, codigo_pagamento, codigo_cliente) values ('Vitaminas e Suplementos', '2022-08-20', '2022-08-20', 200.00, null, 'APROVADA', 3, 1);