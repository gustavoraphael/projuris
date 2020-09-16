CREATE TABLE orderService
(
	id UUID PRIMARY KEY NOT NULL,
	client_id UUID NOT NULL,
	product VARCHAR(100) NOT NULL,
	problem VARCHAR NOT NULL,
	dateInit TIMESTAMP,
	dateFim TIMESTAMP
);

CREATE TABLE client
(
	id UUID PRIMARY KEY NOT NULL,
	name VARCHAR(60) NOT NULL,
	adress VARCHAR(200),
	email VARCHAR(60),
	fone VARCHAR(40)
);

CREATE TABLE  orderServiceAux
(
	id UUID PRIMARY KEY NOT NULL,
	order_id UUID NOT NULL,
	date TIMESTAMP NOT NULL,
	description VARCHAR(200) 
);	