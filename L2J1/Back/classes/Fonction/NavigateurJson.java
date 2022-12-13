package Fonction;
import org.json.simple.*;

public class NavigateurJson {
	public static JSONArray getNB_Navigateur(Tableau t1) {
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		JSONObject obj3 = new JSONObject();
		JSONObject obj4 = new JSONObject();
		JSONObject obj5 = new JSONObject();
		JSONObject obj6 = new JSONObject();
		JSONArray arr = new JSONArray();
		obj1.put("Nav", "Chrome");
		obj1.put("occ", (t1.get_nb_Chrome()));
		
		obj2.put("Nav", "Safari");
		obj2.put("occ", (t1.get_nb_Safari()));
		
		obj3.put("Nav","Firefox");
		obj3.put("occ", (t1.get_nb_Firefox()));
		
		obj4.put("Nav","Microsoft_edge");
		obj4.put("occ", (t1.get_nb_Edge()));
		
		obj5.put("Nav","Internet_explorer");
		obj5.put("occ", (t1.get_nb_Explorer()));
		
		obj6.put("Nav","Autre");
		obj6.put("occ", (t1.get_nb_navi_autre()));
		
		arr.add(obj1);
		arr.add(obj2);
		arr.add(obj3);
		arr.add(obj4);
		arr.add(obj5);
		arr.add(obj6);
		return arr;
	}
	//renvoie le navigateur a partir de l'ip
	public static String getOneNavi(Tableau t1, String ip) {
		return t1.getNavi(ip);
	}
}