package Fonction;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Vector;

public class UrlJson {
	//definir les extentiosn qu'on souhaite avoir
	static String extention1 = ".html";
	static String extention2 = ".css";
	static String extention3 = ".php";
	static String extention4 = ".pdf";
	static String extention5 = ".xhtml";

	//renvoie l'occ de l'url en parametre
	public static int getOccUrl(Tableau t1, String url) {
		int occ =0;
		for(int i =0 ; i< t1.getTaille(); i++) {
			if(url.equals(t1.getUrl(i))){
				occ++;
			}
		}	
		return occ;
	}
	 
	//renvoie l'occ url sauf les .html, .css, .php, .xhtml, .pdf
	public static JSONObject getOccUrl(Tableau t1) {
		JSONObject obj = new JSONObject();
		Vector<String> listUrl = new Vector<String>();

		for(int i = 1; i< t1.getTaille();i++) {
			if(!(listUrl.contains(t1.getUrl(i)))  && !(t1.getUrl(i).contains(extention1)) && !(t1.getUrl(i).contains(extention2)) && !(t1.getUrl(i).contains(extention3)) && !(t1.getUrl(i).contains(extention4)) && !(t1.getUrl(i).contains(extention5))&& !(t1.getUrl(i).equals("-")) ) {
				listUrl.add(t1.getUrl(i));
				obj.put(t1.getUrl(i), getOccUrl(t1,t1.getUrl(i)));
			}
		}
		return obj;	
	}
	
	//renvoie les occ des url extentions
	public static JSONArray getOccUrlDownload(Tableau t1) {
		JSONArray arr = new JSONArray();
		arr.add(getOneUrlDownload(t1, extention1));
		arr.add(getOneUrlDownload(t1, extention2));
		arr.add(getOneUrlDownload(t1, extention3));
		arr.add(getOneUrlDownload(t1, extention4));
		arr.add(getOneUrlDownload(t1, extention5));		
		return arr;	
	}
	
	//renvoie l'occ de l'url en parametre
	public static JSONObject getOneUrlDownload(Tableau t1, String extention) {
		JSONArray arr = new JSONArray();
		int max=0;
		Vector<String> listUrl = new Vector<String>();
		JSONObject obj = new JSONObject();

		for(int i = 0; i< t1.getTaille();i++) {;
			if( t1.getUrl(i).contains(extention) && !(listUrl.contains(t1.getUrl(i))) ) {
				int troisEmeSlache = (t1.getUrl(i)).indexOf("/", 7);

				
				String url = t1.getUrl(i).substring(troisEmeSlache+1, t1.getUrl(i).length());
				listUrl.add(url);

				//pour recuperer l'occ le plus important de l'extention 
				if(max<getOccUrl(t1,t1.getUrl(i))) {
					max = getOccUrl(t1,t1.getUrl(i));
					obj.put("Url",url);
					obj.put("Occ",getOccUrl(t1,t1.getUrl(i)));
				}
			}
		}
		return obj;
	}
	
	//renvoie l'url a partir de l'ip
	public static String getUrlByIp(Tableau t1, String ip) {
		return t1.getUrl(ip);
	}

}
