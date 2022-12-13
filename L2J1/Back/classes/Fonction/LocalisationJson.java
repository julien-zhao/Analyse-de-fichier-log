package Fonction;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class LocalisationJson {
	public static String getOneCountry(String ip){

		DatabaseReader dbr = Generer.genererMapFile();	
		InetAddress ip1 = null;
		try {
			ip1 = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		CityResponse response= null;
		try {
			response = dbr.city(ip1);
		} catch (IOException | GeoIp2Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String country = response.getCountry().getName();
		return country;
	}

	
	public static String getOneCity(String ip){

		DatabaseReader dbr = Generer.genererMapFile();	
		InetAddress ip1 = null;
		try {
			ip1 = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		CityResponse response= null;
		try {
			response = dbr.city(ip1);
		} catch (IOException | GeoIp2Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String city = response.getCity().getName();
		return city;
	}
	
	
	public static CityResponse getOneResponse(String ip){

		DatabaseReader dbr = Generer.genererMapFile();	
		InetAddress ip1 = null;
		try {
			ip1 = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		CityResponse response= null;
		try {
			response = dbr.city(ip1);
		} catch (IOException | GeoIp2Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return response;
	}
	
	
	//renvoie {Country : occ } à partir d'une ip
	public static JSONObject getIpByCountry(Tableau t1){
		
		JSONObject obj = new JSONObject();
		Vector<String> listCountry = new Vector<String>();
		Vector<Integer> listOcc = new Vector<Integer>();
		for(int i = 0; i< t1.getTaille();i++) {
			if(!(listCountry.contains(getOneCountry(t1.getOneIP(i))))) {
				listCountry.add(getOneCountry(t1.getOneIP(i)));
				listOcc.add(1);
			}else {
				int posCountry = listCountry.indexOf(getOneCountry(t1.getOneIP(i)));
				int occCourant = listOcc.get(posCountry);
				occCourant++;
				listOcc.set(posCountry, occCourant);
			}
		}
		for(int i =0;i<listCountry.size();i++) {
			obj.put(listCountry.get(i), listOcc.get(i));
		}
		return obj;	
	}
	
		
	public static JSONObject getOneMap(String AdresseIP) {

		CityResponse response = getOneResponse(AdresseIP);
		
		String country = response.getCountry().getName();
		String city = response.getCity().getName();
		String postal = response.getPostal().getCode();
		String state = response.getLeastSpecificSubdivision().getName();
		String abreviation = response.getCountry().getIsoCode();
		String continant = response.getContinent().getCode();
		String departement = response.getMostSpecificSubdivision().getName();

		Double latitude = response.getLocation().getLatitude();
		Double longitude = response.getLocation().getLongitude();
		int radius = response.getLocation().getAccuracyRadius();
		
		JSONObject obj = new JSONObject();
		obj.put("IP",AdresseIP);
		obj.put("Continant", continant);
		obj.put("Pays", country);
		obj.put("Abreviation", abreviation);
		obj.put("Departement", departement);
		obj.put("State", state);
		obj.put("City", city);
		obj.put("Postal", postal);

		obj.put("Latitude", latitude);
		obj.put("Longitude", longitude);
		obj.put("Radius", radius);
		
		return obj;
	}
	
	
	public static JSONArray getMap(Tableau t1){
		JSONArray arr = new JSONArray();
		for(int i = 0; i< t1.getTaille();i++) {
			JSONObject obj =new JSONObject();
			arr.add(getOneMap(t1.getOneIP(i)));
		}
		return arr;
	}	
}