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

@WebServlet("/AddComment")
public class addCommentServlet extends HttpServlet {
	
	 
		private static final long serialVersionUID = 1L;
	      
		private CommentDBUtil commentDBUtil;
		
		@Resource(name="Comment")
		private DataSource dataSource;
		
		@Override
	    public void init() throws ServletException {
			
			super.init();
			
			//create our park db util and pass in the conn pool
			try{
				commentDBUtil=new CommentDBUtil(dataSource);
				
			}
			catch (Exception exc){
				throw new ServletException(exc);
			}
		}
	    

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				//read the "command" parameter
				String theCommand=request.getParameter("command");
					
				//route to the appropriate method
				
					addComment(request,response);

								
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				
		}

		private void addComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
			//read comment info
			int commentId=0;
			String ChildAge=request.getParameter("ChildAge");
			String rating=request.getParameter("rating");
			String freeText=request.getParameter("freeText");
			int park_id=Integer.parseInt(request.getParameter("parks"));
			//create comment object
			Comments theComments=new Comments(commentId,ChildAge, rating,freeText, park_id);
			//add the comment to the database
			CommentDBUtil.addComment(theComments);
			//send back to main page
			
			if (freeText !=null){
				request.setAttribute("comment", freeText);
				request.getRequestDispatcher("insertResult.jsp").forward(request, response);
			}
			
			
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try{
			String ShowingComment=request.getParameter("showingComment");
			showcomments(request,response);
			
			}catch(Exception e){
				e.printStackTrace();
			}
			}


		private void showcomments(HttpServletRequest request, HttpServletResponse response)throws Exception {
			int parkId=Integer.parseInt(request.getParameter("parks"));
			
			List <Comments> comments=CommentDBUtil.showComment(parkId);
			request.setAttribute("Showing_Comments", comments);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/showComment.jsp");
			dispatcher.forward(request, response);
		}
	}


