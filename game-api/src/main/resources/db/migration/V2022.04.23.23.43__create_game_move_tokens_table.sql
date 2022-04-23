create table public.game_move_tokens
(
    id bigserial primary key,
    token_value varchar(100) not null,
    game_role_id bigserial,
    constraint fk_game_move_tokens_game_role_id
        foreign key(game_role_id)
            references public.game_roles(id)
)