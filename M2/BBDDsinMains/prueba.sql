create or replace procedure prueba(nom user_pw.username%type, num_bat in out number)
is
begin
select count(*) into num_bat from battle where id_user = (select id_user from user_pw where username = nom);
dbms_output.put_line(num_bat);
end;

/ 
set serveroutput on
declare
num_bat number;
begin
prueba('brahian',num_bat);
end;