package Fonction;
import org.json.simple.JSONObject;
public class FonctionnaliteJson{
	
	//=================Affichage json en une ligne=================
	static JSONObject afficheFonctionJSon(Tableau t1) {
		JSONObject obj = new JSONObject();
		obj.put("Nb_pc", t1.get_nb_PC());
		obj.put("Nb_Mobile", t1.get_nb_Mobile());
		obj.put("Nb_Linux", t1.get_nb_linux());
		obj.put("Nb_Windows", t1.get_nb_windows());
		obj.put("Nb_Mac", t1.get_nb_mac());
		obj.put("Nb_IOS", t1.get_nb_IOS());
		obj.put("Nb_Android", t1.get_nb_Android());
		obj.put("Nb_Chrome", t1.get_nb_Chrome());
		obj.put("Nb_Safari", t1.get_nb_Safari());
		obj.put("Nb_Firefox", t1.get_nb_Firefox());
		obj.put("Nb_Microsoft_Edge", t1.get_nb_Edge());
		obj.put("Nb_Internet_Explorer", t1.get_nb_Explorer());
		obj.put("Nb_autre", t1.get_nb_navi_autre());
		return obj;
	}
	//=============================================================
 
}

