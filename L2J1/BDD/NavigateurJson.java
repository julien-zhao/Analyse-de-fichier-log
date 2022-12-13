package BDD;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NavigateurJson {
	public static JSONArray getNB_Navigateur() {
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		JSONObject obj3 = new JSONObject();
		JSONObject obj4 = new JSONObject();
		JSONObject obj5 = new JSONObject();
		JSONArray arr = new JSONArray();
		obj.put("Nav", "Chrome");
		obj.put("occ", InsererConnexionBd.recupererI("navigateur", "Chrome"));
		arr.add(obj);
		obj1.put("Nav", "Safari");
		obj1.put("occ", InsererConnexionBd.recupererI("navigateur", "Safari"));
		arr.add(obj1);
		obj2.put("Nav", "Firefox");
		obj2.put("occ", InsererConnexionBd.recupererI("navigateur", "Firefox"));
		arr.add(obj2);
		obj3.put("Nav", "Microsoft_edge");
		obj3.put("occ", InsererConnexionBd.recupererI("navigateur", "Edge"));
		arr.add(obj3);
		obj4.put("Nav", "Internet_explorer");
		obj4.put("occ", InsererConnexionBd.recupererI("navigateur", "explorer"));
		arr.add(obj4);
		obj5.put("Nav", "Autre");
		obj5.put("occ", InsererConnexionBd.recupererI("navigateur", "Autre"));
		arr.add(obj5);
		
		return arr;
	}
}
