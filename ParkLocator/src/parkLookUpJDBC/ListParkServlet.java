package parkLookUpJDBC;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.sql.*;

 // Servlet implementation class ListPark
 
@WebServlet("/ListPark")
public class ListParkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private ParkDBUtil parkDBUtill;
	
	
	@Resource(name="ParkLocator")
	private DataSource dataSource;
	
    @Override
	public void init() throws ServletException {
		
		super.init();
		
		//create our park db util and pass in the conn pool
		try{
			parkDBUtill=new ParkDBUtil(dataSource);
			
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//read the "command" parameter
			String theCommand=request.getParameter("command");
			
			//route to the appropriate method
			
				showPark(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}


	private void showPark(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
	
		//read zip info 
		String userZip=request.getParameter("zip");
		
		
		if (userZip .equals("63125")|| userZip .equals("63017") || userZip .equals("63146")){
		//pull info from the database
		List<Park>parks=parkDBUtill.locatePark(userZip);
		//send back to location list (name/object)
		request.setAttribute("PARK_LIST", parks);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/location.jsp");
		dispatcher.forward(request, response);
		}
		else{
			
			response.sendRedirect("error.jsp");
		}
	}
	}

	
	
	


