create table users(
tx_name varchar(50) not null,
tx_password varchar not null,
tx_email varchar(100) not null,
tx_id UUID not null,
PRIMARY KEY (tx_id));