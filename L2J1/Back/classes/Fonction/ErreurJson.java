package Fonction;

import org.json.simple.JSONObject;

public class ErreurJson {
	//affiche les erreurs et leur occ
	public static JSONObject get_Diff_Error(Tableau t1){
		JSONObject obj = new JSONObject();
		if(t1.diff_Erreur().length == 0) {
			return obj;
		}
		for (int i=0;i<t1.diff_Erreur().length;i++) {
			obj.put(t1.diff_Erreur()[i],t1.nombreOcurrence()[i]);
			
		}
		return obj;
	}
	//affiche le nb de succus et error
	public static JSONObject get_Nombre_Error(Tableau t1) {
		int nb = MetaJson.getLine(t1);
		JSONObject obj = new JSONObject();
		obj.put("Error",t1.nombreErreur());
		obj.put("Succes", nb-t1.nombreErreur());
		
		return obj;
	}
	//ip unique (bot exclus) apparait dans meta
	public static int get_Diff_Ocurrence(Tableau t1){
		return t1.entrezDiff();
	}		
}
