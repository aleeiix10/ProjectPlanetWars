create or replace procedure CREATE_TABLE
is
existe number;
crear_User_PW varchar2(600);
crear_Planet varchar2(600);
crear_Ship varchar2(600);
crear_Defense varchar2(600);
crear_Battle varchar2(1000);
crear_Planet_Ship varchar2(600);
crear_Planet_Defense varchar2(600);
crear_Enemie varchar2(600);
crear_Attack_Unities varchar2(600);
crear_Defense_Unities varchar2(600);
begin

crear_User_PW := 'CREATE TABLE  User_PW (
          ID_User INT NOT NULL PRIMARY KEY,
          Username VARCHAR(45) NOT NULL UNIQUE,
          Birth_Date DATE NOT NULL,
          Password VARCHAR(45) NOT NULL
)';
crear_Planet :='CREATE TABLE Planet (
          ID_Planet INT NOT NULL  PRIMARY KEY,
          Planet_Name VARCHAR(45) NOT NULL UNIQUE,
          Technology_Attack INT NOT NULL,
          Technology_Defense INT NOT NULL,
          Deuterium_Quantity INT NOT NULL,
          Crystal_Quantity INT NOT NULL,
          Metal_Quantity INT NOT NULL,
          ID_User INT NOT NULL,
          FOREIGN KEY (ID_User) REFERENCES User_PW (ID_User)
)';
crear_Ship :='CREATE TABLE Ship (
          ID_Ship INT NOT NULL PRIMARY KEY,
          Ship_Name VARCHAR(45) NOT NULL UNIQUE,
          Metal_Cost INT NOT NULL,
          Crystal_Cost INT NOT NULL,
          Deuterium_Cost INT NOT NULL,
          InitialArmor INT NOT NULL,
          Armor INT NULL,
          BaseDamage INT NOT NULL,
          Speed INT NOT NULL,
          Generate_Wastings INT NOT NULL
)';
crear_Defense :='CREATE TABLE Defense (
          ID_Defense INT NOT NULL PRIMARY KEY,
          Defense_Name VARCHAR(45) NOT NULL UNIQUE,
          Metal_Cost INT NOT NULL,
          Crystal_Cost INT NOT NULL,
          Deuterium_Cost INT NOT NULL,
          InitialArmor INT NOT NULL,
          Armor INT NULL,
          BaseDamage INT NOT NULL,
          Speed INT NOT NULL,
          Generate_Wastings INT NOT NULL
)';
crear_Battle :='CREATE TABLE Battle (
          ID_Battle INT NOT NULL PRIMARY KEY,
          ID_User INT NOT NULL,
          CAP_Metal INT NOT NULL,
          CAP_Deuterium INT NOT NULL,
          CAE_Metal INT NOT NULL,
          CAE_Deuterium INT NOT NULL,
          Waste_Metal INT NOT NULL,
          Waste_Deuterium INT NOT NULL,
          LAP_Metal INT NOT NULL,
          LAP_Deuterium INT NOT NULL,
          LAP_Weighted INT NOT NULL,
          LAE_Metal INT NOT NULL,
          LAE_Deuterium INT NOT NULL,
          LAE_Weighted INT NOT NULL,
          Battle_Development1 varchar2(3999) NOT NULL,
          Battle_Development2 varchar2(3999) NOT NULL,
          Battle_Development3 varchar2(3999) NOT NULL,
          Battle_Development4 varchar2(3999) NOT NULL,
          FOREIGN KEY (ID_User) REFERENCES User_PW (ID_User)
)';
crear_Planet_Ship := 'CREATE TABLE Planet_Ship (
          ID_Planet INT NOT NULL,
          ID_Ship INT NOT NULL,
          Quantity INT NOT NULL,
          Lvl_Defense INT NOT NULL,
          Lvl_Attack INT NOT NULL,
          FOREIGN KEY (ID_Planet) REFERENCES Planet (ID_Planet),
          FOREIGN KEY (ID_Ship) REFERENCES Ship (ID_Ship),
          PRIMARY KEY (ID_Planet, ID_Ship)
)';
crear_Planet_Defense := 'CREATE TABLE Planet_Defense (
          ID_Planet INT NOT NULL,
          ID_Defense INT NOT NULL,
          Quantity INT NOT NULL,
          Lvl_Defense INT NOT NULL,
          Lvl_Attack INT NOT NULL,
          FOREIGN KEY (ID_Planet) REFERENCES Planet (ID_Planet),
          FOREIGN KEY (ID_Defense) REFERENCES Defense (ID_Defense),
          PRIMARY KEY (ID_Planet, ID_Defense)
)';
crear_Enemie := 'CREATE TABLE  Enemie (
          ID_User INT NOT NULL PRIMARY KEY,
          Deuterium INT NOT NULL,
          Metal INT NOT NULL,
          Fleet INT NOT NULL,
          FOREIGN KEY (ID_User) REFERENCES User_PW (ID_User)
)';
crear_Attack_Unities := 'CREATE TABLE  Attack_Unities (
        ID_Battle INT NOT NULL,
        ID_Ship INT NOT NULL,
        Start_Unities INT NOT NULL,
        End_Unities INT NOT NULL,
        Team VARCHAR(45) NOT NULL,
        FOREIGN KEY (ID_Battle) REFERENCES Battle (ID_Battle),
        FOREIGN KEY (ID_Ship) REFERENCES Ship (ID_Ship)
)';
crear_Defense_Unities := 'CREATE TABLE  Defense_Unities (
        ID_Battle INT NOT NULL,
        ID_Defense INT NOT NULL,
        Start_Unities INT NOT NULL,
        End_Unities INT NOT NULL,
        FOREIGN KEY (ID_Battle) REFERENCES Battle (ID_Battle),
        FOREIGN KEY (ID_Defense) REFERENCES Defense (ID_Defense)
)';
          
          
select count(*) into existe from tab where tname=upper('User_PW');
if existe = 0 then
          execute immediate crear_User_PW;
          dbms_output.put_line('Tabla User_PW creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Planet');
if existe= 0 then
          execute immediate crear_Planet;
          dbms_output.put_line('Tabla Planet creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Ship');
if existe= 0 then
          execute immediate crear_Ship;
          dbms_output.put_line('Tabla Ship creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Defense');
if existe= 0 then
          execute immediate crear_Defense;
          dbms_output.put_line('Tabla Defense creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Battle');
if existe= 0 then
          execute immediate crear_Battle;
          dbms_output.put_line('Tabla Battle creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Planet_Ship');
if existe= 0 then
          execute immediate crear_Planet_Ship;
          dbms_output.put_line('Tabla Planet_Ship creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Planet_Defense');
if existe= 0 then
          execute immediate crear_Planet_Defense;
          dbms_output.put_line('Tabla Planet_Defense creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Enemie');
if existe= 0 then
          execute immediate crear_Enemie;
          dbms_output.put_line('Tabla Enemie creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Attack_Unities');
if existe= 0 then
          execute immediate crear_Attack_Unities;
          dbms_output.put_line('Tabla Attack_Unities creada correctamente');
end if;

select count(*) into existe from tab where tname=upper('Defense_Unities');
if existe= 0 then
          execute immediate crear_Defense_Unities;
          dbms_output.put_line('Tabla Defense_Unities creada correctamente');
end if;

dbms_output.put_line('');

EXCEPTION
          WHEN NO_DATA_FOUND THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> no datos');
          WHEN too_many_rows THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> devuelve m�s de una fila');
          WHEN VALUE_ERROR THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> hay un error aritm�tico o de conversi�n');
          WHEN PROGRAM_ERROR THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> hay un problema interno en la ejecuci�n del programa');
end;

/

set SERVEROUTPUT ON;
begin
CREATE_TABLE();

EXCEPTION
          WHEN NO_DATA_FOUND THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> no datos');
          WHEN too_many_rows THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> devuelve m�s de una fila');
          WHEN VALUE_ERROR THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> hay un error aritm�tico o de conversi�n');
          WHEN PROGRAM_ERROR THEN
                    DBMS_OUTPUT.PUT_LINE('ERROR --> hay un problema interno en la ejecuci�n del programa');

end;