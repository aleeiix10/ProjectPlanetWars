create or replace procedure update_enemie(usuario in varchar2)
is
id_usu number;
begin
select id_user into id_usu from user_pw where username=usuario;
update enemie set deuterium=deuterium*1.06,metal=metal*1.06 where id_user=id_usu;
exception
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;
/
begin
update_enemie('brahian');
end;