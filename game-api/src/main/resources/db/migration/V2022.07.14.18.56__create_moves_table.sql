create table if not exists public.moves
(
    game_id      bigint primary key,
    last_role_id bigint not null unique,
    constraint fk_moves_game_id
    foreign key (game_id)
    references public.games (id),
    constraint fk_moves_last_role_id
    foreign key (last_role_id)
    references public.roles (id)
);
