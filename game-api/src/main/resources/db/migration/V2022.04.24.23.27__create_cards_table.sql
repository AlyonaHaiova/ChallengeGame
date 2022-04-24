create table if not exists public.cards
(
    id bigserial primary key,
    type_id bigserial,
    description varchar(200) not null,
    time varchar(10) not null,
    constraint fk_cards_type_id
        foreign key(type_id)
            references public.card_types(id)
            on delete cascade
            on update cascade
)