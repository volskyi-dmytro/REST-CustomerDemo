create table if not exists customers(
    id bigint primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    address varchar(500) not null,
    budget decimal not null
);
