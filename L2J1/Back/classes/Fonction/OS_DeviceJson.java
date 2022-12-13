package Fonction;

import org.json.simple.JSONObject;

public class OS_DeviceJson {
	
	//Json OS de PC
	public static JSONObject getNB_PC_OS(Tableau t1) {
		
		JSONObject obj = new JSONObject();
		obj.put("Nb_Linux", (float)(t1.get_nb_linux()));
		obj.put("Nb_Windows", (float)(t1.get_nb_windows()));
		obj.put("Nb_Mac", (float)(t1.get_nb_mac()));
		obj.put("Nb_Autre_OS_PC", (float)(t1.get_nb_autre()));
		return obj;
	}
		
	//Json pc/mobile
	public static JSONObject getNB_PC_Mobile(Tableau t1) {
		JSONObject obj = new JSONObject();
		obj.put("Nb_Pc", (t1.get_nb_PC()));
		obj.put("Nb_Mobile", (t1.get_nb_Mobile()));
		return obj;
	}
	
	//Json OS de Mobile
	public static JSONObject getNB_Mobile_OS(Tableau t1) {
		JSONObject obj = new JSONObject();
		obj.put("nb_Android", (double)(t1.get_nb_Android()));
		obj.put("nb_IOS", (double)(t1.get_nb_IOS()));
		obj.put("nb_autre_OS_Mobile", (double)(t1.get_nb_Mobile() - (t1.get_nb_Android()+t1.get_nb_IOS())));
		return obj;
	}
	
}
