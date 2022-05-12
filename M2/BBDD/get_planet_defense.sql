create or replace procedure get_planet_defense (nom in user_pw.username%type, id_d in out planet_defense.id_defense%type, cant in out planet_defense.quantity%type,lvl_d in out planet_defense.lvl_defense%type,lvl_a in out planet_defense.lvl_attack%type)
is
id_u number;
id_p number;
begin
select id_user into id_u from user_pw where username = nom;
select id_planet into id_p from planet where id_user = id_u;
select * into id_d, cant,lvl_d,lvl_a from (select id_defense,quantity,lvl_defense,lvl_attack from planet_defense) where rownum=1;
delete from planet_defense where id_planet=id_p and id_defense=id_d;
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