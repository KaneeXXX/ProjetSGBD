-- Test pour le parcour de matériels  :


CREATE TABLE  Lot
(
    marque VARCHAR(50),
    modele VARCHAR(50) ,
    anneeAchat VARCHAR(50) ,
    nbPieces INT , 

    PRIMARY KEY(marque , modele , anneeAchat)

);



CREATE  TABLE Arbre
(
    sousCategorie VARCHAR(50) ,
    categorie VARCHAR(50) 
);


CREATE TABLE EstParentDe 
(
    sousCategorie1 VARCHAR(50) ,
    sousCategorie2 VARCHAR(50) ,

    FOREIGN KEY(sousCategorie1) REFERENCES Arbre(sousCategorie)

);