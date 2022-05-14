create or replace procedure set_defense_unities(id_batt in number,id_de in number,inicio in number, acabar in number)
is
existe_b number;
existe_d number;
no_existe_battle exception;
no_existe_defense exception;
begin
select count(*) into existe_b from battle where id_battle=id_batt;
if existe_b=1 then
    select count(*)into existe_d from defense where id_defense=id_de;
    if existe_d=1 then
        insert into defense_unities values (id_batt,id_de,inicio,acabar);
    else
        raise no_existe_defense;
    end if;
else
    raise no_existe_battle;
end if;
exception
when no_existe_battle then dbms_output.put_line('No hay ninguna batalla con ese id');
when no_existe_defense then dbms_output.put_line('No hay ninguna defense con ese id');
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;
/
set serveroutput on;
begin
set_defense_unities(1,1,4,3);
end;