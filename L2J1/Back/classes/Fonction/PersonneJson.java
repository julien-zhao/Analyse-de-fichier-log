package Fonction;

import org.json.simple.JSONObject;

import org.json.simple.JSONArray;
import java.util.Vector;


public class PersonneJson {
	
	//Renvoie l'occ d'une ip à partir de son indice
	public static int getOneOcc(Tableau t1, int nb) {
		int occ =0;
		for(int i =0 ; i< t1.getTaille(); i++) {
			if(t1.getOneIP(nb).equals(t1.getOneIP(i))) {
				occ++;
			}
		}	
		return occ;
	}
	
	
	//Renvoie sous forme de json l'ip qui a le plus d'occ 
	public static JSONObject getMustIp(Tableau t1) {
		JSONObject obj = new JSONObject();
		String ip1 =null;
		int test1 = getOneOcc(t1, 0);
		
		for(int i = 1; i< t1.getTaille();i++) {
			if(test1 < getOneOcc(t1,i)) {
				test1 = getOneOcc(t1,i);
				ip1 = t1.getOneIP(i);
			}
		}	
		obj.put(ip1, test1);
		return obj;		
	}
	 
	//Fonctionnalité: renvoie l'ip et son nb d'occ
	public static JSONObject getOccIp(Tableau t1) {
		JSONObject obj = new JSONObject();
		Vector<String> listIP = new Vector<String>();
         
		for(int i = 0; i< t1.getTaille();i++) {
			if(!(listIP.contains(t1.getOneIP(i)))) {
				listIP.add(t1.getOneIP(i));
				obj.put(t1.getOneIP(i), getOneOcc(t1,i));
			}
		}
		return obj;	
	}
	
	
	//Renvoie les ip uniques
	public static JSONArray getIpUnique(Tableau t1) {
		JSONArray obj = new JSONArray();
		Vector<String> listIP = new Vector<String>();
        
        
		for(int i = 1; i< t1.getTaille();i++) {
			if(!(listIP.contains(t1.getOneIP(i)))) {
				listIP.add(t1.getOneIP(i));
				obj.add(t1.getOneIP(i));
			}
		}
		return obj;	
	}
	
	

	 
	
	//Renvoie l'occ a partir d'une ip
	public static int getOneOccByIp(Tableau t1, String ip) {
		int occ =0;
		for(int i =0 ; i< t1.getTaille(); i++) {
			if(ip.equals(t1.getOneIP(i))) {
				occ++;
			}
		}	
		return occ;
	}
	
	//Renvoie l'ip qui a le plud d'occ et le supprime
	public static String getMustIpByListIp(Tableau t1, Vector<String> list) {
		String ip1 =list.get(0);
		int index =0;
		int occ = getOneOccByIp(t1, list.get(0));
		for(int i =1; i<list.size();i++) {
			if(occ < getOneOccByIp(t1,list.get(i))) {
				occ = getOneOccByIp(t1,list.get(i));
				ip1 = list.get(i);
				index = i;
			}
		}
		list.remove(index);
		return ip1;
	}
	
	//renvoie les info sups des top5 ip
	public static JSONArray getPersonneTop5(Tableau t1){
		JSONArray arr = new JSONArray();
		Vector<String> listIP = new Vector<String>();
		if(t1.getTaille() == 0) {
			return arr;
		}
		for(int i = 0; i< t1.getTaille();i++) {
			if(!(listIP.contains(t1.getOneIP(i)))) {
				listIP.add(t1.getOneIP(i));
			}
		}
		String ip1 = getMustIpByListIp(t1, listIP);
		String ip2 = getMustIpByListIp(t1, listIP);
		String ip3 = getMustIpByListIp(t1, listIP);
		String ip4 = getMustIpByListIp(t1, listIP);
		String ip5 = getMustIpByListIp(t1, listIP);
	
		arr.add(getPersonne(t1,ip1));
		arr.add(getPersonne(t1,ip2));
		arr.add(getPersonne(t1,ip3));
		arr.add(getPersonne(t1,ip4));
		arr.add(getPersonne(t1,ip5));
		return arr;	
	}
	
	
	//renvoie les infos d'une personne
	public static JSONObject getPersonne(Tableau t1, String ip) {
		JSONObject obj = new JSONObject();
		obj.put("IP", ip);
		obj.put("Occu", getOneOccByIp(t1,ip));
		obj.put("Pays",LocalisationJson.getOneCountry(ip));
		
		obj.put("Ville",LocalisationJson.getOneCity(ip));
		obj.put("Navigateur",NavigateurJson.getOneNavi(t1, ip));
		obj.put("DerniereSiteConsulte",UrlJson.getUrlByIp(t1, ip));
		obj.put("DerniereConnexion",HeureJson.getOneHeure(t1, ip));
		
		return obj;
	}
}

