create or replace procedure set_attack_unities(id_batt in number,id_sh in number,inicio in number, acabar in number, team in varchar2)
is
existe_b number;
existe_sh number;
no_existe_battle exception;
no_existe_ship exception;
begin
select count(*) into existe_b from battle where id_battle=id_batt;
if existe_b=1 then
    select count(*)into existe_sh from ship where id_ship=id_sh;
    if existe_sh=1 then
        insert into attack_unities values (id_batt,id_sh,inicio,acabar,team);
    else
        raise no_existe_ship;
    end if;
else
    raise no_existe_battle;
end if;
exception
when no_existe_battle then dbms_output.put_line('No hay ninguna batalla con ese id');
when no_existe_ship then dbms_output.put_line('No hay ningun ship con ese id');
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;
