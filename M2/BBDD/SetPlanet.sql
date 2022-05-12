create or replace procedure set_planet(nombre in varchar2,usuario in varchar2)
is
maximo number;
id_usu number;
deut number;
meta number;
begin
select max(id_planet) into maximo from planet;
select id_user into id_usu from user_pw where username=usuario;
select deuterium*0.94,metal*0.94 into deut,meta from enemie where id_user=id_usu;
if maximo is null then
    insert into planet values (1,initcap(nombre),0,0,deut,0,meta,id_usu);
else
    insert into planet values (maximo+1,initcap(nombre),0,0,deut,0,meta,id_usu);
end if;
end;
/
begin
set_planet('Tierra','Admin2020');
end;