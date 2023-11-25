------------------------ Parcoures des formations : nbPlaces && Activités  --------------------------------------------

-- nombre de réservation pour chaque formtion : ----> nbPlaceReserv
DROP VIEW  nbPlaceReserv ;

CREATE VIEW nbPlaceReserv AS
SELECT Formation.annee , Formation.numero ,nom , COUNT(*) as nombreRéservation 
FROM concerneFormation , Formation 
WHERE 
Formation.annee = concerneFormation.annee  AND Formation.numero= concerneFormation.numero
GROUP BY Formation.annee , Formation.numero ,nom ;

-- SELECT * FROM nbPlaceReserv 
-- nombre de places disponibles pour chaque formation : ---->  nbRestantFormation
DROP VIEW  nbRestantFormation ; 

CREATE VIEW nbRestantFormation AS
SELECT Formation.annee , Formation.numero ,Formation.nom , Formation.nbrPlace - nbPlaceReserv.nombreRéservation AS nbrRestant
FROM Formation , nbPlaceReserv
WHERE Formation.annee = nbPlaceReserv.annee AND Formation.numero =  nbPlaceReserv.numero 
;

-- SELECT * FROM nbRestantFormation 
 
--- 

SELECT  DISTINCT Formation.annee  , Formation.numero , Formation.nom , nomActivité  , dateDem , duree  , nbrRestant
FROM Formation ,proposeActivitéForm , nbRestantFormation
WHERE 
Formation.numero = proposeActivitéForm.numero AND Formation.annee = proposeActivitéForm.annee AND 
Formation.numero = nbRestantFormation.numero AND Formation.annee = nbRestantFormation.annee AND 
nbRestantFormation.numero = proposeActivitéForm.numero AND nbRestantFormation.annee = proposeActivitéForm.annee 
ORDER BY Formation.annee , Formation.numero , nom;