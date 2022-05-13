create or replace procedure get_enemie (nom user_pw.username%type, deu in out enemie.deuterium%type, met in out enemie.metal%type, fle in out enemie.fleet%type)
is
id_u int;
begin
select id_user into id_u from user_pw where username = nom;
select deuterium, metal, fleet into deu, met, fle from enemie where id_user = id_u;
end;

