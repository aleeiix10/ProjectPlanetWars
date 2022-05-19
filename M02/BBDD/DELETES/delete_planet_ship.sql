create or replace procedure delete_planet_ship (nom user_pw.username%type)
is
id_u int;
id_p int;
begin
select id_user into id_u from user_pw where username = nom;
select id_planet into id_p from planet where id_user = id_u;
delete from planet_ship where id_planet = id_p;

EXCEPTION
          WHEN NO_DATA_FOUND THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> no datos');
          WHEN too_many_rows THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> devuelve m�s de una fila');
          WHEN VALUE_ERROR THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> hay un error aritm�tico o de conversi�n');
          WHEN PROGRAM_ERROR THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> hay un problema interno en la ejecuci�n del programa');
          WHEN OTHERS THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR -->HA HABIDO UN ERROR ');
end;

