create or replace procedure get_attack_unities (id_ba in number,id_rownum in number,id_s in out number,inicio in out number, acaba in out number, team in out varchar2)
is
existe number;
c number:=0;
cursor c1 is select * from attack_unities where id_battle=id_ba order by id_battle;
linea c1%rowtype;
no_existe_battle exception;
begin
select count(*) into existe from battle where id_battle=id_ba;
if existe=1 then
   open c1;
   loop
   c:=c+1;
   fetch c1 into linea;
   id_s:=linea.id_ship;
   inicio:=linea.start_unities;
   acaba:=linea.end_unities;
   team:=linea.team;
   exit when c=id_rownum;
   end loop;
   close c1;
else
    raise no_existe_battle;
end if;
exception
when no_existe_battle then dbms_output.put_line('La batalla indicada no existe');
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;
/
set serveroutput on;
declare
ship number;
inicio number;
acaba number;
team varchar2(45);
begin
get_attack_unities(1,2,ship,inicio,acaba,team);
dbms_output.put_line(ship||','||inicio||','||acaba||','||team);
end;