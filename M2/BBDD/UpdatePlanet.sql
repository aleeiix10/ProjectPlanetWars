create or replace procedure update_planet(usu in varchar2,atack in number, defense in number,deut in number,metal in number)
is
id_u number;
begin
select id_user into id_u from user_pw where username=usu;
update planet set technology_attack=atack,technology_defense=defense,deuterium_quantity=deut,metal_quantity=metal where id_user=id_u;
end;
/
begin
update_planet('Admin2020',4,6,10000,3000);
end;