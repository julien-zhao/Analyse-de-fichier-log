package BDD;
import org.json.simple.JSONObject;

import org.json.simple.JSONArray;
import java.util.Vector;
import Fonction.*;

public class PersonneJson {
	
	
	//renvoie les info sups des top5 ip
	public static JSONArray getPersonneTop5(){
		JSONArray arr = new JSONArray();
		Vector<String> listIP = new Vector<String>();
		if(InsererConnexionBd.recupererI("Fonctionalitee", "compteur") == 0) {
			return arr;
		}
		String i1[]=InsererConnexionBd.recupererAll("ocurrenceip", "Ip");
		int i2[]=InsererConnexionBd.recupererAllI("ocurrenceip", "Occurence");

		int n;
		String n1;
		int v=i2.length;
		for (int i=0;i<v-1;i++) {

			for (int j=0;j<v-i-1;j++) {

				if(i2[i]>i2[i+1]) {
					n=i2[i+1];
					i2[i+1]=i2[i];
					i2[i]=n;
					
					n1=i1[i+1];
					i1[i+1]=i1[i];
					i1[i]=n1;
				}
				
			}
		
			
	}
		String ip1 = i1[i1.length-1];
		String ip2 = i1[i1.length-2];
		String ip3 = i1[i1.length-3];
		String ip4 = i1[i1.length-4];
		String ip5 = i1[i1.length-5];
	
		arr.add(getPersonne(i2[i1.length-1],ip1));
		arr.add(getPersonne(i2[i1.length-2],ip2));
		arr.add(getPersonne(i2[i1.length-3],ip3));
		arr.add(getPersonne(i2[i1.length-4],ip4));
		arr.add(getPersonne(i2[i1.length-5],ip5));
		return arr;	
	}
	
	
	
	//renvoie les infos d'une personne
	public static JSONObject getPersonne(int t1, String ip) {
		JSONObject obj = new JSONObject();
		obj.put("IP", ip);
		obj.put("Occu", t1);
		obj.put("Pays",LocalisationJson.getOneCountry(ip));
		
		obj.put("Ville",LocalisationJson.getOneCity(ip));
		obj.put("Navigateur",InsererConnexionBd.recuperer("connexions","Date", ip));
		obj.put("DerniereSiteConsulte",InsererConnexionBd.recuperer("connexions","Url", ip));
		obj.put("DerniereConnexion",InsererConnexionBd.recuperer("connexions","Heure", ip));
		
		return obj;
	}
}