
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

import Fonction.*;



@WebServlet(urlPatterns = {"/Url"})
public class Url extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //public Url() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tableau tab = Generer.genererFile();
		response.setContentType("application/Json");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=response.getWriter();
		out.print(UrlJson.getOccUrl(tab));
		response.addHeader("Access-Control-Allow-Origin", "*");
		out.flush();
		out.close();
	}
}