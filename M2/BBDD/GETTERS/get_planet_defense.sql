create or replace procedure get_planet_defense (nom in user_pw.username%type, id_d in out planet_defense.id_defense%type, cant in out planet_defense.quantity%type,lvl_d in out planet_defense.lvl_defense%type,lvl_a in out planet_defense.lvl_attack%type)
is
id_u number;
id_p number;
begin
select id_user into id_u from user_pw where username = nom;
select id_planet into id_p from planet where id_user = id_u;
select * into id_d, cant,lvl_d,lvl_a from (select id_defense,quantity,lvl_defense,lvl_attack from planet_defense) where rownum=1;
delete from planet_defense where id_planet=id_p and id_defense=id_d;
exception
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;
/
declare
d number;
c number;
ld number;
la number;
begin
get_planet_defense('brahian',d,c,ld,la);
end;