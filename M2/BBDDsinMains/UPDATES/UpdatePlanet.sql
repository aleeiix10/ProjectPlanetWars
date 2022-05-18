create or replace procedure update_planet(usu in varchar2,atack in number, defense in number,deut in number,metal in number)
is
id_u number;
begin
select id_user into id_u from user_pw where username=usu;
update planet set technology_attack=atack,technology_defense=defense,deuterium_quantity=deut,metal_quantity=metal where id_user=id_u;
exception
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;