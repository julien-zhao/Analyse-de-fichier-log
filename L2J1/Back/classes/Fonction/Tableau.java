package Fonction;
import java.util.Vector;

public class Tableau {
  private Vector<Connexion> connexions;
  
  public Tableau() {
	  connexions = new Vector<Connexion>();
  }

  public void ajout(Connexion c1) {
	  connexions.add(c1);
  }
  
  public int getTaille() {
	  return connexions.size();
  }
  
  public String getOneIP(int nb) {
	  return connexions.get(nb).getIp();
  } 
  
  public String getUrl(int nb) {
	  return connexions.get(nb).getUrl();
  }
  
  public String getUrl(String ip) {
	  for(int i =connexions.size()-1; i>0;i--) {
		  if(connexions.get(i).getIp() == ip) {
			  return connexions.get(i).getUrl();
		  }
	  }
	  return null;
  }

  public String getNavi(String ip) {
	  for(int i =connexions.size()-1; i>0;i--) {
		  if(connexions.get(i).getIp() == ip) {
			  return connexions.get(i).getNavigateur();
		  }
	  }
	  return null;
  }
  
  
  
  //obtenir la dernier heure, on parcour de l'indice le plus grand au plus petit
  public String getHeure(String ip) {
	  for(int i =connexions.size()-1; i>0;i--) {
		  if(connexions.get(i).getIp() == ip) {
			  return connexions.get(i).getTimeComplet();
		  }
	  }
	  return null;
  }

 //==============================Methode affichage sur la console=================================
  public void PC_Mobile() {
    int nb_pc = 0;
    int nb_mobile = 0;
    for (Connexion c1 : connexions) {
      if (c1.getAppareil() == "PC") {
        nb_pc++;
      } else {
        nb_mobile++;
      }
    }
    double total = nb_pc + nb_mobile;
    System.out.println(
      "Le pourcentage d'appareil pc est : " +
      nb_pc +
      " (" +
      ((nb_pc / total) * 100) +
      "%)" +
      "\nLe pourcentage d'appareil mobile est : " +
      nb_mobile +
      " (" +
      ((nb_mobile / total) * 100) +
      "%)"
    );
  }
  
  public void PC_OS() {
	    int nb_linux = 0;
	    int nb_mac = 0;
	    int nb_windows = 0;
	    int nb_autre = 0;
	    int nb_ios = 0;
	    int nb_android = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getOS() == "linux") {
	        nb_linux++;
	      }
	      if (c1.getOS() == "Mac") {
	        nb_mac++;
	      }
	      if (c1.getOS() == "Windows") {
	        nb_windows++;
	      }
	      if (c1.getOS() == "ios") {
	        nb_ios++;
	      }
	      if (c1.getOS() == "Android") {
	        nb_android++;
	      }
	      if (c1.getOS() == "Other") {
	        nb_autre++;
	      }
	    }
	    float total =
	      (nb_linux + nb_mac + nb_windows + nb_autre + nb_ios + nb_android);
	    System.out.println(
	      "Le pourcentage d'OS Linux est : " +
	      nb_linux +
	      " (" +
	      ((nb_linux / total) * 100) +
	      "%)" +
	      "\nLe pourcentage d'OS Mac est : " +
	      nb_mac +
	      " (" +
	      ((nb_mac / total) * 100) +
	      "%)" +
	      "\nLe pourcentage d'OS Windows est : " +
	      nb_windows +
	      " (" +
	      ((nb_windows / total) * 100) +
	      "‰)" +
	      "\nLe pourcentage d'OS IOS est : " +
	      nb_ios +
	      " (" +
	      ((nb_ios / total) * 100) +
	      "‰)" +
	      "\nLe pourcentage d'OS Android est : " +
	      nb_android +
	      " (" +
	      ((nb_android / total) * 100) +
	      "‰)" +
	      "\nLe pourcentage d'OS d'autre est : " +
	      nb_autre +
	      " (" +
	      ((nb_autre / total) * 100) +
	      "‰)"
	    );
	  }
  
  public void DiffNavigateur() {
	    int nb_Safari = 0;
	    int nb_Chrome = 0;
	    int nb_Firefox = 0;
	    int nb_Explorer = 0;
	    int nb_Edge = 0;
	    int nb_autre = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getNavigateur() == "Safari") {
	        nb_Safari++;
	      }
	      if (c1.getNavigateur() == "Chrome") {
	        nb_Chrome++;
	      }
	      if (c1.getNavigateur() == "Firefox") {
	        nb_Firefox++;
	      }
	      if (c1.getNavigateur() == "Internet Explorer") {
	        nb_Explorer++;
	      }
	      if (c1.getNavigateur() == "Microsoft Edge") {
	        nb_Edge++;
	      }
	      if (c1.getNavigateur() == "Other") {
	        nb_autre++;
	      }
	    }
	    float total =
	      (nb_Safari + nb_Chrome + nb_Firefox + nb_Explorer + nb_Edge + nb_autre);
	    System.out.println(
	      "Le pourcentage navigateur Safari est : " +
	      nb_Safari +
	      " (" +
	      ((nb_Safari / total) * 100) +
	      "%)" +
	      "\nLe pourcentage navigateur Chrome est : " +
	      nb_Chrome +
	      " (" +
	      ((nb_Chrome / total) * 100) +
	      "%)" +
	      "\nLe pourcentage navigateur Firefox est : " +
	      nb_Firefox +
	      " (" +
	      ((nb_Firefox / total) * 100) +
	      "‰)" +
	      "\nLe pourcentage navigateur Internet Explorer est : " +
	      nb_Explorer +
	      " (" +
	      ((nb_Explorer / total) * 100) +
	      "‰)" +
	      "\nLe pourcentage navigateur Microsoft Edge est : " +
	      nb_Edge +
	      " (" +
	      ((nb_Edge / total) * 100) +
	      "‰)" +
	      "\nLe pourcentage navigateur d'autre est : " +
	      nb_autre +
	      " (" +
	      ((nb_autre / total) * 100) +
	      "‰)"
	    );
	  }	  
  
//========================FIN methode affichage console =======================================
  
  
  
  public double get_nb_PC() {
	    double nb_pc = 0;
	    for (Connexion c1 : connexions) {
	    	if (c1.getAppareil() == "PC") {
	        nb_pc++;
	    	}	    
	    }
	    return nb_pc;
  }
 
  public double get_nb_Mobile() {
	    double nb_Mobile = 0.0;
	    for (Connexion c1 : connexions) {
	    	if (c1.getAppareil() == "Mobile") {
	        nb_Mobile++;
	    	}   
	    }
	    return nb_Mobile;
  }
  public double get_total_appareil() {
	  return get_nb_PC() + get_nb_Mobile();
  }
  
  public double get_nb_linux() {
	    double nb_linux = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getOS() == "Linux" || c1.getOS() == "linux") {
	        nb_linux++;
	      }  
	    }
	    return nb_linux;
}
  
  public double get_nb_mac() {
	    double nb_mac = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getOS() == "Mac") {
	        nb_mac++;
	    }
	    
	  }
	    return nb_mac;
}
  
  public double get_nb_windows() {
	    double nb_windows = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getOS() == "Windows") {
	        nb_windows++;
	    }
	    
	  }
	    return nb_windows;
}
  public double get_nb_autre() {
	    double nb_autre = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getOS() == "Inconnu") {
	        nb_autre++;
	    }
	    
	  }
	    return nb_autre;
}
 
  public double get_nb_IOS() {
	    double nb_IOS = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getOS() == "IOS" || c1.getOS() == "ios") {
	        nb_IOS++;
	    }
	    
	  }
	    return nb_IOS;
}
  public double get_nb_Android() {
	    double nb_android = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getOS() == "Android" || c1.getOS() == "ios") {
	        nb_android++;
	    }
	    
	  }
	    return nb_android;
}
  
  
  public int get_nb_Safari() {
	    int nb_Safari = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getNavigateur() == "Safari") {
	        nb_Safari++;
	    }
	    
	  }
	    return nb_Safari;
}
  public int get_nb_Chrome() {
	    int nb_Chrome = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getNavigateur() == "Chrome") {
	        nb_Chrome++;
	    }
	    
	  }
	    return nb_Chrome;
}
  public int get_nb_Firefox() {
	    int nb_Firefox = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getNavigateur() == "Firefox") {
	        nb_Firefox++;
	    }
	    
	  }
	    return nb_Firefox;
}
  public int get_nb_Edge() {
	    int nb_Edge = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getNavigateur() == "Microsoft Edge") {
	        nb_Edge++;
	      }
	    
	    }
	    return nb_Edge;
  }
  public int get_nb_Explorer() {
	    int nb_Explorer = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getNavigateur() == "Internet Explorer") {
	        nb_Explorer++;
	      }
	    
	    }
	    return nb_Explorer;
  }
  public int get_nb_navi_autre() {
	    int nb_autre = 0;
	    for (Connexion c1 : connexions) {
	      if (c1.getNavigateur() == "Inconnu") {
	        nb_autre++;
	      }
	    
	    }
	    return nb_autre;
  }
  
  public double get_total_navi() {
	  return get_nb_Safari() +get_nb_Chrome() + get_nb_Firefox()+ get_nb_Edge() + get_nb_Explorer()+ get_nb_navi_autre();
  }
  
  
  
  public String getDate(int nb) {

	  return connexions.elementAt(nb).getDate();
  }
  
  public String getLastDate() {
	  if(connexions.size()-1 == -1) {
		  return "";
	  }else {
		  return (connexions.elementAt(connexions.size()-1).getDate());
	  }
	  
  }
  
  
  public String getHeure(int nb) {
	  return connexions.get(nb).getHeure();
  }
  
  
  //Methode qui prend en parenmetre une date et retourne le nb utilisateur connecter a ce jour
  public void requestByDay(String date) {
    int i = 0;
    int request = 0;
    for (Connexion c1 : connexions) {
      if (date.equalsIgnoreCase(c1.getDate())) { //crée un getteur pour date
        request++;
      }
    }
    System.out.println("Il y a eu " + request + " entrée à cette date " + date);
  }
  //Methode qui affiche tous les IP unique (pas de doublons)
  public void afficheztoutlesids() {
    int i;
    for (Connexion c1 : connexions) {
      c1.afficherIp();
    }
  }
  
  
  //Methode qui affiche les IP unique
  public int entrezDiff() {
	int x = 1;
	if(connexions.size() == 0) {
		return 0;
	}
    String occurenceUnique[] = new String[connexions.size()];
    occurenceUnique[0] = connexions.elementAt(0).getIp();
    
    boolean b = false;
    for (Connexion c1 : connexions) {
      b = false;
      for (int j = 0; j < x && b == false; j++) {
        if ((c1.getIp()).equalsIgnoreCase(occurenceUnique[j]) == true ) {
          b = true;
        }
      }
      if (b == false) {
        occurenceUnique[x] = c1.getIp();
        x++;
      }
    }
    return x;
  }
  
  
  /*
   * Cette méthode repertorie les erreurs dans un tableau et
   * met leurs occurence dans un autre tableau.
   * Le but est d'afficher ensuite l'erreur la plus frequente et son nombre
   * d'occurence en cherchant la position du max dans le tableau occurence.
   */
  
  
  public int[] diff_Erreur() { //nombre d'erreur
	  int x = 0;
	  int differentsType[] = new int[connexions.size()];
	  int nombreOcurrence[] = new int[connexions.size()];
	  boolean find;
	  for (Connexion c1 : connexions) {
		  find = false;
		  if ((c1.getCode() - 400) >= 0) {
			  for (int j = 0; j < x && !find; j++) {
				  if ((c1.getCode()) == differentsType[j]) {
					  nombreOcurrence[j]++;
					  find = true;
				  }
			  }
			  if (!find) {
				  differentsType[x] = c1.getCode();
				  nombreOcurrence[x] = 1;
				  x++;
			  }
		  }
	  }
	  int aux;
	  for (int i = 0; i < x; i++) {
		  for (int j=0;j<j-i-1;j++) {
			  if (nombreOcurrence[j]>nombreOcurrence[j+1]) {
				  aux=nombreOcurrence[j+1];
				  nombreOcurrence[j+1]=nombreOcurrence[j];
				  nombreOcurrence[j]=aux;
				  aux=differentsType[j+1];
				  differentsType[j+1]=differentsType[j];
				  differentsType[j]=aux;
			  }
		  }
	  }
	  int newDifferentsType[] = new int[x];
	  int newNombreOcurrence[]=new int[x];
	  for (int f=0;f<x;f++) {
		  newDifferentsType[f]=differentsType[f];
		  newNombreOcurrence[f]=nombreOcurrence[f];
	  }

	  return newDifferentsType  ;
  }
	public int[] nombreOcurrence() { //nombre d'erreur
		int x = 0;
		int differentsType[] = new int[connexions.size()];
		int nombreOcurrence[] = new int[connexions.size()];
		boolean find;
		for (Connexion c1 : connexions) {
			find = false;
			if ((c1.getCode() - 400) >= 0) {
				for (int j = 0; j < x && !find; j++) {
					if ((c1.getCode()) == differentsType[j]) {
						nombreOcurrence[j]++;
						find = true;
					}
				}
				if (!find) {
					differentsType[x] = c1.getCode();
					nombreOcurrence[x] = 1;
					x++;
				}
			}
		}
		int aux;
		for (int i = 0; i < x; i++) {
			for (int j=0;j<j-i-1;j++) {
				if (nombreOcurrence[j]>nombreOcurrence[j+1]) {
					aux=nombreOcurrence[j+1];
					nombreOcurrence[j+1]=nombreOcurrence[j];
					nombreOcurrence[j]=aux;
					aux=differentsType[j+1];
					differentsType[j+1]=differentsType[j];
					differentsType[j]=aux;
				}
			}
		}
		int newDifferentsType[] = new int[x];
		int newNombreOcurrence[]=new int[x];
		for (int f=0;f<x;f++) {
			newDifferentsType[f]=differentsType[f];
			newNombreOcurrence[f]=nombreOcurrence[f];
		}
		return newNombreOcurrence  ;
	}
	public int nombreErreur() { //nombre d'erreur
		int x = 0;
		int differentsType[] = new int[connexions.size()];
		int nombreOcurrence[] = new int[connexions.size()];
		boolean find;
		for (Connexion c1 : connexions) {
			find = false;
			if ((c1.getCode() - 400) >= 0) {
				for (int j = 0; j < x && !find; j++) {
					if ((c1.getCode()) == differentsType[j]) {
						nombreOcurrence[j]++;
						find = true;
					}
				}
				if (!find) {
					differentsType[x] = c1.getCode();
					nombreOcurrence[x] = 1;
					x++;
				}
			}
		}
		int aux;
		for (int i = 0; i < x; i++) {
			for (int j=0;j<j-i-1;j++) {
				if (nombreOcurrence[j]>nombreOcurrence[j+1]) {
					aux=nombreOcurrence[j+1];
					nombreOcurrence[j+1]=nombreOcurrence[j];
					nombreOcurrence[j]=aux;
					aux=differentsType[j+1];
					differentsType[j+1]=differentsType[j];
					differentsType[j]=aux;
				}
			}
		}
		int newDifferentsType[] = new int[x];
		int newNombreOcurrence[]=new int[x];
		int somme=0;
		for (int f=0;f<x;f++) {
			newDifferentsType[f]=differentsType[f];
			newNombreOcurrence[f]=nombreOcurrence[f];
			somme=nombreOcurrence[f]+somme;
		}
		return somme  ;
	}
}


