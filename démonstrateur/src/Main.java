

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
     
        String url = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:orcale1";
        String user="mohameml";
        String password = "mohameml";

        try 
        {

            // l'énregistrement du pilote driver d'orcale :
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); 

            // la connexion:
            Connection connection =  DriverManager.getConnection(url, user, password);
        
            // préparation de la réquette :
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Comptes WHERE SOLDE ?");

            Scanner sc = new Scanner(System.in);
            
            int solde = sc.nextInt();
            sc.nextLine();

            stmt.setInt(1, solde);

            ResultSet res = stmt.executeQuery();

            while (res.next()) 
            {
                String name = res.getString("NOM");
                System.out.println(name);    
            }

            
            sc.close();
            connection.close();
        
        
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    }
}