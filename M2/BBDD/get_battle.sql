create or replace procedure get_battle (id_row int, nom user_pw.username%type, id_b in out battle.id_battle%type, cap_m battle.cap
id_u in out number, su in out battle.start_unities%type, eu in out battle.end_unities%type, 
sue in out battle.start_unities_enemie%type, eue in out  battle.end_unities_enemie%type)

create or replace procedure set_battle (usern in varchar2,cap_m in number,cap_d in number,cae_m in number,
cae_d in number,waste_m in number, waste_d in number,lap_m in number,lap_d in number,lap_w in number,lae_m in number,lae_d in number,lae_w in number,
battle_rep1 in varchar2,battle_rep2 in varchar2,battle_rep3 in varchar2,battle_rep4 in varchar2)


is
begin
select id_user into id_u from user_pw where username = nom;
select id_battle, start_unities, end_unities, start_unities_enemie, end_unities_enemie into id_b, su, eu, sue, eue
from (select * FROM battle where id_user = id_u) where rownum = id_row;
end;

/*

set serveroutput on;
declare
id_b number;
id_u number;
su battle.start_unities%type;
eu battle.end_unities%type;
sue battle.start_unities_enemie%type;
eue battle.end_unities_enemie%type;
begin
get_battle (1, 'ADMIN', id_b,  id_u, su, eu, sue, eue);
DBMS_OUTPUT.PUT_LINE('ID_BATTLE: '||id_b||' ID_USER: '||id_u||' START_UNITIES: '||su||' END_UNITIES: '||eu||' START_UNITIES_ENEMIE: '||sue||' END_UNITES_ENEMIES: '||eue);
end;
*/
