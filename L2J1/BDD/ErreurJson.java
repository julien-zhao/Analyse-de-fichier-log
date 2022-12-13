package BDD;
import org.json.simple.JSONObject;

public class ErreurJson {
	public static JSONObject get_Diff_Error(){
		JSONObject obj = new JSONObject();
		
		for (int i=0;i<InsererConnexionBd.recupererAll("erreur", "erreur").length;i++) {
			obj.put(InsererConnexionBd.recupererAll("erreur", "erreur")[i],InsererConnexionBd.recupererAll("erreur", "occurence")[i]);
			
		}
		return obj;
	}
	public static JSONObject get_Nombre_Error() {
		JSONObject obj = new JSONObject();
		obj.put("Error",InsererConnexionBd.recupererI("fonctionalitee", "erreurNB"));
		obj.put("Succes", InsererConnexionBd.recupererI("fonctionalitee", "compteur")-InsererConnexionBd.recupererI("fonctionalitee", "erreurNB"));
		return obj;
	}
	public static JSONObject get_Diff_Ocurrence(){
		JSONObject obj = new JSONObject();
		obj.put("IP", InsererConnexionBd.recupererI("fonctionalitee", "compteur"));
		obj.put("IP_unique",InsererConnexionBd.recupererI("fonctionalitee", "OcurrenceUnique"));
		return obj ;
	}
}
