create table if not exists public.roles
(
    id bigserial primary key,
    title varchar(30) not null,
    game_id bigserial,
    constraint fk_roles_game_id
        foreign key(game_id)
            references public.games(id)
            on delete cascade
            on update cascade
)