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
        System.out.println("Réservation de nuités          ------>   tapez 1");

        System.out.println("Réservation de repas            ------->  tapez 2");

        System.out.println("Réservation de repas et de nuités    ------->  tapez 3");


        System.out.print("Tapez votre choix 1 , 2 ou 3 : ");

        int choix = sc.nextInt();
        sc.nextLine();


        if(choix==1)
        {
	/* On souhaite réserver uniquement des nuités */
            try 
            {
            	PreparedStatement stmt;
            	ResultSet res;
            	
            	/* On exécute ls script de création des tables de réservations et de disponiblités */
            	/*-------------------------------------------------------------------------*/
                res = executeFileSQL(connection , "../../sql/réserveRefuge.sql");
                if(res==null)
                {
                    System.err.println("Erreur SQL : Echec lors de la création des tables de réservations et de disponiblités");
                    System.exit(1);                
                }
                /*-------------------------------------------------------------------------*/
                
                
                /* On affiche tous les refuges (nom + email) */
		/*-------------------------------------------------------------------------*/
                stmt =  connection.prepareStatement("SELECT emailref, nomref FROM Refuge");
                res = stmt.executeQuery();
                if(res==null)
                {
                    System.err.println("Erreur SQL : Echec lors de la sélection des noms et emails des refuges");
                    System.exit(1);                
                }
                System.out.println("Liste des refuges :");
                
                while(res.next())
            	{
			String email = res.getString("emailref");
			String nom = res.getString("nom");

		        System.out.println(nom + " : " + email);
            	}
            	/*-------------------------------------------------------------------------*/
            	
            	
            	/* On demande quel refuge est sollicité (email) et on cherche le nombre de nuités disponibles et on affiche pour informer l'utilisateur */
            	/*-------------------------------------------------------------------------*/
                System.out.print("\nEntrez l'adresse e-mail du refuge dans lequel vous souhaitez réserver :");
                
                String email = sc.nextLine().replace("\n", "");
                stmt = connection.prepareStatement("SELECT nbDormirDispo FROM Dispo WHERE Dispo.email=?");
                stmt.setString(1, email);
                int nbDormirDispo = stmt.executeQuery().getInt("nbDormirDispo");
                System.out.print("Le refuge d'email " + email + " a " + nbDormirDispo + " nuités de disponible");
                /*-------------------------------------------------------------------------*/
                
                
                /* On demande le nombre de nuité souhaité et on vérifie si autant de nutiés sont disponibles pour ce refuge */
                /*-------------------------------------------------------------------------*/
                System.out.print("Entrez le nombre de nuités que vous souhaitez réserver :");
                
                int nbNuits = sc.nextInt();
                stmt.setInt(1, nbNuits);
                
                if(nbNuits > nbDormirDispo)
                {
                	System.out.println("Désolé, ce refuge n'a pas assez de disponibilités."); 
                }

		/*-------------------------------------------------------------------------*/




                if(nbDispo==-1)
                {
                    System.err.println("Erreur SQL ou Refuge non trouvé ");
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
