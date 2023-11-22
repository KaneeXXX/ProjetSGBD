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
SELECT nomActivité FROM proposeActivitéForm WHERE  


SELECT nom ,  FROM Formation ORDER BY annee,num,nom

SELECT * FROM Formation ORDER BY annee,nom



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


