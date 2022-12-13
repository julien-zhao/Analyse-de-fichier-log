package BDD;
import java.sql.Connection;
import java.io.File;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import Fonction.Generer;
public class InsererConnexionBd {
	
	    //Permet d'initialiser la base de donnée lors de la premiere lecture du fichier log
	   
	    public static void initialisationDeLaBd(Tableau tab,int cont) {
	    	InsererConnexionBd.creeFonctionalite(tab,cont);
            InsererConnexionBd.creeFonctionaliteNavigateur(tab,cont);
            InsererConnexionBd.creeFonctionaliteErreur(tab,cont);
            InsererConnexionBd.creeFonctionalitePcetMobile(tab,cont);
            
        	InsererConnexionBd.insererIpUnique(tab);
	    }
	  //Fonction servant a inserer les differents connexions dans la base de donnée
	    
	   public static void insererConnexion(Connexion c1) {
		   Connection connection=Dao.Test();
	          try{   String query = " insert into connexions (Ip, Date, Heure,Appareil, Os,navigateur,Url,code,info)"
	  		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	  		      
	  		      PreparedStatement preparedStmt = connection.prepareStatement(query);
	  		      preparedStmt.setString(1, c1.getIp());
	  		      preparedStmt.setString(2, c1.getDate());
	  		      preparedStmt.setString(3, c1.getHeure());
	  		      preparedStmt.setString(4, c1.getAppareil());
	  		      preparedStmt.setString(5, c1.getOS());
	  		      preparedStmt.setString(6, c1.getNavigateur());
	  		      preparedStmt.setString(7, c1.getUrl());
	  		      preparedStmt.setInt(8, c1.getCode());
	  		      preparedStmt.setString(9, c1.getInfo());

	  		      
	  		      preparedStmt.execute();
	  		      
	  		      connection.close();
	          }catch (Exception e) {
	        	  System.out.println(e);
	          }
	   }
	   //Permet de mettre les differents fonctionalitee dans la base de donnée
	   public static void creeFonctionalite(Tableau t1,int cont){
		   try {
			   Connection conn=Dao.Test(); 
			      String query = " insert into fonctionalitee (OcurrenceUnique,mobileNB,pcNB,erreurNB,compteur,date,taille_octet)"
			        + " values (?, ?, ?, ?,?,?,?)";

			      
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      File file = Generer.getLien();
			      Calendar calendar = Calendar.getInstance();
			      preparedStmt.setDouble (1, t1.entrezDiff());
			      preparedStmt.setDouble (2, t1.get_nb_Mobile());
			      preparedStmt.setDouble  (3, t1.get_nb_PC());
			      preparedStmt.setDouble   (4, t1.nombreErreur());
			      preparedStmt.setDouble   (5, cont);
			      preparedStmt.setString   (6,""+calendar.getTime());
			      preparedStmt.setDouble  (7,file.length());
			        
			      preparedStmt.execute();
			     
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      } 
	   }
	   //permet d'initialiser la table  urlocc dans la bd
	   public static void creeFonctionaliterlocc(Tableau t1,int cont){
		   try {
			   Connection conn=Dao.Test();   
			      String query = " insert into urlocc (html,css,php,pdf,xhtml)"
			        + " values (?,?,?,?,?)";
			      
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			    
			      preparedStmt.setDouble (1, t1.Url()[0]);
			      preparedStmt.setDouble (2, t1.Url()[1]);
			      preparedStmt.setDouble  (3, t1.Url()[2]);
			      preparedStmt.setDouble   (4, t1.Url()[3]);
			      preparedStmt.setDouble   (5, t1.Url()[4]);
			           
			      preparedStmt.execute();
			     
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      } 
	   }
	   
	   
	   
	   
	   
	   
	   //initialise la table de la bd pcetmobile
	   public static void creeFonctionalitePcetMobile(Tableau t1,int cont){
		   try {
			   Connection conn=Dao.Test();   
			      String query = " insert into pcetmobile(Linux,Windows,autre_os_pc,Mac,nb_android,nb_ios,nb_autre_os_mobile,Date)"
			        + " values (?, ?, ?, ?,?,?,?,?)";

			      
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      Calendar calendar = Calendar.getInstance();
			      preparedStmt.setDouble (1, t1.get_nb_linux());
			      preparedStmt.setDouble (2, t1.get_nb_windows());
			      preparedStmt.setDouble  (3, t1.get_nb_autre());
			      preparedStmt.setDouble   (4, t1.get_nb_mac());
			      preparedStmt.setDouble   (5, t1.get_nb_Android());
			      preparedStmt.setDouble   (6,t1.get_nb_IOS());
			      preparedStmt.setDouble  (7,t1.get_nb_Mobile() - (t1.get_nb_Android()+t1.get_nb_IOS()));
			      preparedStmt.setString   (8,""+calendar.getTime());
      
			      preparedStmt.execute();
			     
			    } catch (Exception e){
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      } 
	   }
	   
	   // permet de mettre les differents erreur dans la base de donnee
	   public static void creeFonctionaliteErreur(Tableau t1,int cont){
		   try {
			   Connection conn=Dao.Test();
			  for(int i=0;i<t1.diff_Erreur().length;i++) {
		  			 t1.diff_Erreur();
				      String query = " insert into Erreur (erreur,occurence)"
				  		        + " values (?, ?)";
				     PreparedStatement preparedStmt = conn.prepareStatement(query);
			  		 preparedStmt.setInt (1, t1.diff_Erreur()[i]);
			  		 preparedStmt.setInt(2, t1.nombreOcurrence()[i]);
			  		 preparedStmt.execute();		  		
		  		 }	     
			    } catch (Exception e){
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			    }
		   
	   }
	   // permet de mettre a jour le nombre d'erreur et rajouter les nouvelle erreur dans la base de donn�e
	   public static void FonctionaliteErreurMAJ(Tableau t1,int cont){
		   try {
			  for(int i=0;i<t1.diff_Erreur().length;i++) {
				       
		  			  if(isExist(t1.diff_Erreur()[i])) {
		  				int n = t1.diff_Erreur()[i];
		  				int l =t1.nombreOcurrence()[i]+recupererE("occurence","erreur",t1.diff_Erreur()[i]);
		  				InsererConnexionBd.update( "erreur",l,n);
		  			  }else {
		  				  insertErreur(t1.diff_Erreur()[i],t1.nombreOcurrence()[i]);

		  			  }  		
		  		 }   
			    } catch (Exception e){
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }
		   
	   }
	   //permet de modifier les occurrence des erreur
	   public static void update(String table,int setter,int condition) {
		   try {
			   Connection conn=Dao.Test();
			    
			     
			   String query = "UPDATE "+table+" SET occurence ="+setter+" WHERE erreur = "+condition;
			  
			  PreparedStatement preparedStmt = conn.prepareStatement(query);
	  		 
	  		  preparedStmt.execute();
		           
			     
			    } catch (Exception e){
			        System.err.println("Got an exception firefox!");
			        System.err.println(e.getMessage());
			      }
	   }
	   //permet de mettre  a jour le nombre d'ip
	   public static void updateO(int setter,String n) {
		   try {
			   Connection conn=Dao.Test();
			    
			     
			   String query = "UPDATE ocurrenceip "
		                + "SET Occurence = ? "
		                + "WHERE Ip = ?";

			   Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		    		    ResultSet.CONCUR_READ_ONLY);
			  PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setInt(1, setter);
			  preparedStmt.setString(2, n);
	  		 
	  		  preparedStmt.execute();
		     
			     
			      
			     
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception setter!");
			        System.err.println(e.getMessage());
			      }
	   }
	   //permet d'inserer les nouvelles erreur dans la bd lors d'une update
	   public static void insertErreur(int n,int r) {
		   try {
			   Connection conn=Dao.Test();
			    
			     
			   String query = " insert into erreur (erreur,occurence)"
		  		        + " values (?, ?)";
			  PreparedStatement preparedStmt = conn.prepareStatement(query);
			  preparedStmt.setDouble (1, n);
	  		  preparedStmt.setDouble (2, r);
	  		 
	  		  preparedStmt.execute();
		     
			      
			      
			     
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception firefox!");
			        System.err.println(e.getMessage());
			      }
		   
	   }
		   
	   //permet de mettre les differents types de navigateur dans la bd
	   public static void creeFonctionaliteNavigateur(Tableau t1,int cont){
		   try {
			   Connection conn=Dao.Test();
			    
			     
			   String query = " insert into navigateur (Firefox,explorer, Autre,Safari,Edge,Chrome)"
		  		        + " values (?, ?, ?, ?, ?, ?)";
			  PreparedStatement preparedStmt = conn.prepareStatement(query);
	  		  preparedStmt.setDouble (1, t1.get_nb_Firefox());
	  		  preparedStmt.setDouble (2, t1.get_nb_Explorer());
	  		  preparedStmt.setDouble (3, t1.get_nb_navi_autre());
	  		  preparedStmt.setDouble (4, t1.get_nb_Safari());
	  		  preparedStmt.setDouble (5, t1.get_nb_Edge());
	  		  preparedStmt.setDouble (6, t1.get_nb_Chrome());
	  		  preparedStmt.execute();
     
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception firefox!");
			        System.err.println(e.getMessage());
			      }
	   }
	   //permet de mettre a jour le nombre de navigateur dans la bd
	   public static void FonctionaliteNavigateurMAJ(Tableau t1,int cont){
		   try {
			   Connection conn=Dao.Test();
			    
			     
			   String query = " insert into navigateur (Firefox,explorer, Autre,Safari,Edge,Chrome)"
		  		        + " values (?, ?, ?, ?, ?, ?)";
			  PreparedStatement preparedStmt = conn.prepareStatement(query);
	  		  preparedStmt.setDouble (1, Double.parseDouble(recuperer("navigateur","Firefox"))+t1.get_nb_Firefox());
	  		  
	  		  preparedStmt.setDouble (2, Double.parseDouble(recuperer("navigateur","explorer"))+t1.get_nb_Explorer());
	  		  preparedStmt.setDouble (3, Double.parseDouble(recuperer("navigateur","Autre"))+t1.get_nb_navi_autre());
	  		  preparedStmt.setDouble (4,Double.parseDouble(recuperer("navigateur","Safari"))+ t1.get_nb_Safari());
	  		
	  		  preparedStmt.setDouble (5, Double.parseDouble(recuperer("navigateur","Edge"))+t1.get_nb_Edge());
	  		  preparedStmt.setDouble (6, Double.parseDouble(recuperer("navigateur","Chrome"))+t1.get_nb_Chrome());
	  		
	  		  preparedStmt.execute();
		          
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception firefox!");
			        System.err.println(e.getMessage());
			      }
	   }
	   // permet d'inserer les ip unique dans la bd
	   public static void insererIpUnique(Tableau t1 ) {
		   try {
			   Connection conn=Dao.Test();
   
		      String query = " insert into ocurrenceip (Ip,Occurence)"
		        + " values (?,?)";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      for(int i=0;i<t1.entrezDiff();i++) {
		    	  
		      preparedStmt.setString (1,t1.ipDiff()[i] );
		      preparedStmt.setInt(2,t1.OccurrenceipDiff()[i]);
		       
		      preparedStmt.execute();
		      
		      }
		      conn.close();
		    } catch (Exception e)
		    {
		        System.err.println("pas bon");
		        System.err.println(e.getMessage());
		      }
	   }
	   //permet d'inserer une ip unique
	   public static void insererIpUnique(String n,int i) {
		   try {
			   Connection conn=Dao.Test();

		      String query = " insert into ocurrenceip (Ip,Occurence)"
		        + " values (?,?)";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      
		      preparedStmt.setString (1,n );
		      preparedStmt.setInt(2, i);
		     
		    
		      preparedStmt.execute();
		      
		      
		      conn.close();
		    } catch (Exception e)
		    {
		        System.err.println("Got an exception!");
		        System.err.println(e.getMessage());
		      }
	   }
	   //permet de recuperer une information dans la bd
	   public static String recuperer(String table,String name) {
		   String s ="0";
		   try {
			   Connection conn=Dao.Test();
  
		      String query = "SELECT "+name+" FROM "+table;

		      Statement stmt = conn.createStatement();
		      ResultSet res = stmt.executeQuery(query);
		           
		      while(res.next()){
		        
		     
		         s = res.getString(name);
		        
		      }  
		    
		      conn.close();
		    } catch (Exception e)
		    {
		        System.err.println("Got an exception!");
		        System.err.println(e.getMessage());
		      }
		   return s;
		   
	   }
	   //permet de recuperer un chiffre dans la bd
	   public static int recupererI(String table,String name) {
		   int s =0;
		   try {
			   Connection conn=Dao.Test();
		    
		     

		      
		      String query = "SELECT "+name+" FROM "+table;

		      Statement stmt = conn.createStatement();
		      ResultSet res = stmt.executeQuery(query);
		      
		      
		      while(res.next()){
		        
		     
		         s = res.getInt(name);
		        
		      }  
		    
		      conn.close();
		    } catch (Exception e)
		    {
		        System.err.println("Got an exception!");
		        System.err.println(e.getMessage());
		      }
		   return s;
		   
	   }
	   //permet de recuperer une information avec une certaines ip
	   public static String recuperer(String table,String name,String n) {
		   String s ="0";
		   try {
			   Connection conn=Dao.Test();

		      String query = "SELECT "+name+" FROM "+table+"where Ip=' "+n+"' ";

		      Statement stmt = conn.createStatement();
		      ResultSet res = stmt.executeQuery(query);
		      
		      
		      while(res.next()){
		         
		     
		         s = res.getString(name);
		        
		      }  
		    
		      conn.close();
		    } catch (Exception e)
		    {
		        System.err.println("Got an exception!");
		        System.err.println(e.getMessage());
		      }
		   return s;
		   
	   }
	   // permet de recuperer le nombre d'occurence d'un certain types d'erreur
	   public static int recupererE(String table,String name,int n) {
		  int s =0;
		   try {
			   Connection conn=Dao.Test();   
		      String query = "SELECT "+name+" FROM "+table+"where erreur="+n+" ";

		      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		    		    ResultSet.CONCUR_READ_ONLY);
		      ResultSet res = stmt.executeQuery("SELECT occurence FROM erreur WHERE erreur = '" + n + "';");
		      
		      
		      while(res.next()){
		        
		     
		         s = res.getInt("occurence");
		        
		      }  
		    
		      conn.close();
		    } catch (Exception e)
		    {
		        System.err.println("Got an exception!");
		        System.err.println(e.getMessage());
		      }
		   return s;
		   
	   }
	   // permet de recuperer le nombre d'occurence d'une ip
	   public static int recupererO(String n) {
			  int s =0;
			   try {
				   Connection conn=Dao.Test();

			      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    		    ResultSet.CONCUR_READ_ONLY);
			      ResultSet res = stmt.executeQuery("SELECT Occurence FROM ocurrenceip WHERE Ip = '" + n + "';");
			      
			      
			      while(res.next()){
			        
			     
			         s = res.getInt("Occurence");
			        
			      }  
			    
			      conn.close();
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }
			   return s;
			   
		   }
	   
	   // permet de recuperer un tableau d'information de la bd 
	   public static String [] recupererAll(String table,String name) {
		   String [] s= new String[10150];
		   String [] rep;
		   int i=0;
		   try {
			   Connection conn=Dao.Test();

		      String query = "SELECT "+name+" FROM "+table;

		      Statement stmt = conn.createStatement();
		      ResultSet res = stmt.executeQuery(query);
		      
		      
		      while(res.next()){
		       
		         
		         s[i] = res.getString(name);
		        i++;
		      }  
		       rep= new String[i];
		      for(int j=0;j<i;j++) {
		    	  rep[j]=s[j];
		      }
		    
		      conn.close();
		      return rep;
		    } catch (Exception e)
		    {
		        System.err.println("Got an exception!");
		        System.err.println(e.getMessage());
		      }
		   
		   return s ;
		   
	   }
	   //permet de recuperer tout la table d'une information en int
	   public static int [] recupererAllI(String table,String name) {
		   int [] s= new int[10150];
		   int [] rep;
		   int i=0;
		   try {
			   Connection conn=Dao.Test(); 
		      String query = "SELECT "+name+" FROM "+table;

		      Statement stmt = conn.createStatement();
		      ResultSet res = stmt.executeQuery(query);
		      
		      
		      while(res.next()){
		       
		         
		         s[i] = res.getInt(name);
		        i++;
		      }  
		       rep= new int[i];
		      for(int j=0;j<i;j++) {
		    	  rep[j]=s[j];
		      }
		    
		      conn.close();
		      return rep;
		    } catch (Exception e)
		    {
		        System.err.println("Got an exception!");
		        System.err.println(e.getMessage());
		      }
		   
		   return s ;
		   
	   }
	   // permet de verifier si une information appartient deja a la bd
	   public static boolean isExist(String n) {
		   Boolean find =false;
		   try {
			   Connection conn=Dao.Test();
			    
			     

			     
			      String query = "SELECT * FROM ocurrenceip WHERE Ip='"+n+"'";
			      
			      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    		    ResultSet.CONCUR_READ_ONLY);
			      ResultSet res = stmt.executeQuery(query);
			      return res.absolute(1);

			     
			      
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }
		   return find;
		   
	   } 
	   // la meme mais pour les int
	   public static boolean isExist(int n) {
		   Boolean find =false;
		   try {
			   Connection conn=Dao.Test();
			    
			     

			      // the mysql insert statement
			      String query = "SELECT * FROM erreur WHERE erreur='"+n+"'";
			      
			      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    		    ResultSet.CONCUR_READ_ONLY);
			      ResultSet res = stmt.executeQuery(query);
			      return res.absolute(1);

			     
			      
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }
		   return find;
	   }
	   //permet de compter le nombre d'ip unique
	   public static int nombreIpUnique() {
		   int n=0;
		   try {
			   Connection conn=Dao.Test();
			    
			     

			     
			      
			      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    		    ResultSet.CONCUR_READ_ONLY);
			      
			      ResultSet res = stmt.executeQuery("SELECT COUNT(*) AS count FROM "+"ocurrenceip"+"");
			      if(res.next()){

			    	  n=res.getInt("count");

			        }
			     
			      return n;

			     
			      
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }
		   return n;
	   }
		//permet de mettre a jour la table pcetmobile
	   public static void UpdateFonctionalitePcetMobile(Tableau t1,int cont){
		   try {
			   Connection conn=Dao.Test();
			    
			     

			      
			      String query = " insert into pcetmobile(Linux,Windows,autre_os_pc,Mac,nb_android,nb_ios,nb_autre_os_mobile,Date)"
			        + " values (?, ?, ?, ?,?,?,?,?)";

			      
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      Calendar calendar = Calendar.getInstance();
			      preparedStmt.setDouble (1, recupererI("pcetmobile","Linux")+t1.get_nb_linux());
			      preparedStmt.setDouble (2, recupererI("pcetmobile","Windows")+t1.get_nb_windows());
			      preparedStmt.setDouble  (3, recupererI("pcetmobile","autre_os_pc")+t1.get_nb_autre());
			      preparedStmt.setDouble   (4, recupererI("pcetmobile","Mac")+t1.get_nb_mac());
			      preparedStmt.setDouble   (5, recupererI("pcetmobile","nb_android")+t1.get_nb_Android());
			      preparedStmt.setDouble   (6,recupererI("pcetmobile","nb_ios")+t1.get_nb_IOS());
			      preparedStmt.setDouble  (7,recupererI("pcetmobile","nb_autre_os_mobile")+(t1.get_nb_Mobile() - (t1.get_nb_Android()+t1.get_nb_IOS())));
			      preparedStmt.setString   (8,""+calendar.getTime());
			       
			      preparedStmt.execute();
			     
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }

	   }
	   // permet de mettre a jour la table urlocc
	   public static void Fonctionaliterlocc(Tableau t1,int cont){
		   try {
			   Connection conn=Dao.Test();
   
			      String query = " insert into urlocc (html,css,php,pdf,xhtml)"
			        + " values (?,?,?,?,?)";
			      
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			    
			      preparedStmt.setDouble (1, recupererI("urlocc", "html")+t1.Url()[0]);
			      preparedStmt.setDouble (2, recupererI("urlocc", "css")+t1.Url()[1]);
			      preparedStmt.setDouble  (3, recupererI("urlocc", "php")+t1.Url()[2]);
			      preparedStmt.setDouble   (4, recupererI("urlocc", "pdf")+t1.Url()[3]);
			      preparedStmt.setDouble   (5, recupererI("urlocc", "xhtml")+t1.Url()[4]);
			     
			      
			      
			      preparedStmt.execute();
			     
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }
 
	   }
	   
	   
	   
	   //permet de mettre a jour la table occurenceip
	   public static void updateIpUnique(Tableau t1) {
		   try {
				  for(int r=0;r<t1.entrezDiff();r++) {
					 
					       
			  			  if(isExist(t1.ipDiff()[r])) {
			  				int n = t1.OccurrenceipDiff()[r]+recupererO(t1.ipDiff()[r]);
			  				String l =t1.ipDiff()[r];
			  				InsererConnexionBd.updateO( n,l);
					  		
			  			  }else {
			  				insererIpUnique(t1.ipDiff()[r],t1.OccurrenceipDiff()[r]);

			  			  }
		
			  		 }	     
				    } catch (Exception e)
				    {
				        System.err.println("Got an updateip!");
				        System.err.println(e.getMessage());
				      }
		   
		   
		   
	   }
	 
	   // permet de mettre a jour la db lors du rajout de connexion dnas le fichier log
	   public static void updatefonctionalitee(Tableau t1,int cont) {
		   try {
			   Connection conn=Dao.Test();
			      // the mysql insert statement
			      String query = " insert into fonctionalitee (OcurrenceUnique,mobileNB,pcNB,erreurNB,compteur,date,taille_octet)"
			        + " values (?, ?, ?, ?,?,?,?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      int n=0;
			     
			      Calendar calendar = Calendar.getInstance();
			      File file = Generer.getLien();
			      updateIpUnique(t1);
			      preparedStmt.setDouble (1,  nombreIpUnique());
			      preparedStmt.setDouble (2,   Integer.parseInt(recuperer("fonctionalitee","mobileNB"))+t1.get_nb_Mobile());
			      preparedStmt.setDouble  (3,  Integer.parseInt(recuperer("fonctionalitee","pcNB"))+t1.get_nb_PC());
			      preparedStmt.setDouble   (4, Integer.parseInt(recuperer("fonctionalitee","erreurNB"))+t1.nombreErreur());
			      preparedStmt.setDouble   (5, Integer.parseInt(recuperer("fonctionalitee","compteur"))+cont);
			      preparedStmt.setString   (6, ""+calendar.getTime());
			      preparedStmt.setDouble  (7,file.length());
			      
			      preparedStmt.execute();
			     
			    } catch (Exception e)
			    {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }
		   FonctionaliteNavigateurMAJ(t1,cont);
		   FonctionaliteErreurMAJ(t1,cont);
		   UpdateFonctionalitePcetMobile( t1,cont);
		   Fonctionaliterlocc(t1,cont);	   
	   }   
}
		    

		   
	
	   
	  





