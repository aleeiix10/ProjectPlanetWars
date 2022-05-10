create or replace procedure DROP_TABLE
is
contador number;
drop1 varchar(200):='drop table Planet_Ship';
drop2 varchar(200):='drop table Planet_Defense';
drop3 varchar(200):='drop table Defense';
drop4 varchar(200):='drop table Ship';
drop5 varchar(200):='drop table Planet';
drop6 varchar(200):='drop table Battle';
drop7 varchar(200):='drop table User_PW';
drop8 varchar(200):='drop table Enemie';
begin
select count(*) into contador from tab where tname=upper('Planet_Ship');
if contador=1 then
execute immediate drop1;
dbms_output.put_line('La table Planet_Ship se ha eliminado correctamente');
end if;
select count(*) into contador from tab where tname=upper('Planet_Defense');
if contador=1 then
execute immediate drop2;
dbms_output.put_line('La table Planet_Defense se ha eliminado correctamente');
end if;
select count(*) into contador from tab where tname=upper('Defense');
if contador=1 then
execute immediate drop3;
dbms_output.put_line('La table Defense se ha eliminado correctamente');
end if;
select count(*) into contador from tab where tname=upper('Ship');
if contador=1 then
execute immediate drop4;
dbms_output.put_line('La table Ship se ha eliminado correctamente');
end if;
select count(*) into contador from tab where tname=upper('Planet');
if contador=1 then
execute immediate drop5;
dbms_output.put_line('La table Planet se ha eliminado correctamente');
end if;
select count(*) into contador from tab where tname=upper('Battle');
if contador=1 then
execute immediate drop6;
dbms_output.put_line('La table Battle se ha eliminado correctamente');
end if;
select count(*) into contador from tab where tname=upper('Enemie');
if contador=1 then
execute immediate drop8;
dbms_output.put_line('La table Enemie se ha eliminado correctamente');
end if;
select count(*) into contador from tab where tname=upper('User_PW');
if contador=1 then
execute immediate drop7;
dbms_output.put_line('La table User_PW se ha eliminado correctamente');
end if;
dbms_output.put_line('');
end;

/

set SERVEROUTPUT ON;
begin
drop_table();
end;