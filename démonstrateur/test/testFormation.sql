-- 
INSERT INTO Formation VALUES (1 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'FOR1',TO_DATE('2022-01-01', 'YYYY-MM-DD') , 20 , 30 ,'Bienvenue Dans For1' , 100 , 3 );
INSERT INTO Formation VALUES (2 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'FOR2',TO_DATE('2022-03-01', 'YYYY-MM-DD') , 10 , 50 ,'Bienvenue Dans For2' , 120 , 2 );
INSERT INTO Formation VALUES (3 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'FOR3',TO_DATE('2022-05-01', 'YYYY-MM-DD') , 30 , 70 ,'Bienvenue Dans For3' , 80 , 4 );

--
INSERT INTO ACTIVITE VALUES ('AC1') ;
INSERT INTO ACTIVITE VALUES ('AC2') ;
INSERT INTO ACTIVITE VALUES ('AC3') ;
INSERT INTO ACTIVITE VALUES ('AC4') ;
INSERT INTO ACTIVITE VALUES ('AC5') ;
INSERT INTO ACTIVITE VALUES ('AC6') ;


-- 


INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(1 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC1' ) ; 
INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(1 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC2' ) ; 
INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(1 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC4' ) ; 


INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(2 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC5' ) ; 
INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(2 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC2' ) ; 


INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(3 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC1' ) ; 
INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(3 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC6' ) ; 
INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(3 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC4' ) ; 
INSERT INTO PROPOSE_ACTIVITE_FORM VALUES(3 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ,'AC2' ) ; 


--


INSERT INTO RESERVATION_FORMATION VALUES (1 ,1 ,5 , 1 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ); 
INSERT INTO RESERVATION_FORMATION VALUES (2  ,2 ,6 , 1 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ); 

INSERT INTO RESERVATION_FORMATION VALUES (3 ,1 ,6 , 2 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ); 
INSERT INTO RESERVATION_FORMATION VALUES (4 ,2 ,5 , 2 ,TO_DATE('2022-01-01', 'YYYY-MM-DD') ); 