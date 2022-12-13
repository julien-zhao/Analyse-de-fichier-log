package Fonction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.maxmind.geoip2.DatabaseReader;

import org.json.simple.JSONArray;
import java.util.Scanner;
public class Generer {
	
	//definir le chemin ou se trouve le fichier journal
	
	public static File getLien() {
		//File file_test = new File("/Users/julien/Desktop/logfile.txt");
		File file_test = new File("C:\\Users\\othma\\Desktop\\apache-tomcat-9.0.62\\webapps\\logs.txt");
		return file_test;
	}
	
	public static File getMapLien() {
		//File file_test = new File("/Users/julien/Desktop/GeoLite2-City.mmdb");
		File file_test = new File("C:\\Users\\othma\\Desktop\\apache-tomcat-9.0.62\\webapps\\GeoLite2-City.mmdb");
		return file_test;
	}
	
	//Création du tableau à partir du lien
	public static Tableau genererFile() {
        
        Tableau tab = new Tableau();
        try {BufferedReader br = new BufferedReader(new FileReader(getLien()));
                String line;                    
                while ((line = br.readLine()) != null) {
                        Connexion c1 = new Connexion(line);
                        tab.ajout(c1);                                                        
                }
            } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
            }
        return tab;
	}

	public static DatabaseReader genererMapFile() {
		DatabaseReader dbr = null;
        try {
        	dbr = new DatabaseReader.Builder(getMapLien()).build();

            } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
            }
        return dbr; 
	}
	
	
	
	public static JSONArray genererLogs() {
		JSONArray Logs = new JSONArray();
        
        Tableau tab = new Tableau();
        try {BufferedReader br = new BufferedReader(new FileReader(Generer.getLien()));
                String line;                    
                while ((line = br.readLine()) != null) {
                        Connexion c1 = new Connexion(line);
                        tab.ajout(c1);                                      
                        Logs.add(LogsJson.GetLogs(c1));                  
                }
            } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
            }
        return Logs;
	}
}
