create or replace procedure get_planet (usuario in varchar2,nombre in out varchar2,attack in out number,defense in out number,deuterium in out number, crystal in out number, metal in out number)
is
id_usu number;
begin
select id_user into id_usu from user_pw where username=usuario;
select planet_name,technology_attack,technology_defense,deuterium_quantity,crystal_quantity,metal_quantity into nombre,attack,defense,deuterium,crystal,metal from planet where id_user=id_usu;
end;
/
declare
nombre varchar2(100);
a number;
d number;
deu number;
crys number;
metal number;
begin
get_planet('brahian',nombre,a,d,deu,crys,metal);
dbms_output.put_line(nombre||','||a||','||d||','||deu||','||crys||','||metal);
end;