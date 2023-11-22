package packages;
import java.sql.*;
import java.util.Scanner;




public class requettes 
{
    public requettes()
    {
        
    }




    public static boolean connexionMembre(Connection connection)
    {
        try {
    
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) as count FROM membre WHERE Email=? AND motdepasse=? ");

            
            Scanner sc = new Scanner(System.in);

            System.out.print("Entrez votre emial svp : ");
            
            String emialAvecRetour = sc.nextLine();
            String email = emialAvecRetour.replace("\n", "");



            System.out.print("Entrez votre mot de passe svp : ");
            
            String passwordAvecRetour = sc.nextLine();
            String password = passwordAvecRetour.replace("\n", "");




            sc.close();

            //
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


    public static boolean inscriptionMembre(Connection connection)
    {
        boolean bool = true ;



        return true;



    }






    public static void afficherFormation(Connection connection)
    {
        try{
            Statement stmt = connection.createStatement();
            ResultSet res =stmt.executeQuery("SELECT * FROM Formation ORDER BY annee,num,nom");

            while(res.next())
            {
                String nomFormation = res.getString("nom");
                Date date = res.getDate("annee");
                int num = res.getInt("num");
                System.out.println(date +"\t" + num + "\t" + nomFormation);
            }
            
            
        }
        catch (SQLException e) 
        {

            e.printStackTrace();
        }

    }



    public static void afficherRefuge(Connection connection)
    {
        try{
            Statement stmt = connection.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("si vous voulez ");

            ResultSet res =stmt.executeQuery("SELECT * FROM Formation ORDER BY annee,num,nom");

            while(res.next())
            {
                String nomFormation = res.getString("nom");
                Date date = res.getDate("annee");
                int num = res.getInt("num");
                System.out.println(date +"\t" + num + "\t" + nomFormation);
            }
            
            
        }
        catch (SQLException e) 
        {

            e.printStackTrace();
        }

    }








    public static void ajouter(Connection connection)
    {
        try {
        
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Comptes (NC , NOM , SOLDE ) VALUES (? , ? , ? )");



            Scanner sc = new Scanner(System.in);


            // on récupere le nom :

            System.out.print("Entrez votre nom svp : ");

            String nom = sc.nextLine();

            stmt.setString(1, nom);


            // on récupere le solde :

            System.out.print("Entrez votre solde svp : ");
            int  solde = sc.nextInt();
            stmt.setInt(2, solde);

            

            // valider la transaction :

            connection.commit();

            // on ferme le Scanner :
            sc.close();
        } 
        catch (SQLException e) 
        {

            // En cas d'erreur, annuler la transaction
            if (connection != null) 
            {
                try 
                {
                    connection.rollback();
                    System.out.println("La transaction a été annulée en raison d'une erreur.");
                } 
                catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }
            }

            e.printStackTrace();

        }
        
    }

    // 

    public static void affichageResult(PreparedStatement stmt)
    {
        

        // ResultSet res = stmt.executeQuery();

        // while (res.next()) 
        // {
        //     String name = res.getString("NOM");
        //     System.out.println(name);    
        // }
    }
    
}
