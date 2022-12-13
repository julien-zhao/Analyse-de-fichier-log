package Fonction;

import org.json.simple.JSONObject;

public class LogsJson{
	
   public static JSONObject GetLogs(Connexion c1){
    	JSONObject obj = new JSONObject();
    	obj.put("IP", c1.getIp());
    	obj.put("Date", c1.getDate());
        obj.put("Heure", c1.getHeure());
        obj.put("Os", c1.getOS());
        obj.put("Url", c1.getUrl());
        obj.put("Navigateur", c1.getNavigateur());
        obj.put("Appareil", c1.getAppareil());
        obj.put("Request", c1.getCode());
        obj.put("Info", c1.getInfo());
    	return obj;
    }

}