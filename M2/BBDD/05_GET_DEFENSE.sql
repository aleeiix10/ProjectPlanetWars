create or replace procedure GET_DEFENSE (id in number,nombre in out varchar2, metal in out number, cristal in out number, deuterium in out number, initialar in out number, armor in out number, danyo in out number, 
velo in out number, generate in out number)
is
existe number;
no_existe exception;
begin
select count(*) into existe from defense where id_defense=id;
if existe=1 then
    select defense_name, metal_cost, crystal_cost, deuterium_cost, initialarmor, armor, basedamage, speed, generate_wastings into nombre,metal,cristal,deuterium, initialar,armor,danyo,velo,generate from defense 
    where id_defense=id;
else
  raise no_existe; 
end if;
exception
when no_existe then dbms_output.put_line('The indicated defense does not exist');
end;
/
set serveroutput on;
declare
nombre varchar2(50);
metal number;
cristal number;
deuterium number;
initialar number;
armor number;
danyo number;
velo number;
generate number;
begin
get_defense(1,nombre,metal,cristal,deuterium,initialar,armor,danyo,velo,generate);
dbms_output.put_line(nombre||','||metal||','||cristal||','||deuterium||','||initialar||','||armor||','||danyo||','||velo||','||generate);
end;