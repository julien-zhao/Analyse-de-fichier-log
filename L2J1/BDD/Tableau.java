package BDD;
public class Tableau {
	static int cont =0;
  Connexion connexions[] = new Connexion[cont];
  public void assignez(Connexion c1, int j) {
    connexions[j] = c1;
  }
  
 //==============================Methode affichage sur la console=================================
  public void PC_Mobile() {
    int nb_pc = 0;
    int nb_mobile = 0;
    for (int i = 0; i < cont; i++) {
      if (connexions[i].getAppareil() == "PC") {
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
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getOS() == "linux") {
	        nb_linux++;
	      }
	      if (connexions[i].getOS() == "Mac") {
	        nb_mac++;
	      }
	      if (connexions[i].getOS() == "Windows") {
	        nb_windows++;
	      }
	      if (connexions[i].getOS() == "ios") {
	        nb_ios++;
	      }
	      if (connexions[i].getOS() == "Android") {
	        nb_android++;
	      }
	      if (connexions[i].getOS() == "Other") {
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
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getNavigateur() == "Safari") {
	        nb_Safari++;
	      }
	      if (connexions[i].getNavigateur() == "Chrome") {
	        nb_Chrome++;
	      }
	      if (connexions[i].getNavigateur() == "Firefox") {
	        nb_Firefox++;
	      }
	      if (connexions[i].getNavigateur() == "Internet Explorer") {
	        nb_Explorer++;
	      }
	      if (connexions[i].getNavigateur() == "Microsoft Edge") {
	        nb_Edge++;
	      }
	      if (connexions[i].getNavigateur() == "Other") {
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
	    for (int i = 0; i < cont; i++) {
	    	if (connexions[i].getAppareil() == "PC") {
	        nb_pc++;
	    	}	    
	    }
	    return nb_pc;
  }
 
  public double get_nb_Mobile() {
	    double nb_Mobile = 0.0;
	    for (int i = 0; i < cont; i++) {
	    	if (connexions[i].getAppareil() == "Mobile") {
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
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getOS() == "Linux" || connexions[i].getOS() == "linux") {
	        nb_linux++;
	      }  
	    }
	    return nb_linux;
}
  
  public double get_nb_mac() {
	    double nb_mac = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getOS() == "Mac") {
	        nb_mac++;
	    }
	    
	  }
	    return nb_mac;
}
  
  public double get_nb_windows() {
	    double nb_windows = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getOS() == "Windows") {
	        nb_windows++;
	    }
	    
	  }
	    return nb_windows;
}
  public double get_nb_autre() {
	    double nb_autre = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getOS() == "Other") {
	        nb_autre++;
	    }
	    
	  }
	    return nb_autre;
}
 
  public double get_nb_IOS() {
	    double nb_IOS = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getOS() == "IOS" || connexions[i].getOS() == "ios") {
	        nb_IOS++;
	    }
	    
	  }
	    return nb_IOS;
}
  public double get_nb_Android() {
	    double nb_android = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getOS() == "Android" || connexions[i].getOS() == "ios") {
	        nb_android++;
	    }
	    
	  }
	    return nb_android;
}
  
  
  public int get_nb_Safari() {
	    int nb_Safari = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getNavigateur() == "Safari") {
	        nb_Safari++;
	    }
	    
	  }
	    return nb_Safari;
}
  public int get_nb_Chrome() {
	    int nb_Chrome = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getNavigateur() == "Chrome") {
	        nb_Chrome++;
	    }
	    
	  }
	    return nb_Chrome;
}
  public int get_nb_Firefox() {
	    int nb_Firefox = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getNavigateur() == "Firefox") {
	        nb_Firefox++;
	    }
	    
	  }
	    return nb_Firefox;
}
  public int get_nb_Edge() {
	    int nb_Edge = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getNavigateur() == "Microsoft Edge") {
	        nb_Edge++;
	      }
	    
	    }
	    return nb_Edge;
  }
  public int get_nb_Explorer() {
	    int nb_Explorer = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getNavigateur() == "Internet Explorer") {
	        nb_Explorer++;
	      }
	    
	    }
	    return nb_Explorer;
  }
  public int get_nb_navi_autre() {
	    int nb_autre = 0;
	    for (int i = 0; i < cont; i++) {
	      if (connexions[i].getNavigateur() == "Other") {
	        nb_autre++;
	      }
	    
	    }
	    return nb_autre;
  }
  
  public double get_total_navi() {
	  return get_nb_Safari() +get_nb_Chrome() + get_nb_Firefox()+ get_nb_Edge() + get_nb_Explorer()+ get_nb_navi_autre();
  }
  
  public String getDate(int nb) {
	  
	  return connexions[nb].getDate();
  }
  
  public String getLastDate() {
	  return (connexions[cont-1].getDate());
  }
  
  
  
  //Methode qui prend en parenmetre une date et retourne le nb utilisateur connecter a ce jour
  public void requestByDay(String date) {
    int i = 0;
    int request = 0;
    for (i = 0; i < cont; i++) {
      if (date.equalsIgnoreCase(connexions[i].getDate())) { //crée un getteur pour date
        request++;
      }
    }
    
  }
  //Methode qui affiche tous les IP unique (pas de doublons)
  public void afficheztoutlesids() {
    int i;
    for (i = 0; i < cont; i++) {
      connexions[i].afficherIp();
    }
  }
  
  
  //Methode qui affiche les IP unique
  public int entrezDiff() {
	    String occurenceUnique[] = new String[cont];
	    int occurence[] =new int[cont];
	    
	    occurenceUnique[0] = connexions[0].getIp();
	    occurence[0]=1;
	    int x = 1;
	    boolean b = false;
	    for (int i = 1; i < cont; i++) {
	      b = false;
	      for (int j = 0; j < x && b == false; j++) {
	        if ((connexions[i].getIp()).equalsIgnoreCase(occurenceUnique[j]) == true ) {
	        	occurence[j]=occurence[j]+1;
	          b = true;
	        }
	      }
	      if (b == false) {
	        occurenceUnique[x] = connexions[i].getIp();
	        occurence[x]=1;
	        x++;
	      }
	      
	    }
	    return x;
  }
  public String[] ipDiff() {//les differents adresse ip
	    String occurenceUnique[] = new String[cont];
	    occurenceUnique[0] = connexions[0].getIp();
	    int x = 1;
	    boolean b = false;
	    
	    for (int i = 1; i < cont; i++) {
	      b = false;
	      for (int j = 0; j < x && b == false; j++) {
	        if ((connexions[i].getIp()).equalsIgnoreCase(occurenceUnique[j]) == true ) {
	          b = true;
	        }
	      }
	      if (b == false) {
	        occurenceUnique[x] = connexions[i].getIp();
	        x++;
	      }
	    } 
	   
	    return occurenceUnique;
	  }
  public int[] OccurrenceipDiff() { // l'occurence de chaque adresse ip
	    String occurenceUnique[] = new String[cont];
	    int occurence[] =new int[cont];
	    
	    occurenceUnique[0] = connexions[0].getIp();
	    occurence[0]=1;
	    int x = 1;
	    boolean b = false;
	    for (int i = 1; i < cont; i++) {
	      b = false;
	      for (int j = 0; j < x && b == false; j++) {
	        if ((connexions[i].getIp()).equalsIgnoreCase(occurenceUnique[j]) == true ) {
	        	occurence[j]=occurence[j]+1;
	          b = true;
	        }
	      }
	      if (b == false) {
	        occurenceUnique[x] = connexions[i].getIp();
	        occurence[x]=1;
	        x++;
	      }
	    } 
	   
	    return occurence;
	  }


	  
  
  
  /*
   * Cette méthode repertorie les erreurs dans un tableau et
   * met leurs occurence dans un autre tableau.
   * Le but est d'afficher ensuite l'erreur la plus frequente et son nombre
   * d'occurence en cherchant la position du max dans le tableau occurence.
   */
  public int[] diff_Erreur() { //les differents types d'erreur
	  int x = 0;
	  int differentsType[] = new int[cont];
	  int nombreOcurrence[] = new int[cont];
	  boolean find;
	  for (int i = 0; i < cont; i++) {
		  find = false;
		  if ((connexions[i].getCode() - 400) >= 0) {
			  for (int j = 0; j < x && !find; j++) {
				  if ((connexions[i].getCode()) == differentsType[j]) {
					  nombreOcurrence[j]++;
					  find = true;
				  }
			  }
			  if (!find) {
				  differentsType[x] = connexions[i].getCode();
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
	public int[] nombreOcurrence() { //l'occurence des differents types d'erreur
		int x = 0;
		int differentsType[] = new int[cont];
		int nombreOcurrence[] = new int[cont];
		boolean find;
		for (int i = 0; i < cont; i++) {
			find = false;
			if ((connexions[i].getCode() - 400) >= 0) {
				for (int j = 0; j < x && !find; j++) {
					if ((connexions[i].getCode()) == differentsType[j]) {
						nombreOcurrence[j]++;
						find = true;
					}
				}
				if (!find) {
					differentsType[x] = connexions[i].getCode();
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
	public int nombreErreur() { //nombre d'erreur total
		int x = 0;
		int differentsType[] = new int[cont];
		int nombreOcurrence[] = new int[cont];
		boolean find;
		for (int i = 0; i < cont; i++) {
			find = false;
			if ((connexions[i].getCode() - 400) >= 0) {
				for (int j = 0; j < x && !find; j++) {
					if ((connexions[i].getCode()) == differentsType[j]) {
						nombreOcurrence[j]++;
						find = true;
					}
				}
				if (!find) {
					differentsType[x] = connexions[i].getCode();
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
	public String[] toStringe(){
	      String[] tab=new String[cont] ;
	    for (int i=0;i<cont;i++){
	     tab[i]=connexions[i].toString();
	                   
	    }
	    return tab;

	}
	
	public int[] Url() {
        int tab[] = new int[5];
        String extention1 = ".html";
        String extention2 = ".css";
        String extention3 = ".php";
        String extention4 = ".pdf";
        String extention5 = ".xhtml";
        for (int i=0;i<cont;i++) {
            if (connexions[i].getUrl().contains(extention1)) {
                tab[0]++;

            }
            if (connexions[i].getUrl().contains(extention2)) {
                tab[1]++;

            }
            if (connexions[i].getUrl().contains(extention3)) {
                tab[2]++;

            }
            if (connexions[i].getUrl().contains(extention4)) {
                tab[3]++;

            }
            if (connexions[i].getUrl().contains(extention5)) {
                tab[4]++;

            }

        }
        return tab;
    }
}



