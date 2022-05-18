create or replace procedure log_in (nom user_pw.username%type, pass user_pw.password%type, bolean in out number)
as
existe int;
contra user_pw.password%type;
begin
select count(username) into existe from user_pw where username = nom;
if existe = 1 then
          select password into contra from user_pw where username = nom;
          if contra = pass then
                bolean:=1;
          else
                bolean:=0;
          end if;
else
    bolean:=0;
end if;

EXCEPTION
when no_data_found then dbms_output.put_line('error --> no datos');
bolean:=0;
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
bolean:=0;
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
bolean:=0;
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
bolean:=0;
when others then dbms_output.put_line('error -->ha habido un error ');
bolean:=0;
end;
          