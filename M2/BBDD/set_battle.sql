create or replace procedure set_battle (usern in varchar2,cap_m in number,cap_d in number,cae_m in number,
cae_d in number,waste_m in number, waste_d in number,lap_m in number,lap_d in number,lap_w in number,lae_m in number,lae_d in number,lae_w in number,
battle_rep1 in varchar2,battle_rep2 in varchar2,battle_rep3 in varchar2,battle_rep4 in varchar2)
is
existe number;
id_u number;
max_id number;
no_existe exception;
numero number:=1;
begin
select count(*) into existe from user_pw where username=usern;
if existe=1 then
    select max(id_battle) into max_id from battle;
    select id_user into id_u from user_pw where username=usern;
    if max_id is null then
        execute immediate ' insert into Battle values('||numero||','||id_u||','||cap_m||','||cap_d||','||cae_m||','||cae_d||','||waste_m||','||waste_d||','||lap_m||','||lap_d||','||lap_w||','||lae_m||','||lae_d||','||lae_w||','||battle_rep1||','||battle_rep2||','||battle_rep3||','||battle_rep4||')';
    else
e       execute immediate 'insert into Battle values(''||max_id||','||id_u||','||cap_m||','||cap_d||','||cae_m||','||cae_d||','||waste_m||','||waste_d||','||lap_m||','||lap_d||','||lap_w||','||lae_m||','
        ||lae_d||','||lae_w||','||battle_rep1||','||battle_rep2||','||battle_rep3||','||battle_rep4||')';    
    end if;
else
    raise no_existe;
end if;
exception 
when no_existe then dbms_output.put_line('No existe este usuario');
end;
/
begin
set_battle('brahian',10,20,30,40,50,60,70,80,90,100,111,120,'di','gamos','x','d');
end;
