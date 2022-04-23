create table public.game_roles
(
    id      bigserial primary key,
    game_id bigserial,
    title   varchar(20) not null,
    constraint fk_game_roles_game_id
        foreign key (game_id)
            references public.games(id)
)