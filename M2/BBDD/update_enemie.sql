create or replace procedure update_enemie(usuario in varchar2)
is
id_usu number;
begin
select id_user into id_usu from user_pw where username=usuario;
update enemie set deuterium=deuterium*1.06,metal=metal*1.06 where id_user=id_usu;
end;
/
begin
update_enemie('brahian');
end;