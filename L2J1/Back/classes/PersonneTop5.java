import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;


import javax.servlet.annotation.WebServlet;
import Fonction.*;


@WebServlet(urlPatterns = {"/PersonneTop5"})
public class PersonneTop5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //public PersonneTop5() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tableau tab = Generer.genererFile();
		response.setContentType("application/Json");
		response.setCharacterEncoding("utf-8");	
		PrintWriter out=response.getWriter();	

		out.print(PersonneJson.getPersonneTop5(tab));
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.flush();
		out.close();

	}
}
