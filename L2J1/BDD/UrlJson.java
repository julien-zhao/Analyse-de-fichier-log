package BDD;
import org.json.simple.JSONObject;
import java.io.*;
import org.json.simple.JSONArray;
import java.util.Vector;
public class UrlJson {
	//definir les extentiosn qu'on souhaite avoir
	static String extention1 = ".html";
	static String extention2 = ".css";
	static String extention3 = ".php";
	static String extention4 = ".pdf";
	static String extention5 = ".xhtml";
	
	 
	//renvoie l'occ url sauf les .html, .css, .php, .xhtml, .pdf
	public static JSONArray getOccUrlDownload2() {
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		JSONObject obj3 = new JSONObject();
		JSONObject obj4 = new JSONObject();
		JSONObject obj5 = new JSONObject();
		JSONObject vid = new JSONObject();
		if (0<InsererConnexionBd.recupererI("urlocc", "html")) {
			obj.put("Url",extention1);
			obj.put("Occ",InsererConnexionBd.recupererI("urlocc", "html"));
			arr.add(obj);
			System.out.println("ok");
		}else {
			arr.add(vid);
		}
		
		if (0<InsererConnexionBd.recupererI("urlocc", "css")) {
			obj1.put("Url",extention2);
			obj1.put("Occ",InsererConnexionBd.recupererI("urlocc", "css"));
			arr.add(obj1);
		}else {
			arr.add(vid);
		}
			
		if (0<InsererConnexionBd.recupererI("urlocc", "php")) {
			obj2.put("Url",extention3);
			obj2.put("Occ",InsererConnexionBd.recupererI("urlocc", "php"));
			arr.add(obj2);
		}else {
			arr.add(vid);
		}
			
		if (0<InsererConnexionBd.recupererI("urlocc", "pdf")) {
			obj3.put("Url",extention4);
			obj3.put("Occ",InsererConnexionBd.recupererI("urlocc", "pdf"));
			arr.add(obj3);
		}else {
			arr.add(vid);
		}
			
		if (0<InsererConnexionBd.recupererI("urlocc", "xhtml")) {
			obj4.put("Url",extention5);
			obj4.put("Occ",InsererConnexionBd.recupererI("urlocc", "html"));
			arr.add(obj4);
		}else {
			arr.add(vid);
		}
			
		
		
				
		return arr;	
	}
	
	
	//renvoie l'url a partir de l'ip
	
}