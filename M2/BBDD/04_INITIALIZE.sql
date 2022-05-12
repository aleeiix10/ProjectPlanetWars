create or replace procedure INITIALIZE (reset_button boolean) 
is
existe number;
contador int := 0;
existe_excep EXCEPTION;
begin
select count(*) into existe from tab where tname=upper('Planet_Ship');
if existe= 1 then
          contador := contador +1;
          existe := 0;
end if;
select count(*) into existe from tab where tname=upper('Planet_Defense');
if existe= 1 then
          contador := contador +1;
          existe := 0;
end if;
select count(*) into existe from tab where tname=upper('Defense');
if existe= 1 then
          contador := contador +1;
          existe := 0;
end if;
select count(*) into existe from tab where tname=upper('Ship');
if existe= 1 then
          contador := contador +1;
          existe := 0;
end if;
select count(*) into existe from tab where tname=upper('Planet');
if existe= 1 then
          contador := contador +1;
          existe := 0;
end if;
select count(*) into existe from tab where tname=upper('Battle');
if existe= 1 then
          contador := contador +1;
          existe := 0;
end if;
select count(*) into existe from tab where tname=upper('User_PW');
if existe= 1 then
          contador := contador +1;
end if;
select count(*) into existe from tab where tname=upper('Enemie');
if existe= 1 then
          contador := contador +1;
end if;

if contador != 8 or reset_button = true then
          drop_table;
          create_table;
          Insert_Data;
else
          raise existe_excep;
end if;

EXCEPTION
          WHEN NO_DATA_FOUND THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> no datos');
          WHEN too_many_rows THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> devuelve m�s de una fila');
          WHEN VALUE_ERROR THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> hay un error aritm�tico o de conversi�n');
          WHEN PROGRAM_ERROR THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> hay un problema interno en la ejecuci�n del programa');
          WHEN existe_excep THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> YA EXISTE LA BASE DE DATOS');
          WHEN OTHERS THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR -->HA HABIDO UN ERROR ');
end;
/

set SERVEROUTPUT ON;
begin
INITIALIZE(true);
end;
