package BDD;

import org.json.simple.JSONObject;

public class OS_DeviceJson {
	
	//Json OS de PC
	public static JSONObject getNB_PC_OS() {
		
		JSONObject obj = new JSONObject();
		obj.put("Nb_Linux", (float)(InsererConnexionBd.recupererI("pcetmobile","Linux")));
		obj.put("Nb_Windows", (float)((InsererConnexionBd.recupererI("pcetmobile","Windows"))));
		obj.put("Nb_Mac", (float)((InsererConnexionBd.recupererI("pcetmobile","Mac"))));
		obj.put("Nb_autre_OS_PC", (float)((InsererConnexionBd.recupererI("pcetmobile","autre_os_pc"))));
		return obj;
	}
		
	//Json pc/mobile
	public static JSONObject getNB_PC_Mobile() {
		JSONObject obj = new JSONObject();
		obj.put("Nb_Pc", (float)((InsererConnexionBd.recupererI("fonctionalitee","pcNB"))));
		obj.put("Nb_Mobile",(float) (InsererConnexionBd.recupererI("fonctionalitee","mobileNB")));
		return obj;
	}
	
	//Json OS de Mobile
	public static JSONObject getNB_Mobile_OS() {
		JSONObject obj = new JSONObject();
		obj.put("nb_Android", (double)((InsererConnexionBd.recupererI("pcetmobile","nb_android"))));
		obj.put("nb_IOS", (double)((InsererConnexionBd.recupererI("pcetmobile","nb_ios"))));
		obj.put("nb_autre_OS_Mobile", (double)((InsererConnexionBd.recupererI("pcetmobile","nb_autre_os_mobile"))));
		return obj;
	}
	
}

