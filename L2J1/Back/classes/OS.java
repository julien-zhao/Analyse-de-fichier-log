import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;

import java.io.PrintWriter;


import javax.servlet.annotation.WebServlet;
import BDD.*;
//import Fonction.*;


@WebServlet(urlPatterns = {"/OS"})
public class OS extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //public OS() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray arr = new JSONArray();
		//Tableau tab = Generer.genererFile();
		
		response.setContentType("application/Json");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=response.getWriter();
		//BDD.lancer();
		arr.add(OS_DeviceJson.getNB_PC_Mobile());
		out.print(arr);
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.flush();
		out.close();
		
	}
}
