alter table public.card_types
    add column if not exists is_playable boolean not null default true,
    add column if not exists is_penalty boolean not null default false