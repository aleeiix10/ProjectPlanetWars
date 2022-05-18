create or replace procedure get_battle (nom in varchar2, id_row in number, cap_m in out number,cap_d in out number,cae_m in out number,
cae_d in out number,wm in out number, wd in out number,lap_m in out number,lap_d in out number,lap_w in out number,lae_m in out number,lae_d in out number,lae_w in out number,
bd1 in out varchar2,bd2 in out varchar2,bd3 in out varchar2,bd4 in out varchar2)
is
existe number;
id_u number;
cursor c1 is select * FROM battle where id_user = id_u order by id_battle;
linea c1%rowtype;
c number:=0;
no_existe_usuario exception;
begin
select count(*) into existe from user_pw where username = nom;
if existe=1 then
select id_user into id_u from user_pw where username = nom;
open c1;
loop
c:=c+1;
fetch c1 into linea;
cap_m:=linea.cap_metal;
cap_d:=linea.cap_deuterium;
cae_m:=linea.cae_metal;
cae_d:=linea.cae_deuterium;
wm:=linea.waste_metal; 
wd:=linea.waste_deuterium;
lap_m:=linea.lap_metal; 
lap_d:=linea.lap_deuterium;
lap_w:=linea.lap_weighted;
lae_m:=linea.lae_metal;
lae_d:=linea.lae_deuterium;
lae_w:=linea.lae_weighted; 
bd1:=linea.battle_development1;
bd2:=linea.battle_development2; 
bd3:=linea.battle_development3;
bd4:=linea.battle_development4;
exit when c=id_row;
end loop;
close c1;
else
    raise no_existe_usuario;
end if;
exception
when no_existe_usuario then dbms_output.put_line('EL usuario no existe');
when no_data_found then dbms_output.put_line('error --> no datos');
when too_many_rows then dbms_output.put_line('error --> devuelve mas de una fila');
when value_error then dbms_output.put_line('error --> hay un error aritmetico o de conversion');
when program_error then dbms_output.put_line('error --> hay un problema interno en la ejecucion del programa');
when others then dbms_output.put_line('error -->ha habido un error ');
end;
