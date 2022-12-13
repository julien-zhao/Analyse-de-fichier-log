package Fonction;

import org.json.simple.JSONObject;

public class HeureJson {
	//get l'heure a partir de l'indice
	static int getOnlyHeure(Tableau t1, int nb) {
		
		String heure = t1.getHeure(nb).substring(0,2); 
		return Integer.valueOf(heure);
	}
	//retourne le nb d'occ a partir de d'heure
	static int getTotalByHeure(Tableau t1,int heure) {
		int total =0;
		for(int i = 0; i<t1.getTaille();i++) {
			if(getOnlyHeure(t1,i) == heure) {
				total++;
			}
		}
		return total;
	}
	
	//retourne pour chaque heure (0h à 23h) le nb d'occ
	public static JSONObject getHeure(Tableau t1) {
		JSONObject obj = new JSONObject();
		for(int i = 0; i<24;i++) {
			obj.putIfAbsent(i, getTotalByHeure(t1,i));
		}
		return obj;
	}
	
	//retourne l'heure ou ya le plus d'occ (pour faire des mise a jour)
	public static JSONObject getMostHeure(Tableau t1) {
		JSONObject obj = new JSONObject();
		int occ = getTotalByHeure(t1, 0);
		int heure = 0;
		for(int i = 1; i<24; i++) {
			if(occ < getTotalByHeure(t1,i)) {
				occ = getTotalByHeure(t1,i);
				heure = i;
			}
		}
		obj.put(heure, occ);
		
		return obj;
	}
	
	//retourne l'heure a partir d'une ip
	public static String getOneHeure(Tableau t1, String ip) {
		return t1.getHeure(ip);
	}
}	

