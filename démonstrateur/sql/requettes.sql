-- Analyse  des fonctionnalités :


-- 1er fonctionnalite : Connexion d'un memebre à l'application : connexionMemebre()

/*

--------------------------------------- Connexion : --------------------------------------------------

*/

SELECT COUNT(*) as count FROM memebre WHERE email=? AND motdepasse=?   :





/*

--------------------------------------- Parcoures  : --------------------------------------------------

*/





/*
-------------------------- parcoures des formations : --------------------------------
*/


-- sélection des activités 




-- nomvre de formation réservers :
CREATE VIEW tabNbPlaceReservFormation AS 
SELECT  Formation.annee , Formation.numero  ,  Formation.nbPlace - COUNT(*)   AS nombreReservForm  FROM concerneFormation , Formation 
WHERE Formation.annee = concerneFormation.annee AND Formation.numero = concerneFormation.annee 
GROUP BY Formation.annee , Formation.numero   ;



-- on sélectionn  pour chaque formation(annee , numero) :  ---> nom , Noms_ACtivtés , DateDem , duree , nbPlace Init ;  

CREATE VIEW  infoFormation AS 
SELECT  Formation.annee  , Formation.numero , Formation.nom , nomAct , dateDem , duree , nbPlace  FROM Formation ,ActFor 
WHERE Formation.numero = ActFor.numero AND Formation.annee = ActFor.annee ORDER BY Formation.annee , Formation.numero , nom;



-- Résultat démande : 

SELECT  infoFormation.annee  , infoFormation.numero , infoFormation.nom , nomAct , dateDem , duree , nbPlace - nombreReservForm    
FROM tabNbPlaceReservFormation ,infoFormation 
WHERE infoFormation.numero = tabNbPlaceReservFormation.numero AND infoFormation.annee = tabNbPlaceReservFormation.annee 
ORDER BY Formation.annee , Formation.numero , nom;





/*
-------------------------- parcoures des matérieles   : --------------------------------
*/





/*
-------------------------- parcoures des refuges  : --------------------------------
*/


SELECT nom,dateOuv,dateFerme FROM Refuge



create view  nbrplacedispo as
    SELECT email, nbrDormir from Refuge ;

create view nbrplacereser as
    select refuge, count(*) as nbreser from RésérvationRefuge
     GROUP BY Refuge ;

select email,nbrplacedispo.nbrDormir -nbrplacereser.nbreser as nbrdispo from nbrplacedispo,nbrplacereser 
where nbrplacedispo.email = nbrplacereser.refuge;



create view  nbrplrepasrefuge as
    SELECT email, nbrRepas from Refuge ;

create view nbrrepasreser as
    select refuge, sum(nbrRepasReserve) as nbrepasreser from RésérvationRefuge
    GROUP BY Refuge ;

select email, nbrplrepasrefuge.nbrRepas - nbrrepasreser.nbrepasreser as nbReapsdispo from  nbrplrepasrefuge,nbrrepasreser
where nbrplrepasrefuge.email = nbrrepasreser.refuge;


