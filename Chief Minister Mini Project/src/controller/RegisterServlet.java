package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ChiefMinister;
import model.DataHandler;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		
		String scid=request.getParameter("cid");
		int cid=Integer.parseInt(scid);
		
		String cname=request.getParameter("cname");
		String qualification=request.getParameter("qualification");
		String state=request.getParameter("state");
		String endDate=request.getParameter("endDate");
		String party=request.getParameter("party");
		ChiefMinister cm = new ChiefMinister(cid, cname, qualification, state, endDate, party);
		new DataHandler().registerCM(cm);
		pw.println("CM Registered Successfully ");
		request.getRequestDispatcher("index.html").include(request, response);	
		
	}

}
