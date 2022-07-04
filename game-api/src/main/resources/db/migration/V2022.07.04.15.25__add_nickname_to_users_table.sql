alter table if exists public.users
    add column if not exists nickname varchar(100),
    add constraint email_unique unique (email);

update public.users
set nickname = concat(first_name, last_name);

alter table if exists public.users
    drop column if exists first_name,
    drop column if exists last_name;

alter table if exists public.users
    alter column nickname set not null,
    add constraint nickname_unique unique (nickname);
