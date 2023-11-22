import java.sql.*;
import java.util.Scanner;

import packages.requettes;

public class Main
{
    public static void main(String[] args) {
        

        System.out.println("-------------------------------- Bienvenue dans l'application : gestion des services de l'équipe 1---------------------------------- \n ");
        

        

        String url = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
        // "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:nom_bd"
        String user="mohameml";
        String password = "mohameml";
    
        try 
        {

            // l'énregistrement du pilote driver d'orcale :

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); 

            // la connexion:
            Connection connection =  DriverManager.getConnection(url, user, password);
            

          // Désactiver le mode autocommit pour gérer manuellement la transaction                   
            connection.setAutoCommit(false);

        
            
          // Sacnner 

          Scanner sc = new  Scanner(System.in);


            // étape 1 : connexion 

            boolean verif = etape1(connection , sc);

            if(!verif)
            {
                //  la connexion ou l'inscription ne march pas bien : 
                System.exit(1);
            }

            // etpae 2 : choix des fonctionnalités 

            boolean bool = true ;
            
            while(bool)
            {


            }
            

            connection.close();
        
        
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    }




    public static boolean etape1(Connection connection , Scanner sc ) {
        
            
            
        System.out.println("Pour connecter à votre compte, tapez 1.");
        System.out.println("Pour l'inscription, tapez 2.");


        System.out.print("tapez votre chox 1 ou 2 :");
    
        int choix = sc.nextInt();


        if(choix==1)
        {
            // connexion :

            boolean verif = requettes.connexionMembre(connection);
            return verif;
        }
        else if(choix==2)
        {
            // inscription :

            boolean bool = requettes.inscriptionMembre(connection);
            return bool ;
        }
        else
        {
            // choix invalide :

            System.out.println("choix invalide");

            return false;

        }
    



    
    
    }
    



    public static void etape2(Scanner sc )
    {
        System.out.println("pour le parcoures de : formations/refuges/matériels : tapez 1 ");


        System.out.println("pour la réservation : tapez 2");
    

        System.out.print("tapez votre choix : 1 u 2");

        int choix = sc.nextInt();


        if(choix==1)
        {
            // donc il faut choisir entre formations/refuges/matériels  

            System.out.println("pour le choix de : \n \t formation --> tapez 1 \n \t refuges ----> tapez 2  \n \t matériels ---> tapez 3 ");

            System.out.print("tapez votre choix  1 , 2 ou 3 : ");

            int choix2 = sc.nextInt();



            if(choix2==1)
            {

            }
            else if(choix2==2)
            {

            }
            else if(choix==3)
            {
                //
            }
            else 
            {
                // choix invalide :

            }
        }
        else if (choix==2) 
        {
            // donc il faut choisir entre formations/refuges/matériels  

            System.out.println("pour le choix de réservation  : \n \t formation --> tapez 1 \n \t refuges ----> tapez 2  \n \t matériels ---> tapez 3 ");

            System.out.print("tapez votre choix  1 , 2 ou 3 : ");

            int choix2 = sc.nextInt();



            if(choix2==1)
            {
                // choix de réservation de formation : Uniquemet pour les adhérents 

            }
            else if(choix2==2)
            {
                // choiox de réservation 
            }
            else if(choix==3)
            {
                //
            }
            else 
            {
                // choix invalide :
                
            }
        }
        else
        {
            // choxix invalide 
        }
    
    
    
    }
}


