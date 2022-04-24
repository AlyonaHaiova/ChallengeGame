create table if not exists public.card_types
(
    id      bigserial primary key,
    game_id bigserial,
    title   varchar(20) not null,
    color   varchar(15) not null,
    constraint fk_card_types_game_id
        foreign key (game_id)
            references public.games(id)
            on delete cascade
            on update cascade
)