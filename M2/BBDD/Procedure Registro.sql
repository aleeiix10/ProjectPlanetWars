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
when existe then boleano:=0;
end;
/
set serveroutput on;
declare
dale number;
begin
Registro('brahian','pro','16/05/2000',dale);
end;