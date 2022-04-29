create table if not exists public.cards_roles
(
    id bigserial primary key,
    card_id bigserial,
    role_id bigserial,
    constraint fk_cards_roles_card_id
        foreign key(card_id)
            references public.cards(id)
            on delete cascade
            on update cascade,
    constraint fk_cards_roles_role_id
        foreign key(role_id)
            references public.roles(id)
            on delete cascade
            on update cascade
)
