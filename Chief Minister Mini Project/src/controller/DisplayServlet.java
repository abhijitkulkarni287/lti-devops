package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ChiefMinister;
import model.DataHandler;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		pw.println("CM Details <br>");
		List<ChiefMinister> list = new DataHandler().displayCM();
		//Displaying chief minister details
		for(ChiefMinister cm:list)
		{
			pw.println("<br>"+" "+cm.getCid()+" "+cm.getCname()+" "+cm.getQualification()+" "+cm.getState()+" "+cm.getEndDate()+" "+cm.getParty());
		}
		
		//giving link to index
		request.getRequestDispatcher("index.html").include(request, response);

	}



}
