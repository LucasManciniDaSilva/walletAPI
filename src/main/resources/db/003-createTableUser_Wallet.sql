create table users_wallet(
tx_id UUID not null,
tx_wallet UUID not null,
tx_users UUID not null,
primary key(tx_id),
foreign key(tx_users) references users(tx_id),
foreign key(tx_wallet) references wallet(tx_id));