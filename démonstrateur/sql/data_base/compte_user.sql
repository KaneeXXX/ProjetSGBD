------------------------ Compte USER : -----------------------------


CREATE TABLE COMPTE_UTILISATEUR 
(
   IdUSER INT PRIMARY KEY,
   COUtRESERV DECIMAL,
   SOMMeMATERIElABIME DECIMAL,
   SOMMeREMBOURSEE DECIMAL
);


INSERT INTO COMPTE_UTILISATEUR(IdUSER) VALUES (1); 
INSERT INTO COMPTE_UTILISATEUR(IdUSER) VALUES (2); 
INSERT INTO COMPTE_UTILISATEUR(IdUSER) VALUES (3); 
INSERT INTO COMPTE_UTILISATEUR(IdUSER) VALUES (4); 
INSERT INTO COMPTE_UTILISATEUR(IdUSER) VALUES (5); 
INSERT INTO COMPTE_UTILISATEUR(IdUSER) VALUES (6); 
COMMIT ;

SELECT * FROM COMPTE_UTILISATEUR  ORDER BY Iduser ; 



CREATE TABLE MEMBRE (
   EMAIlMEMBRE VARCHAR(50) PRIMARY KEY,
   MDP VARCHAR(20),
   NOM VARCHAR(20),
   PRENOM VARCHAR(20),
   ADrPOST VARCHAR(30),
   IdUSER INT , 
   FOREIGN KEY(IdUSER) REFERENCES COMPTE_UTILISATEUR(IdUSER) -- Cardinalité 1..1
);

SELECT * FROM MEMBRE  ORDER BY Iduser; 

INSERT INTO MEMBRE(EMAIlMEMBRE , MDP ,NOM ,PRENOM , ADrPOST , IdUSER) VALUES ('user1@gmail.com' , '12345' , 'nom1' ,'Prenom1' , 'ADR1' , 1) ; 
INSERT INTO MEMBRE(EMAIlMEMBRE , MDP ,NOM ,PRENOM , ADrPOST , IdUSER) VALUES ('user2@gamil.com' , '01234' , 'nom2' ,'Prenom2' , 'ADR2' , 2) ; 
INSERT INTO MEMBRE(EMAIlMEMBRE , MDP ,NOM ,PRENOM , ADrPOST , IdUSER) VALUES ('user3@gamil.com' , '01234' , 'nom3' ,'Prenom3' , 'ADR3' , 3) ; 
INSERT INTO MEMBRE(EMAIlMEMBRE , MDP ,NOM ,PRENOM , ADrPOST , IdUSER) VALUES ('user4@gamil.com' , '01234' , 'nom4' ,'Prenom4' , 'ADR4' , 4) ; 
-- membre adhérant :
INSERT INTO MEMBRE(EMAIlMEMBRE , MDP , NOM ,PRENOM ,ADrPOST , IdUSER) VALUES('adh1@gmail.com','12345','Adh1','PrenomAdh1' ,'ADR_ADH 1' , 5);
INSERT INTO MEMBRE(EMAIlMEMBRE , MDP , NOM ,PRENOM ,ADrPOST , IdUSER) VALUES('adh2@gmail.com','12345','Adh2','PrenomAdh2' ,'ADR_ADH 2' , 6);

COMMIT ;


SELECT * FROM MEMBRE ; 


DROP TABLE ADHERENT ; 

CREATE TABLE ADHERENT 
(
    IdADHERENT INT PRIMARY KEY,
    EMAIlMEMBRE VARCHAR(50),
    MDP VARCHAR(20),
    NOM VARCHAR(50), 
    PRENOM VARCHAR(50),
    ADrPOST VARCHAR(50),
    IdUSER INT,
    FOREIGN KEY(IdUSER) REFERENCES COMPTE_UTILISATEUR(IdUSER) , 
    FOREIGN KEY(EMAIlMEMBRE ) REFERENCES  MEMBRE(EMAIlMEMBRE ) 

);

SELECT COUNT(*) as count FROM ADHERENT;


INSERT INTO ADHERENT(IdADHERENT , EMAIlMEMBRE , MDP , NOM ,PRENOM ,ADrPOST , IdUSER) VALUES(1 ,'adh1@gmail.com','12345','Adh1','PrenomAdh1' ,'ADR_ADH 1' , 5);
INSERT INTO ADHERENT(IdADHERENT , EMAIlMEMBRE , MDP , NOM ,PRENOM ,ADrPOST , IdUSER) VALUES(2 ,'adh2@gmail.com','12345','Adh2','PrenomAdh2' ,'ADR_ADH 2' , 6);

SELECT * FROM ADHERENT ; 
COMMIT ;



