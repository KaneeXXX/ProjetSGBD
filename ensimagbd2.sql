CREATE TABLE REFUGE (
   EMAIL VARCHAR(50) PRIMARY KEY,
   NOM VARCHAR(50),
   NUMTEL INT,
   SECGEO VARCHAR(50),
   DATEOUV DATE,
   DATEFERME DATE,
   NBrREPAS INT,
   TEXTE VARCHAR(50),
   TYPePAYEMENT VARCHAR(20),
   PRIxNUITE DECIMAL,
   PRIX DECIMAL
);

CREATE TABLE PROPOSE_REPAS (
   EMAIL REFERENCES REFUGE(EMAIL),
   TYPeREPAS VARCHAR(20),
   PRIMARY KEY (EMAIL, TYPeREPAS),
   PRIX DECIMAL
);

CREATE TABLE RESERVATION_REFUGE (
   ID INT PRIMARY KEY,
   DATE_RESERVATION DATE,
   HEURE HOUR,
   REFUGE VARCHAR(50),
   IdMEMBReRESERVE INT,
   NBrNUITS INT,
   NBrREPAsRESERVE INT,
   PRIxTOTAL DECIMAL,
);

CREATE TABLE LOCATION_MATERIEL (
   ID INT PRIMARY KEY,
   IdADHERENT INT,
   NbPIECEsRESERV INT,
   DATeRECUP DATE,
   DATeRETOUR DATE, 
   NbPIECEsPERDUES INT
);

CREATE TABLE COMPTE_UTILISATEUR (
   IdUSER INT PRIMARY KEY,
   COUtRESERV DECIMAL,
   SOMMeMATERIElABIME DECIMAL,
   SOMMeREMBOURSEE DECIMAL
);

CREATE TABLE RESERVATION_FORMATION (
   ID INT PRIMARY KEY,
   IdADHERENT INT,
   FORMATIOnINSCRITE VARCHAR(50)
);

CREATE TABLE A_LISTE_ATTENTE (
   IdADHERENT REFERENCES RESERVATION_FORMATION(IdADHERENT),
   IdFORMATION REFERENCES RESERVATION_FORMATION(ID) ,
   PRIMARY KEY (IdADHERENT, IdFORMATION),
   RANG INT
);

CREATE TABLE FORMATION (
   NUMERO INT,
   ANNEE YEAR,
   PRIMARY KEY (NUMERO, ANNEE),
   NOM VARCHAR(50),
   DATeDEM DATE,
   DUREE INT,
   NBrPLACE INT,
   DESC VARCHAR(50),
   PRIX DECIMAL,
   NBrACTIVITE INT
);

CREATE TABLE ACTIVITE (
   NOmACTIVITE VARCHAR(50)
);

CREATE TABLE PROPOSE_ACTIVITE_FORM (
   NUMERO REFERENCES FORMATION(NUMERO),
   ANNEE REFERENCES FORMATION(ANNEE),
   NOmACTIVITE REFERENCES ACTIVITE(NomACTIVITE),
   PRIMARY KEY (NUMERO, ANNEE, NOmACTIVITE)
   
);
   
   
   





























   
   

    
