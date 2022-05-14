create or replace procedure get_enemie (nom user_pw.username%type, deu in out enemie.deuterium%type, met in out enemie.metal%type, fle in out enemie.fleet%type)
is
id_u int;
begin
select id_user into id_u from user_pw where username = nom;
select deuterium, metal, fleet into deu, met, fle from enemie where id_user = id_u;
exception
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;

