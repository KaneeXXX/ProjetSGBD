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
            // Créer un objet Statement : 
            Statement statement = connection.createStatement();

            // Lire le fichier SQL : 
            BufferedReader reader = new BufferedReader(new FileReader("src/sql/parcourInfo/afficheformation.sql"));
            StringBuilder query = new StringBuilder();
            String line;

            ResultSet res = statement.executeQuery("SELECT * FROM Membre");  // Init : ???  

            // Parcourir le fichier ligne par ligne
            while ((line = reader.readLine()) != null) 
            {

                String lineCopie = new String(line);

                // Vérifier si la ligne est vide ou un commentaire
                if(!lineCopie.trim().isEmpty() && !lineCopie.trim().startsWith("--")) 
                {
                    query.append(line).append(" ");
                }

                // Si la ligne se termine par un point-virgule, exécuter la requête
                if (lineCopie.trim().endsWith(";")) 
                {
                    // Exécuter la requête

                    res = statement.executeQuery(query.toString().replace(";", " "));

                    // Réinitialiser la requête
                    query = new StringBuilder();
                }
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



            // Fermer le readre : 
            reader.close();
            


        } 
        catch(SQLException e1) 
        {
            e1.printStackTrace();
        }
        catch(IOException e2)
        {
            e2.printStackTrace();

        }


    }

    /*
     * ---------------------- Parcour des  Refuges : ------------------------------ 
    */

    public static void afficherRefuge(Connection connection )
    {
        try{
            Statement stmt = connection.createStatement();

            // lecture de fichier SQL : 
            BufferedReader reader = new BufferedReader(new FileReader("src/sql/parcourInfo/afficheRefuge.sql"));

            StringBuilder query = new StringBuilder();
            String line ; 

            ResultSet res = stmt.executeQuery("SELECT 0 FROM Membre");

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

            
            
            reader.close();
            
        }
        catch (SQLException e1) 
        {

            e1.printStackTrace();
        }
        catch(IOException e2)        
        {
            e2.printStackTrace();
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

    
}
