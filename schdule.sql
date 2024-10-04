-- auto-generated definition
create table schedule
(
    id           bigint auto_increment
        primary key,
    contents     varchar(255) not null,
    name         varchar(100) not null,
    password     varchar(100) not null,
    created_date datetime     not null,
    updated_date datetime     not null
);
