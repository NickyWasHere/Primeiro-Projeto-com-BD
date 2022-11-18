CREATE TABLE IF NOT EXISTS cidade(
	ddd integer PRIMARY KEY,
	nome varchar(150) NOT NULL,
	nro_habitantes integer NOT NULL,
	renda_per_capita numeric(15,2) NOT NULL,
	capital boolean NOT NULL,
	estado varchar(2) NOT NULL,
	nome_prefeito varchar(150) NOT NULL
);

SELECT * FROM cidade;