package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataHandler;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		String state = request.getParameter("state");
		new DataHandler().deleteCM(state);
		pw.println("Deleted Successfully <br>");
		request.getRequestDispatcher("index.html").include(request, response);	

	}

}
