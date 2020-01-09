create table if not exists changelog (
 change_number bigint primary key not null,
 complete_dt date not null,
 applied_by text not null,
 description text not null
);
