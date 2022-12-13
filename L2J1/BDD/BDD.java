package BDD;
import java.io.BufferedReader;


import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import java.io.File;
import Fonction.*;

public class BDD {
	
	public static void lancer() {
		// le but de cette classe est d'initialisée la bd si elle n'existe pas , la mettre a jour si il y a des nouvelle connexions et la laisée identique si 
		//il n y a pas de changement
		 File file_test = Generer.getLien();
		 
         boolean find=false;
         // Cette boucle servira d'obtenir la taille du fichier logs qui va nous permetre d'initialiser la taille de notre tableau
         int cont =0;
         try(BufferedReader br = new BufferedReader(new FileReader(file_test))){
         	String line;
         	while ((line = br.readLine()) != null) {
         		 Connexion c1 = new Connexion(line);
                 if(c1.getIp() != null) {
                	 cont++;
                 }
         	}
         } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }
 
         //Creation de la bd
         if (0==Integer. parseInt(InsererConnexionBd.recuperer("fonctionalitee","compteur"))){
         	 String compteur=InsererConnexionBd.recuperer("fonctionalitee","compteur");
              
         	Tableau.cont = cont;
             int j = 0; 
             int i=0;
             JSONArray Logs = new JSONArray();
             
             Tableau tab = new Tableau();
             try (BufferedReader br = new BufferedReader(new FileReader(file_test))){
                     String line;                    
                     while ((line = br.readLine()) != null) {
                             Connexion c1 = new Connexion(line);
                             if(c1.getIp() != null) {
                            	 tab.assignez(c1, j);                                       
                            	 InsererConnexionBd.insererConnexion(c1);
                            	 j++;
                             }
                             
                          
                     }
                 } catch (IOException e) {
                         System.out.println("An error occurred.");
                         e.printStackTrace();
                 }
             InsererConnexionBd.initialisationDeLaBd(tab, cont);
          
              
            
             }
             //===================================================
         
         // pas de nouvelle connexion bd reste stable
         if (cont==Integer. parseInt(InsererConnexionBd.recuperer("fonctionalitee","compteur") )) { 
         	Tableau.cont = cont;
             int j = 0; 
             int i=0;
             Tableau tab = new Tableau();
         	 try (BufferedReader br = new BufferedReader(new FileReader(file_test))){
                  String line;                    
                  while ((line = br.readLine()) != null) {
                          Connexion c1 = new Connexion(line);
                          if(c1.getIp() != null) {
                        	  
                        	 tab.assignez(c1, j);   
                        	 
                        	 j++; 
                          }
                          
                       
                  }
                  
              } catch (IOException e) {
                      System.out.println("An error occurred.");
                      e.printStackTrace();
              }
         	System.out.println(cont);
      	
         }
         
         // update de la bd en partant de la ligne des nouvelle ligne ajout�e dans le fichier log
         else{
         Tableau.cont = cont;
         int j = 0; 
         int r=0;
         JSONArray Logs = new JSONArray();
         
         Tableau tab = new Tableau();
         try (BufferedReader br = new BufferedReader(new FileReader(file_test))){
                 String line;                    
                 while ((line = br.readLine()) != null) {                                                           
                	 j++;
                          if (j-Integer.parseInt(InsererConnexionBd.recuperer("fonctionalitee","compteur"))>0){ //permet de commencer la ou les lignes on etait rajoutée
                        	  Connexion c1 = new Connexion(line);
                        	  if(c1.getIp() != null) {
                         		tab.assignez(c1, r);                                       
                         		InsererConnexionBd.insererConnexion(c1);
                         		r++;
                        	  }   
                          }
                 }
             } catch (IOException e) {
                     System.out.println("An error occurred.");
                     e.printStackTrace();
             }
       
         Tableau.cont = r;

         InsererConnexionBd.updatefonctionalitee(tab, r);
         }   
     }
}


