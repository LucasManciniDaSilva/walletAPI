create table wallet_items(
tx_id UUID not null,
tx_wallet UUID not null,
dt_date date,
tx_type varchar(2),
tx_description varchar(500),
nm_value numeric(10,2),

primary key(tx_id),
foreign key(tx_wallet) references wallet(tx_id)
);