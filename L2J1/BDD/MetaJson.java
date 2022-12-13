package BDD;
import org.json.simple.JSONObject;





import org.json.simple.JSONArray;



public class MetaJson {
	//renvoie les infos general comme le nb de ligne et la taille du fichier
	public static JSONArray GetMeta(){
		JSONObject obj = new JSONObject();
		
	    obj.put("Nb_line", InsererConnexionBd.recuperer("fonctionalitee","compteur"));
	    obj.put("Size_octets",InsererConnexionBd.recuperer("fonctionalitee","taille_octet") );
	    obj.put("Ip_unique", InsererConnexionBd.recuperer("fonctionalitee","OcurrenceUnique"));
	    obj.put("Dernier_date", InsererConnexionBd.recuperer("connexions","Date"));
	    JSONArray arr = new JSONArray();
	    arr.add(obj);
	    return arr;
	}
	
	
}
