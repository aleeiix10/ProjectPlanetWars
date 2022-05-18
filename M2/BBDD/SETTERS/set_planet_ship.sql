create or replace procedure set_planet_ship (nom user_pw.username%type, id_s  planet_ship.id_ship%type, cant planet_ship.quantity%type, lvl_d planet_ship.lvl_defense%type, lvl_a planet_ship.lvl_attack%type)
is
id_u int;
id_p int;
begin
select id_user into id_u from user_pw where username = nom;
select id_planet into id_p from planet where id_user = id_u;
execute immediate ' insert into planet_ship values('||id_p||','||id_s||','||cant||','||lvl_d||','||lvl_a||')';
exception
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;

/
begin
set_planet_ship('brahian',4,5,1,2);
end;