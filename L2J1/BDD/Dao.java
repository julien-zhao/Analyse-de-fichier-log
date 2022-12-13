package BDD;

import java.sql.Connection;


import java.sql.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
public class Dao {
	//Permet de se connecter a la base de donnée , il faut preciser le nom de la bd et le mot de passe dans l'objet connection
	public static Connection  Test() {
		Connection connection =null;
		 try{
             Class.forName("com.mysql.jdbc.Driver");  

          connection = DriverManager.getConnection(  
                   //"jdbc:mysql://localhost:3306/Projet", "root","Root"); 
          			"jdbc:mysql://localhost:3306/rootDB", "root","1234");
           Statement statement = connection.createStatement(); 

         
          
    }  catch(Exception e)
    {
        System.out.println("rentre pas");
      
           }
	return connection;
    }
}
