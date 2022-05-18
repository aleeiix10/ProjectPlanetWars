create or replace procedure Insert_Data
is
begin
execute immediate ' insert into Ship values(1,''Light Hunter'',3000,0,50,400,400,80,3,20)';
execute immediate ' insert into Ship values(2,''Heavy Hunter'',6500,0,50,1000,1000,150,7,30)';
execute immediate ' insert into Ship values(3,''Battle Ship'',45000,0,7000,6000,6000,1000,45,60)';
execute immediate ' insert into Ship values(4,''Armored Ship'',30000,0,15000,8000,8000,700,70,75)';
execute immediate ' insert into Defense values (1,''Missile Launcher'',2000,0,0,200,200,80,5,10)';
execute immediate ' insert into Defense values (2,''Ion Cannon'',4000,0,500,1200,1200,250,12,25)';
execute immediate ' insert into Defense values (3,''Plasma Cannon'',50000,0,5000,7000,7000,2000,30,50)';
dbms_output.put_line('Se ha a�adido correctamente la informacion en las tablas SHIP y DEFENSE');
exception
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;

/

set serveroutput on;
begin
insert_data();
end;