create table public.games
(
    id          bigserial primary key,
    title       varchar(20) unique not null,
    description varchar(1000)
);