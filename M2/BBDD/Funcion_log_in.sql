create or replace function log_in (nom user_pw.username%type, pass user_pw.password%type) return BOOLEAN
as
existe int;
contra user_pw.password%type;
begin
select count(username) into existe from user_pw where username = nom;
if existe = 1 then
          select password into contra from user_pw where username = nom;
          if contra = pass then
                    return true;
          else
                    return false;
          end if;
else
          return false;
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
          WHEN OTHERS THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR -->HA HABIDO UN ERROR ');
end;
          