alter table if exists public.users
  add column if not exists first_name varchar(50),
  add column if not exists last_name varchar(50);
