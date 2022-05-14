create or replace procedure Registro(usu in varchar2,pass in varchar2, cumple in varchar2,boleano in out number)
is
cont number;
maximo number;
existe exception;
begin
select count(*) into cont from user_pw where username=usu;
if cont=1 then
    raise existe;
else
    select max(id_user) into maximo from user_pw;
    if maximo is null then
        insert into user_pw values (1,usu,cumple,pass);
        insert into enemie values (1,26000,180000,6);
    else
        insert into user_pw values (maximo+1,usu,cumple,pass);
        insert into enemie values (maximo+1,26000,180000,6);
    end if;
    boleano:=1;
end if;
exception
when existe then dbms_output.put_line('Existe el usuario');
boleano:=0;
when no_data_found then dbms_output.put_line('error --> no datos');
boleano:=0;
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
boleano:=0;
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
boleano:=0;
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
boleano:=0;
when others then dbms_output.put_line('error -->ha habido un error ');
boleano:=0;
end;
/
set serveroutput on;
declare
dale number;
begin
Registro('brahian','pro','16/05/2000',dale);
end;