
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;

import java.io.PrintWriter;


import javax.servlet.annotation.WebServlet;

//import Fonction.*;
import BDD.*;

@WebServlet(urlPatterns = {"/PC"})
public class PC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //public PC() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray arr = new JSONArray();
		//Tableau tab = Generer.genererFile();
		
		response.setContentType("application/Json");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=response.getWriter();
		//BDD.lancer();
		arr.add(OS_DeviceJson.getNB_PC_OS());
		out.print(arr);
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.flush();
		out.close();
		
	}
}