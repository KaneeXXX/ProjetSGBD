DROP VIEW Reserve ;

CREATE VIEW  Reserve AS 
SELECT email , SUM(reserverefuge.nbrnuits) AS nbDormirReserv ,  SUM(ReserveRefuge.nbrRepas) AS nbRepasReserv
FROM Refuge  , ReserveRefuge 
WHERE Refuge.emailref = ReserveRefuge.emailref 
GROUP BY email;

CREATE VIEW  Dispo AS 
SELECT  Refuge.email , refuge.nbrrepas - Reserve.nbRepasReserv AS nbRepasDispo , refuge.nbrdormir - Reserve.nbDormirReserv AS nbDormirDispo 
FROM Refuge , Reserve
WHERE Refuge.email = Reserve.email ; 
