create or replace procedure get_planet (usuario in varchar2,nombre in out varchar2,attack in out number,defense in out number,deuterium in out number, crystal in out number, metal in out number)
is
id_usu number;
begin
select id_user into id_usu from user_pw where username=usuario;
select planet_name,technology_attack,technology_defense,deuterium_quantity,crystal_quantity,metal_quantity into nombre,attack,defense,deuterium,crystal,metal from planet where id_user=id_usu;
exception
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;
