package packages;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.sql.*;
import java.util.Scanner;
import java.util.Date;




public class requettes 
{
    public requettes()
    {
        
    }



/*
 * 
 *
 * --------------------------------------------- Connexion && Inscription : ----------------------------------------- 
 * 
 * 
*/
    
    /*
     * ------------------- Connexion : ----------------- 
     */
    public static boolean connexionMembre(Connection connection , Scanner sc )
    {
        try {
    
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) as count FROM membre WHERE Email=? AND password=? ");

            System.out.print("Entrez votre emial svp : ");
            String emialAvecRetour = sc.nextLine();
            String email = emialAvecRetour.replace("\n", "");

            System.out.print("Entrez votre mot de passe svp : ");
            String passwordAvecRetour = sc.nextLine();
            String password = passwordAvecRetour.replace("\n", "");


            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet res = stmt.executeQuery();
            int verif = -1;

            while (res.next()) 
            {
                verif = res.getInt("COUNT");  

            
            }

            if(verif==1)
            {
                System.out.println("Connexion réussie ");

                return true;
            }
            else if(verif==0)
            {
                System.out.println("Invalid Email ou mot de passe .");

                return false;
            }
            else
            {
                System.out.println("");
                return false;
            }

        } 
        catch (SQLException e) 
        {

            e.printStackTrace();
            return false;
        }

    }


    /*
     * 
     * ------------  Inscription : ------------ 
    */

    public static boolean inscriptionMembre(Connection connection)
    {
        boolean bool = true ;



        return bool;



    }


/*
 * 
 *--------------------------------- Parcour des informations : --------------------------------------------- 
 * 
 * 
*/


    
    /*
     * ------------------ Parcour des formations : -------------------- 
    */

    public static void afficherFormation(Connection connection)
    {

        try 
        {
            ResultSet res = executeFileSQL(connection , "sql/parcourInfo/afficheformation.sql");


            if(res==null)
            {
                System.err.println("Erreur SQL");
                System.exit(1);
            }

            // affichage de résultat : 
            System.out.println("Anneé , numéro , nom , , activités , dateDém , Duree , nbPlaceRes ");

            while(res.next())
            {
               int  annee = res.getInt("annee");
               int numero = res.getInt("numero");
               String nom = res.getString("nom");
               String activté = res.getString("nomActivité");
               Date datedem = res.getDate("dateDem");
               int duree = res.getInt("duree");
               int nbRestant = res.getInt("nbrRestant");
               System.out.println(annee + ",  " + numero + " , " + nom + ", " + activté + " , " + datedem + " , " + duree + " , " + nbRestant );



            }



            


        } 
        catch(SQLException e1) 
        {
            e1.printStackTrace();
        }



    }

    /*
     * ---------------------- Parcour des  Refuges : ------------------------------ 
    */

    public static void afficherRefuge(Connection connection )
    {
        try{


            ResultSet res = executeFileSQL(connection, "sql/parcourInfo/afficheRefuge.sql");

            if(res==null)
            {
                System.err.println("Erruer SQL");
                System.exit(1);
            }

            System.out.println("nom , dateOuv , dateFreme , nbRepasDispo , nbDormirDispo \n");

            while(res.next())
            {
                String nom = res.getString("nom");
                Date dateOuv = res.getDate("dateOuv");
                Date dateFreme = res.getDate("dateFerme");
                int nbDispoRepas = res.getInt("nbRepasDispo");
                int nbNuitDispo = res.getInt("nbDormirDispo");

                System.out.println(nom + ", " + dateOuv + " ," + dateFreme + " , " + nbDispoRepas + " , " + nbNuitDispo );
            }

            
            

            
        }
        catch (SQLException e1) 
        {

            e1.printStackTrace();
        }


    }


    /*
     *----------------------------------- Parcour des matériels : -----------------------------------------
    */

    public static void affichageMatériels(Connection connection , Scanner sc)
    {

    }




/*
 *
 * --------------------------------------------------- Réservation : ------------------------------------- 
 * 
*/


    /*
     *----------------- Réservation d'une formation: ---------------------------  
    */
    public static void réserverFormation(Connection connection , Scanner sc )
    {

    }


    /*
     *----------------- Réservation de Refuge : ---------------------------  
    */
    public static void réserverRefuge(Connection connection , Scanner sc )
    {
        System.out.println("Réservation d'une nuit          ------>   tapez 1");

        System.out.println("Réservation de Repas            ------->  tapez 2");

        System.out.println("Réservation de Repas et nuit    ------->  tapez 3");


        System.out.print("tapez votre choix 1 , 2 ou 3 : ");

        int choix = sc.nextInt();
        sc.nextLine();


        if(choix==1)
        {

            try 
            {
                ResultSet res = executeFileSQL(connection , "");
                if(res==null)
                {
                    System.err.println("Erruer SQL");
                    System.exit(1);                
                }

                PreparedStatement stmt = connection.prepareStatement("SELECT nbDormirDispo FROM Dispo WHERE Dispo.email=?");
                
                
                System.out.print("tapez svp les nombres de nuits :");
                
                int nbNuits = sc.nextInt();
                stmt.setInt(1, nbNuits);

                ResultSet res2 = stmt.executeQuery();

                int nbDispo = -1 ;

                while(res2.next()) 
                {
                    nbDispo = res2.getInt("nbDormirDispo");

                    
                }

                if(nbDispo==-1)
                {
                    System.err.println("Erruer SQL ou Refuge non trouvé ");
                    System.exit(0);
                }
                else
                {
                    if(nbDispo < nbNuits)
                    {
                        System.out.println("Désolé, nous n'avons pas de chambres suffisantes.");                            
                    }
                    else
                    {
                        // réservation :

                    }
                }

                        
            } 
            catch(SQLException e) 
            {
                e.printStackTrace();
            }
            

        
        
        }
        else if(choix==2)
        {

        }
        else if(choix==3)
        {

        }
        else
        {
            // choix invalide :
            System.out.println("choix invalide ");
            System.exit(0);
        }
    
    
    }


    /*
     *----------------- Réservation d'une formation: ---------------------------  
    */
    public static void réserverMatériels(Connection connection , Scanner sc )
    {

    }



/*
 * ------------------------- Droit de l'oublie --------------------------
*/

public static void oublierMoi(Connection connection)
{

}

    
/*
 * --------- fonction : exécuter un fichier .sql ---------------
 */

    public static ResultSet executeFileSQL(Connection connection , String nameFile)
    {


        try 
        {
            Statement stmt = connection.createStatement();

            // lecture de fichier SQL : 
            BufferedReader reader = new BufferedReader(new FileReader(nameFile));

            StringBuilder query = new StringBuilder();
            String line ; 

            ResultSet res = stmt.executeQuery("SELECT 0 FROM Membre"); // Init : ?? 

            while((line = reader.readLine())!=null)
            {
                String lineCopie = new String(line);

                if(!lineCopie.trim().isEmpty() && !lineCopie.trim().startsWith("--"))
                {
                    // si n'est pas une ligne vide , ni un commentaire:
                    query.append(line).append(" ");
                }


                if(line.trim().endsWith(";"))
                {
                    // il s'agit de la fin d'une Réquette : 
                    res = stmt.executeQuery(query.toString().replace(";" , " "));
                
                    query = new StringBuilder();
                }
            }
            
            
            reader.close();


            return res ;
        } 
        catch (SQLException e1) 
        {
            e1.printStackTrace();
        }
        catch(IOException e2)
        {
            e2.printStackTrace();
        }

        return null ; // en cas d'errure  
    }

}
