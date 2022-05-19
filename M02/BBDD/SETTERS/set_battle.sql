create or replace procedure set_battle (usern in varchar2,cap_m in number,cap_d in number,cae_m in number,
cae_d in number,waste_m in number, waste_d in number,lap_m in number,lap_d in number,lap_w in number,lae_m in number,lae_d in number,lae_w in number,
battle_rep1 in varchar2,battle_rep2 in varchar2,battle_rep3 in varchar2,battle_rep4 in varchar2,id_batt in out number)
is
existe number;
id_u number;
max_id number;
no_existe exception;
begin
select count(*) into existe from user_pw where username=usern;
if existe=1 then
    select max(id_battle) into max_id from battle;
    select id_user into id_u from user_pw where username=usern;
    if max_id is null then
        insert into Battle values(1,id_u,cap_m,cap_d,cae_m,cae_d,waste_m,waste_d,lap_m,lap_d,lap_w,lae_m,lae_d,lae_w,battle_rep1,battle_rep2,battle_rep3,battle_rep4);
        id_batt:=1;
    else
        insert into Battle values(max_id+1,id_u,cap_m,cap_d,cae_m,cae_d,waste_m,waste_d,lap_m,lap_d,lap_w,lae_m,lae_d,lae_w,battle_rep1,battle_rep2,battle_rep3,battle_rep4);
        id_batt:=max_id+1;
    end if;
else
    raise no_existe;
end if;
exception 
when no_existe then dbms_output.put_line('No existe este usuario');
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;

