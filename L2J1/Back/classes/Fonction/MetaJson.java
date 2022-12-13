package Fonction;
import org.json.simple.JSONObject;

import BDD.InsererConnexionBd;

import org.json.simple.JSONArray;
import BDD.*;


public class MetaJson {
	//renvoie les infos general comme le nb de ligne et la taille du fichier
	public static JSONArray GetMeta(Tableau tab){
		JSONObject obj = new JSONObject();
		double taille_octets = getSize();
	    obj.put("Nb_line", tab.getTaille());
	    obj.put("Size_octets", taille_octets);
	    obj.put("Ip_unique", ErreurJson.get_Diff_Ocurrence(tab));
	    obj.put("Dernier_date", SevenLastJson.lastDate(tab));
	    JSONArray arr = new JSONArray();
	    arr.add(obj);
	    return arr;
	}
	
	public static double getSize() {
		double taille_octets = Generer.getLien().length();
		return taille_octets;
	}
	public static int getLine(Tableau tab) {
		return tab.getTaille();
	}
}

