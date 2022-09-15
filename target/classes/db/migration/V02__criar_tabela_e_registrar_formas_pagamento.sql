CREATE TABLE forma_pagamento (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO forma_pagamento (nome) values ('DINHEIRO');
INSERT INTO forma_pagamento (nome) values ('DÉBITO');
INSERT INTO forma_pagamento (nome) values ('CRÉDITO');