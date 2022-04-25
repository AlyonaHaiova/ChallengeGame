create table if not exists public.amount_units
(
    id    bigserial primary key,
    title varchar(20) unique not null
);

insert into public.amount_units(title) values ('Time'), ('Amount');