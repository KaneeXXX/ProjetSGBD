import java.sql.*;
import java.util.Scanner;

import packages.requettes;

public class Main
{
    public static void main(String[] args) {
        

        System.out.println("-------------------------------- Bienvenue dans l'application : gestion des services de l'équipe 1---------------------------------- \n ");
        


        String url = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
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


            /* 
            ------------------ étape 1 : connexion -------------------- 
            */
            boolean verif = etape1(connection , sc);

            if(!verif)
            {
                //  la connexion ou l'inscription ne marche pas bien : 
                System.exit(0);
            }

            /*
             * 
             *-------------------------------- étpae 2 : choix des fonctionnalités ----------------   
             */

            System.out.println("------------------------ Régles d'Utilisation -------------------------");
            
            System.out.println("Pour le choix entre parcoures des informations ou réservation : ");
            System.out.println("\t-parcoures des informations ----> tapez 1 ");
            System.out.println("\t-réservation               ----> tapez 2 ");

            System.out.println("\nPour le choix entre formation/refuges/matériels:");
            System.out.println("\t-formation --> tapez 1 \n\t-refuges ----> tapez 2\n\t-matériels ---> tapez 3 ");
            
            System.out.println("\nExemple : \n\t -si vous tapez 11 ----> parcour des formations ");
            System.out.println("\t -si vous tapez 21 : ---> réservation des formations ");


            System.out.println("\nPour quitter le mini-shell: -----> tapez exit\n");

            System.out.println("\nPour le droit de l'oublie : ----> tapez oublierMoi");


            String choix ;

            boolean bool = true ;
            
            while(bool)
            {
                System.out.println("");
                System.out.print("> ");
                choix = sc.nextLine();


                if(choix.equals("exit"))
                {
                    System.out.println("----- Au revoir ------");
                    bool=false;
                }
                else if(choix.equals("oublierMoi"))
                {
                    requettes.oublierMoi(connection);
                }
                else if(!choix.isEmpty()  && choix.charAt(0)=='1')
                {
                    // parcour de informations :
                    parcourInfo(connection , choix);
                }
                else if(!choix.isEmpty()  && choix.charAt(0)=='2')
                {
                    // réservation :
                
                    réservation(connection , choix);
                }
                else 
                {
                    // choix invalide : 
                    
                    System.err.println(" \n choix invalide ");
                    System.exit(0);
                }


            }
            

            connection.close();
            sc.close();
        
        
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    }




/*

-------------------------- Les fonctionnalités : ------------------------------------------------------------------

*/

    public static boolean etape1(Connection connection , Scanner sc ) 
    {
        System.out.println("\n----------------- Page de connexion :------------------------\n");
        System.out.println("Pour connecter à votre compte: ----> tapez 1.");
        System.out.println("Pour l'inscription :           ----> tapez 2.");
        System.out.print("\ntapez votre choix 1 ou 2 :");
    
        int choix = sc.nextInt();
        sc.nextLine();


        if(choix==1)
        {
            // connexion :
            System.out.println("");
            boolean verif = requettes.connexionMembre(connection , sc);
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



    public static void parcourInfo(Connection connection , String choix )
    {
        if(choix.equals("11"))
        {
            // System.out.println(" ici : 11");
            // parcour des formations : 
            requettes.afficherFormation(connection);
        }
        else if(choix.equals("12"))
        {
            //System.out.println(" ici : 12");
            requettes.afficherRefuge(connection);
        }
        else if(choix.equals("13"))
        {
            System.out.println(" ici : 13");

        }
        else
        {
            System.err.println("choix invalide");
            System.exit(0);
        }

    }


    public static void réservation(Connection connection , String choix)
    {
        if(choix.equals("21"))
        {
            System.out.println(" ici : 21");
        }
        else if(choix.equals("22"))
        {
            System.out.println(" ici : 22");

        }
        else if(choix.equals("23"))
        {
            System.out.println(" ici : 13");

        }
        else
        {
            System.err.println("choix invalide");
            System.exit(0);
        }  
    }

}
    






