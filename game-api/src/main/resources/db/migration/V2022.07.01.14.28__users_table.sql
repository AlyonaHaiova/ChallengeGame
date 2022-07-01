create table if not exists public.users
(
    id         bigserial primary key,
    email      varchar(50) not null,
    first_name varchar(50) not null,
    last_name  varchar(50) not null
)