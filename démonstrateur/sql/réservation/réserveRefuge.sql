-- Réinitialisation des tables
DROP VIEW Reserve;
DROP VIEW Dispo;

-- On cherche la totalité des réservations de repas et de nuités
CREATE VIEW  Reserve AS 
SELECT emailref, SUM(Reservation_refuge.nbrNuitsReserv) AS nbrNuitsReservTotal,  SUM(Reservation_refuge.nbrRepasReserv) AS nbrRepasReservTotal
FROM Refuge, Reservation_refuge 
WHERE Refuge.emailref = ReserveRefuge.emailref 
GROUP BY emailref;

-- On conserve le nombre de disponiblités pour les repas et les nuités
CREATE VIEW  Dispo AS 
SELECT  Refuge.emailRef, refuge.nbrPlacesRepas - Reserve.nbrRepasReservTotal AS nbRepasDispo, refuge.nbrPlacesDormir - Reserve.nbrNuitsReservTotal AS nbDormirDispo 
FROM Refuge, Reserve
WHERE Refuge.email = Reserve.email; 

-- On récupère le nombre de disponiblités pour les repas
SELECT nbRepasDispo FROM Dispo WHERE Dispo.email=?

-- On récupère le nombre de disponiblités pour les nuités
SELECT nbDormirDispo FROM Dispo WHERE Dispo.email=?


-- On est dans la possibilité de réserver :
INSERT -- nouvelle réservation
