create or replace procedure search_id_battle(nom varchar2,pelea number,id_bat in out number)
is
id_u number;
cursor c1 is select * FROM battle where id_user = id_u order by id_battle;
linea c1%rowtype;
c number:=0;
begin
select id_user into id_u from user_pw where username = nom;
open c1;
loop
c:=c+1;
fetch c1 into linea;
id_bat:=linea.id_battle;
exit when c=pelea;
end loop;
close c1;
end;