-- -----------------------------------------------------
-- User PLANET_WARS
-- -----------------------------------------------------
/*alter session set "_ORACLE_SCRIPT"=true;
CREATE USER PLANET_WARS IDENTIFIED BY PLANET_WARS;
GRANT ALL PRIVILEGES TO PLANET_WARS;
COMMIT;	*/


-- -----------------------------------------------------
-- Table User_PW
-- -----------------------------------------------------
CREATE TABLE  User_PW (
          ID_User INT NOT NULL PRIMARY KEY,
          Username VARCHAR(45) NOT NULL UNIQUE,
          Birth_Date DATE NOT NULL,
          Password VARCHAR(45) NOT NULL
);

-- -----------------------------------------------------
-- Table Planet
-- -----------------------------------------------------
CREATE TABLE Planet (
          ID_Planet INT NOT NULL  PRIMARY KEY,
          Planet_Name VARCHAR(45) NOT NULL UNIQUE,
          Technology_Attack INT NOT NULL,
          Techonology_Defense INT NOT NULL,
          Deuterium_Quantity INT NOT NULL,
          Crystal_Quantity INT NOT NULL,
          Metal_Quantity INT NOT NULL,
          ID_User INT NOT NULL,
          FOREIGN KEY (ID_User) REFERENCES User_PW (ID_User)
);

-- -----------------------------------------------------
-- Table Ship
-- -----------------------------------------------------

CREATE TABLE Ship (
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
);

-- -----------------------------------------------------
-- Table Defense
-- -----------------------------------------------------
CREATE TABLE Defense (
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
);

-- -----------------------------------------------------
-- Table Battle
-- -----------------------------------------------------
CREATE TABLE Battle (
          ID_Battle INT NOT NULL PRIMARY KEY,
          ID_User INT NOT NULL,
          Start_Unities INT NOT NULL,
          End_Unities INT NOT NULL,
          ID_User INT NOT NULL,
          FOREIGN KEY (ID_User) REFERENCES User_PW (ID_User)
);

-- -----------------------------------------------------
-- Table Planet_has_Ship
-- -----------------------------------------------------
CREATE TABLE Planet_has_Ship (
          ID_Planet INT NOT NULL,
          ID_Ship INT NOT NULL,
          Quantity INT NOT NULL,
          FOREIGN KEY (ID_Planet) REFERENCES Planet (ID_Planet),
          FOREIGN KEY (ID_Ship) REFERENCES Ship (ID_Ship),
          PRIMARY KEY (ID_Planet, ID_Ship)
);

-- -----------------------------------------------------
-- Table Planet_has_Defense
-- -----------------------------------------------------
CREATE TABLE Planet_has_Defense (
          ID_Planet INT NOT NULL,
          ID_Defense INT NOT NULL,
          Quantity INT NOT NULL,
          FOREIGN KEY (ID_Planet) REFERENCES Planet (ID_Planet),
          FOREIGN KEY (ID_Defense) REFERENCES Defense (ID_Defense),
          PRIMARY KEY (ID_Planet, ID_Defense)
);