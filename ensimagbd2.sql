
CREATE TABLE REFUGE (
   EMAIL VARCHAR(50) PRIMARY KEY,
   NOM VARCHAR(50),
   NUMTEL INT,
   SECGEO VARCHAR(50),
   DATEOUV DATE,
   DATEFERME DATE,
   CHECK (DATEOUV < DATEFERME),
   NBrREPAS INT,
   CHECK (NBrREPAS >= 0),
   NBrDORMIR INT,
   CHECK (NBrDORMIR >=0),
   TEXTE VARCHAR(50),
   TYPePAYEMENT VARCHAR(20),
   CHECK (TYPePAYEMENT IN ('espèces','chèque', 'carte-bleue')),
   PRIxNUITE DECIMAL,
   CHECK ( PRIxNUITE >= 0),
   PRIX DECIMAL
);

CREATE TABLE REPAS (
    TYPeREPAS VARCHAR(20) PRIMARY KEY,
    CHECK ( TYPeREPAS IN ('déjeuner', 'dîner', 'souper', 'casse-croûte'))
);
CREATE TABLE PROPOSE_REPAS (
   EMAIL REFERENCES REFUGE(EMAIL),
   TYPeREPAS REFERENCES REPAS(TYPeREPAS),
   PRIMARY KEY (EMAIL, TYPeREPAS),
   PRIX DECIMAL,
   CHECK (PRIX >= 0)
);

CREATE TABLE RESERVATION_REFUGE (
   ID INT PRIMARY KEY,
   DATE_RESERVATION DATE,
   --- Il faudrait trouver le moyen de rajouter la contrainte 
   --- DATE_RESERVATION ENTRE DATeOUV et DATeFERM
   HEURE INT,
   REFUGE VARCHAR(50),
   IdMEMBReRESERVE INT,
   NBrNUITS INT,
   CHECK (NBrNUITS >= 0),
   NBrREPAsRESERVE INT,
   CHECK (NBrREPAsRESERVE >= 0),
   PRIxTOTAL DECIMAL,
   CHECK (PRIxTOTAL > 0),
   IdUSER INT,
   EMAIL VARCHAR(50),
   FOREIGN KEY (IdUSER) REFERENCES COMPTE_UTILISATEUR(IdUSER),
   FOREIGN KEY (EMAIL) REFERENCES REFUGE(EMAIL),
   CHECK (NBrREPAsRESERVE <> 0 OR NBrNUITS <> 0)
);

CREATE TABLE LOCATION_MATERIEL (
   IdLOcMATERIEL INT PRIMARY KEY,
   IdADHERENT INT,
   NbPIECEsRESERV INT,
   DATeRECUP DATE,
   DATeRETOUR DATE,
   CHECK (DATeRETOUR < DATeRECUP + 14),
   NbPIECEsPERDUES INT,
   FOREIGN KEY (IdUSER) REFERENCES COMPTE_UTILISATEUR(IdUSER)
);

CREATE TABLE COMPTE_UTILISATEUR (
   IdUSER INT PRIMARY KEY,
   COUtRESERV DECIMAL,
   SOMMeMATERIElABIME DECIMAL,
   SOMMeREMBOURSEE DECIMAL
);


CREATE TABLE MEMBRE (
    EMAIlMEMBRE VARCHAR(70),
    MOTDEPASSE VARCHAR(50),
    PRIMARY KEY (EMAIlMEMBRE, MOTDEPASSE),
    NOM VARCHAR(50),
    PRENOM VARCHAR(50),
    ADrPOST VARCHAR(50),
    IdUSER INT,
    FOREIGN KEY (IdUSER) REFERENCES COMPTE_UTILISATEUR(IdUSER)
);




CREATE TABLE ADHERENT (
    IdADHERENT INT PRIMARY KEY,
    EMAIlMEMBRE VARCHAR(70),
    MOTDEPASSE VARCHAR(50),
    NOM VARCHAR(50), 
    PRENOM VARCHAR(50),
    ADrPOST VARCHAR(50),
    IdUSER INT,
    FOREIGN KEY (EMAIlMEMBRE, MOTDEPASSE) REFERENCES MEMBRE(EMAIlMEMBRE, MOTDEPASSE)
);

CREATE TABLE RESERVATION_FORMATION (
   ID INT PRIMARY KEY,
   IdADHERENT INT,
   FORMATIOnINSCRITE VARCHAR(50),
   RANG INT,
   IdUSER INT,
   NUMERO INT, 
   ANNEE INT,
   FOREIGN KEY (IdUSER) REFERENCES COMPTE_UTILISATEUR(IdUSER),
   FOREIGN KEY (NUMERO, ANNEE) REFERENCES FORMATION(NUMERO, ANNEE)
);

CREATE TABLE FORMATION (
   NUMERO INT,
   ANNEE INT,
   PRIMARY KEY (NUMERO, ANNEE),
   NOM VARCHAR(50),
   DATeDEM DATE,
   CHECK (YEAR(DATeDEM) =ANNEE),
   DUREE INT,
   CHECK (DUREE >= 0),
   NBrPLACE INT,
   CHECK (NBrPLACE >=0),
   DESCRIPT VARCHAR(50),
   PRIX DECIMAL,
   CHECK (PRIX >= 0),
   NBrACTIVITE INT
);


CREATE TABLE ACTIVITE (
   NOmACTIVITE VARCHAR(50) PRIMARY KEY,
   CHECK (NOmACTIVITE IN ('randonnée', 'escalade', 'alpinisme', 'spéologie', 'ski de rando', 'cascade de glace'))
);

CREATE TABLE PROPOSE_ACTIVITE_FORM (
   NUMERO INT,
   ANNEE INT,
   NOmACTIVITE VARCHAR(50),
   FOREIGN KEY (NUMERO, ANNEE) REFERENCES FORMATION(NUMERO, ANNEE),
   FOREIGN KEY (NOmACTIVITE) REFERENCES ACTIVITE(NomACTIVITE),
   PRIMARY KEY (NUMERO, ANNEE, NOmACTIVITE)

);

CREATE TABLE COMPATIBLE_AVEC_ACTIVITE (
    MARQUE VARCHAR(50),
    MODELE VARCHAR(50),
    ANNEeACHAT INT,
    NOmACTIVITE VARCHAR(50),
    FOREIGN KEY (NOmACTIVITE) REFERENCES ACTIVITE(NOmACTIVITE),
    FOREIGN KEY (MARQUE, MODELE, ANNEeACHAT) REFERENCES LOT(MARQUE, MODELE, ANNEeACHAT),
    
    PRIMARY KEY (MARQUE, MODELE, ANNEeACHAT, NOmACTIVITE)
);

CREATE TABLE LOT (
    MARQUE VARCHAR(50),
    MODELE VARCHAR(50),
    ANNEeACHAT INT,
    NbPIECES INT,
    CHECK (NbPIECES >= 0),
    PRIxPERTE DECIMAL,
    CHECK (PRIxPERTE >=0),
    TEXTE VARCHAR(100),
    ANNEePEREMPTION INT,
    CHECK (ANNEePEREMPTION >= 1970),
    PRIMARY KEY (MARQUE, MODELE, ANNEeACHAT),
    SOUsCATEGORIE VARCHAR(50),
    FOREIGN KEY (SOUsCATEGORIE) REFERENCES ABRE(SOUsCATEGORIE)
);
￼
/*
CREATE TABLE EST_LOUE (
    MARQUE REFERENCES LOT(MARQUE),
    MODELE REFERENCES LOT(MODELE),
    ANNEeACHAT REFERENCES LOT(ANNEeACHAT),
    IdLOcMATERIEL REFERENCES LOCATION_MATERIEL(IdLOcMATERIEL),
    NBrPIECEsLOUEES INT,
    PRIMARY KEY (MARQUE, MODELE, ANNEeACHAT, IdLOcMATERIEL)
);
*/ 

CREATE TABLE ABRE (
    SOUsCATEGORIE VARCHAR(50) PRIMARY KEY
);

CREATE TABLE EST_PARENT_DE (
    SOUsCATEGORIE VARCHAR(50) PRIMARY KEY,
    FOREIGN KEY (SOUsCATEGORIE) REFERENCES ABRE(SOUsCATEGORIE),
    CATERGORIE VARCHAR NULL,
    CONSTRAINT PARENTE FOREIGN KEY (CATERGORIE) REFERENCES EST_PARENT_DE(SOUsCATEGORIE)
);


