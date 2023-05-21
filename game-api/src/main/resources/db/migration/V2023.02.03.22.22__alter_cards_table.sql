alter table if exists public.users
    drop column if exists range_begin,
    drop column if exists range_end,
    drop column if exists unit_id,
    add column if not exists points integer;
