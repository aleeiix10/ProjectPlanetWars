create or replace procedure get_planet_ship (nom in user_pw.username%type, id_s in out planet_ship.id_ship%type, cant in out planet_ship.quantity%type,lvl_d in out planet_ship.lvl_defense%type,lvl_a in out planet_ship.lvl_attack%type)
is
id_u number;
id_p number;
begin
select id_user into id_u from user_pw where username = nom;
select id_planet into id_p from planet where id_user = id_u;
select * into id_s, cant,lvl_d,lvl_a from (select id_ship,quantity,lvl_defense,lvl_attack from planet_ship) where rownum=1;
delete from planet_ship where id_planet=id_p and id_ship=id_s;
end;
/
declare
d number;
c number;
ld number;
la number;
begin
get_planet_ship('brahian',d,c,ld,la);
end;