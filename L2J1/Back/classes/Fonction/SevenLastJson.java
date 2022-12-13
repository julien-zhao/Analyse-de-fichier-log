package Fonction;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class SevenLastJson {
	//format date en aaaa-mm-jj
	public static String formatDateAmerique(String date) {
		return date.substring(6,10)+"-"+date.substring(3,5)+"-"+date.substring(0,2);
	}
	
	//Renvoie le dernier jour ya un log -> apparait dans meta
	public static String lastDate(Tableau t1) {
		return formatDateAmerique(t1.getLastDate());
	}
	
	//renvoie une date ulterieur (un jour avant) de la date passé en parametre
	static String testDate(String date) {
		String jj = date.substring(0,2);
		String mm = date.substring(3,5);
		String aa = date.substring(6,10);
		Integer testJJ = Integer.valueOf(jj);
		Integer testMM = Integer.valueOf(mm);
		Integer testAA = Integer.valueOf(aa);
		testJJ--;
		if(testJJ == -1) {
			testMM--;
			if(testMM == -1) {
				testAA--;
			}
		}
		if(testMM-1 == -1) {
			testAA--;
		}		 
	    String JJ = Integer.toString(testJJ);
	    if(jj.length() == 1) {
	    	JJ = "0"+JJ;
	    }
	    String MM = Integer.toString(testMM);
	    if (MM.length() == 1) {
	    	MM = "0"+MM;
	    }
	    String AA = Integer.toString(testAA);
		return (JJ + '-' + MM + "-" +AA);
	}
	
	//renvoie les occ des 7 derniers jours
	public static JSONArray SevenJours(Tableau t1){
		JSONArray arr = new JSONArray();
		String before_1 = t1.getLastDate();
		if(before_1 == "") {
			return arr;
		}
		int nb1 =0, nb2 =0, nb3 =0, nb4 = 0, nb5 =0 , nb6 = 0, nb7 = 0;
		String before_2 = SevenLastJson.testDate(before_1);
		String before_3 = SevenLastJson.testDate(before_2);
		String before_4 = SevenLastJson.testDate(before_3);
		String before_5 = SevenLastJson.testDate(before_4);
		String before_6 = SevenLastJson.testDate(before_5);
		String before_7 = SevenLastJson.testDate(before_6);
	
		for (int i=0;i<t1.getTaille();i++) {
			if(before_1.equals(t1.getDate(i))) {
				nb1++;
			}
			if(before_2.equals(t1.getDate(i))) {
				nb2++;
			}
			if(before_3.equals(t1.getDate(i))) {
				nb3++;
			}
			if(before_4.equals(t1.getDate(i))) {
				nb4++;
			}
			if(before_5.equals(t1.getDate(i))) {
				nb5++;
			}
			if(before_6.equals(t1.getDate(i))) {
				nb6++;
			}
			if(before_7.equals(t1.getDate(i))) {
				nb7++;
			}		
					
		}
		JSONObject obj = new JSONObject();
		obj.put("date", formatDateAmerique(before_1));
		obj.put("occ",nb1);
		
		JSONObject obj2 = new JSONObject();
		obj2.put("date", formatDateAmerique(before_2));
		obj2.put("occ",nb2);
		
		JSONObject obj3 = new JSONObject();
		obj3.put("date", formatDateAmerique(before_3));
		obj3.put("occ",nb3);
		
		JSONObject obj4 = new JSONObject();
		obj4.put("date", formatDateAmerique(before_4));
		obj4.put("occ",nb4);
		
		JSONObject obj5 = new JSONObject();
		obj5.put("date", formatDateAmerique(before_5));
		obj5.put("occ",nb5);
		
		JSONObject obj6 = new JSONObject();
		obj6.put("date", formatDateAmerique(before_6));
		obj6.put("occ",nb6);
		
		JSONObject obj7 = new JSONObject();
		obj7.put("date", formatDateAmerique(before_7));
		obj7.put("occ",nb7);
		

		arr.add(obj);
		arr.add(obj2);
		arr.add(obj3);
		arr.add(obj4);
		arr.add(obj5);
		arr.add(obj6);
		arr.add(obj7);

		return arr;

	}

	
}
