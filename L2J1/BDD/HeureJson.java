package BDD;
import org.json.simple.JSONObject;

public class HeureJson {
	//get l'heure a partir de l'indice
	static int getOnlyHeure( int nb) {
		String t1[]=InsererConnexionBd.recupererAll("connexions", "Heure");
		String heure = t1[nb].substring(0,2); 
		System.out.println(t1[1].substring(0,2));
		return Integer.valueOf(heure);
	}
	//retourne le nb d'occ a partir de d'heure
	static int getTotalByHeure(int heure) {
		int total =0;
		for(int i = 0; i<InsererConnexionBd.recupererI("fonctionalitee", "compteur");i++) {
			if(getOnlyHeure(i) == heure) {
				total++;
			}
		}
		return total;
	}
	
	//retourne pour chaque heure (0h à 23h) le nb d'occ
	public static JSONObject getHeure() {
		JSONObject obj = new JSONObject();
		for(int i = 0; i<24;i++) {
			obj.putIfAbsent(i, getTotalByHeure(i));
		}
		return obj;
	}
	
	//retourne l'heure ou ya le plus d'occ (pour faire des mise a jour)
	public static JSONObject getMostHeure() {
		JSONObject obj = new JSONObject();
		int occ = getTotalByHeure(0);
		int heure = 0;
		for(int i = 1; i<24; i++) {
			if(occ < getTotalByHeure(i)) {
				occ = getTotalByHeure(i);
				heure = i;
			}
		}
		obj.put(heure, occ);
		
		return obj;
	}
	
	//retourne l'heure a partir d'une ip
	public static String getOneHeure( String ip) {
		return InsererConnexionBd.recuperer("connexions","Heure",ip);
	}
}	


