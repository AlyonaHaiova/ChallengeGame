alter table public.cards
    drop column if exists time;

alter table public.cards
    add column if not exists unit_id bigserial,
    add column if not exists role varchar(15) not null default 'MALE',
    add column if not exists range_begin int,
    add column if not exists range_end int,
    add constraint fk_cards_unit_id
        foreign key(unit_id)
            references public.amount_units(id);