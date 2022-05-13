create or replace procedure log_in (nom user_pw.username%type, pass user_pw.password%type, bolean in out number)
as
existe int;
contra user_pw.password%type;
begin
select count(username) into existe from user_pw where username = nom;
if existe = 1 then
          select password into contra from user_pw where username = nom;
          if contra = pass then
                bolean:=1;
          else
                bolean:=0;
          end if;
else
    bolean:=0;
end if;

EXCEPTION
          WHEN NO_DATA_FOUND THEN
                    bolean:=0;
          WHEN too_many_rows THEN
                    bolean:=0;
          WHEN VALUE_ERROR THEN
                    bolean:=0;
          WHEN PROGRAM_ERROR THEN
                    bolean:=0;
          WHEN OTHERS THEN
                    bolean:=0;
end;
          