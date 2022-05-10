create or replace function Registro(usu in varchar2,pass in varchar2, cumple in date)
return boolean
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
        insert into enemie values (1,26000,180000,6);
    end if;
    return true;
end if;
exception
when existe then return false;
end;
/
set serveroutput on;
declare
guardar boolean;
begin
guardar:=Registro('brahian','pro','16/05/2000');
dbms_output.put_line('so');
end;