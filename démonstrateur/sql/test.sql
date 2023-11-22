-- Table Email :

CREATE TABLE membreNebil
(   Email  VARCHAR(50) ,
    motdepasse VARCHAR(50) UNIQUE ,
    
    PRIMARY KEY (Email)
);


INSERT INTO membreNebil (Email , motdepasse)
VALUES 
('kh@gamil.com' , 'kh223');

INSERT INTO membreNebil (Email , motdepasse)
VALUES 
('nb@gamil.com' , 'nb003');


SELECT * FROM membreNebil ;

SELECT COUNT(*) as count FROM membre WHERE Email='kh@gamil.com' AND motdepasse='kh223';





-- 

CREATE TABLE Activite
(
    nomAc VARCHAR(50) PRIMARY KEY 
);


INSERT INTO Activite (nomAc) VALUES ('Ac1');
INSERT INTO Activite (nomAc) VALUES ('Ac2');
INSERT INTO Activite (nomAc) VALUES ('Ac3');
INSERT INTO Activite (nomAc) VALUES ('Ac4');

SELECT * FROM activite;





-- 

DROP TABLE Formation ;

CREATE TABLE Formation
(
    numero INT  ,
    annee INT ,
    nom VARCHAR(50) ,
    nbActivite INT ,
    
    PRIMARY KEY(numero , annee) 
);


INSERT INTO Formation (numero , annee , nom , nbactivite) VALUES (1,2023,'for1' , 2);
INSERT INTO Formation (numero , annee , nom , nbactivite) VALUES (2,2023,'for2' , 3);
INSERT INTO Formation (numero , annee , nom , nbactivite) VALUES (3,2023,'for1' , 4);


SELECT * FROM  Formation ;



-- 
DROP TABLE ActFor;

CREATE TABLE  ActFor
( 

    nomAct VARCHAR(50) ,
    annee INT ,
    numero INT , 
    
    PRIMARY KEY(nomAct , numero , annee) ,  

    FOREIGN KEY(nomAct) REFERENCES  Activite(nomAc) , 
    FOREIGN KEY(numero , annee) REFERENCES  Formation(numero , annee) 


);


INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac1', 2023 , 1);
INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac2', 2023 , 1);

INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac2', 2023 , 2);
INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac1', 2023 , 2);
INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac3', 2023 , 2);


INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac1', 2023 , 3);
INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac2', 2023 , 3);
INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac3', 2023 , 3);
INSERT INTO ActFor(nomAct , annee , numero)  VALUES ('Ac4', 2023 , 3);



SELECT * FROM ActFor ORDER BY numero ;






-- question :



SELECT nomAct , numero , annee FROM ActFor GROUP BY nomact ,annee , numero ;



