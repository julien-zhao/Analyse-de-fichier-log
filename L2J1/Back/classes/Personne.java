
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;



import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

import Fonction.*;


@WebServlet(urlPatterns = {"/Personne"})
public class Personne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //public Personne() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tableau tab = Generer.genererFile();
		JSONArray arr = new JSONArray();
		response.setContentType("application/Json");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=response.getWriter();
		arr.add(PersonneJson.getOccIp(tab));
		out.print(arr);
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.flush();
		out.close();

	}
}