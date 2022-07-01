delete
from public.cards_roles;

delete
from public.cards;

delete
from public.card_types;

delete
from public.roles;

delete
from public.games;

alter table public.games
    add column if not exists user_id bigserial not null,
    add constraint fk_games_user_id
        foreign key (user_id)
            references public.users (id)
            on delete cascade
            on update cascade;
